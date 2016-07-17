package app.game;

import app.App;
import app.State;
import app.view.Window;

import app.game.model.Model;
import app.game.view_model.ViewModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends State{

	public Game(App app, Window window){
		super(app, window);
		model = new Model(1);
		viewModel = new ViewModel();
	}

	@Override
	public void display(){
		if(needUpdate)
			viewModel.displayMap(window, model);

		needUpdate = false;
	}

	@Override
	public void mouseClicked(MouseEvent e){
	}

	@Override
	public void keyUp(){
		window.getCamera().moveUp();
		needUpdate = true;
	}

	@Override
	public void keyDown(){
		window.getCamera().moveDown();
		needUpdate = true;
	}

	@Override
	public void keyLeft(){
		window.getCamera().moveLeft();
		needUpdate = true;
	}

	@Override
	public void keyRight(){
		window.getCamera().moveRight();
		needUpdate = true;
	}

	protected final Model model;
	protected final ViewModel viewModel;
	protected boolean needUpdate = true;
}
