package Board;

import java.util.Random;

public class BasicBoard implements Board {
    private int width;
    private int height;
    private int numMines;
    private Grid grid;

    public BasicBoard(int width, int height, int numMines) {
        this.width = width;
        this.height = height;
        this.numMines = numMines;
        this.grid = new Grid(width, height);
        this.resetBoard();
    }

    @Override
    public int getWidth() {
       return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void resetBoard() {
        // use width, height and numMines to set grid.
        placeMines();
        fillGrid();
    }

    @Override
    public Boolean revealTile(int x, int y) {
        // add visibility of grid here when we get to that
        return grid.containsNegativeBool(x, y);
    }

    @Override
    public void render() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (grid.containsNegativeBool(x, y)) {
                    System.out.print("* ");
                } else {
                    System.out.print(grid.getTileValue(x, y) + " ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public int getNumMines() {
        return numMines;
    }

    /**
     * Place mines (denoted by the int -1) on the grid at random
     */
    private void placeMines() {
        Random rand = new Random();
        int bound = width * height;
        for (int i = 0; i < numMines; ++i) {
            int randomInt = rand.nextInt(bound);
            while (grid.getTileValue(randomInt) == -1) {
                randomInt = rand.nextInt(bound);
            }
            grid.setTileValue(randomInt, -1);
        }
    }

    private void fillGrid() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (grid.containsNegativeBool(x, y)) {
                    continue;
                }
                int value = grid.containsNegativeInt(x - 1, y - 1)
                + grid.containsNegativeInt(x - 1, y)
                + grid.containsNegativeInt(x - 1, y + 1)
                + grid.containsNegativeInt(x, y - 1)
                + grid.containsNegativeInt(x, y + 1)
                + grid.containsNegativeInt(x + 1, y - 1)
                + grid.containsNegativeInt(x + 1, y)
                + grid.containsNegativeInt(x + 1, y + 1);
                grid.setTileValue(x, y, value);
            }
        }
    }

}
