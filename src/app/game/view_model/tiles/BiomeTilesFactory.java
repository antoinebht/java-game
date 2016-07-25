package app.game.view_model.tiles;


import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import java.util.Random;

public class BiomeTilesFactory{

	protected static BufferedImage plain; 
	protected static BufferedImage forest; 

	protected static Random rand = new Random();


	public static BufferedImage plain(){
		if(plain == null){
			try{
				plain = ImageIO.read(new File("res/img/biome/Grass_64-2.png"));
			}
			catch(IOException e){
				System.err.println("Le fichier ressource [res/img/biome/plain4.png] est inaccessible.");
			}
		}

		int i = rand.nextInt(1);
		return plain.getSubimage(i*64,0,64,64);
	}

	public static BufferedImage forest(){
		if(forest == null){
			try{
				forest = ImageIO.read(new File("res/img/biome/Forest_16.png"));	
			}
			catch(IOException e){
				System.err.println("Le fichier ressource [res/img/biome/plain4.png] est inaccessible.");
			}
		}
		return forest;
	}
}