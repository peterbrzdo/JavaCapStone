package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;
import processing.core.PImage;

public class SpaceShip extends Sprite {


	public SpaceShip(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, 0, 0);
		this.setImage(display.loadImage("src/images/ship.gif"));
		update();
	}

	public void update() {
		updatePosition();
		try {
			display.background(204);
			display.image(getImage(), getX(), getY());
			display.redraw();
			System.out.println("Gamer Updated");
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

}
