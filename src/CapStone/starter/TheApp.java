package CapStone.starter;

import CapStone.controller.GamerController;
import CapStone.model.Engine;
import CapStone.view.SpaceShip;
import CapStone.view.Bullet;
import CapStone.view.Sprite;
import processing.core.PApplet;

public class TheApp extends PApplet 
{	
	private Sprite spaceship;
	private Sprite bullet;
	private GamerController gamerController;
	private Engine engine;

	@Override
	public void settings() {
		size(500, 500);
	}

	@Override
	public void setup() {  // setup() runs once
		frameRate(30);
										
		engine = new Engine();
		gamerController = new GamerController(engine);
								
		spaceship = new SpaceShip(this, engine);		
	}

	@Override
	public void draw() {
	}  // draw() loops forever, until stopped
	
	@Override
	public void mouseClicked() {		
	}
	
	@Override
	public void keyPressed() {
		if (keyCode == 'A') {
			gamerController.handleEvent(-10);
		}
		else if (keyCode == 'D') {			
		   	gamerController.handleEvent(10);
		}
		else if (keyCode == 'S') {
			bullet = new Bullet(this, engine);		
		   	gamerController.handleEvent(100);
		} 
		
	}	    
		  
}
