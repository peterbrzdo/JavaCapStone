package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;
import java.awt.Color;

public class Ground extends Sprite {

	public Ground(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
		this.setImage(display.loadImage("src/images/back.gif"));
        update();
	}

	public void update() {
		try {
			display.image(getImage(), getX(), getY());
			//display.redraw();
			//display.background(0);
			display.stroke(Color.GREEN.getRGB());
			display.line(0, GROUND, BOARD_WIDTH,GROUND);
            display.redraw();
		}
		catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

}
