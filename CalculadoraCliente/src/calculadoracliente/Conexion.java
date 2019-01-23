/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoracliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author dani_
 */
public class Conexion {

    static Socket clienteSocket;

    public static void connect() throws IOException {
            System.out.println("Creando socket cliente");
            clienteSocket=new Socket();
            System.out.println("Estableciendo la conexión");
            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            clienteSocket.connect(addr);
    }

    public static String enviar(String operacion) {
        String resultado="0";
        
        try {
            connect();
            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();

            os.write(operacion.getBytes());
            System.out.println("Enviado: "+operacion);

            byte[] recibido = new byte[50];
            is.read(recibido);
            resultado = String.format( "%.2f", Float.parseFloat(new String(recibido)));

            os.close();
            is.close();
            
        } catch (IOException ex) {
            System.out.println("Error al recibir operación");
        } finally {
            try {
                clienteSocket.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar conexión");
            }
        }

        return resultado;
    }
    
    public static void shutDown(){
        try {
            connect();
            OutputStream os = clienteSocket.getOutputStream();
            os.write(0);
            os.close();

        } catch (IOException ex) {
            System.out.println("Error al recibir operación");
        } finally {
            try {
                clienteSocket.close();
            } catch (IOException ex) {
                System.out.println("Error IO");
            }
        }
    }
}
