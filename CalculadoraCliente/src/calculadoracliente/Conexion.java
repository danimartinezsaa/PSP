
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
    
    //Socket cliente
    static Socket clienteSocket;

    /**
     * Conexión con el servidor
     * @param puertoservidor recibe de la interfaz el puerto del servidor
     * @param direccionservidor recibe de la interfaz la dirección del servidor
     * @throws IOException 
     */
    public static void connect(int puertoservidor, String direccionservidor) throws IOException {
            //Creamos el socket
            clienteSocket=new Socket();
            //Establecemos conexión
            InetSocketAddress addr = new InetSocketAddress(direccionservidor, puertoservidor);
            clienteSocket.connect(addr);
    }

    /**
     * Envía la operación al servidor.
     * @param operacion operación a enviar al servidor
     * @param puertoservidor recibe de la interfaz el puerto del servidor
     * @param direccionservidor recibe de la interfaz la dirección del servidor
     * @return Resultado a la interfaz gráfica
     */
    public static String enviar(String operacion,int puertoservidor, String direccionservidor) {
        
        //Variable para guardar el resultado
        String resultado="0";
        
        try {
            //Nos conectamos al servidor
            connect(puertoservidor,direccionservidor);
            
            //Abrimos conexión entrada y salida
            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();
            
            //Enviamos la operación
            os.write(operacion.getBytes());

            //Recibimos el resultado
            byte[] recibido = new byte[50];
            is.read(recibido);
            
            //Formateamos el resultado a dos decimales
            resultado = String.format( "%.2f", Float.parseFloat(new String(recibido)));

            //Cerramos conexiónes de entrada y salida
            os.close();
            is.close();
            
        } catch (IOException ex) {
            return "Error conexión";
        } finally {
            try {
                //Cerramos el socket
                clienteSocket.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar conexión");
            }
        }
        
        //Devolvemos el resultado a la interfaz gráfica
        return resultado;
    }
}
