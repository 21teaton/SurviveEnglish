package com.surviveenglish.main;

import com.surviveenglish.handlers.ClientHandler;
import com.surviveenglish.save.ObjectWriter;
import com.surviveenglish.save.ScenarioSaveHandler;
import com.surviveenglish.scenario.Scenario;
import com.surviveenglish.server.Server;
import com.surviveenglish.util.Logger;
import com.surviveenglish.window.Test;
import com.surviveenglish.window.Window;

public class Main implements Runnable {
	
	private static Server server = new Server();
	
	public static void main(String[] args) {
		
		int port = server.getAvailablePort();
		server.startServer(port);
		Logger.logInformation(port + "");
		//Server.closeServer();
		
		ScenarioSaveHandler.saveScenario(new Scenario("AAAAA This will be on the top because it has all the aaaaaaa's", "This doesn't contribute to the ordering."));
		
		ScenarioSaveHandler.loadSaves();
		
		Window window = new Window();
		window.startWindow();
		
		//Test test = new Test();
		
	}
	
	@Override
	public void run() {
		
		//while (true) {
			
			System.out.print("Running");
			
			server.addRequestingClients();
			Logger.logInformation("Attempting Connection " + ClientHandler.getConnectedClient().size());
			
			
		//}
		
	}
	
	public static Server getServer() {
		
		return server;
		
	}
	
}