
package calculadoraservidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 * Servidor de una calculadora que recibe una cadena de operaciones y la resuelve.
 * La conexión se realiza por SocketStream
 * @author dani_
 */
public class CalculadoraServidor {

    public static void main(String[] args) {
        
        //Ventana de diálogo para introducir el puerto en el que se va a levantar el servidor
        String puerto = JOptionPane.showInputDialog("Escribe el puerto para el servidor");

        try {
            //Creamos el socket del servidor en el puerto enviado previamente
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(puerto));
            
            //El servidor se queda levantado hasta que se mata la aplicación
            while (true) {
                //Aceptamos conexiones
                Socket newSocket = serverSocket.accept();

                //Una vez recibimos una conexión creamos un hilo para resolver su operación
                new Cliente(newSocket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error al recibir conexiones");
        }
    }
}

/**
 * Hilo para cada cliente del servidor.
 * @author dani_
 */
class Cliente extends Thread {

    private Socket socket;
    private InputStream is;
    private OutputStream os;

    /**
     * Recibimos el socket de conexión con el cliente y abrimos las conexiones de entrada y salida.
     * @param socket socket de conexión con ek cliente
     * @throws IOException 
     */
    public Cliente(Socket socket) throws IOException {
        this.socket=socket;
        is = socket.getInputStream();
        os = socket.getOutputStream();
    }
    
    /**
     * Ejecución del hilo.
     * Recibe una operación, la resuelve y envía el resultado.
     */
    @Override
    public void run() {
        try {
            //Recibimos la operación
            byte[] recibido = new byte[250];
            is.read(recibido);

            //La transformamos en un String para separala e identificar operandos y operadores
            String operacion = new String(recibido);
            System.out.println(operacion);
            String linea[] = operacion.split(" ");

            //Recorre la lista de operadores y operandos.
            //Cuándo encuentra un operador lo ejecuta con el número anterior y el siguiente
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
                        cuenta = (double) Math.sqrt(cuenta);
                        break;
                    default:
                        cuenta = Double.parseDouble(linea[i]);
                        break;
                }
            }
            
            //Enviamos la cuenta.
            os.write(String.valueOf(cuenta).getBytes());
        } catch (IOException ex) {
            System.out.println("Error de conexión");
        } finally{
            try {
                //Cerramos la conexión
                socket.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar la conexión");
            }
        }
    }
}
