package CapStone.model;

import java.util.ArrayList;
import java.util.List;

import CapStone.view.*;
import processing.core.PApplet;

public class Engine implements Subject, Commons {

	protected PApplet display;
	private static List<Sprite> sprites = new ArrayList<Sprite>();
	private Sprite ground;
	private Sprite spaceship;
	private ArrayList<Sprite> bullets = new ArrayList<>();
	private ArrayList<Sprite> bombs = new ArrayList<>();
	private ArrayList<Sprite> fleet = new ArrayList<>();
	private boolean ingame = false;

	public Engine(PApplet display) {
		this.display = display;
	}
	
	public void updateData() {
		notifyAllSprites();
	}
	
	@Override
	public void attach(Sprite sprite) {
		System.out.println("Sprite added: " + sprite.toString());
		sprites.add(sprite);	
	}
	
	@Override
	public void notifyAllSprites() {
		for (Sprite sprite : sprites) {
			System.out.println("Sprite notified: " + sprite.toString());
			sprite.update();
		}
	}

	public List<Sprite> getSprites() {
		return sprites;
	}

	public Sprite getGround() {
		return ground;
	}

	public void setGround(Sprite ground) {
		this.ground = ground;
	}

	public Sprite getSpaceship() {
		return spaceship;
	}

	public void setSpaceship(Sprite spaceship) {
		this.spaceship = spaceship;
	}

	public ArrayList<Sprite> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Sprite> bullets) {
		this.bullets = bullets;
	}

	public void addBullet(Sprite bullet) {
		this.bullets.add(bullet);
	}

	public ArrayList<Sprite> getBombs() {
		return bombs;
	}

	public void setBombs(ArrayList<Sprite> bombs) {
		this.bombs = bombs;
	}

	public void addBomb(Sprite bomb) {
		this.bombs.add(bomb);
	}

	public ArrayList<Sprite> getFleet() {
		return fleet;
	}

	public void setFleet(ArrayList<Sprite> fleet) {
		this.fleet = fleet;
	}

	public void addInvader(Sprite invader) {
		this.fleet.add(invader);
	}

	public void startGame() {
		ingame = true;
		setSpaceship(new SpaceShip(display, this, BOARD_PADDING, GROUND - PLAYER_HEIGHT - 20, 0, 0));

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				int x = BOARD_PADDING + (j * 60);
				int y = BOARD_PADDING + (i * 40);
				Sprite invader = new Invader(display, this, x, y, 2, 0);
				addInvader(invader);
			}
		}
	}

	public void endGame() {
		ingame = false;
	}

	public boolean isGameRunning() {
		return ingame;
	}

}
