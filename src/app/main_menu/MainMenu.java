package app.main_menu;

import app.App;
import app.State;
import app.Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenu extends State{

	public MainMenu(App app, Window window){
		super(app, window);
	}

	@Override
	public void display(){
		Graphics g = window.getGraphics();
		g.setColor(Color.RED);
		g.fillRect(20,20,200,200);
	}

	@Override
	public void mouseClicked(MouseEvent e){
		app.playGame();
	}
}
