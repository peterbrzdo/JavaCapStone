package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;
import processing.core.PImage;

public class Logo extends Sprite {

	public Logo(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
		this.setImage(display.loadImage("src/images/logo.png"));
        update();
	}

	public void update() {
		if(!isDestroyed()) {
			try {
				PImage logo = getImage();
				logo.resize(BOARD_WIDTH, 0);
				display.image(logo, 0, 0);
				display.redraw();
			} catch (ClassCastException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
