/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        Correo correo = new Correo();
        new Usuario1(correo).start();
        new Usuario2(correo).start();
    }

}

class Usuario1 extends Thread {

    private Correo correo;

    public Usuario1(Correo correo) {
        this.correo = correo;
    }

    @Override
    public void run() {
        try {
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

    private Correo correo;

    public Usuario2(Correo correo) {
        this.correo = correo;
    }

    @Override
    public void run() {
        try {
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
