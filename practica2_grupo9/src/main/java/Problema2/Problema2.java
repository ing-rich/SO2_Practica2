/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problema2;

/**
 *
 * @author linkh
 */
public class Problema2 {
    public static void main(String[] args) {
        Double prob = Math.random();
        System.out.println(prob);
        if (prob > 0.5){
            System.out.println("entrega");
        }else {
            System.out.println("recoge");
        }
    }
}
