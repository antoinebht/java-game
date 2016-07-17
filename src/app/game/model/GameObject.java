package app.game.model;

abstract class GameObject{
	public abstract int line();
	public abstract int column();

	public void action(GameObject o){
		System.out.println("Rien ne se passe");
	}
}