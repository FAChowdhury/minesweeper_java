package Board;

public class BoardBuilder implements Builder {
    private int numCol;
    private int numRow;
    private int numMines;

    @Override
    public void setNumCol(int numCol) {
        this.numCol = numCol;
    }

    @Override
    public void setNumRow(int numRow) {
        this.numRow = numRow;
    }

    @Override
    public void setNumMines(int numMines) {
        this.numMines = numMines;
    }

    @Override
    public Board generateBoard() {
        return new BasicBoard(numCol, numRow, numMines);
    }

}
