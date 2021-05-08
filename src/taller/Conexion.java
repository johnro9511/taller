package taller;

import java.sql.*;
/**
 *
 * @author: JUAN RODRIGO
 */
public class Conexion {
    Statement stm;
    Connection con;
    
    public Statement CrearConexion(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/taller","postgres","noviembre15");
            stm = con.createStatement();
            System.out.println("conectado");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error conexion: "+e.getMessage());
        }
        return stm;
    }// CrearConexion
 
      public void CloseDB()
    {
        try
        {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // CloseDB
    
}// Conexion
