package liebre.tortuga;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dani_
 */
public class LiebreTortuga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creamos el monitor
        Control controlador=new Control();
        //iniciamos la liebre
        new Liebre(controlador).start();
        //iniciamos la tortuga
        new Tortuga(controlador).start();
    }
    
}

class Liebre extends Thread{
    //creamos el controlador
    Control controlador;
    //posición inicial 0
    int posicion=0;
    //Recibimos el controlador
    public Liebre(Control controlador){
        this.controlador=controlador;
    }
    
    @Override
    public void run(){
        //si la posición es menor que 70
        while(posicion<70){
            try {
                posicion=controlador.avanceLiebre(posicion);    //Llamamos avance liebre y recogemos nueva posición
                System.out.println("Liebre. Posición: "+posicion);  //mostramos nueva posición
                Thread.sleep((long) (Math.random() * 1000));    //Esperamos un tiempo aleatorio 0-1000ms
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("La liebre ha acabado");     //Si está en posición 70 o mas mostramos que ha acabado
    }
}

class Tortuga extends Thread{
    //creamos el controlador
    Control controlador;
    //posición inicial 0
    int posicion=0;
    //Recibimos el controlador
    public Tortuga(Control controlador){
        this.controlador=controlador;
    }
    
    @Override
    public void run(){
        //si la posición es menor que 70
        while(posicion<70){
            try {
                posicion=controlador.avanceTortuga(posicion);   //Llamamos avance tortuga y recogemos nueva posición
                System.out.println("Tortuga. Posición: "+posicion); //mostramos nueva posición
                Thread.sleep((long) (Math.random() * 1000));    //Esperamos un tiempo aleatorio 0-1000ms
            } catch (InterruptedException ex) { 
                Logger.getLogger(Tortuga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("La tortuga ha acabado");    //Si está en posición 70 o mas mostramos que ha acabado
    }
}