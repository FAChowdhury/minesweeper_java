package Board;

public interface Builder {
    void setNumCol(int numCol);
    void setNumRow(int numRow);
    void setNumMines(int numMines);
    Board generateBoard();
}
