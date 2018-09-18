package CapStone.model;

import CapStone.view.Sprite;

public interface Subject {
	void attach(Sprite observer);
	void notifyAllSprites();
}
