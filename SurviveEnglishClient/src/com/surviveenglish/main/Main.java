package com.surviveenglish.main;

import com.surviveenglish.client.Client;

public class Main {
	
	public static void main(String[] args) {
		
		Client.startClient("localhost", 44444);
		Client.sendMessageToServer("THIS IS A TEST!");
		
	}
	
}