package com.surviveenglish.client.player;

public enum PlayerType {
	
	CHAD(new PlayerTemplate("Chad", "Chad", PlayerTemplate.createArrayList(new PlayerTrait(PlayerTraitType.CLOUT, 80), new PlayerTrait(PlayerTraitType.FORAGING, 5), new PlayerTrait(PlayerTraitType.HEALTH, 50), new PlayerTrait(PlayerTraitType.INTELLIGENCE, 10), new PlayerTrait(PlayerTraitType.INVENTORY_SPACE, 4), new PlayerTrait(PlayerTraitType.LUCK, 0), new PlayerTrait(PlayerTraitType.SPEECH, 25), new PlayerTrait(PlayerTraitType.SPEED, 25), new PlayerTrait(PlayerTraitType.STRENGTH, 30)), PlayerTemplate.createArrayList(new PlayerTrait(PlayerTraitType.CLOUT, 30)))),
	BRAD(new PlayerTemplate("Brad", "Like Chad, but he can Surf.", PlayerTemplate.createArrayList(new PlayerTrait(PlayerTraitType.CLOUT, 80), new PlayerTrait(PlayerTraitType.FORAGING, 5), new PlayerTrait(PlayerTraitType.HEALTH, 50), new PlayerTrait(PlayerTraitType.INTELLIGENCE, 30), new PlayerTrait(PlayerTraitType.INVENTORY_SPACE, 3), new PlayerTrait(PlayerTraitType.LUCK, 0), new PlayerTrait(PlayerTraitType.SPEECH, 25), new PlayerTrait(PlayerTraitType.SPEED, 25), new PlayerTrait(PlayerTraitType.STRENGTH, 30)), PlayerTemplate.createArrayList(new PlayerTrait(PlayerTraitType.CLOUT, 40)))),
	CHRUNK(new PlayerTemplate("Chrunk", "Baby RUTH?", PlayerTemplate.createArrayList(new PlayerTrait(PlayerTraitType.CLOUT, 40), new PlayerTrait(PlayerTraitType.FORAGING, 70), new PlayerTrait(PlayerTraitType.HEALTH, 80), new PlayerTrait(PlayerTraitType.INTELLIGENCE, 5), new PlayerTrait(PlayerTraitType.INVENTORY_SPACE, 4)), PlayerTemplate.createArrayList(new PlayerTrait(PlayerTraitType.CLOUT, 40)))),
	//BORIS("Boris", new Player(Player.createArrayList(new PlayerTrait(PlayerTraitType.INTELLIGENCE, 10)))),
	//BONNIE("Bonnie", new Player(Player.createArrayList(new PlayerTrait(PlayerTraitType.FORAGING, 10)))),
	//CLINT("Clint", new Player(Player.createArrayList(new PlayerTrait(PlayerTraitType.FORAGING, 10)))),
	//CLYDE("Clyde", new Player(Player.createArrayList(new PlayerTrait(PlayerTraitType.FORAGING, 10)))),
	RONNIE(new PlayerTemplate("Ronnie", "Ok then", null, null)),
	QUARTER_WISE(new PlayerTemplate("Quarter Wise", "The financing clown", null, null));
	
	private final PlayerTemplate player;
	
	PlayerType(PlayerTemplate player) {
		
		this.player = player;
		
	}
	
	public PlayerTemplate getPlayer() {
		
		return this.player;
		
	}
	
}