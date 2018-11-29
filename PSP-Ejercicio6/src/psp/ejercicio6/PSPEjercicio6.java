/*
    Simular a caixa dunha empresa con dous fíos. Un simulará o ingreso, ca compra de artigos por parte
    de clientes e o outro a extracción de cartos da caixa co pago a proveedores. A conta terá un capital
    inicial. Realizar 10 ingresos e 5 extraccións.
*/
package psp.ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class PSPEjercicio6 {

    public static void main(String[] args) {
        Caja cajero = new Caja();   //Objeto Monitor
        new Compra(cajero).start(); //Hilo Compra
        new Retirada(cajero).start();   //Hilo Retirada
    }

}

class Compra extends Thread {
    
    //Creamos un objeto de tipo monitor para recibir el mismo en el constructor
    private Caja caja;
    //Recibimos objeto monitor
    public Compra(Caja cajero) {
        this.caja = cajero;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {  //Realizamos 10 ingresos
            try {
                caja.ingreso(200);      //llamada al método ingreso del monitor
            } catch (InterruptedException ex) {
                Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Dinero despues de ingresar: "+caja.getDinero());    //Mostramos dinero después de ingresar
    }
}

class Retirada extends Thread {
    //Creamos un objeto de tipo monitor para recibir el mismo en el constructor
    private Caja caja;
    //Recibimos objeto monitor
    public Retirada(Caja cajero) {
        this.caja = cajero;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { //Realizamos 5 retiradas
            try {
                caja.retirada(200);     //Llamada al método retirada del monitor
            } catch (InterruptedException ex) {
                Logger.getLogger(Retirada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Total despues de retirar: "+caja.getDinero());  //mostramos dinero después de retirar
    }
}
