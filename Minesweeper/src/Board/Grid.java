package Board;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int numCol;
    private int numRow;
    private List<Tile> grid;
    
    public Grid(int numCol, int numRow) {
        this.numCol = numCol;
        this.numRow = numRow;
        this.grid = new ArrayList<>(numCol * numRow);
        for (int i = 0; i < numCol * numRow; ++ i) {
            grid.add(new Tile());
        }
    }

    public int getNumCol() {
        return numCol;
    }
    
    public void setNumCol(int numCol) {
        this.numCol = numCol;
    }

    public int getNumRow() {
        return numRow;
    }

    public void setNumRow(int numRow) {
        this.numRow = numRow;
    }

    public int getTileValue(int row, int col) {
        if (row < 0 || row > getNumRow() - 1 || col < 0 || col > getNumCol() - 1) {
            return 0;
        }
        return grid.get(row * getNumCol() + col).getValue();
    }

    public void setTileValue(int row, int col, int value) {
        if (row < 0 || row > getNumRow() - 1 || col < 0 || col > getNumCol() - 1) {
            return;
        }
        grid.set(row * getNumCol() + col, new Tile(value));
    }

    public int getTileValue(int idx) {
        if (idx < 0 || idx > getNumCol() * getNumRow() - 1) {
            return 0;
        }
        return grid.get(idx).getValue();
    }

    public void setTileValue(int idx, int value) {
        if (idx < 0 || idx > getNumCol() * getNumRow() - 1) {
            return;
        }
        grid.set(idx, new Tile(value));
    }

    public Boolean isTileVisible(int row, int col) {
        return grid.get(row * getNumCol() + col).getIsVisible();
    }

    public Boolean isTileFlagged(int row, int col) {
        return grid.get(row * getNumCol() + col).getIsFlagged();
    }

    public int containsNegativeInt(int row, int col) {
        return getTileValue(row, col) == -1 ? 1 : 0;
    }

    public Boolean containsNegativeBool(int row, int col) {
        return getTileValue(row, col) == -1 ? true : false;
    }

    public void flagTile(int row, int col) {
        grid.get(row * getNumCol() + col).setIsFlagged(true);
    }

    public void unflagTile(int row, int col) {
        grid.get(row * getNumCol() + col).setIsFlagged(false);
    }

    public void revealTile(int row, int col, Board board) {
        int idx = row * getNumCol() + col;
        int newlyVisibleTiles = 0;
        if (!grid.get(idx).getIsFlagged()) {
            if (grid.get(idx).getValue() == 0) {
                newlyVisibleTiles = revealTileWhenZero(row, col);
                board.setNumVisible(board.getNumVisible() + newlyVisibleTiles);
            } else {
                grid.get(idx).setIsVisible(true);
                board.setNumVisible(board.getNumVisible() + 1);
            }
        }
    }

    private int revealTileWhenZero(int row, int col) {
        if (row < 0 || row > getNumRow() - 1 || col < 0 || col > getNumCol() - 1) {
            return 0;
        }

        int idx = row * getNumCol() + col;

        if (grid.get(idx).getIsVisible()) {
            return 0;
        }

        int newlyVisibleTiles = 0;

        if (grid.get(idx).getValue() != -1) {
            grid.get(idx).setIsVisible(true);
            ++newlyVisibleTiles;
        }

        if (grid.get(idx).getValue() != 0) {
            return newlyVisibleTiles;
        }

        return revealTileWhenZero(row - 1, col - 1) +
        revealTileWhenZero(row - 1, col) +
        revealTileWhenZero(row - 1, col + 1) +
        revealTileWhenZero(row, col - 1) +
        revealTileWhenZero(row, col + 1) +
        revealTileWhenZero(row + 1, col - 1) +
        revealTileWhenZero(row + 1, col) +
        revealTileWhenZero(row + 1, col + 1) + 1;
    }
}
