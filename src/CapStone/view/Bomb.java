package CapStone.view;

import CapStone.model.Engine;
import processing.core.PApplet;

public class Bomb extends Sprite {

	public Bomb(PApplet display, Engine subject, int x, int y, int dx, int dy) {
		super(display, subject, x, y, dx, dy);
        this.setImage(display.loadImage("src/images/bomb.gif"));
        this.destroy();
		this.update();
	}

	public void update() {
	    if (!this.isDestroyed()) {
            updatePosition();
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
        if (this.getY() > BOMB_GROUND) {
            this.destroy();
        }
        if (this.getY() < BOARD_PADDING) {
            this.setY(BOARD_PADDING);
            this.destroy();
        }
    }

    @Override
    public void resurrect() {
        this.setDestroyed(false);
    }
}
