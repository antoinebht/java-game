package app.game.model;

import app.game.view_model.ViewModel;

public interface IBiome{

	String name();
	int maxSize();
	int minSize();

	void acceptViewModel(ViewModel viewModel);

	void genereEnvironnement(World m);
}