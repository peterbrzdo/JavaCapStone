package CapStone.view;

import CapStone.model.Commons;
import CapStone.model.Subject;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Sprite implements Commons {
	protected PApplet display;

    private PImage image;
	protected int x;
	protected int y;
	protected boolean destroyed;
	protected int dx;
	protected int dy;
	protected Subject subject;
	
	public Sprite(PApplet display, Subject subject, int x, int y, int dx, int dy) {
		this.display = display;
		this.subject = subject;
		this.destroyed = false;
		this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
		subject.attach(this);
	}
	
	public abstract void update();

	public void updatePosition() {
	    this.x += this.dx;
	    if (this.x > BOARD_WIDTH - BOARD_PADDING) {
	        this.x = BOARD_WIDTH - BOARD_PADDING;
        }
        if (this.x < BOARD_PADDING) {
            this.x = BOARD_PADDING;
        }
	    this.y += this.dy;
        if (this.y > BOARD_HEIGHT - BOARD_PADDING) {
            this.y = BOARD_HEIGHT - BOARD_PADDING;
        }
        if (this.y < BOARD_PADDING) {
            this.y = BOARD_PADDING;
        }
    }

	public void destroy() {
	    destroyed = true;
    }

    public boolean isDestroyed() {
	    return destroyed;
    }

    public void setImage(PImage image) {

        this.image = image;
    }

    public PImage getImage() {

        return image;
    }

    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getY() {

        return y;
    }

    public int getX() {

        return x;
    }

    public void changeSpeedX(int value) {
	    this.dx += value;
    }

    public void changeSpeedY(int value) {
        this.dy += value;
    }

    public void resetSpeedX() {
        this.dx = 0;
    }

    public void resetSpeedY() {
        this.dy = 0;
    }
}
