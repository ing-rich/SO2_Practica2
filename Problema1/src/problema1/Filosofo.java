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
    private Tenedor tenedorIzq;
    private Tenedor tenedorDer;
    private Portero portero;
    private Boolean iniciar;
    public Filosofo(JLabel etiquetaFilosofo) {
        this.etiquetaFilosofo = etiquetaFilosofo;
    }

    public Filosofo(JLabel filosofoLbl, Tenedor tenedorIzq, Tenedor tenedorDer) {
        this.etiquetaFilosofo = filosofoLbl;
        this.tenedorIzq = tenedorIzq;
        this.tenedorDer = tenedorDer;
    }

    public Filosofo(JLabel filosofoLbl, Tenedor tenedorIzq, Tenedor tenedorDer,Portero portero) {
        this.etiquetaFilosofo = filosofoLbl;
        this.tenedorIzq = tenedorIzq;
        this.tenedorDer = tenedorDer;
        this.portero=portero;
        iniciar = true;
    }
    
    private void cambiarColor(int codigo) {
        Color color = null;
        switch (codigo) {
            case 1: //pensando
                color = Color.BLUE;
                break;
            case 2: //comiendo
                color = Color.GREEN;
                break;
            case 3: //entro al comedor
                color = Color.WHITE;
                break;
        }
        this.etiquetaFilosofo.setBackground(color);
    }

    private void tomarTenedores() {
        this.tenedorIzq.tomarTenedor();
        this.tenedorDer.tomarTenedor();
    }

    private void pensar() {
        this.cambiarColor(1);
        Random r = new Random();
        try {
            Filosofo.sleep(r.nextInt(2000) + 500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void comer() {
        tomarTenedores();
        this.cambiarColor(2);
        Random r = new Random();
        try {
            Filosofo.sleep(r.nextInt(2000) + 500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tenedorDer.dejarTenedor();
        this.tenedorIzq.dejarTenedor();
        this.cambiarColor(1);
    }
    
    @Override
    public void run() {
        while (iniciar) {
            try {
                pensar();
                this.portero.ingresarFilosofo();
                this.cambiarColor(3);
                comer();
                this.portero.sacarFilosofo();
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Proceso finalizado!");
    }
    
    public void detener(){
        this.iniciar = false;
    }
}
