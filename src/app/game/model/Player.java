package app.game.model;

import app.game.view_model.sprite.SpritesFactory;
import app.game.exceptions.FrameNotDefinedException;

import app.game.model.game_objects.Container;

import java.awt.image.BufferedImage;



public class Player extends MovableEntity {
	public Player(){
		super();
		backpack = null;
	}

	public void objectAction(Container c){
		backpack = c;
		System.out.println("New backpack");
	}



	@Override
	public boolean up(Model model){
		super.up(model);
		step = (step+1)%SpritesFactory.playerUp().getNbFrames();
		return true;
	}

	@Override
	public boolean down(Model model){
		super.down(model);
		step = (step+1)%SpritesFactory.playerDown().getNbFrames();
		return true;
	}

	@Override
	public boolean left(Model model){
		if(super.left(model))
			step = (step+1)%SpritesFactory.playerLeft().getNbFrames();
		return true;
	}

	@Override
	public boolean right(Model model){
		super.right(model);
		step = (step+1)%SpritesFactory.playerRight().getNbFrames();
		return true;
	}

	@Override
	public BufferedImage getSprite(){
		switch(state){
			case UP :
				try{
					return SpritesFactory.playerUp().getFrame(step);
				}
				catch(FrameNotDefinedException e){

				}
				break;
			case DOWN :
				try{
					return SpritesFactory.playerDown().getFrame(step);
				}
				catch(FrameNotDefinedException e){

				}
				break;
			case LEFT :
				try{
					return SpritesFactory.playerLeft().getFrame(step);
				}
				catch(FrameNotDefinedException e){

				}
				break;
			case RIGHT :
				try{
					return SpritesFactory.playerRight().getFrame(step);
				}
				catch(FrameNotDefinedException e){

				}
				break;
		}
		return null;
	}

	protected Container backpack;
}