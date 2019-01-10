import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientesSocketStream {
	
	public static void main(String[] args){
		try{
			System.out.println("Creando socket cliente");
			Socket clienteSocket=new Socket();
			System.out.println("Estableciendo la conexi�n");
			
			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os= clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");
                        
			String mensaje="mensaje desde el cliente";
			os.write(mensaje.getBytes());

			byte[] recibido=new byte[50];
			is.read(recibido);
			System.out.println("Mensaje recibido: "+new String(recibido));
                        
                        mensaje="mensaje desde el cliente 2";
			os.write(mensaje.getBytes());
                        
			is.read(recibido);
			System.out.println("Mensaje recibido: "+new String(recibido));
                        
                        mensaje="mensaje desde el cliente 3";
			os.write(mensaje.getBytes());

			is.read(recibido);
			System.out.println("Mensaje recibido: "+new String(recibido));

			System.out.println("Cerrando el socket cliente");
                        
			clienteSocket.close();

			System.out.println("Terminado");

		}catch (IOException e) {
                    System.out.println("Error de conexión");;
		}
	}
}	