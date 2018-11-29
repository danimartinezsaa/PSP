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
    //Entero para saber planta
    private int planta=0;
    //boolean para saber si está en movimiento
    private boolean movimiento=false;

    public Controlador() {
    }
    //Método sincronizado para moverse
    public synchronized void mover(int piso) throws InterruptedException{
        //Si ya se está moviendo esperamos
        if(movimiento!=false){
            wait();
        }
        movimiento=true;    //Señalamos que se está moviendo
        for(int i=0;i<piso;i++){
            if(planta>piso){    //Si planta es mayor al piso al que vamos
                System.out.println("Bajando al piso "+piso);    //Mostramos que estamos bajando
                planta--;   //Bajamos una planta
                Thread.sleep(1000);    //esperamos 1s
            }else if(planta<piso){  //si planta es menor que el piso al que vamos
                System.out.println("Subiendo al piso "+piso);   //mostramos que estamos subiendo
                planta++;   //subimos
                Thread.sleep(1000);    //esperamos 1s
            }
        }
        System.out.println("Hemos llegado al piso: "+planta);   //Mostramos cuando hemos llegado
        notify();   //notificamos
        movimiento=false;   //indicamos que ya no nos movemos
    }
    //método sincronizado para pedir turno
    public synchronized void pedir(int piso) throws InterruptedException{
        //si se está moviendo el ascensor esperamos
        if(movimiento!=false)
            wait();
        mover(piso);    //el ascensor se mueve al piso que le indicamos
    }
    //Método para devolver el piso en el que está el ascensor
    public int getPiso() {
        return planta;
    }
    
}
