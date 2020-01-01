package com.surviveenglish.save;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.surviveenglish.scenario.Scenario;
import com.surviveenglish.util.Logger;

public class ScenarioSaveHandler {
	
	private static ArrayList<Scenario> loadedScenarios = new ArrayList<Scenario>();
	private static ArrayList<String> loadedScenarioFileNames = new ArrayList<String>();
	
	public static void saveScenario(Scenario scenario) {
		
		ObjectWriter.writeObjectToFile("C:/Users/" + System.getProperty("user.name") + "/Saved Games/SurviveEnglish/data/saves/scenarios/" + scenario.getName().replace(" ", "_").toLowerCase() + ".sesf", scenario);
		
	}
	
	public static void loadSaves() {
		
		File folder = new File("C:/Users/" + System.getProperty("user.name") + "/Saved Games/SurviveEnglish/data/saves/scenarios/");
		File[] potentialSaveFiles = folder.listFiles();
		
		for (int i = 0; i < potentialSaveFiles.length; i++) {
			
			if (potentialSaveFiles[i].getName().endsWith(".sesf")) {
				
				FileInputStream scenarioFile;
				ObjectInputStream scenario;
				
				try {
					
					scenarioFile = new FileInputStream(potentialSaveFiles[i].getPath());
					scenario = new ObjectInputStream(scenarioFile);
					loadedScenarios.add((Scenario) scenario.readObject());
					loadedScenarioFileNames.add(potentialSaveFiles[i].getName());
					
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}
		
	}
	
	public static ArrayList<Scenario> getLoadedScenarios() {
		
		return loadedScenarios;
		
	}
	
	public static ArrayList<String> getLoadedScenarioFileNames() {
		
		return loadedScenarioFileNames;
		
	}
	
}