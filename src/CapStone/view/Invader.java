package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class Invader extends Sprite {

	private Bomb bomb;

	public Invader(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
		this.setImage(display.loadImage("src/images/alien.gif"));
		this.bomb = new Bomb(display, subject, 0, 0, 0, 3);
		this.update();
	}

	public void update() {
		this.updatePosition();
		if (!this.isDestroyed()) {
			try {
				this.getDisplay().image(getImage(), getX(), getY());
				this.getDisplay().redraw();
			} catch (ClassCastException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Bomb getBomb() {
		return bomb;
	}
}
