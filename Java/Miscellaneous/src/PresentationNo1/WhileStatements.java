package PresentationNo1;

import java.util.Scanner;

public class WhileStatements
	{
		public static void main(String[] args)
			{
				int count, number;									// Defines the variables as integers
				System.out.println("Enter a number");
				Scanner keyboard = new Scanner(System.in);			// Invokes the Scanner object in the imported API 
																	// and assigns the variable ~ keyboard ~ a function 
				number = keyboard.nextInt();						// Allows the user to enter in an integer 
		
				count = 1;											// Sets the base value for the variable ~ count ~
		
				while ((count <= number) && ( number <= 100 )) {	// ~ while ~ statements evaluate the boolean before
																	// producing the string of code. Notice the lack of 
																	// ~ ; ~ at the end of the boolean evaluation. Added
																	// the ~ && ~ and an extra boolean to prevent a large
																	// string from being produced.  
		
					System.out.print(count + ", ");					// This ~ while ~ statement will keep producing this
																	// string until the boolean is false.
		
					count++;										// Bumps the value of ~ count ~ up a notch so eventually
																	// the ~ count ~ portion of the boolean string will be false
		
				}													// Ends the ~ while ~ statement
		
				System.out.println();
				System.out.println("Buckle my shoe.");
				keyboard.close();									// Closes the resource leak
			}
	}