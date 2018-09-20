package CapStone.starter;

import CapStone.controller.GamerController;
import CapStone.model.Commons;
import CapStone.model.Engine;
import CapStone.view.Invader;
import CapStone.view.SpaceShip;
import CapStone.view.Bullet;
import CapStone.view.Sprite;
import processing.core.PApplet;

import java.util.ArrayList;

public class TheApp extends PApplet implements Commons
{	
	private Sprite spaceship;
	private ArrayList<Sprite> bullets = new ArrayList<>();
    private ArrayList<Sprite> bombs = new ArrayList<>();
    private ArrayList<Sprite> fleet = new ArrayList<>();
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
								
		spaceship = new SpaceShip(this, engine, BOARD_PADDING, BOARD_HEIGHT - BOARD_PADDING - PLAYER_HEIGHT, 0, 0);

		for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                int x = BOARD_PADDING + (j * 50);
                int y = BOARD_PADDING + (i * 40);
                Sprite invader = new Invader(this, engine, x, y, 0, 0);
                fleet.add(invader);
            }
        }
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
			Sprite bullet = new Bullet(this, engine, spaceship.getX() + 10, 440, 0, -5);
			bullets.add(bullet);
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
