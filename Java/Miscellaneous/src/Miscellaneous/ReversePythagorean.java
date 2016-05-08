package Miscellaneous;

import java.util.Scanner;

public class ReversePythagorean
{
	public static void main(String[] args)
		{
			Scanner userInput = new Scanner (System.in);
			double diaL, verL, horL, surL, x;
			int ratio1, ratio2;

			System.out.print("This program will calculate the horizontal and veritcal length of a rectangular"
					+ "\nobject by using the diagonal lenth and the ratio of that rectangular object.\n\n");

			System.out.print("Please input the length of the diagonal side:");
			diaL = userInput.nextDouble();
			System.out.print("Please input the first part of the ratio: ");
			ratio1 = userInput.nextInt();
			System.out.print("Please input the second part of the ratio: ");
			ratio2 = userInput.nextInt();

			x = Math.sqrt((Math.pow(diaL,2)) / (Math.pow(ratio1,2) + Math.pow(ratio2,2)));

			horL = x * ratio1;
			verL = x * ratio2;
			surL = horL * verL;

			System.out.print("\nIf the diagonal length is: " + diaL + ","
					+ "\nand the ratio is: " + ratio1 + ":" + ratio2
					+ "\nthen the horizontal length is: " + horL + ","
					+ "\nthen the veritcal length is: " + verL + ","
					+ "\nand the Surface area is: " + surL);

			userInput.close();
		}
}

/**
* a^2 + b^2 = c^2
* let a = x*ratio1
* let ratio1 = y
* let b = x*ratio2
* let ratio2 = z
* therefore (x*y)^2 + (x*z)^2 = c^2
* (x^2y^2) + (x^2*z^2) = c^2
* (c^2)/(y^2 + z^2) = x^2
* x = SqRt ((c^2)/(y^2 + z^2))
* where c is diaL
* where y is ratio1
* where z is ratio2
* x = Math.sqrt((Math.pow(diaL,2)) / (Math.pow(ratio1,2) + Math.pow(ratio2,2)))
**/