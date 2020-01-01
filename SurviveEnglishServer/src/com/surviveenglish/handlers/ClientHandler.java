package com.surviveenglish.handlers;

import java.util.ArrayList;

import com.surviveenglish.client.PackagedClient;

public class ClientHandler {
	
	private static ArrayList<PackagedClient> connectedClients = new ArrayList<PackagedClient>();
	private static ArrayList<PackagedClient> confirmedClients = new ArrayList<PackagedClient>();
	
	public static void addConnectedClient(PackagedClient client) {
		
		connectedClients.add(client);
		
	}
	
	public static void addConfirmedClient(PackagedClient client) {
		
		confirmedClients.add(client);
		
	}
	
	public static ArrayList<PackagedClient> getConnectedClient() {
		
		return connectedClients;
		
	}
	
	public static ArrayList<PackagedClient> getConfirmedClient() {
		
		return confirmedClients;
		
	}
	
}