package app.game.model;

import java.awt.image.BufferedImage;

abstract public class MovableEntity {

	public MovableEntity(){
		state = State.DOWN;
		speed = 6;
		step = 0;
		x = 0;
		y= 1;
	}


	public void down(){
		state = State.DOWN;
		y+=1./speed;
	}

	public void up(){
		state = State.UP;
		y-=1./speed;
	}

	public void left(){
		state = State.LEFT;
		x-=1./speed;
	}

	public void right(){
		state = State.RIGHT;
		x+=1./speed;
	}

	abstract public BufferedImage getSprite();

	public float getX(){ return x; }
	public float getY(){ return y; }

	public enum State{ UP, DOWN, LEFT, RIGHT }
	protected float x;
	protected float y;
	protected int speed;
	protected State state;
	protected int step;
}