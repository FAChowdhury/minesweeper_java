import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Minesweeper!");
        Scanner scanner = new Scanner(System.in);
        int difficulty = 0;

        do {
            System.out.println("Please select from the following difficulties by entering a number from the set: {1, 2, 3}.");
            System.out.println("1. Beginner");
            System.out.println("2. Intermediate");
            System.out.println("3. Expert");
        
            try {
                difficulty = scanner.nextInt();
                if (difficulty == 1) {
                    System.out.println("You have selected beginner difficulty.");
                } else if (difficulty == 2) {
                    System.out.println("You have selected intermediate difficulty.");
                } else if (difficulty == 3) {
                    System.out.println("You have selected expert difficulty.");
                }
            } catch (InputMismatchException e) {
                // Consume the invalid input so the scanner can proceed to the next input attempt
                scanner.next();  // This discards the invalid input
            }
        }
        while (difficulty != 1 && difficulty != 2 && difficulty != 3);

        System.out.println("The game will now begin with difficulty " + difficulty + ".");

        scanner.close();
    }
}
