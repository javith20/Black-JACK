/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Javith
 */
public class Jugador extends Thread {

    Socket server;
    private int IDClienteEntrante;
    private DataOutputStream salidaCliente;
    private DataInputStream entradaCliente;

    public Jugador(Socket cs) {
        this.server = cs;
    }

    private void asignarID() {
        while (true) {
            try {
                System.err.println("Entro asignarID");
                salidaCliente.writeInt(Servidor.turno);
                System.err.println("Salio asignarID");
                break;
            } catch (IOException e) {
            }
        }

    }

    private void gestionarTurnos() {
        System.err.println(Servidor.turno);
        switch (Servidor.turno) {
            case 1:
                Servidor.turno = 2;
                break;
            case 2:
                Servidor.turno = 3;
                break;
            case 3:
                Servidor.turno = 1;
                break;
            default:
                break;
        }
    }

    private void ConsederEntrada() {
        try {
            while (true) {
                System.out.println(entradaCliente.readInt());
                if (entradaCliente.readInt() == Servidor.turno) {
                    System.err.println("Entro Conseder Entrada");
                    salidaCliente.write(0);
                    System.err.println("Salio conseder entrada");
                    salidaCliente.writeUTF(entradaCliente.readUTF());
                    break;
                }
            }

        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        try {
            salidaCliente = new DataOutputStream(server.getOutputStream());
            entradaCliente = new DataInputStream(server.getInputStream());
            asignarID();
            while (true) {
                System.out.println("Servidor.Jugador.run()");
                ConsederEntrada();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de conexion\n" + e);
        }

    }
}
