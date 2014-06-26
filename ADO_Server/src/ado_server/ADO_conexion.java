/*
 * MSConexion.java
 *
 * Created on 1 de noviembre de 2007, 23:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ado_server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Administrador
 */
public class ADO_conexion extends Thread{
    
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String nick;
    
    /** Creates a new instance of MSConexion */
    public ADO_conexion(Socket s) {
        try{
            this.s=s;
            dis=new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());
            start();
        }catch(Exception e){
        }
    }
    
    public String getNick(){
        return nick;
    }
    
    public void run(){
        while (true){
            try{
                int nCodigo=dis.readInt();
                String sTrama=dis.readUTF();
                switch(nCodigo){
                    case 1:
                        nick=sTrama;
                        ADO_gestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 2:
                        sTrama="<" + nick + "> - " + sTrama;
                        ADO_gestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 3:
                        ADO_gestorConexiones.getInstance().desconecta(this);
                        break;
                }
                
            }catch(Exception e){
            }
            
        }
    }
    
    public void enviarTrama(int nCodigo, String sTrama){
        try{
           dos.writeInt(nCodigo);
           dos.writeUTF(sTrama);
        }catch(Exception e){
        }
    }
}
