package Servidor;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Servidor {

    private DataInputStream in;
    private ServerSocket serverSocket;
    private DataOutputStream out;
    private int Turno = 1;

    public Servidor(int puerto, int tamanoCola) throws IOException {
        serverSocket = new ServerSocket(puerto, tamanoCola);
    }

    private void gestionarTurnos() {
        System.err.println(this.Turno);
        switch (Turno) {
            case 1:
                Turno = 2;
                break;
            case 2:
                Turno = 3;
                break;
            case 3:
                Turno = 1;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error turno erroneo");
                break;
        }
    }

    private void asignarID() {

        try {
            System.out.println("ID"+Turno);
            out.writeInt(Turno);

        } catch (IOException e) {
        }

    }

    public void run() {
        Socket server;
        while (true) {
            try {
                System.out.println("Esperando cliente en puerto: " + serverSocket.getLocalPort() + "...");
                // Esperar conexiones
                server = serverSocket.accept();
                System.out.println("Se acaba de conectar: " + server.getRemoteSocketAddress());
                in = new DataInputStream(server.getInputStream());
                out = new DataOutputStream(server.getOutputStream());
                int respuesta;

                while (true) {
                    respuesta = in.readInt();
                    System.err.println("Turno" +Turno);
                    switch (respuesta) {
                        case 1:
                            asignarID();
                            gestionarTurnos();
                            break;
                        case 2:
                            if(in.readInt()==Turno){
                                out.writeUTF("Es su turno");
                                out.writeUTF(this.buscarAntonimo(in.readUTF()));
                                gestionarTurnos();
                            }else{
                                break;
                            }
                            break;

                        default:

                            break;
                    }
                    break;
                }
               
                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public String buscarAntonimo(String palabra) {
        String[] lista1 = {"Hola", "Dia", "Privado", "Frio", "Negro", "Mal"};
        String[] lista1Antonima = {"Adios", "Noche", "Publico", "Caliente", "Blanco", "Bien"};

        for (int i = 0; lista1.length > i; i++) {
            if ((lista1[i].toLowerCase()).equals(palabra.toLowerCase())) {
                return lista1Antonima[i];
            }
            if ((lista1Antonima[i].toLowerCase()).equals(palabra.toLowerCase())) {
                return lista1[i];
            }
        }
        return "Error, la palabra no existe";
    }

    public static void main(String[] args) {
        int puerto = 9999;
        int cola = 1;

        try {
            Servidor s = new Servidor(puerto, cola);
            s.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
