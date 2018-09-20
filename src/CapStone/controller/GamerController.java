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
		this.fleetControl();
		this.collisionControl();
	}

	public void fleetControl() {
        List<Sprite> fleet = engine.getFleet();
        Sprite invaderCaptain = fleet.get(0);
        if ((invaderCaptain.getSpeedX() > 0 && invaderCaptain.getX() >= (BOARD_WIDTH - BOARD_PADDING - FLEET_WIDTH))
        || (invaderCaptain.getSpeedX() < 0 && invaderCaptain.getX() <= (BOARD_PADDING))) {
            for (Sprite invader : fleet) {
                invader.reverseSpeedX();
            }
        }
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
