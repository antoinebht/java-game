package app;

import app.view.Window;
import app.App;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

abstract public class State implements MouseListener, KeyListener{

	public State(App app, Window window){
		this.app = app;
		this.window = window;
		window.setMouseListener(this);
		window.setKeyListener(this);
	}

	abstract public void display();
	abstract public void update();
	
	@Override
	public void mouseClicked(MouseEvent e){
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

	@Override
	public void keyPressed(KeyEvent e){
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				keyUp();
				break;
			case KeyEvent.VK_DOWN:
				keyDown();
				break;

			case KeyEvent.VK_LEFT:
				keyLeft();
				break;

			case KeyEvent.VK_RIGHT:
				keyRight();
				break;
		}

	}

	public void keyUp(){}
	public void keyDown(){}
	public void keyLeft(){}
	public void keyRight(){}

	@Override
	public void keyReleased(KeyEvent e){
	} 

	@Override
	public void keyTyped(KeyEvent e) {
	}

	protected App app;
	protected Window window;
} 