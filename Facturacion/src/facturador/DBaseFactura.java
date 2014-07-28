package facturador;

import static facturador.ConexDBase.PASS;
import static facturador.ConexDBase.URL;
import static facturador.ConexDBase.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBaseFactura {
    Connection conect;
    public DBaseFactura(){
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
    public void showFacturas(JTable tabla){
        try{
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            Statement comand = conect.createStatement();
            ResultSet row = comand.executeQuery("SELECT * FROM factura");
            Object[] fila = new Object[15];
            while(row.next()){
                fila[0] = row.getObject("folio");
                fila[1] = row.getObject("rfc");
                fila[2] = row.getObject("nombre");
                fila[3] = row.getObject("direccion");
                fila[4] = row.getObject("email");
                fila[5] = row.getObject("cod_postal");
                fila[6] = row.getObject("nacionalidad");
                fila[7] = row.getObject("servicio");
                fila[8] = row.getObject("cantidad");
                fila[9] = row.getObject("costo");
                fila[10] = row.getObject("subtotal");
                fila[11] = row.getObject("total");
                fila[12] = row.getObject("comentario");
                fila[13] = row.getObject("estado_factura");
                fila[14] = row.getObject("fecha");
                
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public boolean changeStateFactura(String folio){
        try{
            Statement st = conect.createStatement();
            st.executeUpdate("UPDATE factura SET estado_factura='Cancelada' where folio ='"+folio+"'");
            return true;
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
}
