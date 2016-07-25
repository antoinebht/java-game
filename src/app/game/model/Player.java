package app.game.model;

import app.game.view_model.sprite.SpritesFactory;
import app.game.exceptions.FrameNotDefinedException;

import java.awt.image.BufferedImage;

public class Player extends MovableEntity {
	public Player(){
		super();
	}

	@Override
	public void up(Model model){
		super.up(model);
		step = (step+1)%SpritesFactory.playerUp().getNbFrames();
	}

	@Override
	public void down(Model model){
		super.down(model);
		step = (step+1)%SpritesFactory.playerDown().getNbFrames();
	}

	@Override
	public void left(Model model){
		super.left(model);
		step = (step+1)%SpritesFactory.playerLeft().getNbFrames();
	}

	@Override
	public void right(Model model){
		super.right(model);
		step = (step+1)%SpritesFactory.playerRight().getNbFrames();
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
}