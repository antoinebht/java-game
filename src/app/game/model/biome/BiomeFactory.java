package app.game.model.biome;

import app.game.model.IBiome;

/**
 * Classe pour fabriquer des biomes.
 * Permet d'avoir une seule instance d'un biome dans l'app.
 * Permet de regrouper en un seul endroit les types de biomes différents. 
 */
public class BiomeFactory{

	protected static IBiome[] biomes = {
		new Forest(),
		new Plain()
	};

	public Forest forest(){
		return (Forest)biomes[0];
	}

	public Plain plain(){
		return (Plain)biomes[1];
	}

	public IBiome aleatoire(){
		int ind = (int)(Math.random() * biomes.length); //alea entre [0;biomes.length-1]
		return biomes[1];
	}

}