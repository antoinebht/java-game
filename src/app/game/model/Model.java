package app.game.model;

/**
 * 
 */
public class Model{

	public Model(int numberOfBiome){
		world = new World(numberOfBiome);
		world.generate();
	}

//Requete d'affichage

	public void displayMap(){
		//viewModel.display(Plain, line, column)
		//viewModel.display(Forest, line, column)
		//viewModel.display(... , line, column)
	}	


//Facade World
	public int getWorldMinLine(){
		return world.getMinLine();
	}

	public int getWorldMaxLine(){
		return world.getMaxLine();
	}

	public int getWorldMinColumn(){
		return world.getMinColumn();
	}

	public int getWorldMaxColumn(){
		return world.getMaxColumn();
	}

	public IBiome getWorldBiome(int line, int column){
		return world.getBiome(line, column);
	}

	protected World world;
}