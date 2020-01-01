package com.surviveenglish.client.item;

import com.surviveenglish.util.BasicImage;

public class ToolItem extends Item {
	
	private int maxUses;
	private int currentUses;
	
	public ToolItem(String name, String description, BasicImage image, int maxUses) {
		super(name, description, image);
		
		this.maxUses = maxUses;
		
	}
	
	public void useTool(int damage) {
		
		this.currentUses += damage;
		
	}
	
	public boolean isBroken() {
		
		return this.currentUses >= this.maxUses;
		
	}
	
	public boolean canUse(int damage) {
		
		return this.currentUses + damage <= this.maxUses;
		
	}
	
	public int getMaxUses() {
		
		return this.maxUses;
		
	}
	
}