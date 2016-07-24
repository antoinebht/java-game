package app.game.view_model.sprite;


public class SpritesFactory{


	public static Sprite playerUp(){
		if(playerUp == null){
			playerUp = new Sprite("res/img/sprite.png", 0, 8*64, 64, 64, 9);
		}
		return playerUp;
	}

	public static Sprite playerDown(){
		if(playerDown == null){
			playerDown = new Sprite("res/img/sprite.png", 0, 10*64, 64, 64, 9);
		}
		return playerDown;
	}

	public static Sprite playerLeft(){
		if(playerLeft == null){
			playerLeft = new Sprite("res/img/sprite.png", 0, 9*64, 64, 64, 9);
		}
		return playerLeft;
	}

	public static Sprite playerRight(){
		if(playerRight == null){
			playerRight = new Sprite("res/img/sprite.png", 0, 11*64, 64, 64, 9);
		}
		return playerRight;
	}

	protected static Sprite playerUp;
	protected static Sprite playerDown;
	protected static Sprite playerLeft;
	protected static Sprite playerRight;
}