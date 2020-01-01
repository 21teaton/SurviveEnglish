package com.surviveenglish.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.surviveenglish.client.PackagedClient;
import com.surviveenglish.handlers.ClientHandler;
import com.surviveenglish.util.Command;
import com.surviveenglish.util.Logger;

public class Server implements Runnable {
	
	public boolean finishCollectingClients;
	
	public boolean serverThreadIsRunning;
	
	public int serverPort;
	
	public ServerSocket serverSocket;
	
	public Server() {
		
		Thread serverThread = new Thread(this);
		serverThread.start();
		serverThreadIsRunning = true;
		
	}
	
	public void startServer(int port) {
		
		finishCollectingClients = false;
		serverPort = port;
		
		try {
			
			serverSocket = new ServerSocket(serverPort, 50, InetAddress.getByName("localhost"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		Logger.logInformation("Started server on port : " + port);
		
	}
	
	public void closeServer() {
		
		try {
			
			serverSocket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		Logger.logInformation("Closed Server");
		
	}
	
	public void addRequestingClients() {
		
		if (!finishCollectingClients) {
			
			try {
				
				Logger.logInformation("Adding Client");
				ClientHandler.addConnectedClient(new PackagedClient(serverSocket.accept()));
				
			} catch (IOException e) {
				
				Logger.logInformation("Failed to add Client");
				e.printStackTrace();
				
			}
			
			Logger.logInformation(ClientHandler.getConnectedClient().size() + "");
			
		}
		
	}
	
	public int getAvailablePort() {
		
		int port = 0;
		
		ServerSocket server = null;
		
		try {
			
			server = new ServerSocket(0);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		port = server.getLocalPort();
		
		try {
			
			server.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return port;
		
	}
	
	public int getServerPort() {
		
		return serverPort;
		
	}

	@Override
	public void run() {
		
		while (serverThreadIsRunning) {
			
			if (ClientHandler.getConnectedClient().size() > 0) {
				
				Logger.logInformation(ClientHandler.getConnectedClient().size() + "");
				
			}
			
			if (ClientHandler.getConnectedClient().size() == 3) {
				
				finishCollectingClients = true;
				
			}
			
			if (finishCollectingClients) {
				
				
				PackagedClient tempPackagedClient = null;
				
				try {
					
					tempPackagedClient = new PackagedClient(new Socket("localhost", serverPort));
					
				} catch (UnknownHostException e) {
					
					e.printStackTrace();
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				//TODO error; code stops at this line vvv
				tempPackagedClient.sendCommandToServer(Command.REMOVE_CLIENT);
				
			}
			
		}
		
	}
	
}