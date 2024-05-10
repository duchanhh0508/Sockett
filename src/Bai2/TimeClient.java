package Bai2;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TimeClient {
   public static void main(String[] args) throws IOException{
	   Socket socket = new Socket("localhost",3307);
	   DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
	   DataInputStream dataIn = new DataInputStream(socket.getInputStream());
	   JFrame frame = new JFrame("Clock");
	   JLabel label = new JLabel("",SwingConstants.CENTER);
	   label.setFont(new Font("Serif",Font.PLAIN, 96));
	   frame.add(label);
	   frame.setSize(300,200);
	   frame.setVisible(true);
	   while(true) {
		   dataOut.writeUTF("time");
		   dataOut.flush();
		   String time=dataIn.readUTF();
		   label.setText(time);
		   try {
			   Thread.sleep(1000);
		   } catch(InterruptedException e) {
			   e.printStackTrace();
		   }
	   }
	   
   }
}

