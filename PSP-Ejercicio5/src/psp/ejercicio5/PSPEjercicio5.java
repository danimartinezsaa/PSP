/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class PSPEjercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2 = new Hilo2();
        hilo2.setPriority(10);
        hilo1.setPriority(1);
        hilo1.start();
        hilo2.start();
    }

}

class Hilo1 extends Thread {

    public void run() {
        System.out.println("Hola soy el hilo1");
        System.out.println(getPriority());
    }
}

class Hilo2 extends Thread {

    public void run() {
        System.out.println("Hola soy el hilo2");
        System.out.println(getPriority());
    }
}
