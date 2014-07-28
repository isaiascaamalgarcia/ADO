package facturador;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
            //conect.close();
            return true;
        } catch (SQLException e) {
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
    public void ShowUsers(JTable tabla){
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        try{
            
            Statement coman = conect.createStatement();
            ResultSet row = coman.executeQuery("SELECT * FROM usuario");
            Object[] fila = new Object[6];
            while(row.next()){
                fila[0] = row.getObject("nombre");
                fila[1] = row.getObject("apellido");
                fila[2] = row.getObject("id");
                fila[3] = row.getObject("clave");
                fila[4] = row.getObject("tipo_de_usuario");
                fila[5] = row.getObject("nro");
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        }catch(SQLException e){
            
        }
    }
    public int addUser(String nombre, String apellido, String clave, String id_user){
        int numero = 0;
        try{
            Statement st = conect.createStatement();
            Statement cm = conect.createStatement();
            ResultSet row = cm.executeQuery("Select * from usuario order by nro");
            row.last();
            numero = (Integer)row.getObject("nro");
            numero++;
            st.executeUpdate("Insert into usuario values ('"+nombre+"','"+apellido+"','"+id_user+"','"+clave+"','No admin',"+numero+")");
//            conect.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return numero;
    }
    public boolean delUser(String nombre, String apel, String tipo){
        
        System.out.println(tipo);
        if(tipo.equals("Admin")){
            return false;
        } else {
            try{
                Statement cmd = conect.createStatement();
                cmd.executeUpdate("DELETE FROM usuario where nombre='"+nombre+"' AND apellido ='"+apel+"'");
                
                return true;
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return false;
    }
    public boolean updateUser(String nombre,String apel,String id,String clave, int nro){
        try{
            Statement cmd = conect.createStatement();
            cmd.executeUpdate("UPDATE usuario SET nombre='"+nombre+"',apellido = '"+apel+"', id ='"+id+"', clave ='"+clave+"' where nro="+nro+"");
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
}
