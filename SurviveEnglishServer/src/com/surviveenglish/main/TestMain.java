package com.surviveenglish.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.surviveenglish.server.Server;
import com.surviveenglish.util.Logger;

public class TestMain {
	
	public static void main(String[] args) {
		
		String host = "localhost";
        //int port = server.getAvailablePort();
        int port = -000;//DO NOT RUN! TODO
        ServerSocket server;
		try {
			server = new ServerSocket(port, 50, InetAddress.getByName(host));
			System.out.println("Server started on : " + host + " " + port);
	        Socket client = new Socket(host, port);
	        System.out.println("Connecting to server...");
	        Socket connection = server.accept();
	        System.out.println("Connection established.");
	        
	        DataOutputStream clientOut = new DataOutputStream(client.getOutputStream());
	        DataInputStream clientIn = new DataInputStream(client.getInputStream());
	        DataOutputStream serverOut = new DataOutputStream(connection.getOutputStream());
	        DataInputStream serverIn = new DataInputStream(connection.getInputStream());
	        System.out.println("Communication is ready.");
	        Logger.logInformation("Closed Server");
		       connection.close(); 
	        byte[] messageOut = "Hello World".getBytes();
	        clientOut.writeInt(messageOut.length);
	        clientOut.write(messageOut);
	        clientOut.flush();
	        System.out.println("Message sent to server: " + new String(messageOut));
	        int length = serverIn.readInt();
	        byte[] messageIn = new byte[length];
	        if (length > 0) {
	            serverIn.readFully(messageIn, 0, messageIn.length);
	        }
	        String message = new String(messageIn);
	        System.out.println("Message received from client: " + message);
	        Logger.logInformation("Server received Object packet : " + message);
	        
	        
	        
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}