package Controller;

import Model.ConexionMongoDB;
import View.Admin;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

public class ControllerAdmin {
    private ConexionMongoDB mongo;
    private Admin admin;
    
    public ControllerAdmin(ConexionMongoDB mongo, Admin admin) {
        this.mongo = mongo;
        this.admin = admin;
        
        cargarTablaAdmin();
        
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
}
