/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author rich
 */
public class Estanteria extends Thread{

    private CentroAcopio acopio;
    public ReentrantLock candado = new ReentrantLock();
    private boolean actividad = false;
    public Caja cajas[];

    

    public Estanteria(CentroAcopio acopio,int cantidadCajas) {
        this.cajas = new Caja[cantidadCajas];
        this.actividad = true;
        this.acopio = acopio;
    }
    

    public Estanteria(CentroAcopio acopio){
        this(acopio,20);
    }

    public boolean getActividad() {
        return actividad;
    }
    
    
    public boolean vacia(){
        for (int i = 0; i < this.cajas.length; i++) {
            if (this.cajas[i] != null) {
                return false;
            }
        }
        return true;
    }
    public boolean llena(){
        for (int i = 0; i < this.cajas.length; i++) {
            if (this.cajas[i] == null) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void run() {
        try {
            System.out.println("sin actividad");
            sinActividad();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            System.out.println(".");
            if(!actividad){
                try {
                    System.out.println("sin actividad");
                    sinActividad();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public synchronized void sinActividad() throws InterruptedException {
        actividad = true;
        wait();
    }

    public synchronized void entrarEnActividad(){
        System.out.println("entro a actividad");
        actividad=false;
        notify();
    }

    public boolean colocarCaja(Caja nuevaCaja) {
        int azar = this.indiceAzar();
        if (this.cajas[azar] == null) {
            this.cajas[azar] = nuevaCaja;
            return true;
        } else {
            for (int i = 0; i < this.cajas.length; i++) {
                if (this.cajas[i] == null) {
                    this.cajas[i] = nuevaCaja;
                    return true;
                }
            }
            return false;
        }

    }

    public Caja obtenerCaja() {
        int azar = this.indiceAzar();
        if (this.cajas[azar] != null) {
            return this.cajas[azar];
        } else {
            for (int i = 0; i < this.cajas.length; i++) {
                if (this.cajas[i] != null) {
                    return this.cajas[i];
                }
            }
        }
        return null;
    }

    private int indiceAzar() {
        int min = 0;
        int max = this.cajas.length - 1;
        return (int) (Math.random() * (max - min + 1) + min);
    }
    
    public void reporte(){
        String cadena = "|";
        for (int i = 0; i < this.cajas.length; i++) {
            if (this.cajas[i] != null) {
                cadena += "X|";
            }else {
                cadena += " |";
            }
        }
        System.out.println(cadena);
    }
    
    public synchronized void moviendoEstanteria(Persona persona) throws InterruptedException {
        this.candado.lock();
        System.out.println("llego " + persona.getName());
        System.out.println(persona.tipo);
        if( persona.tipo == Persona.TipoPersona.ENTREGA){
            boolean colocada = this.colocarCaja(persona.caja);
            
        }else {
            persona.caja = this.obtenerCaja();
        }
        this.reporte();
        Thread.sleep(2000);
        System.out.println("se fue "+ persona.getName());
        this.candado.unlock();
    }
}
