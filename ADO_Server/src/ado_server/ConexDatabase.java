 package ado_server;

import java.sql.*;
/**
 * @author Alejandro
 */
public class ConexDatabase {
    public static final String DATABASE = "ado";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String URL = "jdbc:mysql://localhost/" + DATABASE;
    
    public static Connection conex;
    public ConexDatabase(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            conex = DriverManager.getConnection(URL, USER, PASSWORD);
            
            if(conex != null){
                System.out.println("Conexion a la base de datos" + URL + " Correcta!");
                //conex.close();
            }
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException e){
            System.out.println("Error al conectar con la base de datos" + URL + e);
        }
    }
    public void conectar(){
        System.out.println("Este es la funcion");
    }
    public void cerrarConex(){
        try{
            ConexDatabase.conex.close();
            System.out.println("Coneccion cerrada");
        }
        catch(SQLException e){
           System.out.println(e);
        }
    }
    public void insertVenta(String nombre, int bus, String origen,String destino, String boleto, int asiento, int costo){
        try{
        Statement comando = conex.createStatement();
        comando.executeUpdate("INSERT INTO ventas values (null,'"+nombre+"',"+bus+",'"+origen+"','"+destino+"','"+boleto+"',"+asiento+","+costo+");");
        System.out.println("Datos insertados");
        }catch(SQLException e){
            System.out.println("Error en los statements"+e);
        }
    }
    public void consultarVenta(String empleado){
        try{
            Statement comando = conex.createStatement();
            try (ResultSet row = comando.executeQuery("Select * from ventas where empleado_venta='"+empleado+"';")) {
                while(row.next()){
                    System.out.println("ID venta = "+ row.getObject("id_venta")+" Empleado = "+ row.getObject("empleado_venta"));
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        ConexDatabase use = new ConexDatabase();
        
        //use.insertVenta("ramon", 2, USER, USER, USER, 22, 120);
        use.consultarVenta("ramon");
        use.cerrarConex();
    }
}