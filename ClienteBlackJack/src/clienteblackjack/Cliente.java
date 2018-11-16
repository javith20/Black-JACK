package clienteblackjack;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.codegen.CompilerConstants;

public class Cliente {

    private String ID = "1";
    private String mano = "";
    private String manoJ0 = "";
    private String manoJ1 = "";
    private OutputStream outToServer;
    private DataOutputStream out;
    private InputStream inFromServer;
    private DataInputStream in;

    private void asignarID() {
        while (true) {
            try {
                System.err.println("Solicitando ID");
                this.ID = in.readUTF();
                System.err.println("ID " + ID);
                break;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void escribirServer(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private String leerServidor() {
        String respuesta = "";
        while ("".equals(respuesta)) {
            try {
                respuesta = in.readUTF();
            } catch (IOException ex) {
                 JOptionPane.showMessageDialog(null, ex);
            }

        }
        return respuesta;
    }
    private void intercambio(){
        try {
            out.writeUTF(ID);
            if(ID.equals("1")){
                asignarID();
            }else{
                this.mano = in.readUTF();
                this.manoJ0 = in.readUTF();
                System.out.println(mano+manoJ0);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void conectar(String serverName, int port) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Conectando a " + serverName + " en el puerto " + port);
                try (Socket client = new Socket(serverName, port)) {
                    Thread.sleep(2000);
                    System.out.println("Conectado " + client.getRemoteSocketAddress());
                    outToServer = client.getOutputStream();
                    out = new DataOutputStream(outToServer);
                    inFromServer = client.getInputStream();
                    in = new DataInputStream(inFromServer);
                    intercambio();
                    
                }
                Thread.sleep(5 * 1000);
            } catch (UnknownHostException e) {
               JOptionPane.showMessageDialog(null, e);
            } catch (IOException e) {
                 JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String serverName = "localhost";
        int port = 9999;
        Cliente a = new Cliente();
        a.conectar(serverName, port);

    }
}
