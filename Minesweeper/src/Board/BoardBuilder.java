package Board;

public class BoardBuilder implements Builder {
    private int width;
    private int height;
    private int numMines;

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setNumMines(int numMines) {
        this.numMines = numMines;
    }

    @Override
    public Board generateBoard() {
        return new BasicBoard(width, height, numMines);
    }

}
