package taller;

import javax.swing.JOptionPane;

/**
 *
 * @author JUAN RODRIGO
 */
public class Ord_Serv_Sal extends javax.swing.JFrame {
    Servicio_Ent serv = new Servicio_Ent();
    
    /**
     * Creates new form Ord_Serv_Sal
     */
    public Ord_Serv_Sal() {
        initComponents();
        
        setTitle("SALIDA DE SERVICIO");
        
        serv.hora_salida();
        
        btn_tom_foto.setEnabled(false);
        btn_registrar.setEnabled(false);
        txt_marca.setEditable(false);
        txt_color.setEditable(false);
        txt_modelo.setEditable(false);
        txt_orden.setEditable(false);
    }// Ord_Serv_Sal

     public void limpiar(){
        txt_placa.setText("");
        txt_modelo.setText("");
        txt_marca.setText(""); 
        txt_color.setText("");
        txt_orden.setText("");
        txt_diagnostico.setText("");
    }//limpiar
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JTextField();
        btn_buscar_placa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_diagnostico = new javax.swing.JTextArea();
        txt_hora_sal = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        txt_color = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_orden = new javax.swing.JTextField();
        btn_tom_foto = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("PLACA:");

        txt_placa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_placa.setForeground(new java.awt.Color(0, 0, 255));
        txt_placa.setToolTipText("INGRESA PLACA");

        btn_buscar_placa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscar_placa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/page_find.png"))); // NOI18N
        btn_buscar_placa.setText("BUSCAR");
        btn_buscar_placa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_placaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("HORA ENTRADA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("MARCA:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("MODELO: ");

        txt_modelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(0, 0, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("COLOR:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("DIAGNOSTICO:");

        txt_diagnostico.setColumns(20);
        txt_diagnostico.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txt_diagnostico.setRows(5);
        jScrollPane1.setViewportView(txt_diagnostico);

        txt_hora_sal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_hora_sal.setForeground(new java.awt.Color(0, 0, 204));
        txt_hora_sal.setText("--:--:--");

        txt_marca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_marca.setForeground(new java.awt.Color(0, 0, 255));

        txt_color.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_color.setForeground(new java.awt.Color(0, 0, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ORDEN: ");

        txt_orden.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_orden.setForeground(new java.awt.Color(0, 0, 255));
        txt_orden.setToolTipText("INGRESA PLACA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_orden, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_buscar_placa)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_hora_sal)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar_placa)
                    .addComponent(jLabel2)
                    .addComponent(txt_hora_sal))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btn_tom_foto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_tom_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tomar_foto.png"))); // NOI18N
        btn_tom_foto.setText("TOMAR FOTO");
        btn_tom_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tom_fotoActionPerformed(evt);
            }
        });

        btn_registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/disk.png"))); // NOI18N
        btn_registrar.setText("REGISTRAR");
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_tom_foto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_registrar)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tom_foto)
                    .addComponent(btn_registrar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscar_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_placaActionPerformed
        if(txt_placa.getText().toUpperCase().trim().equals("")){
            JOptionPane.showMessageDialog(this, "CAMPO VACIO:  INGRESE UNA PLACA ", "BUSCANDO PLACA...", 0);
        } else {
            if(serv.buscar_placa_salida(txt_placa.getText().toUpperCase().replace("'", "").replace(";", "").replace("=", "").trim()) == 1){
                JOptionPane.showMessageDialog(this, "PLACA ENCONTRADA");
                btn_tom_foto.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "PLACA NO ENCONTRADA \n\n  INGRESE DATOS");
            }// if si hay datos registrados
        }// else campo placa vacio
    }//GEN-LAST:event_btn_buscar_placaActionPerformed

    private void btn_tom_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tom_fotoActionPerformed
        new Camara_Sal().setVisible(true);
        btn_registrar.setEnabled(true);
    }//GEN-LAST:event_btn_tom_fotoActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        serv.Editar_resultado();
        limpiar();
        this.dispose();
    }//GEN-LAST:event_btn_registrarActionPerformed

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
            java.util.logging.Logger.getLogger(Ord_Serv_Sal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ord_Serv_Sal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ord_Serv_Sal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ord_Serv_Sal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ord_Serv_Sal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_buscar_placa;
    public static javax.swing.JButton btn_registrar;
    public static javax.swing.JButton btn_tom_foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField txt_color;
    public static javax.swing.JTextArea txt_diagnostico;
    public static javax.swing.JLabel txt_hora_sal;
    public static javax.swing.JTextField txt_marca;
    public static javax.swing.JTextField txt_modelo;
    public static javax.swing.JTextField txt_orden;
    public static javax.swing.JTextField txt_placa;
    // End of variables declaration//GEN-END:variables
}