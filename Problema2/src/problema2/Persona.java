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
        if (prob > 0.3) {
            this.caja = new Caja();
            this.tipo = TipoPersona.ENTREGA;
        } else {
            this.caja = null;
            this.tipo = TipoPersona.RECOGE;
        }
    }

    @Override
    public void run() {
        while (true){
            if(acopio.getEstanteria().getActividad()){
                acopio.getEstanteria().entrarEnActividad();
                try {
                    
                    //aqui preguntar si tiene candado
                    if(!acopio.getEstanteria().candado.isLocked()){
                        if(this.tipo == Persona.TipoPersona.ENTREGA ){
                            if(acopio.getEstanteria().llena()){
                                System.out.println("esta llena esperar");
                            }else{
                                acopio.getEstanteria().moviendoEstanteria(this);
                            }
                        }else if(this.tipo == Persona.TipoPersona.RECOGE ){
                            if(acopio.getEstanteria().vacia()){
                                System.out.println("esta vacia esperar");
                            }else{
                                acopio.getEstanteria().moviendoEstanteria(this);
                            }
                        }
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }

        }

    }
}
