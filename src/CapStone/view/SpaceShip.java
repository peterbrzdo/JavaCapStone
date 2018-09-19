package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class SpaceShip extends Sprite {


	public SpaceShip(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, 0, 0);
		update();
	}

	public void update() {
		updatePosition();
		try {
			display.background(204);
			display.fill(0);
			display.rect(getX(), getY(), 100, 20);
			display.redraw();
			System.out.println("Gamer Updated");
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

}
