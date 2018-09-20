package CapStone.controller;

import CapStone.model.Engine;
import CapStone.view.Sprite;

import java.util.List;

public class GamerController {

	Engine engine;
	
	public GamerController(Engine engine) {
		this.engine = engine;
	}
	
	public void handleEvent() {
		engine.updateData();
	}

	public void run() {
		engine.notifyAllSprites();
		this.collisionControl();
	}

	public void collisionControl() {
        List<Sprite> sprites = engine.getSprites();
    }
}
