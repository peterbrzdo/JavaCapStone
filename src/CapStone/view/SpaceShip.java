package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class SpaceShip extends Sprite {


	public SpaceShip(PApplet display, Engine subject) {
		super(display, subject);
		update(0);		
	}

	public void update(Object value) {
		try {
			int x = (int) value;
			
			display.background(204);
			display.fill(0);
			display.rect(x, 450, 100, 20);
			display.redraw();
			System.out.println("Gamer Updated");
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

}
