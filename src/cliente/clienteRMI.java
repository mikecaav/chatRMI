/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import interfacee.chatServidor;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class clienteRMI {

    public static void main(String[] args) {

        try {

            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
            String nom = nombre;

            Registry rmii = LocateRegistry.getRegistry("localhost", 1099);
            chatServidor servidor = (chatServidor) rmii.lookup("Chat");
            new Thread(new implementacionClienteChat(nom, servidor)).start();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

}
