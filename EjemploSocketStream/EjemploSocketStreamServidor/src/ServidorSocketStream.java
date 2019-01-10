import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorSocketStream {
	
	public static void main(String[] args){
		try{
			System.out.println("Creando socket servidor");
	
			ServerSocket serverSocket=new ServerSocket();

			System.out.println("Realizando el bind");

			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			serverSocket.bind(addr);

			System.out.println("Aceptando conexiones");

			Socket newSocket= serverSocket.accept();

			System.out.println("Conexión recibida");

			InputStream is=newSocket.getInputStream();
			OutputStream os=newSocket.getOutputStream();
                        
                        Thread.sleep(500L);
			byte[] recibido=new byte[5];
			is.read(recibido);
                        
                        int suma=0;
                        for(int i=0;i<5;i++){
                            System.out.println("Recibido número "+recibido[i]);
                            suma=recibido[i]+suma;
                        }
                        
			os.write(suma);
                        
                        System.out.println("Suma enviada");

			System.out.println("Cerrando el nuevo socket");

			newSocket.close();

			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

			System.out.println("Terminado");

                }catch (IOException e) {
                    System.out.println("Error de conexión");
                } catch (InterruptedException ex) {
                Logger.getLogger(ServidorSocketStream.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}
