

// File Name GreetingClient.java
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Cliente {

    private int ID = -1;
    private Scanner sc = new Scanner(System.in);
    private OutputStream outToServer;
    private DataOutputStream out;
    private InputStream inFromServer;
    private DataInputStream in;

    private void asignarID() {
        while (true) {
            try {
                this.ID = in.read();
                System.err.println("ID " + ID);
                break;
            } catch (IOException e) {
                 JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    private void pedirEntrada() {
        try {
            while (true) {
                out.writeInt(ID);
                if (in.readInt()== 0) {
                    out.writeUTF(sc.next());
                    System.out.println(in.readUTF());
                    
                    break;
                }
                System.err.println("entrada consedida");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Cliente(String serverName, int port) {
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            try (Socket client = new Socket(serverName, port)) {
                System.out.println("Just connected to " + client.getRemoteSocketAddress());
                outToServer = client.getOutputStream();
                out = new DataOutputStream(outToServer);
                inFromServer = client.getInputStream();
                in = new DataInputStream(inFromServer);
                asignarID();
                while (true) {
                    pedirEntrada();
                    System.err.println("Aqui quedo1");
                    

                }

            }

        } catch (UnknownHostException e) {
            System.err.println("I can't find " + e);
        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, e);
        }

    }

}
