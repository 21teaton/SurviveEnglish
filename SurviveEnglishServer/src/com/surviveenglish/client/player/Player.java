package com.surviveenglish.client.player;

import java.util.ArrayList;

import com.surviveenglish.client.party.PartyInventoryItem;

public class Player {
	
	private String name;
	private String description;
	
	private PlayerTemplate player;
	
	private ArrayList<PartyInventoryItem> playerInventory = new ArrayList<PartyInventoryItem>();
	
	public Player(PlayerTemplate player) {
		
		this.player = player;
		this.name = player.getName();
		this.description = player.getDescription();		
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setDescription(String description) {
		
		this.description = description;
		
	}
	
	public boolean addToInventory(PartyInventoryItem item) {
		
		if (this.player.getInventorySize() + 1 > this.player.getInventorySize()) {
			
			this.playerInventory.add(item);
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public String getDescription() {
		
		return this.description;
		
	}
	
}