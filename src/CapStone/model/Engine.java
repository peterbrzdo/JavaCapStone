package CapStone.model;

import java.util.ArrayList;
import java.util.List;

import CapStone.view.Bomb;
import CapStone.view.Bullet;
import CapStone.view.Invader;
import CapStone.view.Sprite;

public class Engine implements Subject {

	private static List<Sprite> sprites = new ArrayList<Sprite>();
	private Sprite ground;
	private Sprite spaceship;
	private ArrayList<Sprite> bullets = new ArrayList<>();
	private ArrayList<Sprite> bombs = new ArrayList<>();
	private ArrayList<Sprite> fleet = new ArrayList<>();
	
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
}
