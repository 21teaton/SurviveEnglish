package com.surviveenglish.util;

public abstract class TabButton {
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public TabButton(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void changePosition(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void changeSize(int width, int height) {
		
		this.width = width;
		this.height = height;
		
	}
	
	public boolean checkMouseInBounds(int mouseX, int mouseY) {
		
		if (mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public abstract void onClick(int mouseX, int mouseY);
	public abstract void onHover(int mouseX, int mouseY);
	
}