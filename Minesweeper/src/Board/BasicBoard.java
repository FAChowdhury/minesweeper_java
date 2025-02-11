package Board;

import java.util.Random;

public class BasicBoard implements Board {
    private int numCol;
    private int numRow;
    private int numMines;
    private int numVisible;
    private Grid grid;

    public BasicBoard(int numCol, int numRow, int numMines) {
        this.numCol = numCol;
        this.numRow = numRow;
        this.numMines = numMines;
        this.numVisible = 0;
        this.grid = new Grid(numCol, numRow);
        this.resetBoard();
    }

    @Override
    public int getNumCol() {
       return numCol;
    }

    @Override
    public int getNumRow() {
        return numRow;
    }

    @Override
    public void resetBoard() {
        placeMines();
        fillGrid();
    }

    @Override
    public Boolean revealTile(int row, int col) {
        grid.revealTile(row, col, this);
        return !grid.containsNegativeBool(row, col);
    }

    @Override
    public void render() {
        for (int i = 0; i < getNumRow(); ++i) {
            for (int j = 0; j < getNumCol(); ++j) {
                if (grid.isTileVisible(i, j)) {
                    if (grid.containsNegativeBool(i, j)) {
                        System.out.print("* ");
                    } else {
                        System.out.print(grid.getTileValue(i, j) + " ");
                    }
                } else if (grid.isTileFlagged(i, j)) {
                    System.out.print("□ ");
                } else {
                    System.out.print("# ");
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
        int bound = numCol * numRow;
        for (int i = 0; i < numMines; ++i) {
            int randomInt = rand.nextInt(bound);
            while (grid.getTileValue(randomInt) == -1) {
                randomInt = rand.nextInt(bound);
            }
            grid.setTileValue(randomInt, -1);
        }
    }

    private void fillGrid() {
        for (int i = 0; i < numRow; ++i) {
            for (int j = 0; j < numCol; ++j) {
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
                grid.setTileValue(i, j, value);
            }
        }
    }

    @Override
    public void flagTile(int row, int col) {
        grid.flagTile(row, col);
    }

    @Override
    public void unflagTile(int row, int col) {
        grid.unflagTile(row, col);
    }

    @Override
    public void renderBoardAsVisible() {
        System.out.println();
        System.out.println("Board:");
        for (int i = 0; i < getNumRow(); ++i) {
            for (int j = 0; j < getNumCol(); ++j) {
                if (grid.containsNegativeBool(i, j)) {
                    System.out.print("* ");
                } else {
                    System.out.print(grid.getTileValue(i, j) + " ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public int getNumVisible() {
        return numVisible;
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public Boolean isComplete() {
        return getNumMines() == (getNumCol() * getNumRow() - getNumVisible());
    }

    public void setNumCol(int numCol) {
        this.numCol = numCol;
    }

    public void setNumRow(int numRow) {
        this.numRow = numRow;
    }

    public void setNumMines(int numMines) {
        this.numMines = numMines;
    }

    @Override
    public void setNumVisible(int numVisible) {
        this.numVisible = numVisible;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

}
