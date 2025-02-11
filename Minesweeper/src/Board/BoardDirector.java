package Board;

public class BoardDirector {
    public void constructBeginnerBoard(Builder builder) {
        builder.setHeight(9);
        builder.setWidth(9);
        builder.setNumMines(10);
    }

    public void constructIntermediateBoard(Builder builder) {
        builder.setHeight(16);
        builder.setWidth(16);
        builder.setNumMines(40);
    }

    public void constructExpertBoard(Builder builder) {
        // if width is bigger than height, it fails Index out of bounds
        builder.setHeight(16);
        builder.setWidth(30);
        builder.setNumMines(99);
    }

    public void constructTestBoard(Builder builder) {
        builder.setHeight(20);
        builder.setWidth(10);
        builder.setNumMines(40);
    }

}
