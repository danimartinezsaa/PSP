/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascensor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class Ascensor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Monitor ascensor
        Controlador control=new Controlador();
        //dos usuarios
        new Usuario1(control).start();
        new Usuario2(control).start();
        
    }
    
}

class Usuario1 extends Thread{
    //Recibimos el controlador
    private Controlador control;
    public Usuario1(Controlador control) {
        this.control=control;
    }
    
    @Override
    public void run(){
        try {
            //Pedimos ir a las plantas 3 y 4
            System.out.println("Piso: "+control.getPiso());
            control.pedir(3);
            System.out.println("Piso: "+control.getPiso());
            control.pedir(4);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Usuario1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

class Usuario2 extends Thread{
    //Recibimos el controlador
    private Controlador control;
    public Usuario2(Controlador control) {
        this.control=control;
    }
    
    @Override
    public void run(){
        try {
            //Pedimos ir a las plantas 10 y 2
            System.out.println("Piso: "+control.getPiso());
            control.pedir(10);
            System.out.println("Piso: "+control.getPiso());
            control.pedir(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Usuario2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}