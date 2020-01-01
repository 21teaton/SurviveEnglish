package com.surviveenglish.window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.surviveenglish.util.Logger;
import com.surviveenglish.window.tabs.DebugTab;
import com.surviveenglish.window.tabs.MapTab;
import com.surviveenglish.window.tabs.Tab;
import com.surviveenglish.window.tabs.menu.EditScenarioListTab;
import com.surviveenglish.window.tabs.menu.StartTab;

public class TabHandler {
	
	private static int currentTab;
	
	private static JFrame frame;
	
	private static ArrayList<Tab> tabs = new ArrayList<Tab>();
	
	public void addTabs(JFrame frame) {
		
		this.frame = frame;
		
		tabs.add(new MapTab("debug_tab", frame));
		tabs.add(new StartTab("start_tab", frame));
		tabs.add(new EditScenarioListTab("edit_scenario_list_tab", frame));
		
		setCurrentTab("start_tab");
		
		for (int i = 0; i < tabs.size(); i++) {
			
			Logger.logInformation("Init Index : " + i);
			tabs.get(i).init();
			
		}
		
	}
	
	public static void setCurrentTab(String name) {
		
		for (int i = 0; i < tabs.size(); i++) {
			
			if (tabs.get(i).getTabName().equals(name)) {
				
				frame.remove(tabs.get(currentTab));
				currentTab = i;
				frame.add(tabs.get(currentTab));
				
			}
			
		}
		
	}
	
	public void update() {
		
		tabs.get(currentTab).safeUpdate();
		
	}
	
	public void mouseMoved(MouseEvent e) {
		tabs.get(currentTab).mouseMoved(e);
	}
	
	public void mousePressed(MouseEvent e) {
		tabs.get(currentTab).mousePressed(e);
	}
	
	public void mouseReleased(MouseEvent e) {
		tabs.get(currentTab).mouseReleased(e);
	}
	
	public void mouseEntered(MouseEvent e) {
		tabs.get(currentTab).mouseEntered(e);
	}
	
	public void mouseExited(MouseEvent e) {
		tabs.get(currentTab).mouseExited(e);
	}
	
	public void mouseWheelMoved(MouseWheelEvent e){
		tabs.get(currentTab).mouseWheelMoved(e);
	}
	
}