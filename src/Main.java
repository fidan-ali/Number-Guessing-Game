import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (playAgain) {

            System.out.println("\nPlease select the difficulty level:");
            System.out.println("1. Easy (10 chances)");
            System.out.println("2. Medium (5 chances)");
            System.out.println("3. Hard (3 chances)");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            int chances;

            if (choice == 1) {
                chances = 10;
                System.out.println("Great! You selected Easy mode.");
            } else if (choice == 2) {
                chances = 5;
                System.out.println("Great! You selected Medium mode.");
            } else if (choice == 3) {
                chances = 3;
                System.out.println("Great! You selected Hard mode.");
            } else {
                System.out.println("Invalid choice. Exiting game.");
                return;
            }

            int number = random.nextInt(100) + 1;
            int attempts = 0;

            long startTime = System.currentTimeMillis();

            boolean won = false;

            System.out.println("\nLet's start the game!");

            while (chances > 0) {

                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                attempts++;
                chances--;

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    won = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Incorrect! The number is less than " + guess);
                } else {
                    System.out.println("Incorrect! The number is greater than " + guess);
                }

                if (chances > 0) {
                    System.out.println("Remaining chances: " + chances);
                }
            }

            long endTime = System.currentTimeMillis();

            if (!won) {
                System.out.println("\nYou lost! The correct number was: " + number);
            }

            System.out.println("Time taken: " + (endTime - startTime) / 1000 + " seconds");

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! 👋");
        scanner.close();
    }
}