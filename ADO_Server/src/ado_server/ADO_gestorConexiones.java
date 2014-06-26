/*
 * MSGestorConexiones.java
 *
 * Created on 1 de noviembre de 2007, 23:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ado_server;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class ADO_gestorConexiones {
    
    private static ADO_gestorConexiones singleton=new ADO_gestorConexiones();
    public  static ADO_gestorConexiones getInstance(){
        return singleton;
    }
    
    private ArrayList<ADO_conexion> conexiones = new ArrayList<ADO_conexion>();
    
    public void enviarTrama(int nCodigo, String sTrama){
        for (ADO_conexion ms:conexiones){
            ms.enviarTrama(nCodigo, sTrama);
        }
    }
    
    public void conectaNuevo(ADO_conexion nuevo){
        for (ADO_conexion ms:conexiones){
            nuevo.enviarTrama(1, ms.getNick());
        }
        conexiones.add(nuevo);
    }
    
    public void desconecta(ADO_conexion eliminar){
        int nPos=-1;
        for (int n=0;n<conexiones.size();n++){
            if (conexiones.get(n)==eliminar){
                nPos=n;
            }
        }
        if (nPos!=-1){
            for (int n=0;n<conexiones.size();n++){
                if (n!=nPos){
                    conexiones.get(n).enviarTrama(3, ""+nPos);
                }
            }
            conexiones.remove(nPos);
        }
    }    
    
}
