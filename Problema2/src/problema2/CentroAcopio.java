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
        return estanteria;
    }

    private Estanteria estanteria;

    public CentroAcopio(){
        this.estanteria = new Estanteria(this);
    }

    @Override
    public void run() {
        //estanteria.start();
        while (true);
    }
}
