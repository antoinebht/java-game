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

	public void down(Model model){
		if(actions.isEmpty() && model.getWorldBiome(Math.round(y+1),Math.round(x)) != null)
			for(int i=0; i<speed; i++)
				actions.push(new ActionMove(0, 1f/speed));
	}

	public void up(Model model){
		if(actions.isEmpty() && model.getWorldBiome(Math.round(y-1),Math.round(x)) != null)
			for(int i=0; i<speed; i++)
				actions.push(new ActionMove(0, -1f/speed));
	}

	public void left(Model model){
		if(actions.isEmpty() && model.getWorldBiome(Math.round(y),Math.round(x-1)) != null)
			for(int i=0; i<speed; i++)
				actions.push(new ActionMove(-1f/speed, 0));
	}

	public void right(Model model){
		if(actions.isEmpty()&& model.getWorldBiome(Math.round(y),Math.round(x+1)) != null)
			for(int i=0; i<speed; i++)
				actions.push(new ActionMove(1f/speed, 0));
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