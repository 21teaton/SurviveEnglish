package com.surviveenglish.client.item;

import java.util.ArrayList;

public class Items {
	
	private static ArrayList<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item) {
		
		items.add(item);
		
	}
	
	public Item getItemFromName(String name) {
		
		for (int i = 0; i < items.size(); i++) {
			
			if (name.equals(items.get(i).getName())) {
				
				return items.get(i);
				
			}
			
		}
		
		return null;
		
	}
	
}