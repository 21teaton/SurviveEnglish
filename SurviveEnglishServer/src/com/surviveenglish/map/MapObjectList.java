package com.surviveenglish.map;

import java.util.ArrayList;

public class MapObjectList {
	
	public ArrayList<MapObject> mapObjects = new ArrayList<MapObject>();
	
	public void addObject(MapObject object) {
		
		this.mapObjects.add(object);
		
	}
	
	public void removeObject(MapObject object) {
		
		for (int i = 0; i < this.mapObjects.size(); i++) {
			
			if (this.mapObjects.get(i).equals(object)) {
				
				this.mapObjects.remove(i);
				
			}
			
		}
		
	}
	
	public int getSize() {
		
		return this.mapObjects.size();
		
	}
	
	public MapObject getObject(int index) {
		
		return this.mapObjects.get(index);
		
	}
	
}