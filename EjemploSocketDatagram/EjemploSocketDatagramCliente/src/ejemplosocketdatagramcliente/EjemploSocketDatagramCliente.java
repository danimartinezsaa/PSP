/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosocketdatagramcliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author dani_
 */
public class EjemploSocketDatagramCliente {
    public static void main (String[] args){
        try{
            System.out.println("Creando socket datagram");
            DatagramSocket socketUDP=new DatagramSocket(5556);

            InetAddress addr2=InetAddress.getByName("localhost");
            
            String mensaje="mensaje desde el emisor";
            DatagramPacket datagrama=new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,addr2,5555);
            
            int veces=0;
            while(veces<5){
                System.out.println("enviando mensaje");
                socketUDP.send(datagrama);
                System.out.println("Mensaje enviado");
            
                System.out.println("Recibiendo mensaje");
                byte[] recibir=new byte[25];
                DatagramPacket respuesta=new DatagramPacket(recibir,25);
                socketUDP.receive(respuesta);
                System.out.println("Mensaje recibido: "+new String(recibir));     
                
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
