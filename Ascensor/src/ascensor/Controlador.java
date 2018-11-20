/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascensor;

/**
 *
 * @author dani_
 */
public class Controlador {
    private int planta=0;
    private boolean movimiento=false;

    public Controlador() {
    }
    
    public synchronized void mover(int piso) throws InterruptedException{
        if(movimiento!=false){
            wait();
        }
        movimiento=true;
        int cuenta=piso;
        for(int i=0;i<cuenta;i++){
            if(planta>piso){
                System.out.println("Bajando al piso "+piso);
                planta--;
                Thread.sleep((long) (Math.random() * 1000));
            }else if(planta<piso){
                System.out.println("Subiendo al piso "+piso);
                planta++;
                Thread.sleep((long) (Math.random() * 1000));
            }
        }
        System.out.println("Hemos llegado al piso: "+planta);
        notify();
        movimiento=false;
    }
    
    public synchronized void pedir(int piso) throws InterruptedException{
        if(movimiento!=false)
            wait();
        mover(piso);
    }

    public int getPiso() {
        return planta;
    }
    
}
