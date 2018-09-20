package CapStone.controller;

import CapStone.model.Commons;
import CapStone.model.Engine;
import CapStone.view.Sprite;

import java.util.List;

public class GamerController implements Commons {

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
	    // Load sprite lists
        List<Sprite> bullets = engine.getBullets();
        List<Sprite> fleet = engine.getFleet();

        // Check bullets
        for (Sprite bullet : bullets) {
            int bX = bullet.getX();
            int bY = bullet.getY();
            for (Sprite invader : fleet) {
                int iX = invader.getX();
                int iY = invader.getY();

                if (
                        !invader.isDestroyed()
                        && !bullet.isDestroyed()
                        && bX + BULLET_WIDTH >= iX
                        && bX <= iX + ALIEN_WIDTH
                        && bY >= iY
                        && bY <= iY + ALIEN_HEIGHT
                ) {
                    invader.destroy();
                    bullet.destroy();
                }
            }
        }
    }
}
