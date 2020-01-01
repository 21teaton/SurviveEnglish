package com.surviveenglish.window.tabs;

import java.awt.Font;

import javax.swing.JLabel;

public class JPanelUtils {
	
	public static JLabel getJLabelWithFont(String text, Font font) {
		
		JLabel label = new JLabel(text);
		label.setFont(font);
		return label;
		
	}
	
}