package app.game.model.geo_tools;

import java.util.HashMap;

/**
 * Fabrique de point. Pattern FlyWeight.
 * Permet d'avoir une seul instance des points qui se repete souvent.
 */
public class PointFactory{

	protected HashMap<Integer, Point> map;

	public final int MAX_VALUE = 100000;
	public final int MIN_VALUE = -100000;

	public PointFactory(){
		map = new HashMap<Integer, Point>();
	}

	public Point getPoint(int line, int column){

		int hash = hash(line+MAX_VALUE, column+MAX_VALUE);


		Point point = map.get(hash);

		if(point==null){
			point = new Point(line, column);
			map.put(hash, point);
		}

		return point;
	}

	public Point east(Point p){
		return getPoint(p.line(), p.column()+1);
	}

	public Point west(Point p){
		return getPoint(p.line(), p.column()-1);
	}

	public int hash(int l, int c){
		//Cantor Pairing Function
		return (l+c)*(l+c+1)/2+c;
		//return h/2;
		// int h = 17;
		// h=h*31+l;
		// h=h*31+c;
		// return h;
	}
}