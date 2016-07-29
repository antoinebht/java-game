package app.game.view_model;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

import app.view.Window;
import app.view.Camera;

import app.game.model.Model;
import app.game.model.Player;
import app.game.model.IBiome;

import app.game.view_model.tiles.BiomeTilesFactory;

public class ViewModel{
	protected BufferedImage currentImage;

	final int TILE_SIZE_X = 64;
	final int TILE_SIZE_Y = 64; 

	public void display(Window window, Model model){
		Dimension d = window.size();
	    Image offscreen = window.createImage(d.width, d.height);
	    Graphics g = offscreen.getGraphics();

		//Efface le canvas
		g.clearRect(0,0, 800, 600);

		displayMap(g, model);
		displayPlayer(g, model.getPlayer());

		
		//Recuperer le canvas
		Graphics canvas = window.getGraphics();
	    // transfer offscreen to window
	    canvas.drawImage(offscreen, 0, 0, window);
	}

	public void displayPlayer(Graphics g, Player p){
		BufferedImage sprite = p.getSprite();
		g.drawImage(sprite, /*(int)(p.getX()*TILE_SIZE_X)+*/368, /*(int)(p.getY()*TILE_SIZE_Y)+*/268, null);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Lucida",Font.PLAIN, 12));
		g.drawString("("+p.getX()+", "+p.getY()+")", 20, 20);
	}

	public void displayMap(Graphics g, Model model){
		
		float cX = model.getPlayer().getX();
		float cY = model.getPlayer().getY();

		int width = 800;
		int height = 600;

		// +/- 1 -> Arrondi du float
		int minVisibleLine = (int)(cY - height/2)/TILE_SIZE_Y - 1;
		int maxVisibleLine = (int)(cY + height/2)/TILE_SIZE_Y + 1;
		int minVisibleColumn = (int)(cX - width/2)/TILE_SIZE_X - 1;
		int maxVisibleColumn =  (int)(cX + width/2)/TILE_SIZE_X + 1;

		int minLine = model.getWorldMinLine();
		int maxLine = model.getWorldMaxLine();
		int minColumn = model.getWorldMinColumn();
		int maxColumn = model.getWorldMaxColumn();

		int startLine = (minVisibleLine < minLine) ? minLine : minVisibleLine;
		int endLine = (maxVisibleLine < maxLine) ? maxVisibleLine : maxLine;
		int startColumn = (minVisibleColumn < minColumn) ? minColumn : minVisibleColumn;
		int endColumn = (maxVisibleColumn < maxColumn) ? maxVisibleColumn : maxColumn;

		for(int line = minLine; line <= maxLine; line++){
			for (int column = minColumn; column <= maxColumn; column++) {
				IBiome biome = model.getWorldBiome(line, column);
				if(biome != null){
					biome.acceptViewModel(this);
					g.drawImage(currentImage, (int)(column*TILE_SIZE_X+368-cX*TILE_SIZE_X), (int)(line*TILE_SIZE_Y+268-cY*TILE_SIZE_Y) , null);
				}	
			}
		}


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