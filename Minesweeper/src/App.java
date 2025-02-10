import Board.Board;
import Board.BoardBuilder;
import Board.BoardDirector;

public class App {
    public static void main(String[] args) throws Exception {
        BoardDirector director = new BoardDirector();
        BoardBuilder builder = new BoardBuilder();
        director.constructBeginnerBoard(builder);
        Board board = builder.generateBoard();
        board.render();
    }
}
