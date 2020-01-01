package com.surviveenglish.client.player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import com.surviveenglish.util.BasicImage;

public class AdjustableLimb {
	
	public double rotation;
	public double offsetRotation;
	
	public int connectionPointX;
	public int connectionPointY;
	
	public BasicImage image;
	
	AffineTransform tx;
	AffineTransformOp op;
	
	public AdjustableLimb(double rotation, double offsetRotation, int connectionPointX, int connectionPointY, BasicImage image) {
		
		this.rotation = Math.toRadians(rotation);
		this.offsetRotation = Math.toRadians(offsetRotation);
		this.connectionPointX = connectionPointX;
		this.connectionPointY = connectionPointY;
		this.image = image;
		
		this.tx = AffineTransform.getRotateInstance(this.rotation + this.offsetRotation, this.connectionPointX, this.connectionPointY);
		
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		AffineTransform backup = g2d.getTransform();
		g2d.setTransform(this.tx);
		g2d.drawImage(image.getImage(), this.connectionPointX, this.connectionPointY, null);
		g2d.setTransform(backup);
		
	}
	
}