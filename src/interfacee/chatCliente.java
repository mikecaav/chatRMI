
package interfacee;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface chatCliente extends Remote{
    
    void mensajeCliente(String mensaje) throws RemoteException;
    void getRegistro(int registro) throws RemoteException;
    void isRecibiendo(boolean recbiendo ) throws RemoteException;
    void setOperacion() throws RemoteException;
}
