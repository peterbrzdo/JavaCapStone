package CapStone.view;

import CapStone.model.Subject;
import processing.core.PApplet;

public abstract class Sprite {
	protected PApplet display;	
	
	public Sprite(PApplet display, Subject subject) {
		this.display = display;
		subject.attach(this);
	}
	
	public abstract void update(Object value);
}
