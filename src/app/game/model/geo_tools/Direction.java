package app.game.model.geo_tools;

public enum Direction{

	Nord (-1, +0),
	Est  (+0, +1),
	Sud  (+1, +0),
	Ouest(+0, -1);


	protected int dLine, dColumn;

	private Direction(int dLine, int dColumn){
		this.dLine = dLine;
		this.dColumn = dColumn;
	}

	public int dLine(){
		return dLine;
	}

	public int dColumn(){
		return dColumn;
	}

	public Direction next(){
		return values()[(ordinal()+1)%values().length];
	}

}