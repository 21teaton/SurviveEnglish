package com.surviveenglish.window;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseHandler extends MouseAdapter {
	
	TabHandler handler;
	
	public MouseHandler(TabHandler screenHandler) {
		
		handler = screenHandler;
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		handler.mouseMoved(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		handler.mousePressed(e);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		handler.mouseReleased(e);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		handler.mouseEntered(e);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		handler.mouseExited(e);
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e){
		handler.mouseWheelMoved(e);
	}
	
}