package com.surviveenglish.map.objects;

import java.awt.Graphics;

import com.surviveenglish.map.MapObject;
import com.surviveenglish.map.objects.PromptCircle.CircleState;

public class PromptCircleConnection extends MapObject {
	
	PromptCircle promptCircle1;
	PromptCircle promptCircle2;
	
	public PromptCircleConnection(PromptCircle promptCircle1, PromptCircle promptCircle2) {
		super(promptCircle1.positionX, promptCircle1.positionX);
		
		this.promptCircle1 = promptCircle1;
		this.promptCircle2 = promptCircle2;
		
	}
	
	@Override
	public void update() {
		
		if (promptCircle1.getState() == CircleState.UNLOCKED) {
			
			if (promptCircle2.getState() == CircleState.LOCKED) {
				
				promptCircle2.setState(CircleState.CURRENT);
				
			}
			
		}
		
		if (promptCircle2.getState() == CircleState.UNLOCKED) {
			
			if (promptCircle1.getState() == CircleState.LOCKED) {
				
				promptCircle1.setState(CircleState.CURRENT);
				
			}
			
		}
		
	}
	
	@Override
	public void draw(Graphics g) {
		
		g.drawLine(promptCircle1.positionX + 25, promptCircle1.positionY + 25, promptCircle2.positionX + 25, promptCircle2.positionY + 25);
		
	}
	
}