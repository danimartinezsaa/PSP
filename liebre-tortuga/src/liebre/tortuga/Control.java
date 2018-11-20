/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebre.tortuga;

/**
 *
 * @author dani_
 */
public class Control {
    private boolean avance=false;
    private int posicion=0;
    private int numero=0;
    
    public synchronized int avanceTortuga(int posicion) throws InterruptedException{
        if(avance!=false)
            wait();
        int posicioni=posicion;
        avance=true;
        numero = (int) (Math.random() * 10) + 1;
        if(numero<=5)
            posicion=posicion+3;
        else if(numero>5&&numero<=7)
            if(posicion>=6)
                posicion=posicion-6;
            else
                posicion=0;
        else if(numero>7)
            posicion++;
        
        if(this.posicion==posicion){
            avance=false;
            return posicioni;
        }
            
        avance=false;   
        return posicion;
    }
    
    public synchronized int avanceLiebre(int posicion) throws InterruptedException{
        if(avance!=false)
            wait();
        int posicioni=posicion;
        avance=true;
        numero = (int) (Math.random() * 10) + 1;
        if(numero<=2)
            posicion=posicion;
        else if(numero>2&&numero<=4)
            posicion=posicion+9;
        else if(numero>4&&numero<=5)
            if(posicion<=12)
                posicion=0;
            else
                posicion=posicion-12;
        else if(numero>5&&numero<=8)
            posicion++;
        else
            if(posicion>=2)
                posicion=posicion-2;
            else
                posicion=0;
        
        if(this.posicion==posicion){
            avance=false;
            return posicioni;
        }
            
        avance=false;   
        return posicion;
    }
}
