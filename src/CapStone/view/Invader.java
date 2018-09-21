package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class Invader extends Sprite {

	private Bomb bomb;

	public Invader(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
		this.setImage(display.loadImage("src/images/alien.gif"));
		update();
	}

	public void update() {
		updatePosition();
		if (!isDestroyed()) {
			try {
				display.image(getImage(), getX(), getY());
				display.redraw();
				//System.out.println("Invader Updated.");
			} catch (ClassCastException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Bomb getBomb() {
		return bomb;
	}

}
