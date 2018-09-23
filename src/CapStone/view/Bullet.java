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
		if(!isDestroyed() ) {
            try {                
                display.image(getImage(), getX(), getY());
                display.redraw();                
            } catch (ClassCastException e) {
                System.out.println(e.getMessage());
            }
        }
	}

	@Override
    public void updatePosition() {
        this.y += this.dy;
        if (this.y > BOARD_HEIGHT - BOARD_PADDING) {
            this.y = BOARD_HEIGHT - BOARD_PADDING;
        }
        if (this.y < BOARD_PADDING) {
            this.destroy();
        }
    }

}
