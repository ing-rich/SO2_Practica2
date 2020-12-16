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
public class Persona implements Runnable {

    
    public enum TipoPersona {ENTREGA, RECOGE}
    public Caja caja;
    public TipoPersona tipo;
    public CentroAcopio centroAcopio;
    
    public Persona(CentroAcopio centroAcopio){
        Double prob = Math.random();
        if (prob > 0.5){
            this.caja = new Caja();
            this.tipo = TipoPersona.ENTREGA;
        }else{
            this.caja = null;
            this.tipo = TipoPersona.RECOGE;
        }
        this.centroAcopio = centroAcopio;
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
