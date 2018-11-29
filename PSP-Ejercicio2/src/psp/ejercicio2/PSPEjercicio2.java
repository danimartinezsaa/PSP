/*
 * Programa que crea 4 fíos, os executa e espera a que estes terminen. Os fíos escriben 5 veces o
 * número de iteración do bucle e o seu nome. En cada iteración, despois de escribir o seu nome,
 * bloquéanse durante un segundo e volven a estar dispoñibles para a súa execución
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
        //Empiezan cada uno de los hilos
        new Hilo1().start();
        new Hilo2().start();
        new Hilo3().start();
        new Hilo4().start();
    }
    
}

//Thread-0
class Hilo1 extends Thread {

    public Hilo1() {

    }

    @Override
    public void run() {
        //Bucle con 5 iteraciones
        for(int i=0;i<5;i++){
            System.out.println(i+" "+getName());    //Muestra número mensaje y nombre del hilo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
//Thread-1
class Hilo2 extends Thread {

    public Hilo2() {

    }

    @Override
    public void run() {
        //Bucle con 5 iteraciones
        for(int i=0;i<5;i++){
            System.out.println(i+" "+getName());    //Muestra número mensaje y nombre del hilo
            try {
                Thread.sleep(1000);                 //El hilo se duerme un segundo
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
//Thread-2
class Hilo3 extends Thread {

    public Hilo3() {

    }

    @Override
    public void run() {
        //Bucle con 5 iteraciones
        for(int i=0;i<5;i++){
            System.out.println(i+" "+getName());    //Muestra número mensaje y nombre del hilo
            try {
                Thread.sleep(1000);                 //El hilo se duerme un segundo
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
//Thread-3
class Hilo4 extends Thread {

    public Hilo4() {

    }

    @Override
    public void run() {
        //Bucle con 5 iteraciones
        for(int i=0;i<5;i++){
            System.out.println(i+" "+getName());    //Muestra número mensaje y nombre del hilo
            try {
                Thread.sleep(1000);                 //El hilo se duerme un segundo
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}