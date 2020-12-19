/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author linkh
 */
public class Filosofo extends Thread {

    private JLabel etiquetaFilosofo;
    private int estado;
    private Tenedor tenedorIzq;
    private Tenedor tenedorDer;
    public Filosofo(JLabel etiquetaFilosofo) {
        this.etiquetaFilosofo = etiquetaFilosofo;
        this.estado=1;
    }
    
    public Filosofo(JLabel filosofoLbl, Tenedor tenedorIzq,Tenedor tenedorDer){
        this.etiquetaFilosofo = filosofoLbl;
        this.tenedorIzq = tenedorIzq;
        this.tenedorDer = tenedorDer;
        this.estado = 1;
    }
    
    private void cambiarColor(int codigo){
        Color color = null;
        switch(codigo){
            case 1: //pensando
                color = Color.BLUE;
                this.estado = 1;
                break;
            case 2: //comiendo
                color = Color.GREEN;
                this.estado = 2;
                break;
            case 3: //con un tenedor
                color = Color.YELLOW;
                this.estado = 3;
                break;
            case 4: //entro al comedor
                color = Color.WHITE;
                this.estado = 4;
                break;
        }
        this.etiquetaFilosofo.setBackground(color);
    }

    private int tomarTenedores(){
        Boolean tomarDerecha = this.tenedorDer.tomarTenedor();
        Boolean tomarIzq;
        if(tomarDerecha){
            tomarIzq = tenedorIzq.tomarTenedor();
            if(tomarIzq){
                return 1; //puede comer
            } else {
                return 2; // solo tiene un tenedor
            }
        } else {
            return 0; //sin tenedores
        }
    }
    
    private void pensar(){
        this.cambiarColor(1);
        Random r = new Random();
        try {
            Filosofo.sleep(r.nextInt(1000) + 500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void comer(){
        this.cambiarColor(2);
        Random r = new Random();
        try {
            Filosofo.sleep(r.nextInt(1000) + 500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tenedorDer.dejarTenedor();
        this.tenedorIzq.dejarTenedor();
    }
    
    private void esperarTenedor(){
        this.cambiarColor(3);
        Random r = new Random();
        try {
            Filosofo.sleep(r.nextInt(1000) + 500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tenedorDer.dejarTenedor();
    }
    
    private void acciones(int estado){
        switch(estado){
            case 0://no tiene tenedores, ira a pensar
                pensar();
                break;
            case 1: //puede comer
                comer();
                break;
            case 2:
                esperarTenedor();
                break;
        }
    }
    
    @Override
    public void run() {
        while (true) {
            acciones(tomarTenedores());
            System.out.println("corriendo");
        }
    }
}
