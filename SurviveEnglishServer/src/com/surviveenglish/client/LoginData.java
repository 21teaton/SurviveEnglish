package com.surviveenglish.client;

public class LoginData {
	
	private String displayName;
	private String username;
	private String password;
	
	public LoginData(String username, String password) {
		
		this.username = username;
		this.password = password;
		
	}
	
	public void setDisplayName(String newName, String username) {
		
		if (username.equals(this.username)) {
			
			this.displayName = newName;
			
		}
		
	}
	
	public String getDisplayName() {
		
		return this.displayName;
		
	}
	
	public String getUsername() {
		
		return this.username;
		
	}
	
	public String getPassword(String username) {
		
		if (username.equals(this.username)) {
			
			return this.password;
			
		} else {
			
			return null;
			
		}
		
	}
	
}