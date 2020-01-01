package com.surviveenglish.util;

public class Logger {
	
	public static void logInformation(String message) {
		
		System.out.println("[INFO] " + Thread.currentThread().getStackTrace()[2].getClassName() + " : " + message);
		
	}
	
}