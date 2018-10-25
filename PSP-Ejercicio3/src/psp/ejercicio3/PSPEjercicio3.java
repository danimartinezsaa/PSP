/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class PSPEjercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contador = 0;
        new Hilo1(contador).start();
    }
}

class Hilo1 extends Thread {
    
    Thread hilo;    
    
    public Hilo1(int contador) {
        contador = contador + 1;
        System.out.println(getName() + " empezó");
        
        if (contador < 5) {
            hilo=new Hilo1(contador);
            hilo.start();
        }
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " se está ejecutando");
            try {
                Thread.sleep((long) (Math.random() * 600) + 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!getName().equals("Thread-4")) {
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(getName() + " acabó");
    }
}
