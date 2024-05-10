package Bai1;
import java.io.*;
import java.net.*;
public class Client {
      public static void main(String[] args) throws IOException{
    	  Socket socket = new Socket("localhost",3307);
    	  DataInputStream dataIn = new DataInputStream(socket.getInputStream());
    	  DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
    	  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	  String input="",output="";
    	  while(!input.equals("exit")) {
    		  output = reader.readLine();
    		  dataOut.writeUTF(output);
    		  dataOut.flush();
    		  input = dataIn.readUTF();
    		  System.out.println("Server says: "+input);
    	  }
    	  dataOut.close();
    	  socket.close();
      }
}
