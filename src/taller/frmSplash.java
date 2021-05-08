package taller;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;

public class frmSplash extends javax.swing.JFrame implements ActionListener{
    private Timer timer;
    
    int i=0;
    private int contador = 0;
    private String punto = ".";
    
    public frmSplash(){
        initComponents();
        setLocationRelativeTo(null);
       
        Toolkit pantalla = Toolkit.getDefaultToolkit();
      
        setIconImage(pantalla.getImage("src/iconos/cog.png")); // poner icono a la aplicacion
        
        timer = new Timer(40,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent o){
                //contador
                i+=1;
                //al progresbar se le pasa como parametro el contador
                pBar.setValue(i);
                if(contador==45){
                    punto = ".";
                    contador=0;
                    lbMensaje.setText("Cargando");
                } else {
                    punto +=".";
                    lbMensaje.setText("Cargando"+punto);
                }
                
                contador++;
                if(pBar.getValue()>20)                
                pBar.setForeground(Color.orange);
                
                if(pBar.getValue()>60)
                    pBar.setForeground(Color.BLUE); 
                
                //cuando llega a 100 pone un stop
                cek();
            }
        });
        timer.start();
    } //frmSplash
    
    //metodo para hacer que haga un stop antes de llegar a 100
    public void cek(){
        if(pBar.getPercentComplete()==1.0){
            timer.stop();   
            
           Principal main = new Principal();
            main.setVisible(true);
            
            this.dispose();
        }        
    }// cek       
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pBar = new javax.swing.JProgressBar();
        lbMensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("CARGANDO...");
        setForeground(java.awt.Color.white);
        setUndecorated(true);
        getContentPane().setLayout(null);

        pBar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pBar.setForeground(new java.awt.Color(255, 0, 0));
        pBar.setDoubleBuffered(true);
        pBar.setStringPainted(true);
        getContentPane().add(pBar);
        pBar.setBounds(0, 290, 500, 30);

        lbMensaje.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        lbMensaje.setForeground(new java.awt.Color(255, 0, 0));
        lbMensaje.setText("Cargando..");
        getContentPane().add(lbMensaje);
        lbMensaje.setBounds(0, 250, 500, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/portada2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 250);

        setSize(new java.awt.Dimension(499, 328));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            frmSplash a;
            public void run() {
                a = new frmSplash();
                a.setVisible(true);
            }
        });
    } // main
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // IMPORTANTE P/QUE INICIE LA APLICACION 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbMensaje;
    private javax.swing.JProgressBar pBar;
    // End of variables declaration//GEN-END:variables

    }// frmSplash