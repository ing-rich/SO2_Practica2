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
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static  int id=0;
    public static void main(String[] args) {
        // TODO code application logic here
        CentroAcopio acopio = new CentroAcopio();
        acopio.start();
        Runnable llegada = () ->{
            while (true){
                try {
                    int tiempo = (int)(Math.random()*10000);
                    Thread.sleep(tiempo);
                    System.out.println("aparecio una persona");
                    Persona nuevaPersona = new Persona(acopio, "persona " + Prueba.id++);
                    nuevaPersona.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread hiloLlegada= new Thread(llegada);
        hiloLlegada.start();
    }
    
}
