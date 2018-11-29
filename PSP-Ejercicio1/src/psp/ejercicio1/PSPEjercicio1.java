/*
 * Programa con dos hilos en los que cada hilo saca diez mensajes por consola con un tiempo aleatorio
 * entre ellos
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
//Hilo1
class Hilo1 extends Thread {

    public Hilo1() {

    }

    @Override
    public void run() {
        //Bucle de 10 iteraciones
        for(int i=0;i<10;i++){
            System.out.println(i+" Hilo1"); //Mensaje a mostrar
            try {
                Thread.sleep((long) (Math.random()*3000)+1);    //Tiempo aleatorio entre mensaje
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
//Hilo2
class Hilo2 extends Thread {

    public Hilo2() {

    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(i+" Hilo2"); //Mensaje a mostrar
            try {
                Thread.sleep((long) (Math.random()*3000)+1);    //Tiempo aleatorio entre mensaje
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
