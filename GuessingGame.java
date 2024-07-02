import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int round = 0;
        int totalAttempts = 0;
        while (true) {
            round++;
            int minNum = 1;
            int maxNum = 100;
            int maxAttempts = 10;
            int randomNumber = random.nextInt(maxNum - minNum + 1) + minNum;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            System.out.println("Guess the number between " + minNum + " and " + maxNum + ". You have " + maxAttempts + " attempts.");
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
                attempts++;
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number " + randomNumber + " in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }
            }
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
            }
            totalAttempts += attempts;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        System.out.println("\nYou've played " + round + " rounds with a total of " + totalAttempts + " attempts.");
        System.out.println("Average attempts per round: " + (double) totalAttempts / round);
        scanner.close();
    }
}       