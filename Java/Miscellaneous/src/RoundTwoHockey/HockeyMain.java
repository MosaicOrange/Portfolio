package RoundTwoHockey;

import java.io.*;

public class HockeyMain
	{
		public static void main(String arg[]) throws IOException
			{
				League Round = new League();
				Round.getData();
				System.out.println("The First Round");
				Round.display();
				Round.readSecondRound();
				Round.setPoints();
				System.out.println();
				System.out.println("The Second Round");
				Round.display();
				Round.sort();
				System.out.println();
				System.out.println("The Second Round Sorted");
				Round.display();
			}
	}

