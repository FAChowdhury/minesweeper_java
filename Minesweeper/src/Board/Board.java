package Board;
public interface Board {
    /**
     * @return the width of the board.
     */
    int getWidth();

    /**
     * @return the height of the board
     */
    int getHeight();
    
    /**
     * Reset the board. This hides all tiles and places new mines.
     */
    void reset();
    
    /**
     * Reveals the tile (x, y)
     * @param x
     * @param y
     * @return true if the tile does not contain the mine, otherwise return false.
     */
    Boolean revealTile(int x, int y);

    /**
     * Renders the board to terminal
     */
    void render();
}
