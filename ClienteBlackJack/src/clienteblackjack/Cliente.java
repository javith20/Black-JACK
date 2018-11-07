package clienteblackjack;

// File Name GreetingClient.java

import java.net.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.codegen.CompilerConstants;

public class Cliente {

    private int ID = -1;
    OutputStream outToServer;
    DataOutputStream out;
    InputStream inFromServer;
    DataInputStream in;
    private Mensaje msg;

    private void asignarID() {
        while (true) {
            try {
                this.ID = in.readInt();
                System.err.println("ID " + ID);
                break;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void conectar(String serverName, int port) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Conectando a " + serverName + " en el puerto " + port);
                Thread.sleep(5 * 1000);
                Socket client = new Socket(serverName, port);

                System.out.println("Conectado " + client.getRemoteSocketAddress());
                outToServer = client.getOutputStream();
                out = new DataOutputStream(outToServer);
                inFromServer = client.getInputStream();
                in = new DataInputStream(inFromServer);

                while (true) {
                    if (this.ID == -1){
                        out.writeInt(1);
                        asignarID();
                    }else{
                        out.writeInt(2);
                        out.writeInt(ID);
                        System.err.println(in.readUTF());
                        out.writeUTF(sc.next());
                       System.err.println(in.readUTF());
                    }
                    break;
                }

                client.close();
                Thread.sleep(5 * 1000);
            } catch (UnknownHostException e) {
                System.err.println("I can't find " + e);
            } catch (IOException e) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String serverName = "localhost";
        int port = 9999;
        Cliente a = new Cliente();
        a.conectar(serverName, port);
        //String msg = args[2];

    }
}
