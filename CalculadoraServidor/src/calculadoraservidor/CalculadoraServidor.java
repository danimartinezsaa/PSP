/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraservidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author dani_
 */
public class CalculadoraServidor {

    public static void main(String[] args) {

        try {
            System.out.println("Creando socket servidor");
            ServerSocket serverSocket = new ServerSocket(6666);
            
            while (true) {

                System.out.println("Aceptando conexiones");
                Socket newSocket = serverSocket.accept();
                System.out.println("Conexión recibida");

                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();

                byte[] recibido = new byte[250];
                is.read(recibido);
                
                if(recibido[0]==0){
                    break; 
                }     

                String operacion = new String(recibido);
                System.out.println(operacion);

                String linea[] = operacion.split(" ");
                
                Double cuenta = 0.0;
                for (int i = 0; i < linea.length; i++) {
                    switch (linea[i]) {
                        case "*":
                            i++;
                            cuenta = cuenta * Double.parseDouble(linea[i]);
                            break;
                        case "/":
                            i++;
                            cuenta = cuenta / Double.parseDouble(linea[i]);
                            break;
                        case "+":
                            i++;
                            cuenta = cuenta + Double.parseDouble(linea[i]);
                            break;
                        case "-":
                            i++;
                            cuenta = cuenta - Double.parseDouble(linea[i]);
                            break;
                        case "^":
                            i++;
                            cuenta =(double)Math.sqrt(cuenta);
                            break;
                        default:
                            cuenta = Double.parseDouble(linea[i]);
                            break;
                    }
                }
                System.out.println("Cuenta enviada:" + cuenta.toString());
                os.write(String.valueOf(cuenta).getBytes());
            }
        } catch (IOException ex) {
            System.out.println("Error al recibir conexiones");
        }
    }
}
