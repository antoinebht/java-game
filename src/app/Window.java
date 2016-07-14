package app;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;

public class Window extends Canvas{

	protected JFrame frame;

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
}