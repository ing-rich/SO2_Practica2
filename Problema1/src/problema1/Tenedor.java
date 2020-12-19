/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author linkh
 */
public class Tenedor {
    private JLabel tenedor;
    private int id;
    private Boolean estado; //true = libre, false = ocupado
    
    public Tenedor(JLabel tenedor, int id){
        this.tenedor = tenedor;
        this.id=id;
        this.estado=true;
    }
    
    public synchronized Boolean tomarTenedor(){
        if(this.estado){
            this.estado=false;
            cambiarColor();
            return true;
        } else {
            return false;
        } 
    }
    
   public synchronized Boolean dejarTenedor(){
       if(!this.estado){
           this.estado = true;
           cambiarColor();
           return true;
       } else {
           return false;
       }
   }
    
   private void cambiarColor(){
       if(estado){
           tenedor.setBackground(Color.GREEN);
       } else {
           tenedor.setBackground(Color.RED);
       }
   }
}
