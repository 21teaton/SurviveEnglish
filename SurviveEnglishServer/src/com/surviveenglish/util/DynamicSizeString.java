package com.surviveenglish.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.surviveenglish.window.Window;

public class DynamicSizeString {
	
	public boolean dynamicAdjustment;
	
	public int x;
	public int y;
	
	public int width;
	public int height;
	
	public int widthIncrement;
	
	public String string;
	
	private BufferedImage textImage;
	
	private FontMetrics fontMetrics;
	
	private static Window window;
	
	public DynamicSizeString(String string, int x, int y, int width, int height) {
		
		this.string = string;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public DynamicSizeString(String string, int x, int y, int widthIncrement, int height, boolean dynamicAdjustment) {
		
		this.string = string;
		this.dynamicAdjustment = dynamicAdjustment;
		this.x = x;
		this.y = y;
		
		this.widthIncrement = widthIncrement;
		
		for (int i = 0; i < string.length(); i++) {
			
			this.width += widthIncrement;
			
		}
		
		this.height = height;
		
	}
	
	public void draw(Graphics g, Color color, Font font) {
		
		fontMetrics = g.getFontMetrics(font);
		
		textImage = new BufferedImage(fontMetrics.stringWidth(string), fontMetrics.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = textImage.createGraphics();
        g2d.setColor(color);
        g2d.setFont(font);
        g2d.drawString(string, 0, fontMetrics.getAscent());
        g2d.dispose();
		
        g.drawImage(textImage, (int) (x * window.getWidthOffset()), (int) (y * window.getHeightOffset()), (int) (width * window.getWidthOffset()), (int) (height * window.getHeightOffset()), null);
        
	}
	
	public void drawWidthCenteredText(Window window, Graphics g, Color color, Font font) {
		
		fontMetrics = g.getFontMetrics(font);
		
		textImage = new BufferedImage(fontMetrics.stringWidth(string), fontMetrics.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = textImage.createGraphics();
        g2d.setColor(color);
        g2d.setFont(font);
        g2d.drawString(string, 0, fontMetrics.getAscent());
        g2d.dispose();
		
        g.drawImage(textImage, (int) ((window.getWidth() / 2) - ((width * window.getWidthOffset()) / 2)), (int) (y * window.getHeightOffset()), (int) (width * window.getWidthOffset()), (int) (height * window.getHeightOffset()), null);
        
	}
	
	public static void setWindow(Window windowIn) {
		
		window = windowIn;
		
	}
	
	public void changeText(String string) {
		
		this.string = string;
		
		if (dynamicAdjustment) {
			
			this.width = 0;
			
			for (int i = 0; i < string.length(); i++) {
				
				this.width += widthIncrement;
				
			}
			
		}
		
	}
	
	public void changePosition(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void changeSize(int width, int height) {
		
		this.width = width;
		this.height = height;
		
	}
	
	public BufferedImage getImage() {
		
		return textImage;
		
	}
	
}