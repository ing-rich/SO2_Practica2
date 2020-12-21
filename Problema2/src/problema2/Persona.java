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
public class Persona extends Thread{
    public enum TipoPersona {
        ENTREGA, RECOGE
    }
    public Caja caja;
    public TipoPersona tipo;
    CentroAcopio acopio;

    public Persona(CentroAcopio acopio, String name){
        this.acopio = acopio;
        this.setName(name);
        Double prob = Math.random();
        if (prob > 0.5) {
            this.caja = new Caja();
            this.tipo = TipoPersona.ENTREGA;
        } else {
            this.caja = null;
            this.tipo = TipoPersona.RECOGE;
        }
    }

    @Override
    public void run() {
        boolean contuniar = true;
        while (contuniar){
            if(acopio.getEstanteria().getActividad()){
                //acopio.getEstanteria().entrarEnActividad();
                try {
                    acopio.getEstanteria().moviendoEstanteria(this);
                    if(this.tipo == Persona.TipoPersona.ENTREGA ){
                        if(this.caja == null){
                            contuniar =false;
                        }
                    }else {
                        if(this.caja != null){
                            contuniar =false;
                        }
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }

        }

    }
}
