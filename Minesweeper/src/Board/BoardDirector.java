package Board;

public class BoardDirector {
    public void constructBeginnerBoard(Builder builder) {
        builder.setHeight(9);
        builder.setWidth(9);
        builder.setNumMines(10);
    }
}
