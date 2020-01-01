package com.surviveenglish.client.player;

public class PlayerTrait {
	
	private int traitLevel;
	
	private PlayerTraitType trait;
	
	public PlayerTrait(PlayerTraitType trait) {
		
		this.trait = trait;
		this.traitLevel = 0;
		
	}
	
	public PlayerTrait(PlayerTraitType trait, int traitLevel) {
		
		this.trait = trait;
		this.traitLevel = traitLevel;
		
	}
	
	public PlayerTraitType getTrait() {
		
		return this.trait;
		
	}
	
	public int getTraitLevel() {
		
		return this.traitLevel;
		
	}
	
}