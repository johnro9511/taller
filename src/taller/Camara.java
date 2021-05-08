package taller;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author: JUAN RODRIGO 
 */
public class Camara extends javax.swing.JFrame {
    public static String dir;
    int largoCamara = 400;
    int anchoCamara = 301;
    
    Dimension dimension = new Dimension(largoCamara,anchoCamara);
    Dimension dimension1 = WebcamResolution.VGA.getSize();
    Webcam webcam = Webcam.getDefault();
    WebcamPanel webcamPanel = new WebcamPanel(webcam,dimension,false);
    
    BufferedImage ruta;
    
    /**
     * Creates new form Camara
     */
    public Camara() {
        initComponents();
        setTitle("EVIDENCIA DE ENTRADA");
        webcam.setViewSize(dimension1);
        webcamPanel.setFillArea(true);
        pnlCamara.setLayout(new FlowLayout());
        pnlCamara.add(webcamPanel);
        libre.setText(webcam.toString()); // label libre
        
        apagar();
       // encender();
    }
    
    public void apagar(){
        capturar.setEnabled(false);
        guardar.setEnabled(false);
    }
    
    public void encender(){
        capturar.setEnabled(true);
    }
    
    public void cargando(){
        capturar.setText("INICIANDO CÁMARA");
        guardar.setText("INICIANDO CÁMARA");
        iniciar.setText("INICIANDO CÁMARA");
    }
    
    public void cargado(){
        capturar.setText("CAPTURAR");
        guardar.setText("GUARDAR");
        iniciar.setText("INICIAR");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        capturar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        pnlCamara = new javax.swing.JPanel();
        foto_guar = new javax.swing.JLabel();
        iniciar = new javax.swing.JButton();
        usando = new javax.swing.JLabel();
        libre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        capturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/capturar.png"))); // NOI18N
        capturar.setText("CAPTURAR");
        capturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capturarActionPerformed(evt);
            }
        });

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/disk.png"))); // NOI18N
        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        pnlCamara.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout pnlCamaraLayout = new javax.swing.GroupLayout(pnlCamara);
        pnlCamara.setLayout(pnlCamaraLayout);
        pnlCamaraLayout.setHorizontalGroup(
            pnlCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        pnlCamaraLayout.setVerticalGroup(
            pnlCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );

        foto_guar.setBackground(new java.awt.Color(255, 153, 204));
        foto_guar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/encender.png"))); // NOI18N
        iniciar.setText("INICIAR");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        usando.setText("USANDO CÁMARA");

        libre.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(capturar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(usando))
                            .addComponent(pnlCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(foto_guar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(libre)
                                .addGap(113, 113, 113)))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniciar)
                    .addComponent(usando)
                    .addComponent(libre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(foto_guar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capturar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
        cargando();
        
        Thread hilo = new Thread(){
            @Override
            public void run(){
                webcamPanel.start(); // iniciar camara web
                encender();
                cargado();
            }
        };
        
        hilo.setDaemon(true);
        hilo.start();
        iniciar.setEnabled(false);
    }//GEN-LAST:event_iniciarActionPerformed

    private void capturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capturarActionPerformed
        guardar.setEnabled(true);
        
        ImageIcon foto;
        foto = new ImageIcon(webcam.getImage());
        Icon iconoFoto = new ImageIcon(foto.getImage().getScaledInstance(foto_guar.getWidth(), foto_guar.getHeight(), Image.SCALE_SMOOTH));
        foto_guar.setIcon(iconoFoto); 
        
        ruta = webcam.getImage();
    }//GEN-LAST:event_capturarActionPerformed
     
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Calendar fecha = Calendar.getInstance();
        int ayo = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        // int segundo = fecha.get(Calendar.SECOND);
        
        int pregunta = JOptionPane.showConfirmDialog(this, "¿GUARDAR FOTO?","ALMACENANDO...",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        
        if (pregunta == 0){ //presiono SI
            File sale_imagen = new File("C:\\evidencias\\"+ Orden_Servicio.txt_placa.getText() +"_"+ dia +"_"+ mes +"_"+ ayo +"_"+ hora +"_"+ min +".jpg");
            
            try {
                ImageIO.write(ruta, "jpg", sale_imagen);
                JOptionPane.showMessageDialog(this, "IMAGEN GUARDADA EN " + sale_imagen.getAbsolutePath());
                dir = sale_imagen.getAbsolutePath();
            } catch(IOException e){
                System.out.println("Error: " + e);
            }
            foto_guar.setIcon(null); 
            guardar.setEnabled(false); 
            webcamPanel.stop();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "CANCELÓ CAPTURA ");
        }       
    }//GEN-LAST:event_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(Camara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Camara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Camara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Camara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Camara().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton capturar;
    public static javax.swing.JLabel foto_guar;
    public static javax.swing.JButton guardar;
    public static javax.swing.JButton iniciar;
    public static javax.swing.JLabel libre;
    public static javax.swing.JPanel pnlCamara;
    public static javax.swing.JLabel usando;
    // End of variables declaration//GEN-END:variables
}
