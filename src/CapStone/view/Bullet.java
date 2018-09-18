package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class Bullet extends Sprite{
	
	public Bullet(PApplet display, Engine subject) {
		super(display, subject);
		update(0);		
	}

	public void update(Object value) {
		try {	
			
			int x = (int) value;
			
			
			//display.fill(0);
			for (int i = 450; i > 50; i = i - 20)
			{				
				display.ellipse(x+50,i,5,5);
				display.redraw();				
			}
			
			System.out.println("Bullet Updated");
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}

}
