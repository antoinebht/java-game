package app.game.model.biome;

import app.game.model.IBiome;
import app.game.model.World;

import app.game.view_model.ViewModel;

public class Plain implements IBiome{

	@Override
	public String name(){
		return "Plaine";
	}

	@Override
	public int minSize(){
		return 10;
	}

	@Override
	public int maxSize(){
		return 10;
	}

	@Override
	public String toString(){
		return "P";
	}

	@Override
	public void acceptViewModel(ViewModel viewModel){
		viewModel.visitPlain();	
	}


	@Override
	public void genereEnvironnement(World m){
		
	}
}