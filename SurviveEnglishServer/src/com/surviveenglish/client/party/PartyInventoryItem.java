package com.surviveenglish.client.party;

import com.surviveenglish.client.item.Item;
import com.surviveenglish.client.player.PlayerTemplate;

public class PartyInventoryItem {
	
	private Item item;
	private PlayerTemplate itemOwner;
	
	public PartyInventoryItem(Item item, PlayerTemplate itemOwner) {
		
		this.item = item;
		this.itemOwner = itemOwner;
		
	}
	
	public Item getItem() {
		
		return this.item;
		
	}
	
	public PlayerTemplate getOwner() {
		
		return this.itemOwner;
		
	}
	
}