package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class Bomb extends Sprite {

	public Bomb(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
        this.setImage(display.loadImage("src/images/shot.gif"));
        this.destroyed = true;
		update();
	}

	public void update() {
	    if (!isDestroyed()) {
            updatePosition();
            try {
                display.ellipse(this.x, this.y, 5, 5);
                //display.image(getImage(), getX(), getY());
                display.redraw();
                //System.out.println("Bomb Updated");
                //System.out.println("Bomb Updated: Speed "+dx+","+dy+" Position "+x+","+y);
            } catch (ClassCastException e) {
                System.out.println(e.getMessage());
            }
        }
	}

	@Override
    public void updatePosition() {
        this.y += this.dy;
        if (this.y > BOARD_HEIGHT - BOARD_PADDING) {
            this.destroy();
        }
        if (this.y < BOARD_PADDING) {
            this.y = BOARD_PADDING;
        }
    }

    @Override
    public void resurrect() {
        destroyed = false;
    }

}
