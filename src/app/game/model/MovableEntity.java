package app.game.model;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.lang.Math;

abstract public class MovableEntity {

	public MovableEntity(){
		state = State.DOWN;
		speed = 6;
		step = 0;
		x = 0;
		y= 1;
	}

	public boolean down(Model model){
		if(model.getWorldBiome(Math.round(y+1f/speed), Math.round(x)) == null)
			return false;
		state = State.DOWN;
		y+=1./speed;
		return true;
	}

	public boolean up(Model model){
		if(model.getWorldBiome(Math.round(y-1f/speed), Math.round(x)) == null)
			return false;
		state = State.UP;
		y-=1./speed;
		return true;
	}

	public boolean left(Model model){
		if(model.getWorldBiome(Math.round(y), Math.round(x-1f/speed)) == null)
			return false;
		state = State.LEFT;
		x-=1./speed;
		return true;
	}

	public boolean right(Model model){
		if(model.getWorldBiome(Math.round(y), Math.round(x+1f/speed)) == null)
			return false;
		state = State.RIGHT;
		x+=1./speed;
		return true;
	}

	abstract public BufferedImage getSprite();

	public float getX(){ return x; }
	public float getY(){ return y; }
	public int getSpeed(){ return speed; }

	public enum State{ UP, DOWN, LEFT, RIGHT }


	protected float x;
	protected float y;
	protected int speed;
	protected State state;
	protected int step;
}