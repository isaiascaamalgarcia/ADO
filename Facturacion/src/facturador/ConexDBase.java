package facturador;

import java.sql.*;

public class ConexDBase {
    public static final String USER = "root";
    public static final String PASS = "g4rs14";
    public static final String DBASE = "carwash";
    public static final String URL = "jdbc:mysql://localhost/" + DBASE;
    boolean admin;
    Connection conect = null;
    
    public ConexDBase(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            conect = DriverManager.getConnection(URL,USER,PASS);
            if(conect != null){
                System.out.println("Conexion Correcta!");
            }
        }catch(ClassNotFoundException e){
            System.out.println("Error 1: "+e);
        }catch(SQLException e){
            System.out.println("Error" + e);
        }
    }
    public boolean CheckSession(String User, String password){
        String pass_dbase;
        String sudo;
        try{
            Statement comand = conect.createStatement();
            ResultSet row = comand.executeQuery("Select * from usuario where id = '"+User+"';");
            if(row.next()){
                pass_dbase = String.valueOf(row.getObject("clave"));
                System.out.println("Usuario existe");
                if(pass_dbase.equals(password)){
                    sudo = String.valueOf(row.getObject("tipo_de_usuario"));
                    if(sudo.equals("sudo")){
                        admin = true;
                    }else
                    {
                        admin = false;
                    }
                    return true;
                }
            }
        }catch(SQLException e){
            
        }
        return false;
    }
    public boolean InsertFactura(String folio, String rfc, String nombre, String direccion, String email, String cod_postal, String nacionalidad, String servicio, String cantidad, String costo, String subtotal, String total, String comentario, String estado_factura){
        try {
            Statement comand = conect.createStatement();
            comand.executeUpdate("insert into factura values('"+folio+"','"+rfc+"','"+nombre+"','"+direccion+"','"+email+"','"+cod_postal+"','"+nacionalidad+"','"+servicio+"','"+cantidad+"','"+costo+"','"+subtotal+"','"+total+"','"+comentario+"','"+estado_factura+"',now())");
            conect.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean isAdmin(){    
        return admin;
    }
    public String getFolio(){
        String folio="", foliodb;
        int numfolio;
        try{
            Statement comand = conect.createStatement();
            ResultSet row = comand.executeQuery("Select * from factura");
            
            if(!row.next()){
                folio = "CW001";
                return folio;
            }else{
                row.last();
                foliodb = String.valueOf(row.getObject("folio"));
                numfolio = Integer.valueOf(foliodb.substring(2,5));
                System.out.println(numfolio);
                if(numfolio < 10){
                    numfolio++;
                    System.out.println(numfolio);
                    folio = "CW00"+numfolio;
                    return folio;
                    
                }else{
                    if(numfolio >= 10 && numfolio < 100){
                        numfolio++;
                        folio = "CW0"+numfolio;
                        return folio;
                    }else{
                        numfolio++;
                        folio = "CW"+numfolio;
                        return folio;
                    }
                }
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return folio;
    }
}
