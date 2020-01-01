package com.surviveenglish.client.item;

import com.surviveenglish.util.BasicImage;

public class Item {
	
	private String name;
	private String description;
	
	private BasicImage image;
	
	public Item(String name, String description, BasicImage image) {
		
		this.name = name;
		this.description = description;
		this.image = image;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public String getDescription() {
		
		return this.description;
		
	}
	
	public BasicImage getImage() {
		
		return this.image;
		
	}
	
}