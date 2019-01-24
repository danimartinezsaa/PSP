/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosocketdatagramservidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author dani_
 */
public class EjemploSocketDatagramServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	try{
            System.out.println("Creando socket datagram");
            DatagramSocket socketUDP=new DatagramSocket(5555);
            
            String mensaje="Mensaje desde el servidor";
            InetAddress addr2=InetAddress.getByName("localhost");
            DatagramPacket respuesta=new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,addr2,5556);
            
            int veces=0;
            while(veces<5){
                System.out.println("Recibiendo mensaje");
                byte[] recibir=new byte[25];
                DatagramPacket peticion=new DatagramPacket(recibir,25);
                socketUDP.receive(peticion);
                System.out.println("Mensaje recibido: "+new String(recibir));
                
                System.out.println("Enviando mensaje");
                socketUDP.send(respuesta);
                System.out.println("Mensaje enviado");
                
                veces++;
            }

            System.out.println("Cerrando el socket datagrama");

            socketUDP.close();

            System.out.println("Terminado");

	}catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
