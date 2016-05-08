package PresentationNo1;

import java.util.Scanner;

public class RoachPopulationExample
	{
	//Program to calculate how long it will take a population of
	//roaches to completely fill a house from floor to ceiling.
	
		public static final double GROWTH_RATE = 0.95;
		public static final double ONE_BUG_VOLUME = 0.002;
		
		public static void main(String[] args)
			{
				System.out.print("Enter the total volume of your house in cubic feet: ");
				Scanner keyboard = new Scanner(System.in);
				double houseVolume = keyboard.nextDouble();
				System.out.print("Enter the estimated number of roaches in your house: ");
		
				int startPopulation = keyboard.nextInt();
				int countWeeks = 0;
		
				double population = startPopulation;
				double totalBugVolume = population * ONE_BUG_VOLUME;
				double newBugs, newBugVolume;
		
				while (totalBugVolume < houseVolume)
					{
						newBugs = population * GROWTH_RATE;
						newBugVolume = newBugs * ONE_BUG_VOLUME;
						population = population + newBugs;
						totalBugVolume = totalBugVolume + newBugVolume;
						countWeeks++;
						System.out.printf("\nStarting with a roach population of " + startPopulation + " and a house with\na volume of %1.0f", houseVolume);
						System.out.printf(" cubic feet, after " + countWeeks + " weeks, the house will\nbe filled with %1.0f", population);
						System.out.printf(" roaches. They will fill a volume of %1.0f", totalBugVolume);
						System.out.print("\ncubic feet. Better call Debugging Experts Inc.\n");
					}

				keyboard.close();
			}
	}