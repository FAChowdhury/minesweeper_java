import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import Board.Board;
import Board.BoardBuilder;
import Board.BoardDirector;

public class App {
    public static void main(String[] args) throws Exception {
        BoardDirector director = new BoardDirector();
        BoardBuilder builder = new BoardBuilder();

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        int difficulty = 0;
        // Prompt the user until a valid input is received
        while (difficulty < 1 || difficulty > 3) {
            System.out.println("Select difficulty level (1, 2, or 3):");
            System.out.println("1 - Beginner");
            System.out.println("2 - Intermediate");
            System.out.println("3 - Expert");

            // Read the input from the user
            if (scanner.hasNextInt()) {
                difficulty = scanner.nextInt();
                if (difficulty < 1 || difficulty > 3) {
                    System.out.println("Invalid selection. Please choose 1, 2, or 3.");
                } else {
                    if (difficulty == 1) {
                        director.constructBeginnerBoard(builder);
                    } else if (difficulty == 2) {
                        director.constructIntermediateBoard(builder);
                    } else if (difficulty == 3) {
                        director.constructExpertBoard(builder);
                    }
                }
            } else {
                scanner.next();  // Consume invalid input
            }
        }

        Board board = builder.generateBoard();
        LocalDateTime currentTime = LocalDateTime.now();
        board.render(currentTime);

        // Prompt for a command
        System.out.println("Enter a command (e.g., sweep <row: int> <column: int>, flag <row: int> <column: int>, unflag <row: int> <column: int>):");

        while (scanner.hasNextLine()) {
            // Read the full command line
            String commandLine = scanner.nextLine().trim();

            // If the command is empty, continue prompting
            if (commandLine.isEmpty()) {
                continue;
            }

            // Split the command into its components
            String[] commandParts = commandLine.split(" ");

            // Handle different commands
            if (commandParts.length == 3) {
                String command = commandParts[0];
                try {
                    int row = Integer.parseInt(commandParts[1]);
                    int col = Integer.parseInt(commandParts[2]);

                    // Check if the row and column are within valid range
                    if (row < 0 || row >= board.getNumRow() || col < 0 || col >= board.getNumCol()) {
                        System.out.println("Invalid row or column. Row must be between 0 and " + (board.getNumRow() - 1) + " inclusive.");
                        System.out.println("Column must be between 0 and " + (board.getNumCol() - 1) + " inclusive.");
                        continue;
                    }

                    // Process the command based on the input
                    switch (command) {
                        case "sweep":
                            if (!board.revealTile(row, col)) {
                                System.out.println("Game Over");
                                board.renderBoardAsVisible();
                                scanner.close();
                                return;  // End the game
                            }
                            break;
                        case "flag":
                            board.flagTile(row, col);
                            break;
                        case "unflag":
                            board.unflagTile(row, col);
                            break;
                        default:
                            System.out.println("Invalid command. Please enter a valid command (e.g., sweep <row> <col>, flag <row> <col>, unflag <row> <col>).");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter integers for the coordinates.");
                }
            } else {
                System.out.println("Invalid command format. Please enter a command with 3 parts (e.g., sweep <row> <column>).");
            }

            // Render the board after each command
            board.render(currentTime);

            // Check if the game is complete
            if (board.isComplete()) {
                System.out.println("Congratulations! You have completed the board!");
                LocalDateTime now = LocalDateTime.now();
                Duration elapsed = Duration.between(currentTime, now);
                long secondsElapsed = elapsed.toSeconds();
                System.out.println("You took " + secondsElapsed + " seconds to complete the board.");
                board.renderBoardAsVisible();
                break;
            }
        }
        // Close the scanner
        scanner.close();
    }
}
