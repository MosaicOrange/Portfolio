package Miscellaneous;
import java.util.Scanner;

public class EggBasket
	{
		public static void main(String[] args)
			{
				System.out.println("How many eggs do you have?");
				
				int eggsYouHave, basketsYouHave, howManyFit, mathResult, basketsUsed, unUsed;
				
				Scanner keyboard = new Scanner(System.in);
				eggsYouHave = keyboard.nextInt();
				
				System.out.print("Now tell me how many baskets you have?");
				
				basketsYouHave = keyboard.nextInt();
				
				System.out.print("Ideally, how many eggs would you put in one basket?");
				
				howManyFit = keyboard.nextInt();				
				
				mathResult = eggsYouHave % howManyFit;
				basketsUsed = eggsYouHave / howManyFit;
				unUsed = basketsYouHave - basketsUsed;
				if (unUsed < 0)
					{
						unUsed = 0;
					}
				
				System.out.println("If you put " + howManyFit + " eggs in " + basketsYouHave + " baskets, you would be left with ");
				System.out.println(+ mathResult + " eggs not in a basket and be left with " + unUsed + " unused baskets!");
				System.out.println("");
				
				int eggsStolen, totEggStol = 0;
				
				for (eggsStolen	= (eggsYouHave/8) ; eggsStolen <= eggsYouHave; eggsStolen = (eggsStolen*2))
					{
						if (eggsYouHave < 8)
							{
								eggsStolen = eggsYouHave;
							}
						System.out.println("Now I'm going to steal some eggs!");
						System.out.println("I've currently stolen " + eggsStolen + " eggs!");
						totEggStol = eggsStolen + totEggStol;
						
						if (totEggStol >= eggsYouHave)
							{
								totEggStol = eggsYouHave;
							}
					}
				
				System.out.println("I've stolen " + totEggStol + " eggs, and you are now eggless =)");
				
				keyboard.close();
			}
}
//if you have 4 eggs per basket, only 9 eggs, and 10 baskets you have 8 baskets left over with 1 egg out of a basket