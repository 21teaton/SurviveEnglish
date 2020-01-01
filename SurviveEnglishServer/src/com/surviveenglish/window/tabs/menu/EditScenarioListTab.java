package com.surviveenglish.window.tabs.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.surviveenglish.save.ScenarioSaveHandler;
import com.surviveenglish.scenario.Scenario;
import com.surviveenglish.util.DynamicSizeString;
import com.surviveenglish.util.TabButton;
import com.surviveenglish.window.TabHandler;
import com.surviveenglish.window.tabs.Tab;
import com.surviveenglish.window.tabs.menu.StartTab.OptionButton;

@SuppressWarnings("serial")
public class EditScenarioListTab extends Tab {
	
	private ArrayList<OptionButton> scenarioList;
	
	private int offset;
	
	public EditScenarioListTab(String tabName, JFrame frame) {
		super(tabName, frame);
		
	}
	
	@Override
	public void init() {
		
		offset = 0;
		
		scenarioList = new ArrayList<OptionButton>();
		
		ArrayList<Scenario> loadedScenarios = ScenarioSaveHandler.getLoadedScenarios();
		
		for (int i = 0; i < loadedScenarios.size(); i++) {
			
			scenarioList.add(new OptionButton(i, 0, 0, 0, 0, loadedScenarios.get(i).getName(), loadedScenarios.get(i).getDesciption(), "Saved as : " + ScenarioSaveHandler.getLoadedScenarioFileNames().get(i), 40, 40 + (i * 30), 10 + (loadedScenarios.get(i).getName().length() * 10), 20, Color.BLACK, Color.RED));
			
		}
		
		hasInitialized = true;
		
	}
	
	@Override
	public void update() {
		
		StartTab.getBackgroundColor().update();
		
		int amount = 0;
		
		for (int i = 0; i < scenarioList.size(); i++) {
			
			if (scenarioList.get(i).isHovered) {
				
				amount++;
				
			}
			
		}
		
		if (amount > 1) {
			
			for (int i = 0; i < scenarioList.size(); i++) {
				
				scenarioList.get(i).isHovered = false;
				
			}
			
		}
		
	}
	
	@Override
	public void draw(Graphics g) {
		
		g.setColor(StartTab.getBackgroundColor().getColor());
		g.fillRect(0, 0, window.getWidth(), window.getHeight());
		
		for (int i = 0; i < scenarioList.size(); i++) {
			
			if (scenarioList.get(i).originalY + scenarioList.get(i).heightOffset + offset > -20 && scenarioList.get(i).originalY + scenarioList.get(i).heightOffset + offset < window.HEIGHT + 20) {
				
				scenarioList.get(i).draw(g);
			
			}
			
		}
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		int mouseX = e.getX() - 10;
		int mouseY = e.getY() - 38;
		
		for (int i = 0; i < scenarioList.size(); i++) {
			
			scenarioList.get(i).mouseMoved(mouseX, mouseY);
			
		}
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		int mouseX = e.getX() - 10;
		int mouseY = e.getY() - 38;
		
		for (int i = 0; i < scenarioList.size(); i++) {
			
			scenarioList.get(i).onClick(mouseX, mouseY);
			
		}
		
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		int mouseX = e.getX() - 10;
		int mouseY = e.getY() - 38;
		
		for (int i = 0; i < scenarioList.size(); i++) {
			
			scenarioList.get(i).mouseMoved(mouseX, mouseY);
			
		}
		
		if (e.getWheelRotation() < 0 && offset + 10 < 40 + ((scenarioList.size() - 16) * 30)) {
			
			offset += 10;
			
		}
		if (e.getWheelRotation() > 0) {
			
			offset -= 10;
			
		}
		
	}
	
	public int centeredWithWidth(int width) {
		
		return (int) ((window.getWidth() / 2) - ((width * window.getWidthOffset()) / 2));
		
	}
	
	public class OptionButton extends TabButton {
		
		public boolean isHovered;
		
		public final int buttonID;
		
		public int originalY;
		
		public int heightOffset;
		
		public Color normalColor;
		public Color hoverColor;
		public Color displayColor;
		
		public final DynamicSizeString string;
		
		public DynamicSizeString desciptionString;
		
		public DynamicSizeString pathString;
		
		public OptionButton(int buttonID, int x, int y, int width, int height, String text, String desciptionString, String pathString, int textX, int textY, int textWidth, int textHeight, Color normalColor, Color hoverColor) {
			super(x, y, width, height);
			
			this.buttonID = buttonID;
			
			this.normalColor = normalColor;
			this.hoverColor = hoverColor;
			
			displayColor = normalColor;
			
			originalY = textY;
			
			this.desciptionString = new DynamicSizeString(desciptionString, textX, textY + 15, 6, 20, true);
			this.pathString = new DynamicSizeString(pathString, textX, textY + 30, 6, 20, true);
			
			this.string = new DynamicSizeString(text, textX, textY, textWidth, textHeight);
			
		}
		
		public void mouseMoved(int mouseX, int mouseY) {
			
			displayColor = normalColor;
			
			if (checkMouseInBounds(mouseX, mouseY)) {
				
				onHover(mouseX, mouseY);
				isHovered = true;
				System.out.println(buttonID);
				
			} else {
				
				isHovered = false;
				
				boolean resetOffset = true;
				
				int hovered = 0;
				
				for (int i = 0; i < scenarioList.size(); i++) {
					
					if (scenarioList.get(i).isHovered == true) {
						
						hovered++;
						
					}
					
				}
				
				if (hovered == 1) {
					
					resetOffset = false;
					
				} else {
					
					resetOffset = true;
					
				}
				
				if (resetOffset) {
					
					for (int i = 0; i < scenarioList.size(); i++) {
						
						scenarioList.get(i).heightOffset = 0;
						
					}
					
				}
				
			}
			
		}
		
		@Override
		public void onClick(int mouseX, int mouseY) {
			
			if (checkMouseInBounds(mouseX, mouseY)) {
				
				if (isHovered) {
					
					System.out.println(buttonID + " CLICKED");
					
				}
				
			}
			
		}
		
		@Override
		public void onHover(int mouseX, int mouseY) {
			
			displayColor = hoverColor;
			
			System.out.println(buttonID + "HOVER");
			
			if (buttonID + 1 < scenarioList.size()) {
				
				for (int i = buttonID + 1; i < scenarioList.size(); i++) {
					
					scenarioList.get(i).heightOffset = 20;
					
				}
				
			}
			
		}
		
		public void draw(Graphics g) {
			
			string.changePosition(string.x, originalY + heightOffset + offset);
			desciptionString.changePosition(desciptionString.x, originalY + 15 + offset);
			pathString.changePosition(pathString.x, originalY + 30 + offset);
			
			changePosition(centeredWithWidth(string.width + 10), (int) ((string.y - 5) * window.getHeightOffset()));
			changeSize((int) ((string.width + 10) * window.getWidthOffset()), (int) ((string.height + 10) * window.getHeightOffset()));
			
			string.drawWidthCenteredText(window, g, displayColor, new Font("TimesRoman", Font.PLAIN, 200));
			
			if (isHovered) {
				
				desciptionString.drawWidthCenteredText(window, g, Color.BLACK, new Font("TimesRoman", Font.PLAIN, 200));
				pathString.drawWidthCenteredText(window, g, Color.BLACK, new Font("TimesRoman", Font.ITALIC, 200));
				
			}
			
		}
		
	}
	
}