package Controller;

import Model.ConexionMongoDB;
import Model.ModelFacture;
import Model.ModelProductCar;
import View.FactureClients;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.json.simple.JSONObject;

public class ControllerFacture {
    private ConexionMongoDB mongo = new ConexionMongoDB();
    private ModelFacture facture = new ModelFacture("","", "", "", "", "", "");
    private FactureClients factureClients;
    private double totalAPagar = 0.0; // Inicializar el total
    private List<ModelProductCar> carrito = new ArrayList<>();
    public ControllerFacture(FactureClients factureClients,ConexionMongoDB mongo) {
        this.factureClients = factureClients;
        this.mongo = mongo;
        
        mongo.createConnection();
    }
    
    public void imprimirFactura() {
        // Recuperar la compra más reciente desde la base de datos
        Document compra = mongo.getCollectionCarBuys().find().sort(new Document("_id", -1)).first();
        if (compra == null) {
            JOptionPane.showMessageDialog(factureClients, "No se encontró ninguna compra reciente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Document> productos = (List<Document>) compra.get("Productos");
        StringBuilder productosElegidos = new StringBuilder();
        totalAPagar = 0.0; // Reiniciar el total

        // Recopilar los productos del carrito
        for (Document producto : productos) {
            String nombreProducto = producto.getString("NombreP");
            double precioVenta = producto.getDouble("Precio Venta");
            productosElegidos.append(nombreProducto).append(" - Precio: ").append(precioVenta).append("\n");
            totalAPagar += precioVenta; // Sumar el precio total
        }
        

        // Obtener datos del cliente desde la interfaz
        facture.setLastNames(factureClients.txtLastNames.getText());
        facture.setNames(factureClients.txtNames.getText());
        facture.setAddres(factureClients.txtAddress.getText());
        facture.setDni(factureClients.txtDni.getText());
        facture.setDireccionEmail(factureClients.cbDireccionEmail.getSelectedItem().toString());
        facture.setEmail(factureClients.txtEmail.getText());
        facture.setCellPhone(factureClients.txtCellPhone.getText());

        // Crear el documento del cliente con sus compras
        Document clienteDoc = new Document("Apellidos", facture.getLastNames())
                .append("Nombres", facture.getNames())
                .append("Direccion", facture.getAddres())
                .append("Cedula", facture.getDni()+facture.getDireccionEmail())
                .append("Email", facture.getEmail())
                .append("Numero de telefono", facture.getCellPhone())
                .append("Compras", productos);
        //AGREGA LOS DATOS AL JSON
        JSONObject json = new JSONObject();
            json.put("Apellidos", facture.getLastNames());
            json.put("Nombres", facture.getNames());
            json.put("Direccion", facture.getAddres()+facture.getDireccionEmail());
            json.put("Cedula", facture.getDni());
            json.put("Email", facture.getEmail());
            json.put("Numero de telefono", facture.getCellPhone());
            json.put("Compras", productos);
            try (FileWriter file = new FileWriter("Facturas.json", true)){
                file.write(json.toString()+"\n");
            }catch (IOException e) {
                System.out.println("Error al generar archivo json");
            }
        // Guardar el documento del cliente en la colección Clients
        if (mongo.createDocumentClients(clienteDoc)) {
            System.out.println("[DEPURACION] Los datos del cliente y sus compras fueron guardados correctamente.");
        } else {
            System.out.println("[DEPURACION] Error al guardar los datos del cliente y sus compras.");
        }

        // Crear el mensaje completo
        String datosCliente = "Datos del Cliente:\n" +
                "Apellidos: " + facture.getLastNames() + "\n" +
                "Nombres: " + facture.getNames() + "\n" +
                "Dirección: " + facture.getAddres() + "\n" +
                "Cédula: " + facture.getDni() + "\n" +
                "Email: " + facture.getEmail() + facture.getDireccionEmail() + "\n" +
                "Celular: " + facture.getCellPhone() + "\n";
        String mensaje = datosCliente + "Productos Elegidos:\n" + productosElegidos.toString() +
                         "Total a Pagar: $" + totalAPagar;

        if (facture.validationsFacture(factureClients)) {
            // Mostrar la factura en el textArea
            factureClients.txtProductos.setText(mensaje);
            // Mostrar la factura en un JOptionPane
            JOptionPane.showMessageDialog(
            factureClients, 
            mensaje, 
            "Factura Generada", 
            JOptionPane.INFORMATION_MESSAGE
            );
        }
   }
    
    public double calcularTotalFactura(Document factura) {
        if (factura == null) {
            System.out.println("[ERROR] La factura proporcionada es nula.");
            return 0.0; // Retornar 0 si no se proporciona una factura válida
        }

        double total = 0.0;

        @SuppressWarnings("unchecked")
        List<Document> productos = (List<Document>) factura.get("Productos");
        if (productos != null) {
                for (Document producto : productos) {
                    double precioVenta = producto.getDouble("Precio Venta");
                    total += precioVenta; // Sumar el precio de cada producto
                }
            } else {
                System.out.println("[ERROR] La factura no contiene productos.");
            }

            return total;
    }   
    
    public void exportarTodasLasFacturasAPdf() {
        MongoDatabase db = mongo.createConnection();
        if (db == null) {
            System.out.println("[ERROR] No se pudo conectar a la base de datos.");
            return;
        }

        MongoCollection<Document> collection = db.getCollection("Clients");
        for (Document factura : collection.find()) {
            exportarFacturaAPdf(factura);
        }
}
    
    public void exportarFacturaAPdf(Document factura) {
        if (factura == null) {
            System.out.println("[ERROR] La factura proporcionada es nula.");
            return;
        }

        String nombreArchivo = "Factura_" + factura.getObjectId("_id") + ".pdf"; // Usar el ID único de la factura para el nombre
        try (PdfWriter writer = new PdfWriter(nombreArchivo);
             PdfDocument pdf = new PdfDocument(writer);
             com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdf)) { // Cambiar a la clase correcta

            // Encabezado del PDF
            document.add(new Paragraph("Factura de Compra")
                    .setFontSize(18)
                    .setBold());

            document.add(new Paragraph("ID de la Factura: " + factura.getObjectId("_id"))
                    .setFontSize(12));

            // Información del cliente
            document.add(new Paragraph("Información del Cliente:")
                    .setBold());
            document.add(new Paragraph("Apellidos: " + factura.getString("Apellidos")));
            document.add(new Paragraph("Nombres: " + factura.getString("Nombres")));
            document.add(new Paragraph("Dirección: " + factura.getString("Direccion")));
            document.add(new Paragraph("Cédula: " + factura.getString("Cedula")));
            document.add(new Paragraph("Email: " + factura.getString("Email")));
            document.add(new Paragraph("Número de Teléfono: " + factura.getString("Numero de telefono")));

            // Tabla de productos
            document.add(new Paragraph("Productos Comprados:")
                    .setBold());
            Table table = new Table(new float[]{4, 2}); // Columnas: Producto y Precio
            table.addCell("Producto");
            table.addCell("Precio ($)");

            @SuppressWarnings("unchecked")
            List<Document> productos = (List<Document>) factura.get("Productos");
            if (productos != null) {
                for (Document producto : productos) {
                    table.addCell(producto.getString("NombreP"));
                    table.addCell(String.valueOf(producto.getDouble("Precio Venta")));
                }
            }

            document.add(table);

            // Total a pagar
            double total = calcularTotalFactura(factura);
            document.add(new Paragraph("Total a Pagar: $" + total)
                    .setBold()
                    .setFontSize(14));

            System.out.println("[INFO] Factura exportada a: " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("[ERROR] Ocurrió un error al generar el PDF: " + e.getMessage());
        }
    }
     
}
