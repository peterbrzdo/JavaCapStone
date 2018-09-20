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

		engine = new Engine();
		gamerController = new GamerController(engine);

		engine.setGround(new Ground(this, engine, 0, 0, 0, 0));
		engine.setSpaceship(new SpaceShip(this, engine, BOARD_PADDING, GROUND - PLAYER_HEIGHT - 20, 0, 0));

		for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                int x = BOARD_PADDING + (j * 60);
                int y = BOARD_PADDING + (i * 40);
                Sprite invader = new Invader(this, engine, x, y, 2, 0);
                engine.addInvader(invader);
            }
        }
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
		if (keyCode == 'A') {
			engine.getSpaceship().changeSpeedX(-10);
			gamerController.handleEvent();
		} else if (keyCode == 'D') {
            engine.getSpaceship().changeSpeedX(10);
			gamerController.handleEvent();
		} else if (keyCode == 'S') {
			Sprite bullet = new Bullet(this, engine, engine.getSpaceship().getX() + 10, engine.getSpaceship().getY() - 10, 0, -5);
			engine.addBullet(bullet);
			gamerController.handleEvent();
		}
	}

	@Override
	public void keyReleased() {
		if (keyCode == 'A') {
            engine.getSpaceship().resetSpeedX();
			gamerController.handleEvent();
		}
		else if (keyCode == 'D') {
            engine.getSpaceship().resetSpeedX();
			gamerController.handleEvent();
		}
	}
}
