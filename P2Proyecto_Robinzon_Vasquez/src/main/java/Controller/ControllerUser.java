package Controller;

import Model.ConexionMongoDB;
import Model.SellerRegiste;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class ControllerUser  {
    private ConexionMongoDB mongo = new ConexionMongoDB();
    
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    
    // Método para registrar USUARIOS en mongo
    public String registerUser (SellerRegiste user) {
        // Verificar si el DNI ya está registrado
        Document filter = new Document("DNI", user.getDni());
        List<Document> resultados = mongo.readDocument(filter);

        if (resultados != null && !resultados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario registrado con esta cedula (DNI).", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // No registrar el usuario
        }

        Document doc = new Document("Names", user.getNames())
                .append("LastNames", user.getLastNames())
                .append("User", user.getUser ()) 
                .append("DNI", user.getDni())
                .append("Email", user.getEmail()+user.getDireccionEmail())
                .append("Password", user.getPassword())
                .append("Products", new ArrayList<>());

        if (mongo.createDocument(doc)) {
            ObjectId userId = (ObjectId) doc.get("_id"); // Recupera el ObjectId generado
            System.out.println("[INFO] Usuario registrado: " + user.getUser () + ", ID: " + userId.toHexString());
            return userId.toHexString(); // Devuelve el userId
        } else {
            System.out.println("[ERROR] Error al registrar el usuario: " + user.getUser ());
            return null;
        }
    }
    
    public boolean loginAdmin(String userInput, String passwordInput) {
        if (ADMIN_USER.equals(userInput) && ADMIN_PASSWORD.equals(passwordInput)) {
            System.out.println("[INFO] Inicio de sesion exitoso como administrador");
            return true;
        } else {
            System.out.println("[ERROR] Credenciales de administrador incorrectas");
            return false;
        }
    }

    // Método para iniciar sesión
    public boolean login(String userInput, String passwordInput) {
        System.out.println("Intentando iniciar sesion con usuario: " + userInput + "\n y contrasenia: " + passwordInput);
        
        Document filter = new Document("User", userInput); 
        List<Document> resultados = mongo.readDocument(filter);

        if (resultados != null && !resultados.isEmpty()) {
            String storedPassword = resultados.get(0).getString("Password");
            if (storedPassword.equals(passwordInput)) {
                System.out.println("[INFO] Inicio de sesion exitoso para: " + userInput);
                return true;
            } else {
                System.out.println("[ERROR] Contrasenia incorrecta");
                JOptionPane.showMessageDialog(null, "Contrasenia incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            System.out.println("[ERROR] Usuario no encontrado");
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}