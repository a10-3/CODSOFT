import java.util.*;
public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Guess the Number game!");
        String playagain = "yes";
        int totalAttempts = 0;
        int roundsWon = 0;

        String anotherstring;
        while (playagain.equalsIgnoreCase(anotherstring="yes")) {
            int bound;
            int secretNumber = random.nextInt(bound=100) + 1; // Generates a random number between 1 and 100
            int attempts = 0;

            System.out.println("\nI've picked a number between 1 and 100. Try to guess it!!!\nLet the number be: " + secretNumber);

            while(attempts < 5) {//Limit the number of attempts to 5
                System.out.print("Enter your guess: ");
                int userGuess;

                try{
                    userGuess = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); //clear the input buffer
                    continue;
                }

                attempts++;
                if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " in " + attempts + " attempts!");
                    roundsWon++;
                    totalAttempts += attempts;
                    break;       
                }
            }

            if (attempts ==5) {
                System.out.println("\nSorry, you've reached the maximum number of attempts. The correct number was " + secretNumber +".");
            }

            System.out.println("\nDo you want to play another round? (yes/no): ");
            playagain = scanner.next();
        }

        if (roundsWon > 0) {
            double averageAttempts = (double) totalAttempts / roundsWon;
            System.out.println("\nYou won" + roundsWon + " rounds with an average of " + String.format("%.2f", averageAttempts) + " attempts per round." );
        } else {
            System.out.println("Thanks for playing! Goodbye!");
        }

        scanner.close();
    }
}
