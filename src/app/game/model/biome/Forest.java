package app.game.model.biome;

import app.game.model.IBiome;
import app.game.model.World;

import app.game.view_model.ViewModel;

public class Forest implements IBiome{

	@Override
	public String name(){
		return "Foret";
	}

	@Override
	public int minSize(){
		return 80;
	}

	@Override
	public int maxSize(){
		return 10000;
	}

	@Override
	public String toString(){
		return "F";
	}

	@Override
	public void acceptViewModel(ViewModel viewModel){
		viewModel.visitForest();	
	}

	@Override
	public void genereEnvironnement(World m){
		// int nbMiniArbre = 3;
		// int nbMaxArbre = 25;
		// int nbArbre = (int)(Math.random()*(nbMaxArbre - nbMiniArbre))+nbMiniArbre;

		// for(int i=0; i< nbArbre; i++){
			
		// }
	}
}