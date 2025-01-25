/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author usuario
 */
public class AddProduct extends javax.swing.JFrame {

    /**
     * Creates new form addProduct
     */
    public AddProduct() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtPVUnitario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPVenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spStockActual = new javax.swing.JSpinner();
        selCategory = new javax.swing.JComboBox<>();
        txtCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        selIva = new javax.swing.JComboBox<>();
        SpStockMin = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        lblErrorStockActual = new javax.swing.JLabel();
        lblErrorCode = new javax.swing.JLabel();
        lblErrorIVA = new javax.swing.JLabel();
        lblErrorPVentas = new javax.swing.JLabel();
        lblErrorCategory = new javax.swing.JLabel();
        lblErrorPUnitario = new javax.swing.JLabel();
        lblErrorProductConfirme = new javax.swing.JLabel();
        lblErrorStockMin = new javax.swing.JLabel();
        checkProduct = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        lblErrorNombreProducto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnInventario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(231, 231, 231));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 48, 16)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "NombreP", "Precio Unitario", "Precio Venta", "IVA", "Stock Mínimo", "Stock Actual", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 960, 150));

        jPanel2.setBackground(new java.awt.Color(190, 93, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 292, -1, -1));

        jPanel5.setBackground(new java.awt.Color(243, 189, 135));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(txtPVUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Precio Unitario (Precio de compra)");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanel5.add(txtPVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 110, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Precio de Venta");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Stock Actual");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));
        jPanel5.add(spStockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 70, -1));

        selCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "Alacena", "Carnes", "Embutidos", "Frutas", "Legumbres", "Aseo Personal", "Aseo del hogar", "Producto para mascotas", "Lacteos" }));
        jPanel5.add(selCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 134, -1));
        jPanel5.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Código del producto");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        selIva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IVA", "0.00", "0.12" }));
        jPanel5.add(selIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));
        jPanel5.add(SpStockMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 70, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Stock Minimo");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        lblErrorStockActual.setForeground(new java.awt.Color(255, 0, 0));
        jPanel5.add(lblErrorStockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 330, 20));

        lblErrorCode.setForeground(new java.awt.Color(255, 0, 0));
        jPanel5.add(lblErrorCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 370, 20));

        lblErrorIVA.setForeground(new java.awt.Color(255, 0, 0));
        jPanel5.add(lblErrorIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 210, 20));

        lblErrorPVentas.setForeground(new java.awt.Color(255, 0, 0));
        jPanel5.add(lblErrorPVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 250, 20));

        lblErrorCategory.setForeground(new java.awt.Color(255, 0, 0));
        jPanel5.add(lblErrorCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 230, 20));

        lblErrorPUnitario.setForeground(new java.awt.Color(255, 0, 0));
        jPanel5.add(lblErrorPUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 230, 20));

        lblErrorProductConfirme.setForeground(new java.awt.Color(255, 0, 0));
        jPanel5.add(lblErrorProductConfirme, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 260, 20));

        lblErrorStockMin.setForeground(new java.awt.Color(255, 0, 0));
        jPanel5.add(lblErrorStockMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 330, 20));

        checkProduct.setText("Confirmar Producto");
        jPanel5.add(checkProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Nombre del producto");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel5.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, -1));
        jPanel5.add(lblErrorNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 380, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 410));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("ALEX STORE");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoAlexStore.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCreate.setText("Agregar");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel4.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnUpdate.setText("Modificar");
        jPanel4.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnDelete.setText("Eliminar");
        jPanel4.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        btnRead.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnRead.setText("Buscar");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        jPanel4.add(btnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 80, -1));

        btnReturn.setBackground(new java.awt.Color(255, 102, 51));
        btnReturn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReturn.setText("Volver");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        jPanel4.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        btnLimpiar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        jPanel4.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 330, 180));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 400, 320));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Compra cliente");
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 93, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carritoCompras.jpg"))); // NOI18N
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 70));

        btnInventario.setText("INVENTARIO DE VENTA");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        jPanel6.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 400, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReturnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JSpinner SpStockMin;
    public javax.swing.JButton btnCreate;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnInventario;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnRead;
    public javax.swing.JButton btnReturn;
    public javax.swing.JButton btnUpdate;
    public javax.swing.JCheckBox checkProduct;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblErrorCategory;
    public javax.swing.JLabel lblErrorCode;
    public javax.swing.JLabel lblErrorIVA;
    public javax.swing.JLabel lblErrorNombreProducto;
    public javax.swing.JLabel lblErrorPUnitario;
    public javax.swing.JLabel lblErrorPVentas;
    public javax.swing.JLabel lblErrorProductConfirme;
    public javax.swing.JLabel lblErrorStockActual;
    public javax.swing.JLabel lblErrorStockMin;
    public javax.swing.JComboBox<String> selCategory;
    public javax.swing.JComboBox<String> selIva;
    public javax.swing.JSpinner spStockActual;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtCode;
    public javax.swing.JTextField txtNombreProducto;
    public javax.swing.JTextField txtPVUnitario;
    public javax.swing.JTextField txtPVenta;
    // End of variables declaration//GEN-END:variables
}
