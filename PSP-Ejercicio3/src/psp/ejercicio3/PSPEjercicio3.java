/*
 * Realizar un programa que cree un fío, que a súa vez cree outro fío, e así consecutivamente,
 * ata un total de cinco fíos. Cada fío debe presentar o seu nome indicando que comenzou, crear
 * o seu fío fillo e presentar o seu nome 10 veces indicando que se está procesando, esperando
 * un tempo aleatorio entre 100 e 600 milisegundos entre cada presentación. Cada fío deberá
 * esperar a que o seu fillo termine antes de presentar o seu último mensaxe indicando o seu
 * nome e que rematou.
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
        //Entero para contar el número de hilos que creamos
        int contador = 0;
        //Empieza el primero hilo
        new Hilo1(contador).start();
    }
}

//Clase para los 5 hilos, ya que los 5 hacen lo mismo
class Hilo1 extends Thread {
    
    Thread hilo; 
    
    //Constructor
    public Hilo1(int contador) {
        contador = contador + 1;                    //Contamos que hemos creado un hilo más
        System.out.println(getName() + " empezó");  //Mensaje indicando que el hilo empezó
        
        //Si todavía no hemos creado los 5 hilos creamos uno más
        if (contador < 5) {
            hilo=new Hilo1(contador);
            hilo.start();
        }
    }

    @Override
    public void run() {
        
        //Bucle de 10 iteraciones
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " se está ejecutando");  //Muestra nombre del hilo y que se está ejecutando
            try {
                Thread.sleep((long) (Math.random() * 600) + 1);     //El hilo se duerme un tiempo aleatorio entre 0-600ms
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!getName().equals("Thread-4")) {    //Si no estamos en el último hilo tenemos que hacer un "join" para esperar a que acabe el hijo
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(getName() + " acabó");   //Tras acabar el hijo del hilo en cuestión indicamos que hemos acabado la ejecución
    }
}
