/*
 * @author BikDS
 * December 29, 2017
 * This is the game 21 sticks
 */

import java.util.Scanner;

public class Sticks_21 {

	public static void main(String[] args) {

		int sticksLeft = 21;
		// number of sticks left
		int sticksTaken = 0;
		// number of sticks that have been taken
		int compPick;
		// number of sticks computer picks
		int userChoice;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to 21 Sticks");
		System.out.println("Do you want to go first (yes or no): ");
		String yesNo = keyboard.nextLine();

		while (sticksLeft >= 0) {
			
			// only allows game to run while the number of sticks available is 0 or more

			if (yesNo.equals("yes") || yesNo.equals("Yes") || yesNo.equals("Y") || yesNo.equals("y")) {

				if (sticksLeft >= 4) {
					System.out.println("Pick the number of sticks you want to pick up (either 1, 2, 3, or 4): ");
					// lists out options for user
				} else if (sticksLeft == 3) {
					System.out.println("Pick the number of sticks you want to pick up (either 1, 2, or 3): ");
					// restricts number of options available to user
				} else if (sticksLeft == 2) {
					System.out.println("Pick the number of sticks you want to pick up (either 1 or 2): ");
					// restricts number of options available to user
				} else if (sticksLeft == 1) {
					System.out.println("Pick the number of sticks you want to pick up (only 1): ");
					// restricts number of options available to user
				}
				userChoice = keyboard.nextInt();
				if (userChoice == 1 || userChoice == 2 || userChoice == 3 || userChoice == 4) {
					// checks whether the number of sticks the user picks is legitimate
					if (sticksLeft >= userChoice) {
						sticksLeft = sticksLeft - userChoice;
						System.out.println("There are " + sticksLeft + " sticks left");
					} else {
						System.out.println("Cheater! Restart and try again!");
						break;
						// ends the game if the user "cheats"
					}
				}
				if (sticksLeft == 0) {
					System.out.println("You Lose!");
					break;
					// checks if the user lost
				}

				compPick = random(1, Math.min(4, sticksLeft));
				if (compPick == 1) {
					System.out.println("I pick " + compPick + " stick");
				} else {
					System.out.println("I pick " + compPick + " sticks");
				}
				// informs the user of how many sticks are picked by the CPU
				
				sticksLeft = sticksLeft - compPick;
				sticksTaken = sticksTaken + compPick;
				// the sticks that the CPU takes are "taken out"
				if (sticksLeft == 0) {
					System.out.println("You Win!");
					// checks if user won, and if they did, ends the game
					break;
				} else {
					// if user did not win, the game continues
					if (sticksLeft == 1) {
						System.out.println("There is " + sticksLeft + " stick left");
					} else {
						System.out.println("There are " + sticksLeft + " sticks left");
					}

				}
			}

			else if (yesNo.equals("no") || yesNo.equals("No") || yesNo.equals("n") || yesNo.equals("N")) {
				// this is for when the user wants the computer to go first 
				compPick = random(1, Math.min(4, sticksLeft));
				System.out.println("I pick " + compPick + " sticks");
				sticksLeft = sticksLeft - compPick;
				sticksTaken = sticksTaken + compPick;
				if (sticksLeft == 0) {
					System.out.print("You Win!");
					// checks if user won, and if not, the game continues
					break;
				} else {
					if (sticksLeft == 1) {
						System.out.println("There is " + sticksLeft + " stick left");
					} else {
						System.out.println("There are " + sticksLeft + " sticks left");
					}
				}

				if (sticksLeft >= 4) {
					System.out.println("Pick the number of sticks you want to pick up (either 1, 2, 3, or 4): ");
				} else if (sticksLeft == 3) {
					System.out.println("Pick the number of sticks you want to pick up (either 1, 2, or 3): ");
				} else if (sticksLeft == 2) {
					System.out.println("Pick the number of sticks you want to pick up (either 1 or 2): ");
				} else if (sticksLeft == 1) {
					System.out.println("Pick the number of sticks you want to pick up (only 1): ");
				}
				// restrictions depending on the number of sticks remaining
				userChoice = keyboard.nextInt();
				if (userChoice == 1 || userChoice == 2 || userChoice == 3 || userChoice == 4) {
					if (userChoice <= sticksLeft) {
						sticksLeft = sticksLeft - userChoice;
						System.out.println("There are " + sticksLeft + " sticks left");
					} else {
						System.out.println("Cheater! Restart and try again!");
						break;
					}
				}
				if (sticksLeft == 0) {
					System.out.println("You Lose!");
					// checks if user lost
					break;
				}

			}

		}

	}

	static int random(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
		// code for picking a random number for the CPU
	}
}
