package Bai2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) throws IOException{
    	ServerSocket serverSocket = new ServerSocket(5000);
    	Socket socket = serverSocket.accept();
    	DataInputStream dataIn = new DataInputStream(socket.getInputStream());
    	DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
    	while(true) {
    		String request = dataIn.readUTF();
    		if(request.equals("time")) {
    			String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
    			dataOut.writeUTF(time);
    			dataOut.flush();
    		}
    	}
    }
}
