package psp.ejercicio6;

/**
 *
 * @author dani_
 */
public class Caja {

    private int dinero = 1000;
    private boolean ingreso = false;
    private boolean retirada = false;

    public Caja() {
    }

    public int getDinero() {
        return dinero;
    }

    public synchronized void ingreso(int dinero) throws InterruptedException {

        if (retirada == true) {
            wait();
        }
        ingreso = true;
        this.dinero = this.dinero + dinero;
        System.out.println("Ingreso");
        ingreso = false;
        notify();

    }

    public synchronized void retirada(int dinero) throws InterruptedException {
        if (ingreso == true) {
            wait();
        }
        retirada = true;
        this.dinero = this.dinero - dinero;
        System.out.println("Retirada");
        retirada = false;
        notify();
    }
}
