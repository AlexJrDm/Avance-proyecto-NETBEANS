package Model;

import View.FactureClients;

public class ModelFacture implements Interface{
    private String lastNames;
    private String names;
    private String addres;
    private String dni;
    private String email;
    private String cellPhone;
    
    public boolean validConfirmation = true;

    public ModelFacture(String lastNames, String names, String addres, String dni, String email, String cellPhone) {
        this.lastNames = lastNames;
        this.names = names;
        this.addres = addres;
        this.dni = dni;
        this.email = email;
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
    
    public boolean validationsFacture(FactureClients factura) {
        System.out.println("Validamos datos de factura");
        validConfirmation = true;

        // Validar nombres
        String names = getNames();
        if (names.isEmpty()) {
        System.out.println("[DEPURACION] Names está vacío");
        factura.lblErrorNames.setText("*campo obligatorio*");
        validConfirmation = false;
        } else {
            factura.lblErrorNames.setText("");
        }

        // Validar apellidos
        String lastNames = getLastNames();
        if (lastNames.isEmpty()) {
            System.out.println("[DEPURACION] LastNames está vacío");
            factura.lblErrorLastNames.setText("*campo obligatorio*");
            validConfirmation = false;
        } else {
            factura.lblErrorLastNames.setText("");
        }

        // Validar DNI
        String dni = getDni();
        if (dni.isEmpty()) {
            System.out.println("[DEPURACION] DNI está vacío");
            factura.lblErrorDni.setText("*campo obligatorio*");
            validConfirmation = false;
        } else if (dni.length() != 10) {
            System.out.println("[DEPURACION] número de caracteres inválidos");
            factura.lblErrorDni.setText("*debe contener 10 caracteres*");
            validConfirmation = false;
        } else {
            factura.lblErrorDni.setText("");
        }

        // Validar celular
        String cellPhone = getCellPhone();
        if (cellPhone.isEmpty()) {
            System.out.println("[DEPURACION] Cell está vacío");
            factura.lblErrorCell.setText("*campo obligatorio*");
            validConfirmation = false;
        } else if (cellPhone.length() != 10) {
            System.out.println("[DEPURACION] número de caracteres inválidos");
            factura.lblErrorCell.setText("*debe contener 10 caracteres*");
            validConfirmation = false;
        } else {
            factura.lblErrorCell.setText("");
        }

        // Validar email
        String email = getEmail();
        if (email.isEmpty()) {
            System.out.println("[DEPURACION] correo está vacío");
            factura.lblErrorEmail.setText("*campo obligatorio*");
            validConfirmation = false;
        } else {
            factura.lblErrorEmail.setText("");
        }

        // Validar dirección
        String address = getAddres();
        if (address.isEmpty()) {
            System.out.println("[DEPURACION] dirección está vacía");
            factura.lblErrorDireccion.setText("*campo obligatorio*");
            validConfirmation = false;
        } else {
            factura.lblErrorDireccion.setText("");
        }

        return validConfirmation;
    }
    
    @Override 
    public void getData() {
        
    }
}
