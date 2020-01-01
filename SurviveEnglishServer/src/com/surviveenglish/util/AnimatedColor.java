package com.surviveenglish.util;

import java.awt.Color;
import java.util.ArrayList;

public class AnimatedColor {
	
	int currentUpdateTime;
	int updateRate;
	
	int currentIndex;
	
	Color currentDisplayColor;
	
	ArrayList<Color> colors = new ArrayList<Color>();
	
	public AnimatedColor(int updateRate, Color...colors) {
		
		currentUpdateTime = 0;
		this.updateRate = updateRate;
		currentIndex = 0;
		
		currentDisplayColor = colors[0];
		
		for (int i = 0; i < colors.length; i++) {
			
			this.colors.add(colors[i]);
			
		}
		
	}
	
	public void update() {
		
		currentUpdateTime++;
		
		if (currentUpdateTime == updateRate) {
			
			if (currentDisplayColor.getRGB() != colors.get(currentIndex).getRGB()) {
				
				currentDisplayColor = new Color(changeToColor(currentDisplayColor.getRed(), colors.get(currentIndex).getRed()), changeToColor(currentDisplayColor.getGreen(), colors.get(currentIndex).getGreen()), changeToColor(currentDisplayColor.getBlue(), colors.get(currentIndex).getBlue()));
				
			} else {
				
				if (currentIndex + 1 < colors.size()) {
					
					currentIndex++;
					
				} else {
					
					currentIndex = 0;
					
				}
				
			}
			
			currentUpdateTime = 0;
			
		}
		
	}
	
	public int changeToColor(int originalColor, int newColor) {
		
		if (originalColor + 1 <= 255 && originalColor - 1 >= 0) {
			
			if (originalColor > newColor) {
				
				originalColor--;
				
			}
			
			if (originalColor < newColor) {
				
				originalColor++;
				
			}
			
		}
		
		return originalColor;
		
	}
	
	public Color getColor() {
		
		return currentDisplayColor;
		
	}
	
}