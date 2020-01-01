package com.surviveenglish.map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import com.surviveenglish.map.objects.PromptCircle;
import com.surviveenglish.util.BasicImage;

public class Map {
	
	public BasicImage mapBackground;
	
	public MapObjectList mapObjects = new MapObjectList();
	
	public HashMap<PromptCircle, PromptCircle> connectedPromptCircles = new HashMap<>();
	
	public Map(BasicImage mapBackground) {
		
		this.mapBackground = mapBackground;
		
	}
	
	public void update() {
		
		for (int i = 0; i < mapObjects.getSize(); i++) {
			
			mapObjects.getObject(i).update();
			
		}
		
	}
	
	public void draw(Graphics g) {
		
		mapBackground.draw(g);
		
		for (int i = 0; i < mapObjects.getSize(); i++) {
			
			mapObjects.getObject(i).draw(g);
			
		}
		
	}
	
}