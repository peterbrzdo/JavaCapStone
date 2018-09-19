package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class Bullet extends Sprite {

	private final String shotImg = "src/images/bullet.png";
	private int posX;
	
	public Bullet(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
		this.posX = subject.getPosition();
		update();
	}

	public void update() {
		updatePosition();
		try {	
			//display.ellipse(posX, getY(),5,5);
			display.ellipse(getX(), getY(),5,5);
			display.redraw();
//			int x = (int) value;
//
//			//display.fill(0);
//			for (int i = 450; i > 50; i = i - 20)
//			{
//				display.ellipse(x+50,i,5,5);
//				display.redraw();
//			}
			
			System.out.println("Bullet Updated");
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

}
