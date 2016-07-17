package app.game.model.geo_tools;

public class Point{

	protected final int line, column;

	public Point(int line, int column){
		this.line = line;
		this.column = column;
	}

	public int line(){
		return line;
	}

	public int column(){
		return column;
	}

	// @Override
 //    public int hashCode()
 //    {
 //        int hash = 17;
 //        hash = ((hash + line) << 5) - (hash + line);
 //        hash = ((hash + column) << 5) - (hash + column);
 //        return hash;
 //    }

	@Override
	public String toString(){
		return "("+line+","+column+")";
	}
}