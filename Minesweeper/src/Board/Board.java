package Board;
public interface Board {
    /**
     * @return the number of columns of the board.
     */
    int getNumCol();

    /**
     * @return the number of rows of the board
     */
    int getNumRow();

    /**
     * 
     * @return the total number of mines on the board.
     */
    int getNumMines();
    
    /**
     * Reset the board. This hides all tiles and places new mines.
     */
    void resetBoard();
    
    /**
     * Reveals the tile (row, col)
     * @param row
     * @param col
     * @return true if the tile does not contain the mine, otherwise return false.
     */
    Boolean revealTile(int row, int col);

    /**
     * Flag the tile (row, col). Flagging a tile ensures that you cannot reveal it.
     * @param row
     * @param col
     */
    void flagTile(int row, int col);

    /**
     * Unflag the tile (row, col).
     * @param row
     * @param col
     */
    void unflagTile(int row, int col);

    /**
     * Renders the board to terminal
     */
    void render();

    /**
     * Renders the entire board as if all the tiles are visible.
     */
    void renderBoardAsVisible();
}
