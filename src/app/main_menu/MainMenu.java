package app.main_menu;

import app.State;
import app.Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class MainMenu implements State{

	public MainMenu(Window window){
		this.window = window;
	}

	@Override
	public void display(){
		//System.out.println("MainMenu");

		Graphics g = window.getGraphics();
		g.setColor(Color.RED);
		g.fillRect(20,20,200,200);
	}

	@Override
	public void handleEvent(){
		
	}

	protected Window window;
}
