package Model;

import View.FactureClients;

public class ModelFacture {
    private String lastNames;
    private String names;
    private String addres;
    private String dni;
    private String email;
    private String direccionEmail;
    private String cellPhone;
    
    public boolean validConfirmation = true;

    public ModelFacture(String lastNames, String names, String addres, String dni, String email,
            String direccionEmail, String cellPhone) {
        this.lastNames = lastNames;
        this.names = names;
        this.addres = addres;
        this.dni = dni;
        this.email = email;
        this.direccionEmail = direccionEmail;
        this.cellPhone = cellPhone;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getDireccionEmail() {
        return direccionEmail;
    }

    public void setDireccionEmail(String direccionEmail) {
        this.direccionEmail = direccionEmail;
    }
    
    public boolean validationsFacture(FactureClients factura) { 
        System.out.println("Validamos datos de factura"); 
        validConfirmation = true;

        // Validación de nombres
        if (getNames().isEmpty() || getNames() == null) { 
            System.out.println("[DEPURACION] Names está vacío"); 
            factura.lblErrorNames.setText("*campo obligatorio*"); 
            validConfirmation = false; 
        } else if (!getNames().matches("[a-zA-ZÁÉÍÓÚáéíóúÑñÜü ]+")) { 
            System.out.println("[DEPURACION] Names contiene números"); 
            factura.lblErrorNames.setText("*debe ingresar únicamente letras*"); 
            validConfirmation = false; 
        } else { 
            factura.lblErrorNames.setText(""); 
        }

        // Validación de apellidos
        if (getLastNames().isEmpty()) { 
            System.out.println("[DEPURACION] LastNames está vacío"); 
            factura.lblErrorLastNames.setText("*campo obligatorio*"); 
            validConfirmation = false; 
        } else if (!getLastNames().matches("[a-zA-ZÁÉÍÓÚáéíóúÑñÜü ]+")) { 
            System.out.println("[DEPURACION] LastNames contiene números"); 
            factura.lblErrorLastNames.setText("*debe ingresar únicamente letras*"); 
            validConfirmation = false; 
        } else { 
            factura.lblErrorLastNames.setText(""); 
        }

         
        if (getDni().isEmpty()) { 
            System.out.println("[DEPURACION] DNI está vacío"); 
            factura.lblErrorDni.setText("*campo obligatorio*"); 
            validConfirmation = false; 
        } else if (!getDni().matches("\\d{10}")) { 
            System.out.println("[DEPURACION] DNI contiene letras o no tiene 10 caracteres"); 
            factura.lblErrorDni.setText("*debe contener exactamente 10 caracteres numéricos*"); 
            validConfirmation = false; 
        } else { 
            factura.lblErrorDni.setText(""); 
        }

         
        if (getCellPhone().isEmpty()) { 
            System.out.println("[DEPURACION] Cell está vacío"); 
            factura.lblErrorCell.setText("*campo obligatorio*"); 
            validConfirmation = false; 
        } else if (!getCellPhone().matches("\\d{10}")) { 
            System.out.println("[DEPURACION] Cell contiene letras o no tiene 10 caracteres"); 
            factura.lblErrorCell.setText("*debe contener exactamente 10 caracteres numéricos*"); 
            validConfirmation = false; 
        } else { 
            factura.lblErrorCell.setText(""); 
        }

         
        if (getEmail().isEmpty()) { 
            System.out.println("[DEPURACION] correo está vacío"); 
            factura.lblErrorEmail.setText("*campo obligatorio*"); 
            validConfirmation = false; 
        } else { 
            factura.lblErrorEmail.setText(""); 
        }


        if (getAddres().isEmpty()) { 
            System.out.println("[DEPURACION] dirección está vacía"); 
            factura.lblErrorDireccion.setText("*campo obligatorio*"); 
            validConfirmation = false; 
        } else { 
            factura.lblErrorDireccion.setText(""); 
        }
        
        if (direccionEmail.equals("@email.com")){
            System.out.println("[DEPURACION] dirección de correo no seleccionada"); 
            factura.lblErrorEmail.setText("*debe seleccionar un email*");
            validConfirmation = false;
        } else {
            factura.lblErrorEmail.setText("");
        }

        return validConfirmation; 
    }
}
