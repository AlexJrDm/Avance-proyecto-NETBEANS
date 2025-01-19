package Controller;

import Model.ConexionMongoDB;
import Model.ModelFacture;
import Model.ModelProductCar;
import View.FactureClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;

public class ControllerFacture {
    private ConexionMongoDB mongo = new ConexionMongoDB();
    private ModelFacture facture = new ModelFacture("", "", "", "", "", "");
    private FactureClients factureClients;
    private double totalAPagar = 0.0; // Inicializar el total
    private List<ModelProductCar> carrito = new ArrayList<>();
    public ControllerFacture(FactureClients factureClients) {
        this.factureClients = factureClients;
        
        mongo.createConnection();
    }

    public void mostrarProductos() {
        ArrayList<ModelProductCar> productosElegidos = new ArrayList<>();
        String userId = "ID_DEL_USUARIO_ACTUAL"; // Cambia esto por el ID real del usuario

        try (MongoCursor<Document> cursor = mongo.getCollectionCar()
                .find(Filters.eq("userId", userId)).iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                String nombreProducto = doc.getString("NombreP");
                double precioTotal = doc.getDouble("Precio Total");

                // Solo se necesita el nombre del producto
                ModelProductCar producto = new ModelProductCar(nombreProducto, "", 0, precioTotal); // No se necesita la categoría
                productosElegidos.add(producto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(factureClients, "Error al recuperar productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pasar los nombres de los productos a la vista
        String nombresProductos = obtenerNombresProductos(productosElegidos);
        factureClients.txtProductos.setText(nombresProductos); // Establecer el texto en el textArea
        
        // Establecer los datos del cliente desde la interfaz
        facture.setLastNames(factureClients.txtLastNames.getText());
        facture.setNames(factureClients.txtNames.getText());
        facture.setAddres(factureClients.txtAddress.getText());
        facture.setDni(factureClients.txtDni.getText());
        facture.setEmail(factureClients.txtEmail.getText());
        facture.setCellPhone(factureClients.txtCellPhone.getText());
        
        Document doc = new Document("Nombres",facture.getNames())
                .append("Apellidos", facture.getLastNames())
                .append("Direccion", facture.getAddres())
                .append("Cedula", facture.getDni())
                .append("Email", facture.getEmail())
                .append("Numero de teléfono", facture.getCellPhone());
        if (facture.validationsFacture(factureClients)) {
            mongo.createDocumentClients(doc);
        }
        
        // Guardar los productos en el carrito
        carrito = productosElegidos; // Asignar los productos elegidos al carrito
    }

    private String obtenerNombresProductos(ArrayList<ModelProductCar> productos) {
        StringBuilder nombres = new StringBuilder();
        for (ModelProductCar producto : productos) {
            nombres.append(producto.getNombreProducto()).append(", "); // Concatenar nombres
        }
        // Eliminar la última coma y espacio si hay productos
        if (nombres.length() > 0) {
            nombres.setLength(nombres.length() - 2); // Eliminar la última coma y espacio
        }
        return nombres.toString();
    }

    public void factura() {
        // Validar los datos del cliente antes de proceder
        if (!facture.validationsFacture(factureClients)) {
            JOptionPane.showMessageDialog(factureClients, "Por favor, complete todos los campos obligatorios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return; // Salir si hay errores de validación
        }

        StringBuilder productosElegidos = new StringBuilder();
        totalAPagar = 0.0; // Reiniciar el total

        // Recopilar los productos del carrito
        for (ModelProductCar producto : carrito) {
            productosElegidos.append(producto.getNombreProducto()).append("\n");
            totalAPagar += producto.getPrecioVenta(); // Sumar el precio total
        }

        // Obtener datos del cliente
        String datosCliente = "Datos del Cliente:\n" +
                "Apellidos: " + facture.getLastNames() + "\n" +
                "Nombres: " + facture.getNames() + "\n" +
                "Dirección: " + facture.getAddres() + "\n" +
                "Cédula: " + facture.getDni() + "\n" +
                "Email: " + facture.getEmail() + "\n" +
                "Celular: " + facture.getCellPhone() + "\n";

        // Crear el mensaje completo
        String mensaje = datosCliente + "Productos Elegidos:\n" + productosElegidos.toString() +
                         "Total a Pagar: $" + totalAPagar;

        // Mostrar la factura en un JOptionPane
        JOptionPane.showMessageDialog(factureClients, mensaje, "Factura", JOptionPane.INFORMATION_MESSAGE);

        // Escribir los productos en un archivo de texto
        escribirProductosEnArchivo(carrito); // Pasar el carrito a escribirProductosEnArchivo
    }

    private void escribirProductosEnArchivo(List<ModelProductCar> productos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("txtProductos.txt"))) {
            for (ModelProductCar producto : productos) {
                writer.write(producto.getNombreProducto() + " - Precio: " + producto.getPrecioVenta());
                writer.newLine(); // Nueva línea para cada producto
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(factureClients, "Error al escribir en el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
