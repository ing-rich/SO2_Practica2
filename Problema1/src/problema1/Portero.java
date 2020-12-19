/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

/**
 *
 * @author linkh
 */
public class Portero {
    public int filosofos;
    public Portero(){
        this.filosofos=4;
    }
    
    
    public synchronized void ingresarFilosofo() throws InterruptedException{
        while(filosofos==0){
            this.wait();
        }
        filosofos--;
    }
    
    public synchronized void sacarFilosofo() {
        filosofos++;
        this.notify();
    }
}
