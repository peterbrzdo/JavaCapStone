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
								
		spaceship = new SpaceShip(this, engine, 10, 450, 0, 0);
	}

	@Override
	public void draw() {
		engine.notifyAllSprites();
	}  // draw() loops forever, until stopped
	
	@Override
	public void mouseClicked() {		
	}
	
	@Override
	public void keyPressed() {
		if (keyCode == 'A') {
			spaceship.changeSpeedX(-10);
			gamerController.handleEvent();
		} else if (keyCode == 'D') {
			spaceship.changeSpeedX(10);
			gamerController.handleEvent();
		} else if (keyCode == 'S') {
			bullet = new Bullet(this, engine, spaceship.getX(), 450, 0, -5);
			gamerController.handleEvent();
		}

	}

	@Override
	public void keyReleased() {
		if (keyCode == 'A') {
			spaceship.changeSpeedX(10);
			gamerController.handleEvent();
		}
		else if (keyCode == 'D') {
			spaceship.changeSpeedX(-10);
			gamerController.handleEvent();
		}

	}

}
