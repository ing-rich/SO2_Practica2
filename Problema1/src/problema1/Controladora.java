/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import javax.swing.JLabel;

/**
 *
 * @author linkh
 */
public class Controladora {
    private JLabel [] tenedoresLbl;
    private JLabel [] filosofosLbl;
    private Filosofo [] filosofos;
    private Tenedor [] tenedores;
    private Portero portero;
    public Controladora(JLabel [] tenedoresLbl, JLabel [] filosofosLbl){
        filosofos = new Filosofo[5];
        tenedores = new Tenedor[5];
        this.tenedoresLbl = tenedoresLbl;
        this.filosofosLbl = filosofosLbl;
        this.portero = new Portero();
    }
    
    public void iniciarSimulacion(){
        for(int i=0;i<5;i++){
            tenedores[i] = new Tenedor(tenedoresLbl[i]);
        }
        for(int i=0; i<5; i++){
            filosofos[i] = new Filosofo(filosofosLbl[i],tenedores[(i+4)%5],tenedores[i],this.portero);
        }
        for(int i=0; i<5;i++){
            filosofos[i].start();
        }
    }
    
    public void detenerSimulacion(){
        for(int i=0;i <5; i++){
            filosofos[i].detener();
        }
    }
}
