package app.game.model;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.lang.Math;

abstract public class MovableEntity {

	public MovableEntity(){
		state = State.DOWN;
		speed = 9;
		step = 0;
		x = 0;
		y= 1;
		actions = new LinkedList<ActionMove>();
	}

	public void update(){
		if(!actions.isEmpty())
			actions.pop().exec(this);
	}

	public void move(float x, float y){
		this.x+= x;
		this.y+= y;

		if(x>0)
			state = State.RIGHT;
		else if (x<0)
			state = State.LEFT;
		else if (y>0) 
			state = State.DOWN;
		else
			state = State.UP;
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
	public int getSpeed(){ return speed; }

	public enum State{ UP, DOWN, LEFT, RIGHT }


	protected float x;
	protected float y;
	protected int speed;
	protected State state;
	protected int step;
	protected LinkedList<ActionMove> actions;
}