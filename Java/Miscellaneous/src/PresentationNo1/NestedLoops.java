package PresentationNo1;

import java.util.Scanner;

public class NestedLoops
	{
	//Computes the average of a list of (nonnegative) exam scores.
	// Repeats computation for more exams until the user says to stop.
		public static void main(String[] args)
			{
				System.out.print("This program computes the average of a list of (nonnegative) exam scores.\n");
				double sum = 0, next;
				int numberOfStudents = 0;
				String answer = "";
				Scanner keyboard = new Scanner(System.in);
				do {
						System.out.println();
						System.out.println("Enter all the scores to be averaged.");
						System.out.println("Enter a negative number after");
						System.out.println("you have entered all the scores.");
	
						next = keyboard.nextDouble();
						while (next >= 0)
							{
								sum = sum + next;
								numberOfStudents++;
								next = keyboard.nextDouble();
							}
		
						if (numberOfStudents > 0)
							{
								System.out.println("The average is " + (sum / numberOfStudents));
							}
						else
							{
								System.out.println("No scores to average.");
							}
	
						System.out.print("Want to average another exam? Enter yes[y] or no[n]: ");
						answer = keyboard.next();
					} while (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"));
	
				keyboard.close();
			}
}