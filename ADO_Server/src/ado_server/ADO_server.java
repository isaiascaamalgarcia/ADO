/*
 * MServidor.java
 *
 * Created on 1 de noviembre de 2007, 22:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ado_server;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ADO_server extends Thread{
    
    private int port;
    private JFrame ventana;
    
    /** Creates a new instance of MServidor */
    public ADO_server(JFrame ventana, int port) {
        this.port = port;
        this.ventana = ventana;
    }
    
    public void run(){
        ServerSocket ss=null;
        try{
            ss=new ServerSocket(port);
            while (true){
                Socket s=ss.accept();
                ADO_gestorConexiones.getInstance().conectaNuevo(new ADO_conexion(s));
            }
            //JOptionPane.showMessageDialog(ventana,"Se han conectado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana,"Error al abrir el puerto. Posiblemente ya est� en uso.");
        }
        try{
            ss.close();
        }catch(Exception e){
        }
    }
    
}
