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
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (grid.containsNegativeBool(i, j)) {
                    System.out.print("* ");
                } else {
                    System.out.print(grid.get(i, j) + " ");
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
            while (grid.get(randomInt) == -1) {
                randomInt = rand.nextInt(bound);
            }
            grid.set(randomInt, -1);
        }
    }

    private void fillGrid() {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (grid.containsNegativeBool(i, j)) {
                    continue;
                }
                int value = grid.containsNegativeInt(i - 1, j - 1)
                + grid.containsNegativeInt(i - 1, j)
                + grid.containsNegativeInt(i - 1, j + 1)
                + grid.containsNegativeInt(i, j - 1)
                + grid.containsNegativeInt(i, j + 1)
                + grid.containsNegativeInt(i + 1, j - 1)
                + grid.containsNegativeInt(i + 1, j)
                + grid.containsNegativeInt(i + 1, j + 1);
                grid.set(i, j, value);
            }
        }
    }

}
