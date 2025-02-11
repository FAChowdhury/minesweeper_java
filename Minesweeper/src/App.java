import java.util.Scanner;

import Board.Board;
import Board.BoardBuilder;
import Board.BoardDirector;

public class App {
    public static void main(String[] args) throws Exception {
        BoardDirector director = new BoardDirector();
        BoardBuilder builder = new BoardBuilder();
        director.constructTestBoard(builder);
        Board board = builder.generateBoard();
        board.render();

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt for a command
        System.out.println("Enter a command (e.g., sweep <row: int> <column: int>, flag <row: int> <column: int>, unflag <row: int> <column: int>):");

        while (scanner.hasNextLine()) {
            // Read the full command line
            String commandLine = scanner.nextLine();

            // Split the command into its components
            String[] commandParts = commandLine.split(" ");

            // Handle different commands
            if (commandParts.length == 3) {
                String command = commandParts[0];
                try {
                    int row = Integer.parseInt(commandParts[1]);
                    int col = Integer.parseInt(commandParts[2]);
                    
                    if (row < 0 || row > board.getNumRow() - 1 || col < 0 || col > board.getNumCol() - 1) {
                        System.out.println("row must be between 0 and " + (board.getNumRow() - 1) + " inclusive");
                        System.out.println("col must be between 0 and " + (board.getNumCol() - 1) + " inclusive");
                        continue;
                    }

                    // Check for specific commands and process accordingly
                    switch (command) {
                        case "sweep":
                            if (!board.revealTile(row, col)) {
                                System.out.println("Game Over");
                                board.renderBoardAsVisible();
                                scanner.close();
                                System.exit(0);
                            } else {
                            }
                            break;
                        case "flag":
                            board.flagTile(row, col);
                            break;
                        case "unflag":
                            board.unflagTile(row, col);
                            break;
                        default:
                            System.out.println("Enter a command (e.g., sweep <row: int> <column: int>, flag <row: int> <column: int>, unflag <row: int> <column: int>):");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter integers for the coordinates.");
                }
            } else {
                System.out.println("Invalid command. Enter a command (e.g., sweep <row: int> <column: int>, flag <row: int> <column: int>, unflag <row: int> <column: int>):");
            }
            board.render();
            if (board.isComplete()) {
                System.out.println("Congratulations! You have completed the board!");
                board.renderBoardAsVisible();
                break;
            }
        }
        // Close the scanner
        scanner.close();
    }
}
