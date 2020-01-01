package com.surviveenglish.client.player;

public enum PlayerTraitType {
	
	CLOUT("clout"),
	FORAGING("foraging"),
	HEALTH("health"),
	INTELLIGENCE("intelligence"),
	INVENTORY_SPACE("inventory_space"),
	LUCK("luck"),
	SPEECH("speech"),
	SPEED("speed"),
	STRENGTH("strength");
	
	private final String traitName;
	
	PlayerTraitType(String traitName) {
		
		this.traitName = traitName;
		
	}
	
	public String getTraitName() {
		
		return this.traitName;
		
	}
	
}