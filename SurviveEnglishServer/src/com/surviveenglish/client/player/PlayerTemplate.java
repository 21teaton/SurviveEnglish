package com.surviveenglish.client.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.surviveenglish.client.party.PartyInventoryItem;
import com.surviveenglish.util.BasicImage;

public class PlayerTemplate {
	
	private int health;
	private int intelligence;
	private int strength;
	private int speed;
	private int foraging;
	private int inventorySpace;
	
	private String name;
	private String description;
	
	private PlayerImage characterImage;
	
	private ArrayList<PlayerTrait> playerTraits = new ArrayList<PlayerTrait>();
	private ArrayList<PlayerTrait> favoredTraits = new ArrayList<PlayerTrait>();
	
	private ArrayList<PlayerType> favoredCharacters = new ArrayList<PlayerType>();
	
	public PlayerTemplate(String name, String description, ArrayList<PlayerTrait> playerTraits, ArrayList<PlayerTrait> favoredTraits, String... favoredCharacters) {
		
		this.name = name;
		this.description = description;
		this.playerTraits = playerTraits;
		this.favoredTraits = favoredTraits;
		
		for (int i = 0; i < favoredCharacters.length; i++) {
			
			for (int j = 0; j < PlayerType.values().length; j++) {
				
				if (PlayerType.values()[j].getPlayer().getName().equals(favoredCharacters[i])) {
					
					this.favoredCharacters.add(PlayerType.values()[j]);
					
				}
				
			}
			
		}
		
	}
	
	public void setFavoredCharacters(ArrayList<PlayerType> favoredCharacters) {
		
		this.favoredCharacters = favoredCharacters;
		
	}
	
	public static ArrayList<PlayerTrait> createArrayList(PlayerTrait... playerTraits) {
		
		ArrayList<PlayerTrait> newArrayList = new ArrayList<PlayerTrait>();
		
		for (int i = 0; i < playerTraits.length; i++) {
			
			newArrayList.add(playerTraits[i]);
			
		}
		
		return newArrayList;
		
	}
	
	public int getInventorySize() {
		
		return this.inventorySpace;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public String getDescription() {
		
		return this.description;
		
	}
	
}