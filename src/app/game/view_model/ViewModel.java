package app.game.view_model;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import app.view.Window;
import app.view.Camera;

import app.game.model.Model;
import app.game.model.IBiome;

public class ViewModel{
	protected BufferedImage currentImage;

	final int TILE_SIZE_X = 16;
	final int TILE_SIZE_Y = 16; 

	public void displayMap(Window window, Model model){
	    Dimension d = window.size();
	    Image offscreen = window.createImage(d.width, d.height);
	    Graphics g = offscreen.getGraphics();

		//Efface le canvas
		g.clearRect(0,0, 800, 600);

		//Recuperer la camera
		Camera camera = window.getCamera();
		//On stock les détails de la caméra
		int cY = camera.getY(); int cX = camera.getX();
		int cW = camera.getWidth(); int cH = camera.getHeight();

		// +/- 1 -> Arrondi du float
		int minVisibleLine = xy2l(cX+cW, cY) - 1;
		int maxVisibleLine = xy2l(cX, cY+cH) + 1;
		int minVisibleColumn = xy2c(cX, cY) - 1;
		int maxVisibleColumn =  xy2c(cX+cW, cY+cH) +1;

		int minLine = model.getWorldMinLine();
		int maxLine = model.getWorldMaxLine();
		int minColumn = model.getWorldMinColumn();
		int maxColumn = model.getWorldMaxColumn();

		int startLine = (minVisibleLine < minLine) ? minLine : minVisibleLine;
		int endLine = (maxVisibleLine < maxLine) ? maxVisibleLine : maxLine;
		int startColumn = (minVisibleColumn < minColumn) ? minColumn : minVisibleColumn;
		int endColumn = (maxVisibleColumn < maxColumn) ? maxVisibleColumn : maxColumn;

		for(int line = startLine; line <= endLine; line++){
			for (int column = startColumn; column <= endColumn; column++) {
				IBiome biome = model.getWorldBiome(line, column);
				if(biome != null){
					biome.acceptViewModel(this);
					g.drawImage(currentImage, -camera.getX() + cl2x(line, column) , 
								-camera.getY() + cl2y(line, column) , null);
				}	
			}
		}


		//Recuperer le canvas
		Graphics canvas = window.getGraphics();
	    // transfer offscreen to window
	    canvas.drawImage(offscreen, 0, 0, window);
	}

	private int xy2l(int x, int y){
		// return (int)( (y/TILE_SIZE_Y) - (x/TILE_SIZE_X) );
		return (int)(y/TILE_SIZE_Y);
	}

	private int xy2c(int x, int y){
		// return (int)( (y/TILE_SIZE_Y) + (x/TILE_SIZE_X) +1 ) ;
		return (int)(x/TILE_SIZE_X) ;
	}

	private int cl2x(int l, int c){
		// return (c - l - 1) * TILE_SIZE_X/2;
		return c*TILE_SIZE_X;
	}

	private int cl2y(int l, int c){
		// return (c + l - 1)* TILE_SIZE_Y/2 ;
		return l*TILE_SIZE_Y ;
	}


	public void visitForest(){
		currentImage = BiomeTilesFactory.forest();
	}

	public void visitPlain(){
		
		currentImage = BiomeTilesFactory.plain();
	}

}