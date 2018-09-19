package CapStone.model;

import java.util.ArrayList;
import java.util.List;

import CapStone.model.Subject;
import CapStone.view.Sprite;

public class Engine implements Subject {

	private int position = 10;
	private static List<Sprite> sprites = new ArrayList<Sprite>();

	public int getCount() {
		return position;
	}
	
	public void updateData() {
		notifyAllSprites();
	}
	
	@Override
	public void attach(Sprite sprite) {
		System.out.println("Sprite added: " + sprite.toString());
		sprites.add(sprite);	
	}
	
	@Override
	public void notifyAllSprites() {
		for (Sprite sprite : sprites) {
			System.out.println("Sprite notified: " + sprite.toString());
			sprite.update();
		}
	}

	public int getPosition() {
		return position;
	}
}
