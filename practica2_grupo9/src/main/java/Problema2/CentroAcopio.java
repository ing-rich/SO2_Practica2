/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problema2;

/**
 *
 * @author rich
 */
public class CentroAcopio implements Runnable {
    public Estanteria estanteria;
    
    public CentroAcopio(){
        this.estanteria = new Estanteria();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
