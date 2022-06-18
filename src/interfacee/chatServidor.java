
package interfacee;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface chatServidor extends Remote{
    
    void registro(chatCliente cliente) throws RemoteException;
    void mensaje(String  mensaje) throws RemoteException;
    void setNumero(float  numero) throws RemoteException;
    int getRegistro() throws RemoteException;
    void setTipoOperacion(int tipo) throws RemoteException;
}
