package com.surviveenglish.map;

import java.awt.Graphics;

public abstract class MapObject {
	
	public MapObject(int positionX, int positionY) {
		
		this.positionX = positionX;
		this.positionY = positionY;
		
	}
	
	public int positionX;
	public int positionY;
	
	public abstract void update();
	public abstract void draw(Graphics g);
	
}