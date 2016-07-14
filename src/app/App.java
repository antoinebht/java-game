package app;

import java.util.Stack;

import app.main_menu.MainMenu;
import app.game.Game;


public class App{

	public App(){
		System.out.println("Hello World in Mind");
		mainMenu();
	}

	public void mainMenu(){
		states.push(new MainMenu());
		states.peek().display();
	}

	public void playGame(){
		states.push(new Game());
		states.peek().display();
	}


	final private Stack<State> states = new Stack<State>();
}