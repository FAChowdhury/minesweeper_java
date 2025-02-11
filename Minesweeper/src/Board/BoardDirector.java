package Board;

public class BoardDirector {
    public void constructBeginnerBoard(Builder builder) {
        builder.setNumRow(9);
        builder.setNumCol(9);
        builder.setNumMines(10);
    }

    public void constructIntermediateBoard(Builder builder) {
        builder.setNumRow(16);
        builder.setNumCol(16);
        builder.setNumMines(40);
    }

    public void constructExpertBoard(Builder builder) {
        // if numCol is bigger than numRow, it fails Index out of bounds
        builder.setNumRow(16);
        builder.setNumCol(30);
        builder.setNumMines(99);
    }

    public void constructTestBoard(Builder builder) {
        builder.setNumRow(5);
        builder.setNumCol(5);
        builder.setNumMines(3);
    }

}
