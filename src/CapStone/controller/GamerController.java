package CapStone.controller;

import CapStone.model.Engine;

public class GamerController {

	Engine engine;
	
	public GamerController(Engine engine) {
		this.engine = engine;
	}
	
	public void handleEvent() {
		engine.updateData();
	}
}
