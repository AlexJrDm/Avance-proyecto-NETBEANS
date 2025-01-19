package com.mycompany.p2lab2robinzonalex;

import Controller.ControllerAdmin;
import Controller.ControllerFacture;
import Controller.ControllerSaleStore;
import Controller.ControllerStore;
import Controller.ControllerUser;
import Model.ConexionMongoDB;
import Model.Products;
import View.AddProduct;
import View.Admin;
import View.FactureClients;
import View.Login;
import View.MainMenu;
import View.MenuAdmin;
import View.RecoverPassword;
import View.Registration;
import View.SaleStore;

public class P2Lab2RobinzonAlex {
    public static void main(String[] args) {
        AddProduct addProduct = new AddProduct();
        Login login = new Login();
        Registration regis = new Registration();
        ControllerUser  userController = new ControllerUser();
        RecoverPassword recover = new RecoverPassword();
        Products productModel = new Products("", "", "", "", "", "", "","");
        SaleStore storeMenuSecond = new SaleStore();
        ConexionMongoDB mongo = new ConexionMongoDB();
        MainMenu menu = new MainMenu();
        FactureClients factura = new FactureClients();
        Admin admin = new Admin();
        MenuAdmin menuAdmin = new MenuAdmin();
        
        
        ControllerAdmin controllerAdmin = new ControllerAdmin(mongo, admin);
        ControllerFacture controllerFacture = new ControllerFacture(factura);
        ControllerSaleStore controlSaleStore = new ControllerSaleStore(storeMenuSecond, mongo, controllerFacture);
        ControllerStore control = new ControllerStore(addProduct, productModel, 
                login, regis, userController, recover, storeMenuSecond, controlSaleStore, menu, factura, controllerAdmin,
        menuAdmin, admin, controllerFacture);
        control.startViewLogin();
    }
}
