package app.game.model;

public class Model{

	public Model(int numberOfBiome){
		world = new World(numberOfBiome);
		world.generate();
		player = new Player();
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

//Facade Player
	public Player getPlayer(){
		return player;
	}

	public void playerUp(){
		player.up();
	}
	public void playerDown(){
		player.down();
	}
	public void playerLeft(){
		player.left();
	}
	public void playerRight(){
		player.right();
	}


	protected World world;
	protected Player player;
}