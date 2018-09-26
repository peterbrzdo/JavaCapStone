 package CapStone.view;

import CapStone.model.Commons;
import CapStone.model.Subject;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Sprite implements Commons {

    private PApplet display;

    private PImage image;
    private int startX;
    private int startY;
    private int x;
    private int y;
    private boolean destroyed;
    private int dx;
    private int dy;
    private Subject subject;
	
	public Sprite(PApplet display, Subject subject, int x, int y, int dx, int dy) {
		this.display = display;
		this.subject = subject;
		this.destroyed = false;
		this.x = x;
        this.y = y;
        this.startX = x;
        this.startY = y;
        this.dx = dx;
        this.dy = dy;
		subject.attach(this);
	}

    /**
     * Getter and Setter functions.
     */
    public PApplet getDisplay() {
        return display;
    }

    public void setDisplay(PApplet display) {
        this.display = display;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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

    public int getSpeedX() {
        return this.dx;
    }

    public int getSpeedY() {
        return this.dy;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public abstract void update();

    /**
     * Updates the position of a sprite based on its previous position and applying the speed.
     */
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

    /**
     * Destroys a sprite.
     * The sprite will not render anymore and is moved below the board.
     */
    public void destroy() {
	    this.setDestroyed(true);
	    this.setY(BOARD_HEIGHT + 10);
    }

    /**
     * Resurrects a destroyed sprite and resets its position to initial state.
     */
    public void resurrect() {
        this.setDestroyed(false);
	    this.setX(startX);
	    this.setY(startY);
    }

    public boolean isDestroyed() {
	    return destroyed;
    }

    /**
     * Changes the horizontal movement speed of a sprite.
     */
    public void changeSpeedX(int value) {
	    this.dx += value;
    }

    /**
     * Changes the vertical movement speed of a sprite.
     */
    public void changeSpeedY(int value) {
        this.dy += value;
    }

    /**
     * Reverses the horizontal movement speed of a sprite.
     */
    public void reverseSpeedX() {
        this.dx *= -1;
    }

    /**
     * Reverses the vertical movement speed of a sprite.
     */
    public void reverseSpeedY() {
        this.dy *= -1;
    }

    /**
     * Stops the horizontal movement speed of a sprite.
     */
    public void resetSpeedX() {
        this.dx = 0;
    }

    /**
     * Stops the vertical movement speed of a sprite.
     */
    public void resetSpeedY() {
        this.dy = 0;
    }
}
