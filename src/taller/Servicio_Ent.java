package taller;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author: JUAN RODRIGO
 */
public class Servicio_Ent {
    Conexion sql = new Conexion();
    Statement stm;
    ResultSet rest;
    String id_marca, id_color, modelo;
    String id_marca_txt, id_color_txt;
    int id_cliente, valor1, no_orden;
    String desc_color, desc_marca, nombre;
    String apellidos, domicilio, email, telefono;
    Integer juan_recibe;
    
    // CONSTRUCTOR: Servicios
    public Servicio_Ent(){}
    
    public void hora_entrada(){
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        Orden_Servicio.txt_hora_ent.setText(formateador.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }// hora_entrada
    
    public void ob_id_marca() {
        String nom_marca = Orden_Servicio.ob_marca.getSelectedItem().toString().trim();
        String consulta = "SELECT id_marca FROM marca where desc_marca='" + nom_marca + "'";
        System.out.println("marca "+ consulta);
           try{
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta); 
            sql.CloseDB();  
            while (rest.next()) {
                id_marca = rest.getString("id_marca");                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }// od_id_marca
    
    public void ob_id_color() {
        String nom_color = Orden_Servicio.ob_color.getSelectedItem().toString().trim();
        String consulta = "SELECT id_color FROM color where desc_color='" + nom_color + "'";
        System.out.println("color "+ consulta);
           try{
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta); 
            sql.CloseDB();  
            while (rest.next()) {
                id_color = rest.getString("id_color");                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }// od_id_color
    
    public int buscar_placa(String placa) {
        int result = 0;
        String consulta = "select a.*,m.*,c.*,x.* from auto a, marca m, color c, cliente x where a.id_color = c.id_color "
                + "and a.id_marca = m.id_marca and a.no_placa = x.no_placa and a.no_placa ='" + placa +"';";
        System.out.println(consulta);
        
        try {
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta);

            while (rest.next()) {
                modelo = rest.getString("modelo");
                desc_marca = rest.getString("desc_marca");
                desc_color = rest.getString("desc_color");
                id_cliente = rest.getInt("id_cliente");
                nombre = rest.getString("nombre");
                apellidos = rest.getString("apellidos");
                domicilio = rest.getString("domicilio");
                email = rest.getString("email");
                telefono = rest.getString("telefono");
                
                Orden_Servicio.txt_modelo.setText(modelo);
                Orden_Servicio.txt_marca.setText(desc_marca);
                Orden_Servicio.txt_color.setText(desc_color);
                Orden_Servicio.txt_cliente.setText("" + id_cliente);
                Orden_Servicio.txt_nombre.setText(nombre);
                Orden_Servicio.txt_apellido.setText(apellidos);
                Orden_Servicio.txt_domicilio.setText(domicilio);
                Orden_Servicio.txt_email.setText(email);
                Orden_Servicio.txt_telefono.setText(telefono);               
                result = 1;
            }
            sql.CloseDB();
            return result;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return 0;
        }
    } // Buscar_placa
    
    public int buscar_Cliente(String Nom, String Ape) {
        int result = 0;
        String consulta = "select * from cliente where nombre like '"+"%" + Nom + "%"+"' and apellidos like '"+"%" + Ape + "%"+ "' limit 1;";
        System.out.println(consulta);
        
        try {
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta);

            while (rest.next()) {
                id_cliente = rest.getInt("id_cliente");
                nombre = rest.getString("nombre");
                apellidos = rest.getString("apellidos");
                domicilio = rest.getString("domicilio");
                email = rest.getString("email");
                telefono = rest.getString("telefono");
                
                Orden_Servicio.txt_cliente.setText("" + id_cliente);
                Orden_Servicio.txt_nombre.setText(nombre);
                Orden_Servicio.txt_apellido.setText(apellidos);
                Orden_Servicio.txt_domicilio.setText(domicilio);
                Orden_Servicio.txt_email.setText(email);
                Orden_Servicio.txt_telefono.setText(telefono);
                
                result = 1;
            }
            sql.CloseDB();
            return result;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return 0;
        }
    } // Buscar_cliente
    
    public Integer consulta_id_cliente() {
        String consulta = "select * from cliente order by id_cliente desc limit 1";
        System.out.println(consulta);
        
        try {
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta);

            while (rest.next()) {
                juan_recibe = rest.getInt("id_cliente");
            }
            sql.CloseDB();
            return juan_recibe;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    } // Consulta_Id_cliente
      
    public void cont_nuevo_cli() {
        consulta_id_cliente();
        
        System.out.println("esto es juan: " + juan_recibe +", valor: " + valor1);
        Integer contador = 0;
       
        if (juan_recibe == null ) {
            Orden_Servicio.txt_cliente.setText("1");
        } else {
            contador = juan_recibe + 1;
            Orden_Servicio.txt_cliente.setText(contador.toString());
        }
    }  // cont_nuevo_cli
    
    public void ob_id_marca_txt() {
        String nom_marca = Orden_Servicio.txt_marca.getText().toUpperCase().trim();
        String consulta = "SELECT id_marca FROM marca where desc_marca='" + nom_marca + "'";
        System.out.println("marca "+ consulta);
           try{
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta); 
            sql.CloseDB();  
            while (rest.next()) {
                id_marca_txt = rest.getString("id_marca");                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }// od_id_marca
    
    public void ob_id_color_txt() {
        String nom_color = Orden_Servicio.txt_color.getText().toUpperCase().trim();
        String consulta = "SELECT id_color FROM color where desc_color='" + nom_color + "'";
        System.out.println("color "+ consulta);
           try{
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta); 
            sql.CloseDB();  
            while (rest.next()) {
                id_color_txt = rest.getString("id_color");                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }// od_id_color
    
    public boolean Reg_datos_comb(){      
        ob_id_marca();
        ob_id_color();
       
        try {
            stm = sql.CrearConexion();

            String plc = Orden_Servicio.txt_placa.getText().toUpperCase().trim();
            String idm = id_marca;
            String idc = id_color;
            String mod = Orden_Servicio.txt_modelo.getText().toUpperCase().trim();
            String hor = Orden_Servicio.txt_hora_ent.getText().toUpperCase().trim();
            String dig = Orden_Servicio.txt_diagnostico.getText().toUpperCase().trim();          
            String cli = Orden_Servicio.txt_cliente.getText().toUpperCase().trim();
            String nom = Orden_Servicio.txt_nombre.getText().toUpperCase().trim();
            String ape = Orden_Servicio.txt_apellido.getText().toUpperCase().trim();
            String ema = Orden_Servicio.txt_email.getText().trim();
            String tel = Orden_Servicio.txt_telefono.getText().toUpperCase().trim();
            String dom = Orden_Servicio.txt_domicilio.getText().toUpperCase().trim();
            String fot = Camara.dir.trim();

            String consulta = ("SELECT orden_serv_ent('"+ plc +"'::varchar,"+ idm +"::integer,'"+ mod +"'::varchar,"
                    + idc +"::integer,'"+ hor +"'::time,'"+ dig +"'::varchar,'"+ fot +"'::varchar,"+ cli +"::integer,'"+ nom +"'::varchar,'"
                    + ape +"'::varchar,'"+ ema +"'::varchar,'"+ tel +"'::varchar,'"+ dom +"'::varchar);");

            System.out.println("METIENDO" + consulta);

            int z = stm.executeUpdate(consulta);
            sql.CloseDB();

            if (z != 0) {
                JOptionPane.showMessageDialog(null, " DATOS REGISTRADOS CON EXITO ", "GUARDANDO", JOptionPane.WARNING_MESSAGE);
                return true;
            } else {
                return false;
            }
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " DATOS REGISTRADOS CON EXITO ", "GUARDANDO", JOptionPane.WARNING_MESSAGE);
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }            
    } // Reg_datos
    
    public boolean Reg_datos_txt(){      
        ob_id_marca();
        ob_id_color();
       
        try {
            stm = sql.CrearConexion();

            String plc = Orden_Servicio.txt_placa.getText().toUpperCase().trim();
            String idm = id_marca_txt;
            String idc = id_color_txt;
            String mod = Orden_Servicio.txt_modelo.getText().toUpperCase().trim();
            String hor = Orden_Servicio.txt_hora_ent.getText().toUpperCase().trim();
            String dig = Orden_Servicio.txt_diagnostico.getText().toUpperCase().trim();          
            String cli = Orden_Servicio.txt_cliente.getText().toUpperCase().trim();
            String nom = Orden_Servicio.txt_nombre.getText().toUpperCase().trim();
            String ape = Orden_Servicio.txt_apellido.getText().toUpperCase().trim();
            String ema = Orden_Servicio.txt_email.getText().trim();
            String tel = Orden_Servicio.txt_telefono.getText().toUpperCase().trim();
            String dom = Orden_Servicio.txt_domicilio.getText().toUpperCase().trim();
            String fot = Camara.dir.trim();

            String consulta = ("SELECT orden_serv_ent('"+ plc +"'::varchar,"+ idm +"::integer,'"+ mod +"'::varchar,"
                    + idc +"::integer,'"+ hor +"'::time,'"+ dig +"'::varchar,'"+ fot +"'::varchar,"+ cli +"::integer,'"+ nom +"'::varchar,'"
                    + ape +"'::varchar,'"+ ema +"'::varchar,'"+ tel +"'::varchar,'"+ dom +"'::varchar);");

            System.out.println("METIENDO: " + consulta);

            int z = stm.executeUpdate(consulta);
            sql.CloseDB();

            if (z != 0) {
                JOptionPane.showMessageDialog(null, " DATOS REGISTRADOS CON EXITO ", "GUARDANDO", 1);
                return true;
            } else {
                return false;
            }
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " DATOS REGISTRADOS CON EXITO ", "GUARDANDO", 1);
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }            
    } // Reg_datos
    
    public int buscar_placa_salida(String placa) {
        int result = 0;
        String consulta = "select a.*,m.*,c.*,o.* from auto a, marca m, color c, orden_servicio o where a.id_color = c.id_color "
                + "and a.id_marca = m.id_marca and a.no_placa = o.no_placa and a.no_placa ='" + placa +"' order by no_orden desc limit 1;";
        System.out.println(consulta);
        
        try {
            stm = sql.CrearConexion();
            rest = stm.executeQuery(consulta);

            while (rest.next()) {
                modelo = rest.getString("modelo");
                desc_marca = rest.getString("desc_marca");
                desc_color = rest.getString("desc_color");
                no_orden = rest.getInt("no_orden");
                
                Ord_Serv_Sal.txt_modelo.setText(modelo);
                Ord_Serv_Sal.txt_marca.setText(desc_marca);
                Ord_Serv_Sal.txt_color.setText(desc_color);
                Ord_Serv_Sal.txt_orden.setText("" + no_orden);
                
                result = 1;
            }
            sql.CloseDB();
            return result;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return 0;
        }
    } // Buscar_placa_Salida
    
    public boolean Editar_resultado() {
        String diag = Ord_Serv_Sal.txt_diagnostico.getText().toUpperCase().replace("'", "").replace(";", "").trim();
        String ordn = Ord_Serv_Sal.txt_orden.getText().toUpperCase().replace("'", "").replace(";", "").trim();
        String hora = Ord_Serv_Sal.txt_hora_sal.getText().toUpperCase().trim();
        String foto = Camara_Sal.dir.trim();
            
        String consulta1 = ("update orden_servicio set hora_sal = '"+ hora +"', serv_realizado = '"+ diag +"', foto_serv_real = '"+ foto +"' "
                + "where no_orden = "+ ordn +";");
            
        try {
            stm = sql.CrearConexion();
        
            int z = stm.executeUpdate(consulta1);
            sql.CloseDB();
            if (z != 0) {
                JOptionPane.showMessageDialog(null, "SERVICIO ACTUALIZADO CORRECTAMENTE", "ACTUALIZANDO", JOptionPane.INFORMATION_MESSAGE);                            
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL INTENTAR ACTUALIZAR EL SERVICIO", "ACTUALIZANDO", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } 
    }// Editar_resultados
        
    public void hora_salida(){
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        Ord_Serv_Sal.txt_hora_sal.setText(formateador.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }// hora_salida
      
}// Servicios
