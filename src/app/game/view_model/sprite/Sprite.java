package app.game.view_model.sprite;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import app.game.exceptions.FrameNotDefinedException;

public class Sprite{

	public Sprite(String file, int x, int y, int w, int h, int nb){

		BufferedImage spriteSheet;
		try{
			spriteSheet = ImageIO.read(new File(file));
		}
		catch(IOException e){
			System.err.println("Le fichier ressource ["+file+"] est inaccessible.");
			return;
		}

		frames = new BufferedImage[nb];
		for(int i = 0; i < nb; i++){
			frames[i] = spriteSheet.getSubimage(x+i*w, y, w, h);
		}
	}

	public int getNbFrames(){
		return frames.length;
	}

	public BufferedImage getFrame(int nb) throws FrameNotDefinedException{ 
		if(nb < 0 || nb > frames.length)
			throw new  FrameNotDefinedException("The frame number is not valid");
		return frames[nb]; 
	}

	protected BufferedImage[] frames;
}