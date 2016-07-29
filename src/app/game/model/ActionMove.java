package app.game.model;

public class ActionMove{

	public ActionMove(float x, float y){
		this.x = x;
		this.y = y;
	}

	public void exec(MovableEntity e){
		e.move(x, y);
	}


	protected float x;
	protected float y;
}