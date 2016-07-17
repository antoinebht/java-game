package app.game.model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

import app.game.model.geo_tools.Point;
import app.game.model.geo_tools.PointFactory;
import app.game.model.geo_tools.Direction;
import app.game.model.biome.BiomeFactory;


/**
 * Representation d'un monde.
 * Met en place une usine FlyWeigth pour les points et biome.
 * Permet de reguler le nombre d'instance identique.
 * Associe a un biome un point de la map.
 */
public class World{

	/* Les usines de fabrications */
	protected BiomeFactory biomeFactory;
	protected PointFactory pointFactory;

	protected HashMap<Point, IBiome> map;

	/* Pour les point libre lors de la generation */
	protected ArrayList<Point> freePoints;

	protected int minLine, maxLine;
	protected int minColumn, maxColumn;

	protected int numberOfBiome;

	public World(int numberOfBiome){
		pointFactory = new PointFactory();
		biomeFactory = new BiomeFactory();

		map = new HashMap<Point,IBiome>();

		//Le premier point libre est l'origine de la map (0,0);
		freePoints = new ArrayList<Point>();
		freePoints.add(pointFactory.getPoint(0,0));

		this.numberOfBiome = numberOfBiome;

		minLine = 0;
		maxLine = 0;
		minColumn = 0;
		maxColumn = 0;
	}


	public void generate(){
		int numberOfCreatedBiome = 0;
		while(numberOfCreatedBiome < numberOfBiome){
			generateBiome();
			numberOfCreatedBiome++;
		}
		//standardize();
	}

	private void generateBiome(){
		IBiome biome = biomeFactory.aleatoire();
		int numberOfPoint = 0;

		//On recupere un point aleatoire dans les points libres.
		Point center = pointRand();

		int minLineBiome = center.line();
		int maxLineBiome = center.line();
		int minColumnBiome = center.column();
		int maxColumnBiome = center.column();



		//On reset les points libres pour les adapter à la nouvelle position
		freePoints.clear();
//TODO -> ALEA de LA TAILLE	
		// Tant qu'on a pas atteint la taille max
		while(numberOfPoint < biome.maxSize()){
			//On pose un biome sur le point select
			map.put(center, biome);
			//On reajuste les dimension de la maps
			updateMapSize(center);
			//On recupere les nouveaux points libres
			unblockPoints(center);
			//On recupere un nouveau point
			center = pointRand();
			numberOfPoint++;
			maxLineBiome = 
				center.line() > maxLineBiome ? 
					center.line() : 
					maxLineBiome;
			minLineBiome = 
				center.line() < minLineBiome ? 
					center.line() : 
					minLineBiome;
			maxColumnBiome = 
				center.column() > maxColumnBiome ? 
					center.column() : 
					maxColumnBiome;
			minColumnBiome = 
				center.column() < minColumnBiome ? 
					center.column() : 
					minColumnBiome;
		}
		Point start = null;
		Point end = null;
		ArrayList<Point> nullPoint = new ArrayList<Point>();
		for(int l = minLineBiome; l < maxLineBiome; l++){
			start = null;
			end = null;
			nullPoint.clear();

			for(int c = minColumnBiome; c < maxColumnBiome; c++){
				Point currentPoint = pointFactory.getPoint(l,c);
				if(map.get(currentPoint) != null){
					if(start == null)
						start = currentPoint;
					end = currentPoint;
				}
				else{
					if(start != null)
						nullPoint.add(currentPoint);
				}
			}
			for(Point p : nullPoint){
				if(p.column() > start.column() && p.column() < end.column())
					map.put(p, map.get(pointFactory.west(p)));
			}
		}
	}

	private void standardize(){
		Point start = null;
		Point end = null;
		ArrayList<Point> nullPoint = new ArrayList<Point>();
		for(int l = minLine; l < maxLine; l++){
			start = null;
			end = null;
			nullPoint.clear();

			for(int c = minColumn; c < maxColumn; c++){
				Point currentPoint = pointFactory.getPoint(l,c);
				if(map.get(currentPoint) != null){
					if(start == null)
						start = currentPoint;
					end = currentPoint;
				}
				else{
					if(start != null)
						nullPoint.add(currentPoint);
				}
			}
			for(Point p : nullPoint){
				if(p.column() > start.column() && p.column() < end.column())
					map.put(p, map.get(pointFactory.west(p)));
			}
		}
	}


	private void updateMapSize(Point p){
		int line = p.line();
		int column = p.column();

		//Pout chaque dimension  on regarde si elle a bouger avec le nouveau point
		maxLine = line > maxLine ? line : maxLine;
		minLine = line < minLine ? line : minLine;
		maxColumn = column > maxColumn ? column : maxColumn;
		minColumn = column < minColumn ? column : minColumn;
	}


	/**
	 * Récupérer un point libre aléatoirement
	 */
	private Point pointRand(){
		if(freePoints.size()>0){
			Random rand = new Random();
			int i = rand.nextInt(freePoints.size());
			Point res = freePoints.get(i);
			freePoints.remove(i);
			return res;
		}
		//On n'a pas de point libre on prend celui en dessous
		return pointFactory.getPoint(minLine, maxColumn+1);
	}


	private void unblockPoints(Point p){
		Direction d = Direction.Nord;
		do{
			Point tmpP = pointFactory.getPoint(
							p.line()+d.dLine(), 
							p.column()+d.dColumn()
						);
			if(map.get(tmpP) == null && !freePoints.contains(tmpP))
				freePoints.add(tmpP);

			d=d.next();
		}while(d!=Direction.Nord);
	}

	private int maxNumberPoints(){
		return (maxLine - minLine) * (maxColumn - minColumn);
	}


	public int getMinLine(){
		return minLine;
	}

	public int getMaxLine(){
		return maxLine;
	}

	public int getMinColumn(){
		return minColumn;
	}

	public int getMaxColumn(){
		return maxColumn;
	}

	/**
	 * Pour recupérer le Biome d'une coordonnée
	 */
	public IBiome getBiome(int line, int column){
		return map.get(pointFactory.getPoint(line, column));
	}

	@Override
	public String toString(){
		String res = "";
		for(int line = minLine; line <= maxLine; line++){
			for(int column = minColumn; column <= maxColumn; column++){
				IBiome biome = map.get(pointFactory.getPoint(line, column));
				if(biome!=null){
					res+=biome.toString();
				}
				// else if(pointsLibre.contains(fabriquePoint.lirePoint(ligne, colonne)))
				// 	res+=".";
				else
					res+=" ";
			}
			res+="\n";
		}
		return res;
	}
}