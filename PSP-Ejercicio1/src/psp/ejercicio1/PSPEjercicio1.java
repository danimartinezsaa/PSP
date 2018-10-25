/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class PSPEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Hilo1().start();
        new Hilo2().start();
    }
}

class Hilo1 extends Thread {

    public Hilo1() {

    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(i+" Hilo1");
            try {
                Thread.sleep((long) (Math.random()*3000)+1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class Hilo2 extends Thread {

    public Hilo2() {

    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(i+" Hilo2");
            try {
                Thread.sleep((long) (Math.random()*3000)+1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
