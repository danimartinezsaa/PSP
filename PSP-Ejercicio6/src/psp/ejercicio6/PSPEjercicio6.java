
package psp.ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class PSPEjercicio6 {

    public static void main(String[] args) {
        Caja cajero = new Caja();
        new Compra(cajero).start();
        new Retirada(cajero).start();
    }

}

class Compra extends Thread {

    private Caja caja;

    public Compra(Caja cajero) {
        this.caja = cajero;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                caja.ingreso(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Dinero despues de ingresar: "+caja.getDinero());
    }
}

class Retirada extends Thread {

    private Caja caja;

    public Retirada(Caja cajero) {
        this.caja = cajero;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                caja.retirada(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Retirada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Total despues de retirar: "+caja.getDinero());
    }
}
