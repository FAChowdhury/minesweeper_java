package Board;

public interface Builder {
    void setWidth(int width);
    void setHeight(int height);
    void setNumMines(int numMines);
    Board generateBoard();
}
