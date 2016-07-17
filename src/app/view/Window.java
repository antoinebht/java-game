package app.view;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;

public class Window extends Canvas{

	public Window(int width, int height, String name){
		setSize(width, height);
		setBackground(Color.BLACK);

		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		camera = new Camera(800, 600);
	}

	public void setMouseListener(MouseListener mouseListener){
		if(getMouseListeners().length > 0){
			removeMouseListener(getMouseListeners()[0]);
		}
		addMouseListener(mouseListener);
	}

	public void setKeyListener(KeyListener keyListener){
		if(getKeyListeners().length > 0){
			removeKeyListener(getKeyListeners()[0]);
		}
		addKeyListener(keyListener);
	}

	public Camera getCamera(){
		return camera;
	}
	
	protected JFrame frame;
	protected Camera camera;
}