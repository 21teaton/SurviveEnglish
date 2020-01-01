package com.surviveenglish.scenario;

import java.io.Serializable;

import com.surviveenglish.util.BasicImage;

public class Scenario implements Serializable {
	
	private static final long serialVersionUID = -2200461394981685025L;
	
	private String name;
	private String description;
	
	private BasicImage mapImage;
	
	public Scenario(String name, String description) {
		
		this.name = name;
		this.description = description;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String getDesciption() {
		
		return description;
		
	}
	
}