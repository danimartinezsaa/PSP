/*
    Programa que simule un buzón de correo (recurso compartido), de xeito que se
    poida leer unha mensaje ou envialo. O buzón soamente pode almacear unha
    mensaxe, de xeito que para poder escribir débese atopar baleiro e para poder leer
    debe de estar cheo. Crear varios fíos lectores e escritores que manexen o buzón
    de xeito sincronizado.
 */
package psp.ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class PSPEjercicio7 {

    public static void main(String[] args) {
        //instanciamos el correo
        Correo correo = new Correo();
        //creamos dos usuarios
        new Usuario1(correo).start();
        new Usuario2(correo).start();
    }

}

class Usuario1 extends Thread {
    
    //Creamos un objeto del monitor
    private Correo correo;

    public Usuario1(Correo correo) {
        this.correo = correo;
    }

    @Override
    public void run() {
        try {
            //Realizamos operaciones de escritura y lectura de mensajes
            correo.escribir("Hola");
            correo.leer();
            correo.escribir("Qué tal?");
            correo.leer();
            correo.leer();
            correo.escribir("PSP");
        } catch (InterruptedException ex) {
            Logger.getLogger(Usuario1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Usuario2 extends Thread {
    //Creamos un objeto monitor
    private Correo correo;

    public Usuario2(Correo correo) {
        this.correo = correo;
    }

    @Override
    public void run() {
        try {
            //Enviamos y leemos mensajes
            correo.escribir("Hola");
            correo.leer();
            correo.leer();
            correo.escribir("Qué tal?");
            correo.leer();

        } catch (InterruptedException ex) {
            Logger.getLogger(Usuario2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
