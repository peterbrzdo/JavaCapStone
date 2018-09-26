package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;
import java.awt.Color;

public class Ground extends Sprite {

	public Ground(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
		this.setImage(display.loadImage("src/images/back.gif"));
        this.update();
	}

	public void update() {
		try {
			this.getDisplay().image(getImage(), getX(), getY());
			this.getDisplay().stroke(Color.GREEN.getRGB());
			this.getDisplay().line(0, GROUND, BOARD_WIDTH,GROUND);
			this.getDisplay().redraw();
		}
		catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

}
