/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfacee.interfaceRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class implementacionInterface extends UnicastRemoteObject implements interfaceRMI{

    public implementacionInterface () throws RemoteException { 
        super();
    }
    
    @Override
    public String nombre(String nombre) throws RemoteException {  
        return nombre; 
    }
    
}