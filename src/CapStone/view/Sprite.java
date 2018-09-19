package CapStone.view;

import CapStone.model.Subject;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Sprite {
	protected PApplet display;

    private PImage image;
	protected int x;
	protected int y;
	protected boolean destroyed;
	protected int dx;
	protected int dy;
	
	public Sprite(PApplet display, Subject subject, int x, int y, int dx, int dy) {
		this.display = display;
		this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
		subject.attach(this);
	}
	
	public abstract void update();

	public void updatePosition() {
	    this.x += this.dx;
	    this.y += this.dy;
    }

	public void destroy() {
	    destroyed = true;
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
}
