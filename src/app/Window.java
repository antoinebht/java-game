package app;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseListener;

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
	}

	public void setMouseListener(MouseListener mouseListener){
		if(getMouseListeners().length > 0)
			removeMouseListener(frame.getMouseListeners()[0]);
		addMouseListener(mouseListener);
	}
	
	protected JFrame frame;
}