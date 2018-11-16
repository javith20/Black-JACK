package Servidor;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Servidor {

    private DataInputStream in;
    private ServerSocket serverSocket;
    private DataOutputStream out;
    private String Turno = "0";
    private Socket server;

    public Servidor(int puerto, int tamanoCola) throws IOException {
        serverSocket = new ServerSocket(puerto, tamanoCola);
    }

    private void gestionarTurnos() {
        System.err.println("Entro gesTurno");
        switch (Integer.parseInt(Turno)) {
            case 0:
                Turno = "1";
                break;
            case 1:
                Turno = "2";
                break;
            case 2:
                Turno = "0";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error turno erroneo");
                break;
        }
    }

    public void asignarID(String nombre) {
        try {
            System.out.println("ID" + nombre);
            out.writeUTF(nombre);
            gestionarTurnos();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void intercambio(String nombre) throws IOException {

        String respuesta = leerCliente();

        if (respuesta.equals("")){
            System.out.println(nombre);
            asignarID(nombre);
            server.close();
        } else {
            if (respuesta.equals(nombre)) {
                gestionarTurnos();
            }
        }
    }

    public boolean establecerConexion(String nombre) {

        try {
            server = serverSocket.accept();
            in = new DataInputStream(server.getInputStream());
            out = new DataOutputStream(server.getOutputStream());
            intercambio(nombre);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return true;

    }

    public void escribirCliente(String mensaje) {
        try {
            this.out.writeUTF(mensaje);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public String leerCliente() {
        String respuesta = "";
        while ("".equals(respuesta)) {
            System.out.println("Leyendo");
            try {
                respuesta = in.readUTF();
                System.out.println(respuesta + "Hola");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            System.err.println("Salida de lectura");
        }
        return respuesta;
    }

    public Socket getServer() {
        return server;
    }

    public void setServer(Socket server) {
        this.server = server;
    }

    public int getTurno() {
        return Integer.parseInt(Turno);
    }

}
