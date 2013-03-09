/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author macbook
 */
public class Settings {
    private static final int GAME_WIDTH = 780;
    private static final int GAME_HEIGHT = 600;
    private static final int BLOCK_SPEED = 1;
    private static final int BLOCK_SIZE = 40;

    /**
     * @return the GAME_WIDTH
     */
    public static int getGAME_WIDTH() {
        return GAME_WIDTH;
    }

    /**
     * @return the GAME_HEIGHT
     */
    public static int getGAME_HEIGHT() {
        return GAME_HEIGHT;
    }

    /**
     * @return the BLOCK_SPEED
     */
    public static int getBLOCK_SPEED() {
        return BLOCK_SPEED;
    }

    /**
     * @return the BLOCK_SIZE
     */
    public static int getBLOCK_SIZE() {
        return BLOCK_SIZE;
    }
}
