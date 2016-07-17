package app.view;

public class Camera{

	protected int x, y;
	protected int width, height;

	protected final int SPEED = 30;

	public Camera(int width, int height){
		this.width = width;
		this.height = height;
		this.x = 0;
		this.y = 0;
	}

	public void moveUp(){
		y-=SPEED;
		//System.out.println("x:"+x+"y:"+y);
	}

	public void moveDown(){
		y+=SPEED;
		//System.out.println("x:"+x+"y:"+y);
	}

	public void moveLeft(){
		x-=SPEED;
		//System.out.println("x:"+x+"y:"+y);
	}

	public void moveRight(){
		x+=SPEED;
		//System.out.println("x:"+x+"y:"+y);
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
}