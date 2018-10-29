

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Servidor {
  
    protected static ArrayList<Socket> clientes = new ArrayList<>();    
    protected static int turno = 0;
    private ServerSocket serverSocket;
    public Servidor(int puerto, int tamanoCola) throws IOException  {
    serverSocket = new ServerSocket(puerto, tamanoCola);
    }

    public void run() {
        Socket server;
        try {
            while (true) {
                server = serverSocket.accept();
                Thread hiloParaTratarElCliente = new Jugador(server);
                hiloParaTratarElCliente.start();

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de conexion\n"+e);
        }

    }

    public static void main(String[] args) {
        int puerto = 9999;
        int cola = 1;

        try {
            Servidor s = new Servidor(puerto, cola);
            s.run();
        } catch (IOException e) {
           JOptionPane.showMessageDialog(null, "Error de conexion\n"+e);
        }
    }
}
