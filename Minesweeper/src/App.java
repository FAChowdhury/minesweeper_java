import Board.Board;
import Board.BoardBuilder;
import Board.BoardDirector;

public class App {
    public static void main(String[] args) throws Exception {
        BoardDirector director = new BoardDirector();
        BoardBuilder builder = new BoardBuilder();
        director.constructExpertBoard(builder);;
        Board board = builder.generateBoard();
        board.render();
    }
}
