package com.surviveenglish.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.surviveenglish.util.Command;
import com.surviveenglish.util.Logger;

public class PackagedClient {
	
	private boolean hasBeenVerified;
	
	private boolean isInvalid;
	
	private Socket client;
	private Socket connection;
	
	private ObjectOutputStream clientOut;
	private ObjectInputStream clientIn;
	
	private LoginData clientLogin;
	
	public PackagedClient(Socket client) {
		
		this.client = client;
		try {
			
			clientOut = new ObjectOutputStream(client.getOutputStream());
			clientIn = new ObjectInputStream(client.getInputStream());
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void sendCommandToServer(Command command) {
		
		Logger.logInformation("COMMAND1");
		
		try {
			Logger.logInformation("COMMAND2");
			
			clientOut.writeInt(command.length());
			Logger.logInformation("COMMAND3");
			
			clientOut.writeObject(command.getCommand());
			Logger.logInformation("COMMAND4");
			
			clientOut.flush();
			Logger.logInformation("COMMAND5");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		Logger.logInformation("COMMAND6");
		
	}
	
	public ObjectOutputStream getClientOutput() {
		
		return this.clientOut;
		
	}
	
	public ObjectInputStream getClientInput() {
		
		return this.clientIn;
		
	}
	
	public LoginData getLoginData() {
		
		return this.clientLogin;
		
	}
	
}