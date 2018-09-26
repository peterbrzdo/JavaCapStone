package CapStone.controller;

import CapStone.model.Commons;
import CapStone.model.Engine;
import CapStone.view.Bomb;
import CapStone.view.Invader;
import CapStone.view.Sprite;
import processing.core.PApplet;
import processing.core.PConstants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
        List<Invader> fleet = engine.getFleet();
        if (!fleet.isEmpty()) {
            Sprite invaderCaptain = fleet.get(0);
            //System.out.println("IC: " + invaderCaptain.getX() + " + " + invaderCaptain.getSpeedX());
            if ((invaderCaptain.getSpeedX() > 0 && invaderCaptain.getX() >= (BOARD_WIDTH - BOARD_PADDING - FLEET_WIDTH))
                    || (invaderCaptain.getSpeedX() < 0 && invaderCaptain.getX() <= (BOARD_PADDING))) {
                for (Invader invader : fleet) {
                    invader.reverseSpeedX();
                    invader.setY(invader.getY() + INVASION_SPEED);
                }
            }
            int invaderCount = 0;
            int bombCount = 0;
           
            for (Invader invader : fleet) 
            {  
            	Bomb bomb = invader.getBomb();
                if (!bomb.isDestroyed()) 
                {
                	bombCount++;            			               
                }
            }
            
            Random generator = new Random();
           
            boolean last_row;
            for (Invader invader : fleet) {
            	last_row = true;     	            	
            	Bomb bomb = invader.getBomb();
            	for (Invader invader_under : fleet){
            		     
            		if (invader_under.getY() > invader.getY() && invader_under.getX() == invader.getX() && !invader_under.isDestroyed())
            			last_row = false;}
            	
            	if (!invader.isDestroyed()) 
            	{
            		invaderCount++;
                    int shot = generator.nextInt(BOMB_CHANCE + 1);
                    if (!invader.isDestroyed() && bomb.isDestroyed() && bombCount < BOMB_COUNT && shot == BOMB_CHANCE && last_row == true) 
                    {
                    	bomb.setX(invader.getX() + (INVADER_WIDTH / 2));
                        bomb.setY(invader.getY() + INVADER_HEIGHT);
                        bomb.resurrect();
                    }
                }            		               
            }
            
            if (invaderCount == 0) {
                this.endGame(1);
            } else {
                display.textAlign(PConstants.RIGHT);
                display.textSize(13);
                display.fill(Color.BLUE.getRGB());
                display.text("Score: " + (INVADERS - invaderCount), BOARD_WIDTH - BOARD_PADDING, GROUND + 20);
                display.fill(Color.WHITE.getRGB());
            }
        }
    }

	public void collisionControl() {
	    // Load sprite lists
        List<Sprite> bullets = engine.getBullets();
        List<Invader> fleet = engine.getFleet();
        Sprite spaceship = engine.getSpaceship();

        // Check bullets
        if (!bullets.isEmpty() && !fleet.isEmpty()) {
            for (Sprite bullet : bullets) {
                int bX = bullet.getX();
                int bY = bullet.getY();
                for (Invader invader : fleet) {
                    int iX = invader.getX();
                    int iY = invader.getY();
                    Bomb bomb = invader.getBomb();
                    int oX = bomb.getX();
                    int oY = bomb.getY();

                    if (
                            !invader.isDestroyed()
                                    && !bullet.isDestroyed()
                                    && bX + BULLET_WIDTH >= iX
                                    && bX <= iX + INVADER_WIDTH
                                    && bY >= iY
                                    && bY <= iY + INVADER_HEIGHT
                    ) {
                        invader.destroy();
                        bullet.destroy();
                    }
                    else if (
                            !bomb.isDestroyed()
                            && oX + BOMB_WIDTH >= bX
                            && oX <= bX + BULLET_WIDTH
                            && oY + BOMB_HEIGHT >= bY
                            && oY <= bY + BULLET_HEIGHT
                    ) {
                        bomb.destroy();
                        bullet.destroy();
                    }
                }
            }

            for (Invader invader : fleet) {
                if (!invader.isDestroyed() && invader.getY() + INVADER_HEIGHT >= engine.getSpaceship().getY()) {
                    this.endGame(2);
                }
            }
        }

        // Check bombs
        if (!fleet.isEmpty()) {
            int sX = spaceship.getX();
            int sY = spaceship.getY();
            for (Invader invader : fleet) {
                Bomb bomb = invader.getBomb();
                int oX = bomb.getX();
                int oY = bomb.getY();

                if (
                        !bomb.isDestroyed()
                        && oX + BOMB_WIDTH >= sX
                        && oX <= sX + PLAYER_WIDTH
                        && oY + BOMB_HEIGHT >= sY
                        && oY <= sY + PLAYER_HEIGHT
                ) {
                    bomb.destroy();
                    engine.setLives((engine.getLives() - 1));
                    if (engine.getLives() <= 0) {
                        this.endGame(3);
                    }
                }
            }
        }
    }

    public void endGame(int status) {
        engine.endGame();
        engine.getGround().update();
        ArrayList<Invader> fleet = engine.getFleet();
        for (Invader invader : fleet) {
            Bomb bomb = invader.getBomb();
            bomb.destroy();
            bomb.update();
            invader.destroy();
            invader.update();
        }
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
        else if (status == 3) {
            // Invasion.
            display.textAlign(PConstants.CENTER);
            display.textSize(24);
            display.text("Spaceship destroyed. You lose!", (int) (BOARD_WIDTH / 2), (int) (BOARD_HEIGHT / 2));
        }
        engine.getLogo().resurrect();
        engine.getLogo().update();
        display.textSize(18);
        display.fill(Color.RED.getRGB());
        display.text("Press any key to start game", (int) (BOARD_WIDTH / 2), (int) (BOARD_HEIGHT / 2 + BOARD_PADDING));
        display.fill(Color.WHITE.getRGB());
    }
}
