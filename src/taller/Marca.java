package taller;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author: JUAN RODRIGO
 */
public class Marca {
    Conexion sql = new Conexion();
    Statement stm;
    ResultSet rest;
    private int id_marca;
    private String desc_marca;
    
    // CONSTRUCTOR: Marca
    public Marca(){}
    
    public Marca(int id_marca, String desc_marca){
        this.id_marca = id_marca;
        this.desc_marca = desc_marca;
    }// Datos marca
    
     public int getId_marca() {
        return id_marca;
    } // obt id_marca
     
     public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }// act id_marca
     
    public String getDesc_marca() {
        return desc_marca;
    }// obt desc_marca
    
    public void Cargar_Marca() {
        DefaultComboBoxModel value;
        String consulta = "select *from marca order by desc_marca;";
        System.out.println(consulta);

        try {
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta);   
            value = new DefaultComboBoxModel(); 
            Orden_Servicio.ob_marca.setModel(value);          
            while (rest.next()) {
                value.addElement(new Marca(rest.getInt("id_marca"),rest.getString("desc_marca")));
            }
            sql.CloseDB(); // cerrar conexion
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        } // try - catch
    }// Cargar_Marca
    
    @Override
    public String toString(){
        return this.desc_marca;
    } // retornar desc_marca

    public int toint(){
        return this.id_marca;
    } // retornar id_marca  
    
}// Marca
