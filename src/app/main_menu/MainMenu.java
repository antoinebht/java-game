package app.main_menu;

import app.App;
import app.State;
import app.view.Window;

import java.awt.Color;
import java.awt.Font;
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
		g.setColor(Color.WHITE);
		g.setFont(new Font("Lucida",Font.PLAIN, 12));
		g.drawString("Mind v0.1 - ©AntoineB",650,590);
		g.setFont(new Font("Lucida",Font.PLAIN, 36));
		g.drawString("Mind v0.1",35,50);
	}

	@Override
	public void mouseClicked(MouseEvent e){
		app.playGame();
	}
}
