
package interfacee;

import cliente.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceRMI extends Remote{
    
    String nombre(String nombre) throws RemoteException;
    
}
