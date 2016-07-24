package app.game.exceptions;

public class FrameNotDefinedException extends Exception{

	public FrameNotDefinedException(){
		super();
	}

	public FrameNotDefinedException(String m){
		super(m);
	}
}