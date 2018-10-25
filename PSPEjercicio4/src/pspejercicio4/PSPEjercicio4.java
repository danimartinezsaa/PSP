/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        new hiloPares().start();
        new hiloImpares().start();
        new hiloDosTres().start();
        
    }
    
}

class hiloPares extends Thread{
    public void run(){
        int suma=1;
        for(int i=0;i<1000;i++){
            if(i%2==0){
                suma=suma+i;
                System.out.println("Pares: "+suma);
                try {
                    Thread.sleep((long)(Math.random()*600)+1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(hiloPares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

class hiloImpares extends Thread{
    public void run(){
        int suma=0;
        for(int i=0;i<1000;i++){
            if(i%2!=0){
                suma=suma+i;
                System.out.println("Impares: "+suma);
                try {
                    Thread.sleep((long)(Math.random()*600)+1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(hiloPares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
    }
}

class hiloDosTres extends Thread{
    public void run(){
        int suma=0;
        for(int i=0;i<1000;i++){
            if(i%10==2 || i%10==3){
                suma=suma+i;
                System.out.println("Dos o tres "+suma);
                try {
                    Thread.sleep((long)(Math.random()*600)+1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(hiloPares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
    }
}