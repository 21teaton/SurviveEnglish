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
import com.surviveenglish.util.BasicImage;

@SuppressWarnings("serial")
public class DebugTab extends Tab {
	
	int i = 0;
	
	public DebugTab(String tabName, JFrame frame) {
		super(tabName, frame);
		
	}
	
	public void init() {
		
		//this.frame.add(JPanelUtils.getJLabelWithFont("test font", new Font("TimesRoman", Font.ITALIC, 100)));
		//labelTest.setBounds(10, 1, 10, 1);
		//this.frame.add(labelTest);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);  
		
		i++;
		
		g.drawRect(230 + i,80,10,10);  
		g.setColor(Color.RED);  
		g.fillRect(230 + i,80,10,10);  
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 500));
		g.drawString("ok then", 200, 500);
		
		AdjustableLimb image = new AdjustableLimb(i, 0, 800, 800, new BasicImage(0, 0, "/textures/window/buttons/default_button.png"));
		
		image.draw(g);
		
	}
	
}