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
public class Estanteria {

    public Caja cajas[];

    public Estanteria(int cantidadCajas) {
        this.cajas = new Caja[cantidadCajas];
    }

    public Estanteria() {
        this(20);
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
}
