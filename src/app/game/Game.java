package app.game;

import app.App;
import app.State;
import app.Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends State{

	public Game(App app, Window window){
		super(app, window);
	}

	@Override
	public void display(){
		//System.out.println("MainMenu");

		Graphics g = window.getGraphics();
		g.setColor(Color.YELLOW);
		g.fillRect(20,20,200,200);
	}
}
