package Controller;

import Model.ConexionMongoDB;
import View.Admin;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ControllerAdmin {
    private ConexionMongoDB mongo;
    private Admin admin;
    
    public ControllerAdmin(ConexionMongoDB mongo, Admin admin) {
        this.mongo = mongo;
        this.admin = admin;
        
        cargarTablaAdmin();
    }
    
    public void cleanTable() {
        DefaultTableModel table = (DefaultTableModel) admin.tabla.getModel();
        table.setRowCount(0);
    }
    
    public void cargarTablaAdmin() {
        List<Document> users = mongo.getAllUsersFromStore();
        DefaultTableModel table = new DefaultTableModel(new Object[] {"Names","LasNames","User","DNI",
        "Email", "Password","Pago Mensual"},0);
        admin.tabla.setModel(table);
        table.setRowCount(0);
        
        for (Document user : users) {
            String name = user.getString("Names");
            String lastNames = user.getString("LastNames");
            String userr = user.getString("User");
            String  dni = user.getString("DNI");
            String email = user.getString("Email");
            String password = user.getString("Password");
            
            Object [] row = {
                name,
                lastNames,
                userr,
                dni,
                email,
                password, 
                0
            };
            table.addRow(row);
        }
    }
    
    public void lookForUserAdmin() {
        String dni = JOptionPane.showInputDialog(admin, "Ingrese la cédula del empleado a buscar: ");
        
        if (dni == null || dni.isEmpty()) {
            JOptionPane.showMessageDialog(admin, "Debe ingresar un numero de cédula para buscar al empleado");
            return;
        }
        
        Document filter = new Document("DNI",dni);
        ArrayList<Document> resultados = mongo.searchDocument(filter);
        
        cleanTable();
        
        if (resultados != null && !resultados.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) admin.tabla.getModel();
            for (Document doc : resultados) {
                model.addRow(new Object[]{
                    doc.getString("Names"),
                    doc.getString("LastNames"),
                    doc.getString("User"),
                    doc.getString("DNI"),
                    doc.getString("Email"),
                    doc.getString("Password"),
                    doc.containsKey("Pago mensual") ? doc.get("Pago mensual") : 0
                });
            }
        } else {
            JOptionPane.showMessageDialog(admin, "No se encontraron datos para el empleado ingresado.",
                    "Búsqueda", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteUser() {
        
    }
}
