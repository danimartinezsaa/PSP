package psp.ejercicio7;

/**
 *
 * @author dani_
 */
public class Correo {

    private boolean leyendo = false;
    private boolean escribiendo = false;
    private String mensaje = null;

    public Correo() {
    }

    public synchronized void leer() throws InterruptedException {

        if (escribiendo == true || mensaje==null) {
            wait();
        }

        if (mensaje != null) {
            leyendo = true;
            System.out.println(mensaje);
            mensaje=null;
        } else {
            System.out.println("Esperando mensaje");
        }
        leyendo = false;
        notify();
    }

    public synchronized void escribir(String mensaje) throws InterruptedException {
        if (leyendo == true) {
            wait();
        }
        escribiendo = true;
        this.mensaje=mensaje;
        escribiendo = false;
        notify();
    }
}
