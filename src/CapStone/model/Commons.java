package CapStone.model;

public interface Commons {
    public static final int BOARD_WIDTH = 640;      // Width of the game board.
    public static final int BOARD_HEIGHT = 480;     // Height of the game board.
    public static final int BOARD_PADDING = 30;     // Inner padding of the game board.
    public static final int GROUND = 390;           // Position of the ground.
    public static final int BOMB_GROUND = 390;      // Threshold for the bombs' impact, may vary from GROUND for visual reasons.
    public static final int FLEET_WIDTH = 360;      // Total width of the invaders' fleet.
    public static final int INVADERS = 24;          // Total count of invaders.
    public static final int INVADER_HEIGHT = 29;    // Height of a single invader.
    public static final int INVADER_WIDTH = 43;     // Width of a single invader.
    public static final int INVASION_SPEED = 15;    // Speed of the down movement when edge of game board is reached by fleet.
    public static final int BOMB_CHANCE = 99;       // Chance for an invader to drop a bomb, 1 in X.
    public static final int BOMB_COUNT = 6;         // Maximum number of bombs visible at a time.
    public static final int BOMB_HEIGHT = 5;        // Height of a bomb.
    public static final int BOMB_WIDTH = 5;         // Width of a bomb.
    public static final int PLAYER_WIDTH = 33;      // Width of the spaceship.
    public static final int PLAYER_HEIGHT = 23;     // Height of the spaceship.
    public static final int PLAYER_LIVES = 3;       // Initial number of lives for the player.
    public static final int BULLET_HEIGHT = 23;     // Height of a bullet.
    public static final int BULLET_WIDTH = 12;      // Width of a bullet.
    public static final int BULLET_COUNT = 3;       // Maximum number of bullets visible at a time.
}
