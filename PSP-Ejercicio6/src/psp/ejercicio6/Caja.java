package psp.ejercicio6;

/**
 *
 * @author dani_
 */
public class Caja {
    
    private int dinero = 1000;  //Dinero inicial del cajeto
    //Booleanos para controlar si se está realizando una retirada o un ingreso
    private boolean ingreso = false;
    private boolean retirada = false;

    public Caja() {
    }
    
    //Método que devuelve el dinero actual
    public int getDinero() {
        return dinero;
    }
    
    //Método sincronizado para realizar ingresos
    public synchronized void ingreso(int dinero) throws InterruptedException {
        //Si se está realizando una retirada esperamos
        if (retirada == true) {
            wait();
        }
        ingreso = true; //Señalamos que estamos realizando un ingreso
        this.dinero = this.dinero + dinero; //Realizamos el ingreso
        System.out.println("Ingreso");      //Mostramos que ingreamos dinero
        ingreso = false;//Señalamos que ya no estamos ingresando
        notify();       //notificamos

    }
    //Método sincronizado para retirar dinero
    public synchronized void retirada(int dinero) throws InterruptedException {
        //Si está ingresando esperamos
        if (ingreso == true) {
            wait();
        }
        retirada = true;    //indicamos que se está produciendo una retirada
        this.dinero = this.dinero - dinero; //Realizamos la retirada
        System.out.println("Retirada");     //Mostramos por pantalla que hemos retirado dienero
        retirada = false;   //Indicamos que ya no estamos retirando
        notify();   //Notificamos
    }
}
