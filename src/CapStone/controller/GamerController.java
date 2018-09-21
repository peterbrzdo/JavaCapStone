package CapStone.controller;

import CapStone.model.Commons;
import CapStone.model.Engine;
import CapStone.view.Sprite;
import processing.core.PApplet;
import processing.core.PConstants;

import java.util.List;

public class GamerController implements Commons {

	Engine engine;
    protected PApplet display;
	
	public GamerController(PApplet display, Engine engine) {
		this.engine = engine;
		this.display = display;
	}
	
	public void handleEvent() {
		//engine.updateData();
	}

	public void run() {
	    if (!engine.isGameRunning()) {
	        display.textAlign(PConstants.CENTER);
	        display.textSize(18);
            display.text("Press any key to start game", (int) (BOARD_WIDTH / 2), (int) (BOARD_HEIGHT / 2 + BOARD_PADDING));
        }
        else {
            engine.notifyAllSprites();
            this.fleetControl();
            this.collisionControl();
        }
	}

	public void fleetControl() {
        List<Sprite> fleet = engine.getFleet();
        if (!fleet.isEmpty()) {
            Sprite invaderCaptain = fleet.get(0);
            if ((invaderCaptain.getSpeedX() > 0 && invaderCaptain.getX() >= (BOARD_WIDTH - BOARD_PADDING - FLEET_WIDTH))
                    || (invaderCaptain.getSpeedX() < 0 && invaderCaptain.getX() <= (BOARD_PADDING))) {
                for (Sprite invader : fleet) {
                    invader.reverseSpeedX();
                    invader.setY(invader.getY() + INVADE_SPEED);
                }
            }
            int invaderCount = 0;
            for (Sprite invader : fleet) {
                if (!invader.isDestroyed()) {
                    invaderCount++;
                }
            }
            if (invaderCount == 0) {
                this.endGame(1);
            } else {
                display.textAlign(PConstants.RIGHT);
                display.textSize(13);
                display.text("Invaders left: " + invaderCount, BOARD_WIDTH - BOARD_PADDING, GROUND + 20);
            }
        }
    }

	public void collisionControl() {
	    // Load sprite lists
        List<Sprite> bullets = engine.getBullets();
        List<Sprite> fleet = engine.getFleet();

        // Check bullets
        if (!bullets.isEmpty() && !fleet.isEmpty()) {
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

            for (Sprite invader : fleet) {
                if (!invader.isDestroyed() && invader.getY() + ALIEN_HEIGHT >= engine.getSpaceship().getY()) {
                    this.endGame(2);
                }
            }
        }
    }

    public void endGame(int status) {
        engine.endGame();
        engine.getLogo().resurrect();
        engine.getLogo().update();
	    if (status == 1) {
	        // Invaders destroyed.
            display.textAlign(PConstants.CENTER);
            display.textSize(24);
            display.text("All invaders destroyed. You win!", (int) (BOARD_WIDTH / 2), (int) (BOARD_HEIGHT / 2));
        }
        else if (status == 2) {
            // Invasion.
            display.textAlign(PConstants.CENTER);
            display.textSize(24);
            display.text("Invasion. You lose!", (int) (BOARD_WIDTH / 2), (int) (BOARD_HEIGHT / 2));
        }
        display.textSize(18);
        display.text("Press any key to start game", (int) (BOARD_WIDTH / 2), (int) (BOARD_HEIGHT / 2 + BOARD_PADDING));
    }
}
