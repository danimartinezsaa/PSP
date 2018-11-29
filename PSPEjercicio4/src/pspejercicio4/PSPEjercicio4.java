/*
 * Realiza un programa en java que execute tres fíos de forma concurrente. Un de eles debe sumar os
 * números pares del 1 ao 1000, outro os impares, e outro, os que terminen en dous ou en tres.
 */
package pspejercicio4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class PSPEjercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Se inician los hilos
        new hiloPares().start();
        new hiloImpares().start();
        new hiloDosTres().start();
        
    }
    
}
//Hilo que suma los números pares
class hiloPares extends Thread{
    public void run(){
        int suma=0;                 //Entero para realizar la suma
        for(int i=0;i<1000;i++){    //Pregunto por los números de 0 a 1000
            if(i%2==0){             //Preguntamos si el número es par
                suma=suma+i;        //Realizamos la suma
                System.out.println("Pares: "+suma); //Mostramos el resultado por pantalla
                try {
                    Thread.sleep((long)(Math.random()*600)+1);  //Hilo dormido en un tiempo aleatorio entre 0-600ms
                } catch (InterruptedException ex) {
                    Logger.getLogger(hiloPares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
//Hilo que suma los números impares
class hiloImpares extends Thread{
    public void run(){
        int suma=0; //Entero para realizar la suma
        for(int i=0;i<1000;i++){    //Pregunto por los números de 0 a 1000
            if(i%2!=0){             //Preguntamos si el número es impar
                suma=suma+i;        //Realizamos la suma
                System.out.println("Impares: "+suma);
                try {
                    Thread.sleep((long)(Math.random()*600)+1); //Hilo dormido en un tiempo aleatorio entre 0-600ms
                } catch (InterruptedException ex) {
                    Logger.getLogger(hiloPares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
    }
}
//Hilo que suma los números que terminan en dos o tres
class hiloDosTres extends Thread{
    public void run(){
        int suma=0; //Entero para realizar la suma
        for(int i=0;i<1000;i++){    //Pregunto por los números de 0 a 1000
            if(i%10==2 || i%10==3){ //Preguntamos si el número acaba en dos o tres
                suma=suma+i;        //Realizamos la suma
                System.out.println("Dos o tres "+suma); //Mostramos el resultado por pantalla
                try {
                    Thread.sleep((long)(Math.random()*600)+1); //Hilo dormido en un tiempo aleatorio entre 0-600ms
                } catch (InterruptedException ex) {
                    Logger.getLogger(hiloPares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
    }
}