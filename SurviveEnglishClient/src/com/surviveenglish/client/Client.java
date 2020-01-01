package com.surviveenglish.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static Socket clientSocket;
	
	public static ObjectOutputStream clientOut;
    public static ObjectInputStream clientIn;
    
	public static void startClient(String name, int port) {
		
		try {
			
			clientSocket = new Socket(name, port);
			clientOut = new ObjectOutputStream(clientSocket.getOutputStream());
		    clientIn = new ObjectInputStream(clientSocket.getInputStream());
			
		} catch (UnknownHostException e) {
			
			System.out.println("Failed Connection");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.out.println("Failed to Connect");
			e.printStackTrace();
			
		}
		
	}
	
	
	public static void sendMessageToServer(String message) {
		
		try {
			
			clientOut.writeInt(message.length());
			clientOut.writeObject(message);
			clientOut.flush();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
}