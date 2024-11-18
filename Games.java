import java.util.ArrayList;
import java.util.Scanner;

public class Gaming {
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
    public void hangman(){
        String[] wordList = {"banker", "teller", "hanger", "airplane", "peashooter"};
        int attempts = 6;
        Scanner scanner = new Scanner(System.in);
        String word = wordList[(int)Math.random()*5];
        char[] currWord = new char[word.length()];
        for (int i = 0; i < currWord.length; i++) {
            currWord[i] = '_';
        }
        ArrayList<Character> guessedLetters = new ArrayList<>();
        while (attempts > 0 && charToString(currWord).contains("_")) {
            System.out.println(charToString(currWord));
            System.out.println("Attempts left: " + attempts);
            System.out.print("Guess a letter (lowercase): ");
            char guess = scanner.next().charAt(0);
            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter!");
                continue;
            }
            guessedLetters.add(guess);
            if (word.indexOf(guess) != -1) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        currWord[i] = guess;
                    }
                }
                System.out.println("Correct!");
            } else {
                attempts--;
                System.out.println("Wrong!");
            }
        }

        if (charToString(currWord).equals(word)) {
            System.out.println("Congratulations! You guessed the word: " + word);
        } else {
            System.out.println("Game over! The word was: " + word);
        }
        scanner.close();
    }
    public String charToString(char[] arr) {
        String ret = "";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
        }
        return ret;
    }
    public class TicTacToe {
        public static void main(String[] args) {
            char[][] board = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}};

            Scanner scanner = new Scanner(System.in);
            char currentPlayer = 'X';
            boolean gameWon = false;

            for (int turn = 0; turn < 9 && !gameWon; turn++) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1 1 for top-left): ");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                if (board[row][col] != ' ') {
                    System.out.println("Invalid move! Try again.");
                    turn--;
                    continue;
                }

                board[row][col] = currentPlayer;
                gameWon = checkWin(board, currentPlayer);

                if (!gameWon) {
                    if(currentPlayer == 'X'){
                        currentPlayer = 'O';
                    }else{
                        currentPlayer = 'X';
                    }
                }else {
                    break;
                }
            }

            printBoard(board);

            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            scanner.close();
        }

        private static void printBoard(char[][] board) {
            for (char[] row : board) {
                for (char cell : row) {
                    System.out.print("|" + cell);
                }
                System.out.println("|");
            }
        }

        private static boolean checkWin(char[][] board, char player) {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
                if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
            }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

            return false;
        }
    }




}

public void main() {
}
