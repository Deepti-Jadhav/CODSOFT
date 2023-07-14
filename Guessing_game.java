import java.util.Random;
import java.util.Scanner;
public class Guessing_game {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7;
        int score = 0;

        System.out.println("Welcome to the Guessing Game!");

        boolean playagain = true;
        while (playagain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nI have generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("\nEnter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame over! You have run out of attempts.");
                System.out.println("The number was: " + generatedNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playagain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("\nYour final score: " + score);
        System.out.println("Thank you for playing the Guessing Game!");
    }

}
