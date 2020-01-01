package com.surviveenglish.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.surviveenglish.window.Window;

public class BasicImage {
	
	public int x;
	public int y;
	
	public BufferedImage image;
	
	private static Window window;
	
	public BasicImage(String imageLocation) {
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream(imageLocation));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public BasicImage(int x, int y, String imageLocation) {
		
		this.x = x;
		this.y = y;
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream(imageLocation));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void setWindow(Window windowIn) {
		
		window = windowIn;
		
	}
	
	public BufferedImage getImage() {
		
		return this.image;
		
	}
	
	public void draw(Graphics g) {
		
		draw(g, x, y);
		
	}
	
	public void draw(Graphics g, int x, int y) {
		
		draw(g, x, y, image.getWidth(), image.getHeight());
		
	}
	
	public void draw(Graphics g, int x, int y, int width, int height) {
		
		g.drawImage(image, (int) (x * window.getWidthOffset()), (int) (y * window.getHeightOffset()), (int) (width * window.getWidthOffset()), (int) (height * window.getHeightOffset()), null);
		
	}
	
}