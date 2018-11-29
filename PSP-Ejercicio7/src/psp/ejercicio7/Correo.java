package psp.ejercicio7;

/**
 *
 * @author dani_
 */
public class Correo {
    //Booleanos para controlar si se está leyendo o escribiendo
    private boolean leyendo = false;
    private boolean escribiendo = false;
    //variable para almacenar el mensaje
    private String mensaje = null;

    public Correo() {
    }
    //Método sincronizado para leer mensaje
    public synchronized void leer() throws InterruptedException {
        //Si se está escribiendo o no hay mensaje en el buzón esperamos
        if (escribiendo == true || mensaje==null) {
            wait();
        }
        //Si hay mensaje leemos
        if (mensaje != null) {
            leyendo = true; //indicamos que estamos leyendo
            System.out.println(mensaje);    //Mostramos por pantalla el mensaje
            mensaje=null;   //Borramos el mensaje
        } else {
            System.out.println("Esperando mensaje");    //si no hay mensaje mostramos por pantalla que no hay mensaje
        }
        leyendo = false;    //indicamos que ya no estamos leyendo
        notify();   //notificamos
    }
    //Hilo sincronizado para escribir mensaje
    public synchronized void escribir(String mensaje) throws InterruptedException {
        //Si se está leyendo esperamos
        if (leyendo == true) {
            wait();
        }
        escribiendo = true; //indicamos que estamos escribiendo
        this.mensaje=mensaje;   //escribimos un nuevo mensaje
        escribiendo = false;    //indicamos que dejamos de escribir
        notify();   //notificamos
    }
}
