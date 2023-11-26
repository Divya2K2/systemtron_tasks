package Task2;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorgame {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        String[] options = {"rock", "paper", "scissors"};

	        System.out.println("Welcome to Rock-Paper-Scissors game!");

	        while (true) {
	            System.out.print("Enter your move (rock, paper, or scissors): ");
	            String userMove = scanner.nextLine().toLowerCase();

	            if (!isValidMove(userMove)) {
	                System.out.println("Invalid move. Please enter rock, paper, or scissors.");
	                continue;
	            }

	            String computerMove = options[random.nextInt(options.length)];

	            System.out.println("Computer's move: " + computerMove);

	            String result = determineWinner(userMove, computerMove);
	            System.out.println(result);

	            System.out.print("Do you want to play again? (yes/no): ");
	            String playAgain = scanner.nextLine().toLowerCase();
	            if (!playAgain.equals("yes")) {
	                break;
	            }
	        }

	        System.out.println("Thanks for playing!");
	        scanner.close();
	    }

	    private static boolean isValidMove(String move) {
	        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
	    }

	    private static String determineWinner(String userMove, String computerMove) {
	        if (userMove.equals(computerMove)) {
	            return "It's a tie!";
	        } else if (
	            (userMove.equals("rock") && computerMove.equals("scissors")) ||
	            (userMove.equals("paper") && computerMove.equals("rock")) ||
	            (userMove.equals("scissors") && computerMove.equals("paper"))
	        ) {
	            return "You win!";
	        } else {
	            return "Computer wins!";
	        }
	    }
}
