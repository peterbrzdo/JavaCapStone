package CapStone.starter;

import CapStone.controller.GamerController;
import CapStone.model.Commons;
import CapStone.model.Engine;
import CapStone.view.*;
import processing.core.PApplet;

import java.util.ArrayList;

public class TheApp extends PApplet implements Commons
{
	private GamerController gamerController;
	private Engine engine;

	@Override
	public void settings() {
	    size(BOARD_WIDTH, BOARD_HEIGHT);
	}

	@Override
	public void setup() {  // setup() runs once
		frameRate(30);

		engine = new Engine(this);
		gamerController = new GamerController( this, engine);

		engine.setGround(new Ground(this, engine, 0, 0, 0, 0));
		engine.setLogo(new Logo(this, engine, 0, 0, 0, 0));
	}

	@Override
	public void draw() { // draw() loops forever, until stopped
        gamerController.run();
	}
	
	@Override
	public void mouseClicked() {		
	}
	
	@Override
	public void keyPressed() {
	    if (!engine.isGameRunning()) {
	        engine.startGame();
            gamerController.handleEvent();
        }
		if (keyCode == 'A') {
			engine.getSpaceship().changeSpeedX(-10);
		} else if (keyCode == 'D') {
            engine.getSpaceship().changeSpeedX(10);
		} else if (keyCode == 'S') {
			Sprite bullet = new Bullet(this, engine, engine.getSpaceship().getX() + 10, engine.getSpaceship().getY() - 10, 0, -5);
			engine.addBullet(bullet);
		}
	}

	@Override
	public void keyReleased() {
		if (keyCode == 'A') {
            engine.getSpaceship().resetSpeedX();
		}
		else if (keyCode == 'D') {
            engine.getSpaceship().resetSpeedX();
		}
	}
}
