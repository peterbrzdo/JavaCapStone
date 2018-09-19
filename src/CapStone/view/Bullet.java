package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class Bullet extends Sprite {

	private final String shotImg = "src/images/bullet.png";
	
	public Bullet(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
		update();
	}

	public void update() {
		updatePosition();
		try {
			display.ellipse(getX(), getY(),5,5);
			display.redraw();
			System.out.println("Bullet Updated");
		}
		catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

}
