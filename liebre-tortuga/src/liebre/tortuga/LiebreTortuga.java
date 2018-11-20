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
        Control controlador=new Control();
        new Liebre(controlador).start();
        new Tortuga(controlador).start();
    }
    
}

class Liebre extends Thread{
    Control controlador;
    int posicion=0;
    public Liebre(Control controlador){
        this.controlador=controlador;
    }
    
    @Override
    public void run(){
        while(posicion<70){
            try {
                posicion=controlador.avanceLiebre(posicion);
                System.out.println("Liebre. Posición: "+posicion);
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("La liebre ha acabado");
    }
}

class Tortuga extends Thread{
    Control controlador;
    int posicion=0;
    public Tortuga(Control controlador){
        this.controlador=controlador;
    }
    
    @Override
    public void run(){
        while(posicion<70){
            try {
                posicion=controlador.avanceTortuga(posicion);
                System.out.println("Tortuga. Posición: "+posicion);
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Tortuga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("La tortuga ha acabado");
    }
}