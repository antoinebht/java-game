package app.game.geo_tools;


public class Box{

	public Box(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h
	}

	public boolean collide(int x2, int y2){
		return x2 >= x && x2 <= x+w && y2>=y && y2<=y+h;
	}

	protected int x, y;
	protected int w, h;
}