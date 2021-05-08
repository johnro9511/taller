package taller;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author: JUAN RODRIGO
 */
public class Color {
    Conexion sql = new Conexion();
    Statement stm;
    ResultSet rest;
    private int id_color;
    private String desc_color;
    
    // CONSTRUCTOR: Marca
    public Color(){}
    
    public Color(int id_color, String desc_color){
        this.id_color = id_color;
        this.desc_color = desc_color;
    }// Datos marca

    public int getId_color() {
        return id_color;
    }

    public void setId_color(int id_color) {
        this.id_color = id_color;
    }

    public String getDesc_color() {
        return desc_color;
    }

    public void setDesc_color(String desc_color) {
        this.desc_color = desc_color;
    }
    
    public void Cargar_Color() {
        DefaultComboBoxModel value;
        String consulta = "select *from color order by desc_color;";
        System.out.println(consulta);

        try {
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta);   
            value = new DefaultComboBoxModel(); 
            Orden_Servicio.ob_color.setModel(value);          
            while (rest.next()) {
                value.addElement(new Marca(rest.getInt("id_color"),rest.getString("desc_color")));
            }
            sql.CloseDB(); // cerrar conexion
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        } // try - catch
    }// Cargar_Color
    
    @Override
    public String toString(){
        return this.desc_color;
    } // retornar desc_color

    public int toint(){
        return this.id_color;
    } // retornar id_color
    
}// Color
