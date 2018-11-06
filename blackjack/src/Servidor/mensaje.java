/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

/**
 *
 * @author Javith
 */
public class mensaje {
    private int ID;
    private int intruccion;

    public mensaje(int ID) {
        this.ID = ID;
    }

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
