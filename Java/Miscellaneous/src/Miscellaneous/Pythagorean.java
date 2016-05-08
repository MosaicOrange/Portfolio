package Miscellaneous;

import java.util.Scanner;

public class Pythagorean
	{
		public static void main(String[] args)
			{
				Scanner userInput = new Scanner (System.in);
				double verL, horL, diaL;
				System.out.print("This program will calculate the diagonal length of a rectangular object."
						+ "\nThen it will calculate the area of the rectgular object.\n\n");
				System.out.print("Please input the length of the horizontal side:");
				horL = userInput.nextDouble();
				System.out.print("Please input the length of the vertical side:");
				verL = userInput.nextDouble();

				double verSq = Math.pow(verL,2);
				double horSq = Math.pow(horL,2);
				double diaSq = verSq + horSq;
				diaL = Math.sqrt(diaSq);
				double surL = horL*verL;

				System.out.print("\nIf the horizonal length is: " + horL
						+ "\nAnd the vertical length is: " + verL
						+ "\nThen the diagonal length is: " + diaL
						+ "\nAnd the Surface area is: " + surL);

				userInput.close();
			}
	}