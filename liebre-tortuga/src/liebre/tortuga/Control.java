
package liebre.tortuga;

/**
 *
 * @author dani_
 */
public class Control {
    //Booleano para controlar si algún animal está avanzando
    private boolean avance=false;
    //entero para almacenar la nueva posición
    private int posicion=0;
    //número para almacenar el número aleatorio que calcula probabilidades
    private int numero=0;
    
    public synchronized int avanceTortuga(int posicion) throws InterruptedException{
        //si hay alguien avanzando esperamos
        if(avance!=false)
            wait();
        int posicioni=posicion; //Recojemos la posición inicial del personaje
        avance=true;            //indicamos que vamos a avanzar
        numero = (int) (Math.random() * 10) + 1;    //Generamos número aleatorio para calcular probabilidades
        
        //Probabilidades
        if(numero<=5)   //50%
            posicion=posicion+3;
        else if(numero>5&&numero<=7)//20%
            if(posicion>=6) //Si la posición es mayor o igual que 6 retrocedemos 6 posiciones
                posicion=posicion-6;
            else
                posicion=0; //Si no vamos a la posicion 0
        else if(numero>7)   //30%
            posicion++;
        
        //Si el animal se queda en la misma posición que el otro se vuelve a la posición en la que estaba
        if(this.posicion==posicion){
            avance=false;   //indicamos que ya no avanzamos
            notify();
            return posicioni;   //Devolvemos posición anterior
        }
        notify();
        avance=false;   //indicamos que ya no avanzamos
        return posicion;//Devolvemos nueva posición
    }
    
    public synchronized int avanceLiebre(int posicion) throws InterruptedException{
        if(avance!=false)   //si hay alguien avanzando esperamos
            wait();
        int posicioni=posicion; //Recojemos la posición inicial del personaje
        avance=true;        //indicamos que vamos a avanzar
        numero = (int) (Math.random() * 10) + 1;    //Generamos número aleatorio para calcular probabilidades
        //Probabilidades
        if(numero<=2)   //20%
            posicion=posicion;
        else if(numero>2&&numero<=4)    //20%
            posicion=posicion+9;
        else if(numero>4&&numero<=5)    //10%
            if(posicion<=12)
                posicion=0;
            else
                posicion=posicion-12;
        else if(numero>5&&numero<=8)    //30%
            posicion++;
        else                            //20%
            if(posicion>=2)             //Si su posición es mayor o igual a 2 retrocede 2
                posicion=posicion-2;
            else
                posicion=0;             //si no se va a la 0
        //Si el animal se queda en la misma posición que el otro se vuelve a la posición en la que estaba
        if(this.posicion==posicion){
            avance=false;       //indicamos que ya no avanzamos
            notify();
            return posicioni;   //Devolvemos posición anterior
        }
            
        avance=false;       //indicamos que ya no avanzamos
        notify();
        return posicion;    //Devolvemos nueva posición
    }
}
