/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serv;


import java.io.Serializable; 
/**
 *
 * @author Javith
 */
public class Mensaje implements Serializable {
    private int ID;
    private int intruccion;

    public Mensaje(int ID) {
        super();
        this.ID = ID;
    }
    public Mensaje() {super();}
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIntruccion() {
        return intruccion;
    }

    
    
    public void setIntruccion(int intruccion) {
        this.intruccion = intruccion;
    }
    
    
}
