import java.util.Scanner;

public class Games {

    public void guessingGame(int target) {
        System.out.println("Think of a number between 1 and 100, and I'll  guess it!");
        System.out.println("Answer with 'higher', 'lower', or 'correct'.");
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        int guess;
        while (low <= high) {
            guess = low + (high - low) / 2;
            System.out.println("Is it " + guess + "?");
            String answer = scanner.nextLine();
            if (answer.equals("correct")) {
                System.out.println("I win");
                break;
            } else if (answer.equals("higher")) {
                low = guess + 1;
            } else {
                high = guess - 1;
            }
        }
        scanner.close();
    }
}
