
package servidor;

import interfacee.chatCliente;
import interfacee.chatServidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class implementacionChat extends UnicastRemoteObject implements chatServidor{
    public int VALORINICIAL=-500;
    public int operacion=-1;
    public ArrayList<chatCliente> clientes;
    public float numero1=VALORINICIAL;
    public float numero2=VALORINICIAL;
    public implementacionChat() throws RemoteException{
        clientes = new ArrayList<chatCliente>(); 
    }
    
    public void mensaje(String mensaje) throws RemoteException {
        int a = 0;
        while( a < clientes.size() ){  
            clientes.get(a++).mensajeCliente(mensaje);
        }  
    }
    
    public void registro (chatCliente cliente) throws RemoteException { 
        this.clientes.add(cliente);
    }

    @Override
    public void setNumero(float numero) throws RemoteException {
        String operador="";
        if(numero1==VALORINICIAL){
            numero1=numero;
        System.out.println("numero1 = " + numero1);
        }
        else{
            numero2=numero;
            System.out.println("numero2 = " + numero2);
            float res=0;
            switch(operacion){
                case 1: 
                    res=numero1+numero2;
                    operador="+";
                    break;
                case 2: 
                    res=numero1-numero2;
                    operador="-";
                    
                    break;
                case 3: 
                    res=numero1*numero2;
                    operador="*";
                  
                    break;
                case 4: 
                    res=numero1/numero2;
                    operador="/";
                    
                    break;
            }
            mensaje("Respuesta\n "+numero1+operador+numero2+"="+Float.toString(res));
            numero1=VALORINICIAL;
            numero2=VALORINICIAL;
            operacion=-1;
            clientes.get(0).setOperacion();
            clientes.get(0).isRecibiendo(false);
        }
    }

    @Override
    public int getRegistro() throws RemoteException {
         return clientes.size();
    }

    @Override
    public void setTipoOperacion(int tipo) throws RemoteException {
        operacion=tipo;
        System.out.println("tipo = " + operacion);
    }
    
}
