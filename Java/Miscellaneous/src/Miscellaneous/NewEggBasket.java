package Miscellaneous;
import java.util.Scanner; // Importing the API to be able to get input from the user
public class NewEggBasket // Name of the class
	{
		public static void main(String[] args)
			{
				int amount, originalAmount, hundreds, fifties, twenties, tens, fives, ones; // Initializing the variables to be integers
		 		System.out.println("Enter in a whole positive."); // String of text telling the user what to do
		 		System.out.println("I will find a combination of bills that equals that amount."); // Letting the user know what the program will do with that number

		 		Scanner keyboard = new Scanner(System.in); // This is preparing the program to accept user input 
		 		amount = keyboard.nextInt(); // This is where the user inputs the variable
		 		originalAmount = amount; // This is so we don't lose track of the original number so we can later recall it
		 		hundreds = amount / 100; // This takes the number and divides by 100 and stores the value in another variable
		 		amount %= 100; // This takes the remainder of the original value and stores it as an ongoing changing value
		 		fifties = amount / 50; // This takes the previous amount and divides by 50 and stores the value in another variable
		 		amount %= 50; // This takes the remainder of the previous value and stores it as an ongoing changing value
		 		twenties = amount / 20; // This takes the previous amount and divides by 20 and stores the value in another variable
		 		amount %= 20;// This takes the remainder of the previous value and stores it as an ongoing changing value
		 		tens = amount / 10; // This takes the previous amount and divides by 10 and stores the value in another variable
		 		amount %= 10;// This takes the remainder of the previous value and stores it as an ongoing changing value
		 		fives = amount / 5; // This takes the previous amount and divides by 5 and stores the value in another variable
		 		amount %= 5;// This takes the remainder of the previous value and stores it as an ongoing changing value
		 		ones = amount; // This takes the previous amount and stores it as the last variable

		 		System.out.println(originalAmount +	" dollars in bills can be given as:"); // This displays the original amount entered in by the user
		 		System.out.println(hundreds + " hundreds"); // This displays how many times it was possible to divide the number by 100
		 		System.out.println(fifties + " fifties"); // This displays how many times it was possible to divide by 50 after dividing by 100
		 		System.out.println(twenties + " twenties"); // This displays how many times it was possible to divide by 20 after dividing by 100 and then 50
		 		System.out.println(tens + " tens"); // This displays how many times it was possible to divide by 10 after dividing by 100 and then 50 and then 20
		 		System.out.println(fives + " fives"); // This displays how many times it was possible to divide by 5 after dividing by 100 and then 50 and then 20 and then 10
		 		System.out.println(ones + " ones"); // This displays the last remainder after the original amount was divided by 100, then 50, then 20, then 10, then 5
		 		keyboard.close(); // This closes the Scanner object so there is no resource leak
			}
	}