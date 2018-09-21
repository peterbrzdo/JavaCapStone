package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class SpaceShip extends Sprite {


	public SpaceShip(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, 0, 0);
		this.setImage(display.loadImage("src/images/ship.gif"));
		update();
	}

	public void update() {
		this.updatePosition();
		try {
			display.image(getImage(), getX(), getY());
			display.redraw();
			System.out.println("Spaceship Updated: Speed "+dx+","+dy+" Position "+x+","+y);
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updatePosition() {
		this.x += this.dx;
		if (this.x > BOARD_WIDTH - BOARD_PADDING - PLAYER_WIDTH) {
			this.x = BOARD_WIDTH - BOARD_PADDING - PLAYER_WIDTH;
		}
		if (this.x < BOARD_PADDING) {
			this.x = BOARD_PADDING;
		}
	}

}
