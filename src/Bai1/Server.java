package Bai1;
import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(3307);
		Socket socket = serverSocket.accept();
		DataInputStream dataIn = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input="",output="";
		while(!input.equals("exit")) {
			input=dataIn.readUTF();
			System.out.println("Client says: "+input);
			output=reader.readLine();
			dataOut.writeUTF(output);
			dataOut.flush();
		}
		dataIn.close();
		socket.close();
		serverSocket.close();
	}

}
