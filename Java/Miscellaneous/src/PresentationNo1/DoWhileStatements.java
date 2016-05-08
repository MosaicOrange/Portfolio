package PresentationNo1;

import java.util.Scanner;

public class DoWhileStatements
	{
		public static void main(String[] args)
			{
				Scanner keyboard = new Scanner(System.in);			// Covered Previously
				System.out.print("Enter a non negative number: ");
				int count = 1; 
				float number = keyboard.nextFloat();				// This was added to be able
				 													// to accept nearly any value
		
				number = (int)number; 								// This was done to convert
																	// the previous number into an integer
		
				do {												// ~ do-while ~ statements evaluate the
				 													// boolean before producing the string of code
		
					if (number <= 0) {								// This was added to show the effect
																	// of the ~ break ~ code
		
							System.out.print("That is an invalid number. Do not ");
							break;									// This will make the ~ do ~ statement behave
							 										// as if a ~ while ~ statement
		
						}
					System.out.print(count + ", ");
					count++;
				} while (count <= number); {						// Notice the ~ ; ~ at the end of the
																	// boolean evaluation
		
					System.out.print("buckle my shoe.");			// This Occurs after the boolean
																	// evaluation becomes false
				}
				keyboard.close(); 									// Closes the resource leak
			}
	}