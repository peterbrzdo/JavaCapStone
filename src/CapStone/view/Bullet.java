package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class Bullet extends Sprite {

	public Bullet(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
        this.setImage(display.loadImage("src/images/shot.gif"));        
		this.update();
	}

	public void update() {
		this.updatePosition();
		if(!this.isDestroyed() ) {
            try {                
                this.getDisplay().image(getImage(), getX(), getY());
                this.getDisplay().redraw();
            } catch (ClassCastException e) {
                System.out.println(e.getMessage());
            }
        }
	}

	@Override
    public void updatePosition() {
        this.setY(this.getY() + this.getSpeedY());
        if (this.getY() > BOARD_HEIGHT - BOARD_PADDING) {
            this.setY(BOARD_HEIGHT - BOARD_PADDING);
        }
        if (this.getY() < BOARD_PADDING) {
            this.destroy();
        }
    }
}
