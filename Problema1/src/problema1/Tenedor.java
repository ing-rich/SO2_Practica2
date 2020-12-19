/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import java.awt.Color;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JLabel;

/**
 *
 * @author linkh
 */
public class Tenedor {

    private JLabel tenedor;
    private Boolean estado; //true = libre, false = ocupado
    private ReentrantLock bloqueo;

    public Tenedor(JLabel tenedor) {
        this.tenedor = tenedor;
        this.estado = true;
        this.bloqueo = new ReentrantLock();
    }

    public void tomarTenedor() {
        this.bloqueo.lock();
        this.estado = false;
        cambiarColor();
    }

    public void dejarTenedor() {
        this.estado = true;
        cambiarColor();
        bloqueo.unlock();
    }
    
    private void cambiarColor() {
        if (estado) {
            tenedor.setBackground(Color.GREEN);
        } else {
            tenedor.setBackground(Color.RED);
        }
    }
}
