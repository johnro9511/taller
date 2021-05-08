package taller;

import java.awt.Component;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author JUAN RODRIGO
 */
public class Reportes extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof JLabel){
            JLabel lbl = (JLabel)value;
            return lbl;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    }
    
    Conexion sql = new Conexion();
    Statement stm;
    ResultSet rest;
    public Integer totalregistros, treg_b;
    public String[] registro = new String[8];

    // CONSTRUCTOR: Reportes
    public Reportes(){}
    
    public DefaultTableModel Buscar_Entradas() {
        Rep_Entrada.tabla_rep_ent.setDefaultRenderer(Object.class, new Reportes());
        DefaultTableModel modelo;
        Date Fecha1;
        Date Fecha2;
        
        String fecha_ini = new SimpleDateFormat("yyyy-MM-dd").format(Rep_Entrada.fecha_ent.getDate());
        Fecha1 = Date.valueOf(fecha_ini);
        
        String fecha_fin = new SimpleDateFormat("yyyy-MM-dd").format(Rep_Entrada.fecha_sal.getDate());
        Fecha2 = Date.valueOf(fecha_fin);
        
        String[] titulos = {"No. ORDEN", "FECHA", "PLACA", "MARCA", "MODELO", "COLOR", "DIAGNOSTICO","FOTO"};

        treg_b = 0;
        modelo = new DefaultTableModel(null, titulos);
        String consulta = "select o.no_orden,o.fec_orden,a.no_placa,m.desc_marca,a.modelo,c.desc_color,o.diagnostico,o.foto_diag from orden_servicio o,"
                + "auto a, marca m, color c where o.no_placa=a.no_placa and m.id_marca=a.id_marca and c.id_color=a.id_color and "
                + "o.fec_orden between '"+ Fecha1 +"' and '"+ Fecha2 +"';";
        System.out.println(consulta);
        
        try {
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta);

            while (rest.next()) {
                registro[0] = rest.getString("no_orden");               
                registro[1] = rest.getString("fec_orden");
                registro[2] = rest.getString("no_placa");
                registro[3] = rest.getString("desc_marca");
                registro[4] = rest.getString("modelo");
                registro[5] = rest.getString("desc_color");
                registro[6] = rest.getString("diagnostico");
                registro[7] = rest.getString("foto_diag");
               
                treg_b = treg_b + 1;
                modelo.addRow(new Object []{
                    registro[0],registro[1],registro[2],registro[3],registro[4],registro[5],registro[6],new JLabel(new ImageIcon(registro[7]))}); 
            }
            sql.CloseDB();

            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    } // buscar_entradas
    
    public void Mostrar_Entradas() {
        try {
            DefaultTableModel modelo;

            modelo = Buscar_Entradas();
            
            Rep_Entrada.tabla_rep_ent.setRowHeight(234); 
            Rep_Entrada.tabla_rep_ent.setModel(modelo);
            Rep_Entrada.tot_reg.setText(Integer.toString(treg_b));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }// mostrar_entradas
    
    public void Rep_Ent() {
          Date Fechaaaa;
          Date Fechaaaa2;
          
        System.out.println("ando en orden de servicio");
        String fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").format(Rep_Entrada.fecha_ent.getDate());
        System.out.println("esto es fecha inicio"+fecha_inicio);
        Fechaaaa = Date.valueOf(fecha_inicio);
   
        String fecha_final = new SimpleDateFormat("yyyy-MM-dd").format(Rep_Entrada.fecha_sal.getDate());
        System.out.println("esto es fecha final"+fecha_final);
        Fechaaaa2 = Date.valueOf(fecha_final);
        
         stm = sql.CrearConexion();
         
         try{
            String archivo = System.getProperty ("user.dir")+"\\src\\reportes\\rep_ent.jasper";
            System.out.println("Cargando desde: " + archivo);
            if(archivo == null){
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n", "Generar Reporte",JOptionPane.ERROR_MESSAGE);
            } JasperReport masterReport= null;
            try {
                masterReport= (JasperReport) JRLoader.loadObject(archivo);               
            } catch (JRException e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n","Generar Reporte",JOptionPane.ERROR_MESSAGE);
            }
            
            Map parametro = new HashMap();    
            parametro.put("fecha1", Fechaaaa);
            parametro.put("fecha2",Fechaaaa2);
            
            JasperPrint jasperPrint= JasperFillManager.fillReport(masterReport,parametro,stm.getConnection());
            JasperViewer jviewer= new JasperViewer(jasperPrint,false);
            jviewer.setTitle("REPORTE DE ENTRADA DE SERVICIOS");
            jviewer.setVisible(true);
            
            sql.CloseDB(); // cerrar conexion
        }catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
    } // Rep_Ent 
    
    public DefaultTableModel Buscar_Salidas() {
        Rep_Salida.tabla_rep_sal.setDefaultRenderer(Object.class, new Reportes());
        DefaultTableModel modelo;
        Date Fecha1;
        Date Fecha2;
        
        String fecha_ini = new SimpleDateFormat("yyyy-MM-dd").format(Rep_Salida.fecha_ent.getDate());
        Fecha1 = Date.valueOf(fecha_ini);
        
        String fecha_fin = new SimpleDateFormat("yyyy-MM-dd").format(Rep_Salida.fecha_sal.getDate());
        Fecha2 = Date.valueOf(fecha_fin);
        
        String[] titulos = {"HORA ENT", "FECHA", "PLACA", "MARCA", "MODELO", "COLOR", "SERV. REALIZADO","FOTO"};

        treg_b = 0;
        modelo = new DefaultTableModel(null, titulos);
        String consulta = "select o.hora_sal,o.fec_orden,a.no_placa,m.desc_marca,a.modelo,c.desc_color,o.serv_realizado,o.foto_serv_real from orden_servicio o,"
                + "auto a, marca m, color c where o.no_placa=a.no_placa and m.id_marca=a.id_marca and c.id_color=a.id_color and "
                + "o.fec_orden between '"+ Fecha1 +"' and '"+ Fecha2 +"';";
        System.out.println(consulta);
        
        try {
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta);

            while (rest.next()) {
                registro[0] = rest.getString("hora_sal");               
                registro[1] = rest.getString("fec_orden");
                registro[2] = rest.getString("no_placa");
                registro[3] = rest.getString("desc_marca");
                registro[4] = rest.getString("modelo");
                registro[5] = rest.getString("desc_color");
                registro[6] = rest.getString("serv_realizado");
                registro[7] = rest.getString("foto_serv_real");
               
                treg_b = treg_b + 1;
                modelo.addRow(new Object []{
                    registro[0],registro[1],registro[2],registro[3],registro[4],registro[5],registro[6],new JLabel(new ImageIcon(registro[7]))}); 
            }
            sql.CloseDB();

            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    } // buscar_salidas
    
    public void Mostrar_Salidas() {
        try {
            DefaultTableModel modelo;

            modelo = Buscar_Salidas();
            
            Rep_Salida.tabla_rep_sal.setRowHeight(234); 
            Rep_Salida.tabla_rep_sal.setModel(modelo);
            Rep_Salida.tot_reg.setText(Integer.toString(treg_b));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }// mostrar_salidas
    
    public void Rep_Sal() {
          Date Fechaaaa;
          Date Fechaaaa2;
          
          System.out.println("ando en orden de servicio");
        String fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").format(Rep_Salida.fecha_ent.getDate());
        System.out.println("esto es fecha inicio"+fecha_inicio);
        Fechaaaa = Date.valueOf(fecha_inicio);
   
        String fecha_final = new SimpleDateFormat("yyyy-MM-dd").format(Rep_Salida.fecha_sal.getDate());
        System.out.println("esto es fecha final"+fecha_final);
        Fechaaaa2 = Date.valueOf(fecha_final);
        
         stm = sql.CrearConexion();
         
         try{
            String archivo = System.getProperty ("user.dir")+"\\src\\reportes\\rep_sal.jasper";
            System.out.println("Cargando desde: " + archivo);
            if(archivo == null){
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n", "Generar Reporte",JOptionPane.ERROR_MESSAGE);
            } JasperReport masterReport= null;
            try {
                masterReport= (JasperReport) JRLoader.loadObject(archivo);               
            } catch (JRException e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n","Generar Reporte",JOptionPane.ERROR_MESSAGE);
            }
            
            Map parametro = new HashMap();    
            parametro.put("fecha1", Fechaaaa);
            parametro.put("fecha2",Fechaaaa2);
            
            JasperPrint jasperPrint= JasperFillManager.fillReport(masterReport,parametro,stm.getConnection());
            JasperViewer jviewer= new JasperViewer(jasperPrint,false);
            jviewer.setTitle("REPORTE DE SALIDA DE SERVICIOS");
            jviewer.setVisible(true);
            
            sql.CloseDB(); // cerrar conexion
        }catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
    } // Rep_Sal
    
    public DefaultTableModel Buscar_General() {
        Rep_General.tabla_rep_sal.setDefaultRenderer(Object.class, new Reportes());
        DefaultTableModel modelo;
        Date Fecha1;
        Date Fecha2;
        
        String fecha_ini = new SimpleDateFormat("yyyy-MM-dd").format(Rep_General.fecha_ent.getDate());
        Fecha1 = Date.valueOf(fecha_ini);
        
        String fecha_fin = new SimpleDateFormat("yyyy-MM-dd").format(Rep_General.fecha_sal.getDate());
        Fecha2 = Date.valueOf(fecha_fin);
        
        String[] titulos = {"No. ORDEN", "PLACA", "MARCA", "MODELO", "NOMBRES","APELLIDOS", "H. ENTRADA","H. SALIDA"};

        treg_b = 0;
        modelo = new DefaultTableModel(null, titulos);
        String consulta = "select o.no_orden,a.no_placa,m.desc_marca,a.modelo,c.nombre,c.apellidos,o.hora_ent,o.hora_sal from orden_servicio o,"
                + "auto a, marca m, cliente c where o.no_placa=a.no_placa and m.id_marca=a.id_marca and c.id_cliente=o.id_cliente and "
                + "o.fec_orden between '"+ Fecha1 +"' and '"+ Fecha2 +"';";
        System.out.println(consulta);
        
        try {
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta);

            while (rest.next()) {
                registro[0] = rest.getString("no_orden");               
                registro[1] = rest.getString("no_placa");
                registro[2] = rest.getString("desc_marca");
                registro[3] = rest.getString("modelo");
                registro[4] = rest.getString("nombre");
                registro[5] = rest.getString("apellidos");
                registro[6] = rest.getString("hora_ent");
                registro[7] = rest.getString("hora_sal");
               
                treg_b = treg_b + 1;
                modelo.addRow(new Object []{
                    registro[0],registro[1],registro[2],registro[3],registro[4],registro[5],registro[6],registro[7]}); 
            }
            sql.CloseDB();

            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    } // buscar_general
    
    public void Mostrar_General() {
        try {
            DefaultTableModel modelo;

            modelo = Buscar_General();
            
            Rep_General.tabla_rep_sal.setRowHeight(234); 
            Rep_General.tabla_rep_sal.setModel(modelo);
            Rep_General.tot_reg.setText(Integer.toString(treg_b));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }// mostrar_General
    
    public void Rep_Gen() {
          Date Fechaaaa;
          Date Fechaaaa2;
          
          System.out.println("ando en orden de servicio");
        String fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").format(Rep_General.fecha_ent.getDate());
        System.out.println("esto es fecha inicio"+fecha_inicio);
        Fechaaaa = Date.valueOf(fecha_inicio);
   
        String fecha_final = new SimpleDateFormat("yyyy-MM-dd").format(Rep_General.fecha_sal.getDate());
        System.out.println("esto es fecha final"+fecha_final);
        Fechaaaa2 = Date.valueOf(fecha_final);
        
         stm = sql.CrearConexion();
         
         try{
            String archivo = System.getProperty ("user.dir")+"\\src\\reportes\\rep_gen.jasper";
            System.out.println("Cargando desde: " + archivo);
            if(archivo == null){
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n", "Generar Reporte",JOptionPane.ERROR_MESSAGE);
            } JasperReport masterReport= null;
            try {
                masterReport= (JasperReport) JRLoader.loadObject(archivo);               
            } catch (JRException e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n","Generar Reporte",JOptionPane.ERROR_MESSAGE);
            }
            
            Map parametro = new HashMap();    
            parametro.put("fecha1", Fechaaaa);
            parametro.put("fecha2",Fechaaaa2);
            
            JasperPrint jasperPrint= JasperFillManager.fillReport(masterReport,parametro,stm.getConnection());
            JasperViewer jviewer= new JasperViewer(jasperPrint,false);
            jviewer.setTitle("REPORTE GENERAL DE SERVICIOS");
            jviewer.setVisible(true);
            
            sql.CloseDB(); // cerrar conexion
        }catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
    } // Rep_Gen
    
    public void reciboVer(){
         stm = sql.CrearConexion();
         
         try{
            String archivo = System.getProperty ("user.dir")+"\\src\\reportes\\recibow.jasper";
            System.out.println("Cargando desde: " + archivo);
            if(archivo == null){
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n", "Generar Reporte",JOptionPane.ERROR_MESSAGE);
            } JasperReport masterReport= null;
            try {
                masterReport= (JasperReport) JRLoader.loadObject(archivo);               
            } catch (JRException e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                JOptionPane.showMessageDialog(null,"Error al generar reporte, verifique impresora\n","Generar Reporte",JOptionPane.ERROR_MESSAGE);
            }
            
            Map parametro = new HashMap();    
            parametro.put("cantidad", "125");
            parametro.put("trabajador","JUAN RODRIGO MALDONADO PEREZ");
            parametro.put("letras", "CIENTO VEINTICINCO PESOS 00/100");
            parametro.put("concepto","PAGO POR EXTRAVIO DE GAFETE");
            parametro.put("fecha","20-05-2020");
            
            JasperPrint jasperPrint= JasperFillManager.fillReport(masterReport,parametro,stm.getConnection());
            JasperViewer jviewer= new JasperViewer(jasperPrint,false);
            jviewer.setTitle("REPORTE DE ENTRADA DE SERVICIOS");
            jviewer.setVisible(true);
            
          //  sql.CloseDB(); // cerrar conexion
        }catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
    }// reciboVer
    
}// Reportes
