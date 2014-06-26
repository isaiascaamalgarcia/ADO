package Cliente;

/*
 * MCliente.java
 *
 * Created on 1 de noviembre de 2007, 22:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ADO_cliente extends Thread{

    private int puerto;
    private String servidor;
    private Socket socketEscucha;
    private boolean estado;
    Ventas ventana;
    private String nickName;
    /** Creates a new instance of MCliente */
    public ADO_cliente(int port, String server, String nick, Ventas window) {
        this.puerto=port;
        this.servidor=server;
        this.ventana=window;
        this.nickName=nick;
    }
    
    public void run(){
        try{
            socketEscucha=new Socket(servidor, puerto);
            DataInputStream entradaDatos=new DataInputStream(socketEscucha.getInputStream());
            enviarDatos(1, nickName);
            estado=true;
            while(estado){
                int codigo =entradaDatos.readInt();
                String datos=entradaDatos.readUTF();
                switch(codigo){
                    case 1:
                        ventana.nuevaPersona(datos);
                        break;
                    case 2:
                        ventana.mensajeRecibido(datos);
                        break;
                    case 3:
                        try{
                            int posicion = Integer.parseInt(datos);
                            ventana.borrarPersona(posicion);
                            //socketEscucha.close();
                        }catch(Exception error){
                        }
                        break;
                }
            }        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se pudo establecer la conexi�n");
        }
    }
    
    public void enviarMensaje(String message){
        enviarDatos(2, message);
    }
    
    public void enviarDatos(int code, String data){
        try{
            DataOutputStream salidaDatos=new DataOutputStream(socketEscucha.getOutputStream());
            salidaDatos.writeInt(code);
            salidaDatos.writeUTF(data);
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se pudo enviar el mensaje");
        }
        
    }

}
