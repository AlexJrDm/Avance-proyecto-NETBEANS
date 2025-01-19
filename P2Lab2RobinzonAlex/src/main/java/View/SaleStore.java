package View;

public class SaleStore extends javax.swing.JFrame {
    
    public SaleStore() {
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

        rbtnGrupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnAddToCar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBuscarProducto = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCarrito = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        menuRecarga = new javax.swing.JMenu();
        itemRecarga = new javax.swing.JMenuItem();
        menuAlacena = new javax.swing.JMenu();
        itemAlacena = new javax.swing.JMenuItem();
        menuCarnes = new javax.swing.JMenu();
        itemCarne = new javax.swing.JMenuItem();
        menuFrutas = new javax.swing.JMenu();
        itemFrutas = new javax.swing.JMenuItem();
        menuEmbutidos = new javax.swing.JMenu();
        itemEmbutidos = new javax.swing.JMenuItem();
        menuLegumbres = new javax.swing.JMenu();
        itemLegumbres = new javax.swing.JMenuItem();
        menuAseoP = new javax.swing.JMenu();
        itemAseoPersonal = new javax.swing.JMenuItem();
        MenuAseoH = new javax.swing.JMenu();
        itemAseoHogar = new javax.swing.JMenuItem();
        menuMascotas = new javax.swing.JMenu();
        itemMascotas = new javax.swing.JMenuItem();
        menuLacteos = new javax.swing.JMenu();
        itemLacteos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(161, 43, 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 30, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoAlexStore.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(172, 50, 9));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 20));

        jPanel4.setBackground(new java.awt.Color(147, 48, 15));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 30, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel2.setText("Productos disponibles.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddToCar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddToCar.setText("Añadir al carrito");
        btnAddToCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCarActionPerformed(evt);
            }
        });
        jPanel5.add(btnAddToCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 140, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        jPanel5.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        btnVolver.setBackground(new java.awt.Color(204, 255, 255));
        btnVolver.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 153));
        btnVolver.setText("Volver");
        jPanel5.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Terminar Compra");
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 310, 110));

        rbtnGrupo.add(jRadioButton1);
        jRadioButton1.setText("Si");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, -1, -1));

        rbtnGrupo.add(jRadioButton2);
        jRadioButton2.setText("No");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("¿Desea factura con datos?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercado.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 310, 140));

        btnBuscarProducto.setBackground(new java.awt.Color(255, 153, 102));
        btnBuscarProducto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnBuscarProducto.setText("Buscar produto");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 150, 40));
        jPanel1.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 320, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lupa.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        jPanel6.setBackground(new java.awt.Color(204, 102, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 910, 10));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 210, 20));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 320, 20));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre Producto", "Categoria", "Cantidad", "Valor Unitario", "Cantidad Pedido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 540, 300));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel9.setText("Añadidos al carrito de compras");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        TablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre Producto", "Categoria", "Cantidad", "Precio de la venta"
            }
        ));
        jScrollPane1.setViewportView(TablaCarrito);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 540, 120));

        jPanel7.setBackground(new java.awt.Color(255, 153, 102));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Eliminar producto del carrito");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton4)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, 310, 30));

        menuRecarga.setText("Recargar Tabla");

        itemRecarga.setText("Tabla completa");
        menuRecarga.add(itemRecarga);

        MenuBar.add(menuRecarga);

        menuAlacena.setText("Alacena");

        itemAlacena.setText("ver productos");
        menuAlacena.add(itemAlacena);

        MenuBar.add(menuAlacena);

        menuCarnes.setText("Carnes");

        itemCarne.setText("ver carnes");
        menuCarnes.add(itemCarne);

        MenuBar.add(menuCarnes);

        menuFrutas.setText("Frutas");

        itemFrutas.setText("ver frutas");
        itemFrutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFrutasActionPerformed(evt);
            }
        });
        menuFrutas.add(itemFrutas);

        MenuBar.add(menuFrutas);

        menuEmbutidos.setText("Embutidos");

        itemEmbutidos.setText("ver embutidos");
        menuEmbutidos.add(itemEmbutidos);

        MenuBar.add(menuEmbutidos);

        menuLegumbres.setText("Legumbres");

        itemLegumbres.setText("ver legumbres");
        itemLegumbres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLegumbresActionPerformed(evt);
            }
        });
        menuLegumbres.add(itemLegumbres);

        MenuBar.add(menuLegumbres);

        menuAseoP.setText("Aseo Personal");

        itemAseoPersonal.setText("Ver productos de aseo personal");
        itemAseoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAseoPersonalActionPerformed(evt);
            }
        });
        menuAseoP.add(itemAseoPersonal);

        MenuBar.add(menuAseoP);

        MenuAseoH.setText("Aseo del hogar");

        itemAseoHogar.setText("Ver productos de aseo hogar");
        itemAseoHogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAseoHogarActionPerformed(evt);
            }
        });
        MenuAseoH.add(itemAseoHogar);

        MenuBar.add(MenuAseoH);

        menuMascotas.setText("Productos para mascota");

        itemMascotas.setText("Ver productos para mascotas");
        menuMascotas.add(itemMascotas);

        MenuBar.add(menuMascotas);

        menuLacteos.setText("Lacteos");

        itemLacteos.setText("Ver lacteos");
        menuLacteos.add(itemLacteos);

        MenuBar.add(menuLacteos);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCarActionPerformed
       
    }//GEN-LAST:event_btnAddToCarActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void itemFrutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFrutasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemFrutasActionPerformed

    private void itemLegumbresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLegumbresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemLegumbresActionPerformed

    private void itemAseoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAseoPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemAseoPersonalActionPerformed

    private void itemAseoHogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAseoHogarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemAseoHogarActionPerformed

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
            java.util.logging.Logger.getLogger(SaleStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleStore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu MenuAseoH;
    public javax.swing.JMenuBar MenuBar;
    public javax.swing.JTable TablaCarrito;
    public javax.swing.JButton btnAddToCar;
    public javax.swing.JButton btnBuscarProducto;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnVolver;
    public javax.swing.JMenuItem itemAlacena;
    public javax.swing.JMenuItem itemAseoHogar;
    public javax.swing.JMenuItem itemAseoPersonal;
    public javax.swing.JMenuItem itemCarne;
    public javax.swing.JMenuItem itemEmbutidos;
    public javax.swing.JMenuItem itemFrutas;
    public javax.swing.JMenuItem itemLacteos;
    public javax.swing.JMenuItem itemLegumbres;
    public javax.swing.JMenuItem itemMascotas;
    public javax.swing.JMenuItem itemRecarga;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JMenu menuAlacena;
    public javax.swing.JMenu menuAseoP;
    public javax.swing.JMenu menuCarnes;
    public javax.swing.JMenu menuEmbutidos;
    public javax.swing.JMenu menuFrutas;
    public javax.swing.JMenu menuLacteos;
    public javax.swing.JMenu menuLegumbres;
    public javax.swing.JMenu menuMascotas;
    public javax.swing.JMenu menuRecarga;
    public javax.swing.ButtonGroup rbtnGrupo;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
