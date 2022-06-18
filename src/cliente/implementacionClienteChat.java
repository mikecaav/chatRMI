/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import interfacee.chatCliente;
import interfacee.chatServidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class implementacionClienteChat extends UnicastRemoteObject implements chatCliente, Runnable {
    Scanner s = new Scanner(System.in);
    chatServidor servidor;
    public String nombre = null;
    boolean bandera=true;
    int tipo=-1;
    int registro=-1;
    implementacionClienteChat(String nombre, chatServidor servidor) throws RemoteException {
        this.nombre = nombre;
        this.servidor = servidor;
        servidor.registro(this);
        registro=servidor.getRegistro();
        
    }
    
       
        
         
    
    @Override
    public void mensajeCliente(String mensaje) throws RemoteException {
        System.err.println(mensaje);
    }

    @Override
    public void run() {
        while(true){
        String mensaje;
        if(registro==1){
            String menu = "\n\n 1) Sumar\n 2) Restar\n 3) Multiplicar\n 4) Dividir \n 5) Salir\nElige: ";
        
            System.out.println(menu);
            while(tipo==-1){
             
                try {
                       tipo = Integer.parseInt(s.nextLine());
                       servidor.setTipoOperacion(tipo);
                   } catch (NumberFormatException e) {
                       tipo = 0;
                   } catch (RemoteException ex) {
                    Logger.getLogger(implementacionClienteChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            bandera=true;
            
        }
        System.out.println("Inserte un numero");   
        while (bandera) {
            
            mensaje = s.nextLine();
            try {
                servidor.setNumero(Integer.parseInt(mensaje));
                servidor.mensaje(nombre + ":" + mensaje);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        s.nextLine();
        }
    }

    @Override
    public void getRegistro(int registro) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void setOperacion() throws RemoteException {
        tipo=-1;
        
    }

    @Override
    public void isRecibiendo(boolean recbiendo) throws RemoteException {
       bandera=false;
    }

}
