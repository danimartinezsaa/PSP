/*
 * Escribe unha clase que cree dous fíos e force que a escritura do segundo sexa sempre anterior á
 * escritura por pantalla do primeiro.
 * Exemplo de ejecución:
 *  Ola, son o fío número 2
 *  Ola, son o fío número 1
 * a) faino con join
 * b)faino con prioridades
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
        //instanciamos los dos hilos
        Hilo2 hilo2 = new Hilo2();
        Hilo1 hilo1 = new Hilo1(hilo2); //Hilo 1 recibe hilo2 para realizar el join y que espere a que acabe
        //Empiezan los hilos
        hilo1.start();
        hilo2.start();
    }

}
//Hilo1
class Hilo1 extends Thread {
    Hilo2 hilo2;    //Creamos un Hilo2 para recojer el hilo por el que tiene que esperar
    public Hilo1(Hilo2 hilo){
        hilo2=hilo; //Contrcutor, recibimos hilo2 y lo metemos en la variable local hilo2
    }
    public void run() {
        try {
            hilo2.join();   //Esperamos a que hilo2 acabe
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hola soy el hilo1");    //Mensaje por pantalla
    }
}
//Hilo2
class Hilo2 extends Thread {

    public void run() {
        System.out.println("Hola soy el hilo2");    //mensaje por pantalla
    }
}
