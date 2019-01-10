import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

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
                        
                        String enviado="mensaje desde el servidor";
			os.write(enviado.getBytes());

			byte[] recibido=new byte[50];
			is.read(recibido);
                        System.out.println("Mensaje recibido: "+new String(recibido));
                        
                        enviado="mensaje desde el servidor 2";
			os.write(enviado.getBytes());
                        
			is.read(recibido);
			System.out.println("Mensaje recibido: "+new String(recibido));
                          
                        enviado="mensaje desde el servidor 3";
			os.write(enviado.getBytes());
                        
                        is.read(recibido);
			System.out.println("Mensaje recibido: "+new String(recibido));

			System.out.println("Cerrando el nuevo socket");

			newSocket.close();

			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

			System.out.println("Terminado");

                }catch (IOException e) {
                    System.out.println("Error de conexión");
                }
	}
}
