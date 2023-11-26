package Task1;


import java.util.Scanner;

import java.util.Random;

public class NumberGuessingGame {
	
	public static void main(String[] args) 
	{
		//take input from user using scanner 
		Scanner Input = new Scanner(System.in);
		String Play = "yes";
		
		//while loop to determine if we are going to play game again
		while(Play.equals("yes"))
		{
			Random r = new Random();
			int Random_num = r.nextInt(100);
			int guess = -1;
			int tries = 0;
			
			//while loop to check the game over or not
			while(guess != Random_num)
			{
				System.out.println("Guess a number between 1 and 100 : ");
				guess = Input.nextInt();
				tries++;
				
				if(guess == Random_num)
				{
					System.out.println("yupp!!!!!hurray....congratulations !!You guessed the number!");
					System.out.println("It only took " + tries + " to guess a number.");

					System.out.println("Would you like to play again ? Yes or No : ");
					Play = Input.next().toLowerCase();
				}
				
				else if (guess > Random_num)
				{
					System.out.println("Your Guess is too high , Try Again .");
				}
				
				else 
				{
					System.out.println("Your guess is too low , Try Again .");
				}
			}
		}
		
		Input.close();
	}

}
