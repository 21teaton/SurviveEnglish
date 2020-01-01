package com.surviveenglish.map.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.surviveenglish.map.MapObject;
import com.surviveenglish.util.BasicImage;

public class PromptCircle extends MapObject {
	
	private BasicImage imageCurrent = new BasicImage("/textures/map/prompt_circle_current.png");
	private BasicImage imageLocked = new BasicImage("/textures/map/prompt_circle_locked.png");
	private BasicImage imageUnlocked = new BasicImage("/textures/map/prompt_circle_unlocked.png");
	
	private CircleState state;
	
	public PromptCircle(int positionX, int positionY) {
		super(positionX, positionY);
		
		this.state = CircleState.LOCKED;
		
	}
	
	public PromptCircle(int positionX, int positionY, CircleState state) {
		super(positionX, positionY);
		
		this.state = state;
		
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void draw(Graphics g) {
		
		if (this.state.getType() == 0) {
			
			imageCurrent.draw(g, this.positionX, this.positionY, 50, 50);
			
		}
		
		if (this.state.getType() == 1) {
			
			imageLocked.draw(g, this.positionX, this.positionY, 50, 50);
			
		}
		
		if (this.state.getType() == 2) {
			
			imageUnlocked.draw(g, this.positionX, this.positionY, 50, 50);
			
		}
		
	}
	
	public void setState(CircleState circleState) {
		
		this.state = circleState;
		
	}
	
	public CircleState getState() {
		
		return this.state;
		
	}
	
	public enum CircleState {
		
		CURRENT("current", 0),
		LOCKED("locked", 1),
		UNLOCKED("unlocked", 2);
		
		public final int type;
		public final String nameType;
		
		CircleState(String nameType, int type) {
			
			this.type = type;
			this.nameType = nameType;
			
		}
		
		public int getType() {
			
			return this.type;
			
		}
		
	}
	
}