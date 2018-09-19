package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class Bullet extends Sprite {

	public Bullet(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
        this.setImage(display.loadImage("src/images/shot.gif"));
		update();
	}

	public void update() {
		updatePosition();
		try {
			//display.ellipse(getX(), getY(),5,5);
            display.image(getImage(), getX(), getY());
			display.redraw();
			System.out.println("Bullet Updated");
		}
		catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

}
