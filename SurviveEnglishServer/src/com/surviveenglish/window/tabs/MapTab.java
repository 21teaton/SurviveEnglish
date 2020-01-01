package com.surviveenglish.window.tabs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.surviveenglish.client.player.AdjustableLimb;
import com.surviveenglish.client.player.PlayerImage;
import com.surviveenglish.handlers.ClientHandler;
import com.surviveenglish.main.Main;
import com.surviveenglish.map.Map;
import com.surviveenglish.map.objects.PromptCircle;
import com.surviveenglish.map.objects.PromptCircle.CircleState;
import com.surviveenglish.server.Server;
import com.surviveenglish.map.objects.PromptCircleConnection;
import com.surviveenglish.util.BasicImage;
import com.surviveenglish.util.Logger;

@SuppressWarnings("serial")
public class MapTab extends Tab {
	
	public Map map;
	
	public MapTab(String tabName, JFrame frame) {
		super(tabName, frame);
		
	}
	
	public void init() {
		
		PromptCircle prompt1 = new PromptCircle(100, 100, CircleState.UNLOCKED);
		PromptCircle prompt2 = new PromptCircle(340, 250);
		PromptCircle prompt3 = new PromptCircle(157, 498);
		
		this.map = new Map(new BasicImage(0, 0, "/textures/map/map.png"));
		this.map.mapObjects.addObject(new PromptCircleConnection(prompt1, prompt2));
		this.map.mapObjects.addObject(prompt1);
		this.map.mapObjects.addObject(prompt2);
		this.map.mapObjects.addObject(prompt3);
		
		super.init();
		
	}
	
	@Override
	public void update() {
		
		map.update();
		//Main.getServer().addRequestingClients();
		System.out.print(ClientHandler.getConnectedClient().size());
		Logger.logInformation("UPDATING MAP");
		if (ClientHandler.getConnectedClient().size() > 0) {
			
			//ClientHandler.getConfirmedClient().get(1);
			
		}
		
	}
	
	@Override
	public void draw(Graphics g) {
		
		map.draw(g);
		Logger.logInformation("UPDATING M121AP");
		
	}
	
}