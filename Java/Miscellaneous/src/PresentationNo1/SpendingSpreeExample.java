package PresentationNo1;

import java.util.Scanner;

public class SpendingSpreeExample
	{
		public static final float SPENDING_MONEY = 100;
		public static final int MAX_ITEMS = 3;
	
		public static void main(String[] args)
			{
				Scanner keyboard = new Scanner(System.in);
	
				float leftToSpend = SPENDING_MONEY, totalSpent = 0;
				int itemNumber = 1;
	
				while (itemNumber <= MAX_ITEMS) {
						System.out.println("You may buy up to " + (MAX_ITEMS - itemNumber + 1) + " items");
						System.out.printf("costing no more than $%1.2f", leftToSpend);
						System.out.print(".\nEnter cost of item #" + itemNumber + ": $");
		
						float itemCost = keyboard.nextFloat();
	
						if (itemCost <= leftToSpend) {
								System.out.println("You may buy this item. ");
								totalSpent = totalSpent + itemCost;
								System.out.printf("You spent $%1.2f", totalSpent);
								System.out.println(" so far.");
								leftToSpend = SPENDING_MONEY - totalSpent;
	
								if (leftToSpend > 0) {
										itemNumber++;
									} else {
										System.out.println("You are out of money.");
										break;
									}
							} else {
								System.out.println("You cannot buy that item.");
							}
					}
	
				System.out.printf("You spent $%1.2f", totalSpent);
				System.out.println(", and are done shopping.");
	
				keyboard.close();
			}
	}