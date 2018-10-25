/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class PSPEjercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Hilo1().start();
        new Hilo2().start();
        new Hilo3().start();
        new Hilo4().start();
    }
    
}

class Hilo1 extends Thread {

    public Hilo1() {

    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(i+" Hilo1");
            try {
                Thread.sleep(1000);
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
        for(int i=0;i<5;i++){
            System.out.println(i+" Hilo2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class Hilo3 extends Thread {

    public Hilo3() {

    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(i+" Hilo3");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class Hilo4 extends Thread {

    public Hilo4() {

    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(i+" Hilo4");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}