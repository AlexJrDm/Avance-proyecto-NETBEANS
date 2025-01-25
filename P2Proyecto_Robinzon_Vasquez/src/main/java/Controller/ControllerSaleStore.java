package Controller;

import Model.ConexionMongoDB;
import Model.ModelProductCar;
import View.FactureClients;
import View.SaleStore;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ControllerSaleStore {

    SaleStore storeMenuSecond;
    ConexionMongoDB mongo;
    FactureClients facture;
    ControllerFacture controlFacture;
    
    private List<ModelProductCar> carrito = new ArrayList<>();

    public ControllerSaleStore(SaleStore storeMenuSecond, ConexionMongoDB mongo, FactureClients facture, ControllerFacture controlFacture) {
        this.storeMenuSecond = storeMenuSecond;
        this.mongo = mongo;
        this.facture = facture;
        this.controlFacture = controlFacture;
        mongo.createConnection();
        mongo.getCollectionInv();
        
        
        DefaultTableModel tableModelCarrito = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Código","Nombre Producto", "Categoria", "Cantidad Compra", "Precio de la Venta" }
        );
        storeMenuSecond.TablaCarrito.setModel(tableModelCarrito);
    }
    
    public void starViewFacture() {
         if (storeMenuSecond.rbtnSi.isSelected()) { // Verificar si el botón de radio está seleccionado
            facture.setVisible(true); // Mostrar la vista de facturación
            storeMenuSecond.setVisible(false); // Ocultar la vista de la tienda
        } else if (storeMenuSecond.rbtnNo.isSelected()){
            // Mostrar mensaje de éxito si el botón "No" está seleccionado
            JOptionPane.showMessageDialog(
                storeMenuSecond, 
                "La venta se ha realizado con éxito", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE
            );
        
            // Recuperar la última factura
            Document factura = mongo.getCollectionCarBuys().find().sort(new Document("_id", -1)).first();
        
            if (factura != null) {
                // Calcular y mostrar el total de la factura
                double total = controlFacture.calcularTotalFactura(factura);
                JOptionPane.showMessageDialog(
                    storeMenuSecond, 
                    "El total de la factura es: $" + total, 
                    "Total de la Factura", 
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                // Manejar el caso de factura no encontrada
                JOptionPane.showMessageDialog(
                    storeMenuSecond, 
                    "No se encontró ninguna factura reciente.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
             // Mostrar advertencia si no se seleccionó ninguna opción
            JOptionPane.showMessageDialog(
                facture, 
                "Debe seleccionar una opción de la factura.", 
                "Error", 
                JOptionPane.WARNING_MESSAGE
             );
        }
    }
    
    public void cargarTabla() {
        List<Document> products = mongo.getAllProductsFromStore();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Código", "NombreP", "Categoria", "Stock Actual", "Precio Venta", "Cantidad"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; // Hacer que solo la columna "Cantidad" sea editable
            }
        };
        storeMenuSecond.tabla.setModel(tableModel);
        tableModel.setRowCount(0); // Limpiar la tabla

        for (Document product : products) {
            int stockActual = 0;
            int stockMinimo = 5; // Ejemplo de valor por defecto
            String codigo = product.getString("Código");
            String nombreP = product.getString("NombreP");
            String categoria = product.getString("Categoria");
            double precioVenta = 0.0;
            
            // Manejar el caso en el que el stock actual es un String
            if (product.get("Stock Actual") instanceof Integer) {
                stockActual = product.getInteger("Stock Actual");
            } else if (product.get("Stock Actual") instanceof String) {
                try {
                    stockActual = Integer.parseInt(product.getString("Stock Actual"));
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] No se pudo convertir el stock actual a Integer: " + product.getString("Stock Actual"));
                }
            }

            // Manejar el caso en el que el precio venta es un String
            if (product.get("Precio Venta") instanceof Double) {
                precioVenta = product.getDouble("Precio Venta");
            } else if (product.get("Precio Venta") instanceof String) {
                try {
                    precioVenta = Double.parseDouble(product.getString("Precio Venta"));
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] No se pudo convertir el precio Venta a Double: " + product.getString("Precio Venta"));
                }
            }

            if (stockActual == 0) {
                System.out.println("[DEPURACIÓN] Producto eliminado por stock agotado: " + nombreP);
                continue; // Si el stock es 0, no agregarlo a la tabla
            }

            if (stockActual <= stockMinimo) {
                JOptionPane.showMessageDialog(storeMenuSecond, 
                    "El producto " + nombreP + " ha alcanzado su stock mínimo (" + stockMinimo + "). ¡Realice un nuevo pedido!",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

            Object[] row = {
                codigo,
                nombreP,
                categoria,
                stockActual,
                precioVenta,
                0 // Inicialmente, la cantidad es 0
            };
            tableModel.addRow(row);
        }
    }
    
    public void limpiarTabla() {
        DefaultTableModel tableModel = (DefaultTableModel) storeMenuSecond.tabla.getModel();
        tableModel.setRowCount(0);
    }

    //ARREGLAR DE AQUÍ EN ADELANTE
    public void AjustarCategoria(String categoria) { //busca en el documento de mongo donde estén almacenados todos los productos
        //CREO UN FOR CON EL VALOR NUMERO DE PRODUCTOS, IF
        Bson filter = Filters.eq("Categoria", categoria);
        try (MongoCursor<Document> cursor = mongo.createConnection().getCollection("ProductsAdd")
                .find(filter)
                .iterator()) {
            DefaultTableModel tabla = (DefaultTableModel) storeMenuSecond.tabla.getModel();
            tabla.setRowCount(0);

            while (cursor.hasNext()) {
                Document producto = cursor.next();
                String codigo = producto.getString("Código");
                String nombreP = producto.getString("NombreP");
                String categoriaProducto = producto.getString("Categoria");
                String stockMinimo = producto.get("Stock Actual") != null ? String.valueOf(producto.get("Stock Actual")) : "0";
                String precioVenta = producto.get("Precio Venta") != null ? String.valueOf(producto.get("Precio Venta")) : "0";
                String cantidad = producto.get("Cantidad") != null ? String.valueOf(producto.get("Cantidad")) : "0";

                String[] fila = {
                    codigo,
                    nombreP,
                    categoriaProducto,
                    stockMinimo,
                    precioVenta,
                    cantidad
                };
                tabla.addRow(fila);
                System.out.println(" [DEPURACION] Aniadido a la tabla: " + Arrays.toString(fila)); // 
            }
        } catch (Exception e) {
            e.printStackTrace();
           
        }
    }
public void lookForProductsSecondMenu() {
    // Limpiar la tabla antes de buscar
    limpiarTabla();

    // Obtener los valores de los campos de texto
    String nombreProducto = storeMenuSecond.txtProducto.getText().trim();
    String codigoProducto = storeMenuSecond.txtProducto.getText().trim();
    String categoriaProducto = storeMenuSecond.txtProducto.getText().trim();

    // Crear una lista de filtros
    ArrayList<Bson> filters = new ArrayList<>();

    // Agregar filtros según los parámetros no vacíos
    if (!nombreProducto.isEmpty()) {
        filters.add(Filters.regex("NombreP", ".*" + Pattern.quote(nombreProducto) + ".*", "i"));
    }
    if (!codigoProducto.isEmpty()) {
        filters.add(Filters.regex("Código", ".*" + Pattern.quote(codigoProducto) + ".*", "i"));
    }
    if (!categoriaProducto.isEmpty()) {
        filters.add(Filters.regex("Categoria", ".*" + Pattern.quote(categoriaProducto) + ".*", "i"));
    }

    // Verificar si hay filtros
    if (filters.isEmpty()) {
        JOptionPane.showMessageDialog(storeMenuSecond, "Por favor, ingrese al menos un criterio de búsqueda.");
        return;
    }

    // Combinar los filtros en uno solo
    Bson filter = Filters.or(filters);

    System.out.println("[DEPURACION] Buscando productos con los filtros: " + filters);
    ArrayList<Document> resultados = mongo.searchProduct(filter);

    // Limpiar la tabla antes de cargar los resultados
    DefaultTableModel table = (DefaultTableModel) storeMenuSecond.tabla.getModel();
    table.setRowCount(0);

    if (resultados != null && !resultados.isEmpty()) {
        for (Document doc : resultados) {
            String codigo = doc.getString("Código");
            String nombreP = doc.getString("NombreP");
            String categoria = doc.getString("Categoria");
            String stockActual = doc.get("Stock Actual") != null ? String.valueOf(doc.get("Stock Actual")) : "0";
            String precioVenta = doc.get("Precio Venta") != null ? String.valueOf(doc.get("Precio Venta")) : "0";

            table.addRow(new Object[]{
                codigo,
                nombreP,
                categoria,
                stockActual,
                precioVenta,
                0
            });
        }
    } else {
        JOptionPane.showMessageDialog(storeMenuSecond, "No se ha encontrado un Producto con los criterios especificados.");
    }
}
    
    public void addProductToCar() {
    DefaultTableModel tableModel = (DefaultTableModel) storeMenuSecond.tabla.getModel();
    int selectedRow = storeMenuSecond.tabla.getSelectedRow();

    if (selectedRow != -1) {
        String codigo = (String) tableModel.getValueAt(selectedRow, 0);
        String nombreP = (String) tableModel.getValueAt(selectedRow, 1);
        String categoria = (String) tableModel.getValueAt(selectedRow, 2);
        int stockActual = Integer.parseInt(String.valueOf(tableModel.getValueAt(selectedRow, 3)));
        double precioVenta = Double.parseDouble(String.valueOf(tableModel.getValueAt(selectedRow, 4)));
        Object cantidadObj = tableModel.getValueAt(selectedRow, 5);

        if (cantidadObj == null || cantidadObj.toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(storeMenuSecond, "Por favor, ingrese una cantidad válida.");
            return;
        }

        int cantidad = Integer.parseInt(String.valueOf(cantidadObj));

        if (cantidad > 0 && cantidad <= stockActual) {
            // Calcular el precio total de la venta
            double precioTotal = cantidad * precioVenta;

            // Verificar si el producto ya está en el carrito
            boolean productoExistente = false;
            for (ModelProductCar producto : carrito) {
                if (producto.getNombreProducto().equals(nombreP)) {
                    // Actualizar la cantidad del producto existente
                    producto.setCantidad(producto.getCantidad() + cantidad);
                    producto.setPrecioVenta(producto.getCantidad() * precioVenta);
                    productoExistente = true;
                    break;
                }
            }

            if (!productoExistente) {
                // Crear un objeto del carrito
                ModelProductCar productoCarrito = new ModelProductCar(codigo, nombreP, categoria, cantidad, precioTotal);

                // Añadirlo a la lista del carrito
                carrito.add(productoCarrito);

                // Mostrar el producto añadido en la tabla
                DefaultTableModel tableCarrito = (DefaultTableModel) storeMenuSecond.TablaCarrito.getModel();
                tableCarrito.addRow(new Object[]{
                    productoCarrito.getCodigo(),
                    productoCarrito.getNombreProducto(),
                    productoCarrito.getCategoria(),
                    productoCarrito.getCantidad(),
                    productoCarrito.getPrecioVenta()
                });
                try (FileWriter writer = new FileWriter("ProductosComprados.csv",true)){
                    writer.write("Productos Comprados");
                    writer.write("Código del producto"+productoCarrito.getCodigo());
                    writer.write("Nombre producto: " + productoCarrito.getNombreProducto());
                    writer.write("Categoria" + productoCarrito.getCategoria());
                    writer.write("Cantidad: " + productoCarrito.getCantidad());
                    writer.write("Precio de esta venta: " + productoCarrito.getPrecioVenta());
                    System.out.println("[DEPURACION] producto agregado correctamente a archivo csv");
                }catch (IOException e) {
                    System.out.println("[DEPURACION] error al crear el archivo csv");
                }
            } else {
                // Actualizar la tabla del carrito
                DefaultTableModel tableCarrito = (DefaultTableModel) storeMenuSecond.TablaCarrito.getModel();
                for (int i = 0; i < tableCarrito.getRowCount(); i++) {
                    if (tableCarrito.getValueAt(i, 1).equals(nombreP)) {
                        tableCarrito.setValueAt(cantidad, i, 3);
                        tableCarrito.setValueAt(cantidad * precioVenta, i, 4);
                        break;
                    }
                }
            }

            // Guardar el producto en la colección CarritoDeCompras
            Document doc = new Document("Código", codigo)
                    .append("NombreP", nombreP)
                    .append("Categoria", categoria)
                    .append("Cantidad", cantidad)
                    .append("Precio Venta", precioVenta)
                    .append("Precio Total", precioTotal);
            if (mongo.saveCarBuys(doc)) {
                System.out.println("[DEPURACION] el carrito fue aniadido correctamente a la base de datos");
            } else {
                System.out.println("[DEPURACION] el producto fue aniadido al carrito pero no a la base de datos.");
            }

            // Actualizar el stock en la base de datos
            int nuevoStock = stockActual - cantidad;
            Bson filter = Filters.eq("NombreP", nombreP);
            Bson updateOperation = new Document("$set", new Document("Stock Actual", nuevoStock));
            mongo.createConnection().getCollection("ProductsAdd").updateOne(filter, updateOperation);

            // Actualizar el stock en la tabla
            tableModel.setValueAt(nuevoStock, selectedRow, 3);

            if (nuevoStock == 0) {
                // Eliminar la fila si el stock llega a cero
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(storeMenuSecond, 
                    "El producto " + nombreP + " ha sido eliminado de la tabla por falta de stock.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            } else if (nuevoStock <= 5) { // Suponiendo que el stock mínimo es 5
                // Advertencia si el stock alcanza el mínimo
                JOptionPane.showMessageDialog(storeMenuSecond, 
                    "El producto " + nombreP + " ha alcanzado su stock mínimo. ¡Realice un nuevo pedido!",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

            JOptionPane.showMessageDialog(storeMenuSecond, "Producto aniadido al carrito. Precio total: " + precioTotal);
        } else {
            JOptionPane.showMessageDialog(storeMenuSecond, "Cantidad inválida. Debe ser mayor que 0 y menor o igual al stock actual. \n"
                    + "EDITE el campo cantidad pedido y presione ENTER antes de añadir al carrito.");
        }
    } else {
        JOptionPane.showMessageDialog(storeMenuSecond, "Seleccione un producto para añadir al carrito.");
    }
    }

    
    public void llenarTablaCarnes() {
        String categoria = "Carnes";
        AjustarCategoria(categoria);
    }

    public void llenarTablaAlacena() {
        String categoria = "Alacena";
        AjustarCategoria(categoria);
    }

    public void llenarTablaFrutas() {
        String categoria = "Frutas";
        AjustarCategoria(categoria);
    }

    public void llenarTablaLegumbres() {
        String categoria = "Legumbres";
        AjustarCategoria(categoria);

    }

    public void llenarTablaEmbutidos() {
        String categoria = "Embutidos";
        AjustarCategoria(categoria);

    }
    
    public void llenarTablaAseoPersonal() {
        String categoria = "Aseo Personal";
        AjustarCategoria(categoria);
    }
    
    public void llenarTablaAseodelHogar() {
        String categoria = "Aseo del hogar";
        AjustarCategoria(categoria);
    }
    
    public void llenarTablaProductosMascotas() {
        String categoria = "Productos para mascota";
        AjustarCategoria(categoria);
    }
    
    public void llenarTablaLacteos() {
        String categoria = "Lacteos";
        AjustarCategoria(categoria);
    }
    
    public void actualizarTablaPorStock() {
        DefaultTableModel tableModel = (DefaultTableModel) storeMenuSecond.tabla.getModel();
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            int stockActual = Integer.parseInt(String.valueOf(tableModel.getValueAt(i, 2)));
            if (stockActual == 0) {
                tableModel.removeRow(i);
            }
        }
    }
    
    public void guardarCompraTotal() {
        DefaultTableModel tableModelCarrito = (DefaultTableModel) storeMenuSecond.TablaCarrito.getModel();
        List<Document> productosCarrito = new ArrayList<>();

        for (int i = 0; i < tableModelCarrito.getRowCount(); i++) {
            String codigo = (String) tableModelCarrito.getValueAt(i, 0);
            String nombreP = (String) tableModelCarrito.getValueAt(i, 1);
            String categoria = (String) tableModelCarrito.getValueAt(i, 2);
            int cantidad = (int) tableModelCarrito.getValueAt(i, 3);
            double precioVenta = (double) tableModelCarrito.getValueAt(i, 4);

            Document producto = new Document("Código", codigo)
                    .append("NombreP", nombreP)
                    .append("Categoria", categoria)
                    .append("Cantidad", cantidad)
                    .append("Precio Venta", precioVenta);
            productosCarrito.add(producto);
        }

        Document compraTotal = new Document("Productos", productosCarrito)
                .append("Fecha", new Date());

        if (mongo.saveCarsBuysTotal(compraTotal)) {
            JOptionPane.showMessageDialog(storeMenuSecond, "Compra guardada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(storeMenuSecond, "Error al guardar la compra. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteProductToCar() {
        int rowSelected = storeMenuSecond.TablaCarrito.getSelectedRow();

        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(storeMenuSecond, 
                "Debe seleccionar un producto en el carrito para eliminarlo.", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel tableModelCarrito = (DefaultTableModel) storeMenuSecond.TablaCarrito.getModel();
        String nombreP = (String) tableModelCarrito.getValueAt(rowSelected, 1);
        int cantidad = (int) tableModelCarrito.getValueAt(rowSelected, 3);

        int confirmar = JOptionPane.showConfirmDialog(storeMenuSecond, 
                "¿Está seguro de que desea eliminar el producto '" + nombreP + "' del carrito?",
                "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            Bson filter = Filters.eq("NombreP", nombreP);
            boolean eliminado = mongo.deleteDocumentFromCar(filter); // Usar el método correcto

            if (eliminado) {
                tableModelCarrito.removeRow(rowSelected);

                // Restaurar el stock en la colección ProductsAdd
                Bson stockFilter = Filters.eq("NombreP", nombreP);
                Document producto = mongo.getCollectionInv().find(stockFilter).first(); // Cambiar a getCollectionInv()
                if (producto != null) {
                    int stockActual = producto.getInteger("Stock Actual", 0);
                    int nuevoStock = stockActual + cantidad;

                    Bson updateOperation = new Document("$set", new Document("Stock Actual", nuevoStock));
                    mongo.getCollectionInv().updateOne(stockFilter, updateOperation); // Cambiar a getCollectionInv()
                }
                
                cargarTabla();

                JOptionPane.showMessageDialog(storeMenuSecond, 
                        "Producto eliminado del carrito correctamente.", 
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(storeMenuSecond, 
                        "Error al eliminar el producto del carrito. Intente nuevamente.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }

}