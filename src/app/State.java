package app;

import app.Window;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

abstract public class State implements MouseListener{

	public State(App app, Window window){
		this.app = app;
		this.window = window;
		window.setMouseListener(this);
	}

	abstract public void display();
	
	@Override
	public void mouseClicked(MouseEvent e){
		System.out.println("Click");
	}
	@Override
	public void mouseEntered(MouseEvent e){
	}
	@Override
	public void mouseExited(MouseEvent e){
	}
	@Override
	public void mousePressed(MouseEvent e){
	}
	@Override
	public void mouseReleased(MouseEvent e){
	}

	protected App app;
	protected Window window;
} 