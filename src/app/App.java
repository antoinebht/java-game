package app;

import java.util.Stack;
import java.lang.Thread;

import app.view.Window;
import app.main_menu.MainMenu;
import app.game.Game;

public class App{

	public App(){
		System.out.println("Hello World in Mind");
		mainMenu();
		run();
	}

	public void run(){
		int fps = 0;
		long lastTime = System.currentTimeMillis();

		while(running){
			
			states.peek().display();

			fps++;
			//Display info fps in term
			if(System.currentTimeMillis() - lastTime >= 1000){
				System.out.println("FPS:"+fps);
				lastTime = System.currentTimeMillis();
				fps = 0;
			}

			try{
				Thread.sleep(1000/30); // 1s / 60FPS
			}
			catch(InterruptedException e){
				System.err.println("Err pausing FPS");
			}
		}
	}


	public void mainMenu(){
		states.push(new MainMenu(this, window));
	}

	public void playGame(){
		states.push(new Game(this, window));
	}


	final private Window window = new Window(800,600, "Mind");
	final private Stack<State> states = new Stack<State>();
	final private boolean running = true;
}