/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

/**
 *
 * @author rich
 */
public class CentroAcopio extends Thread{

    public Estanteria getEstanteria() {
        return barbero;
    }

    private Estanteria barbero;

    public CentroAcopio(){
        this.barbero = new Estanteria(this);
    }

    @Override
    public void run() {
        barbero.start();
        while (true);
    }
}
