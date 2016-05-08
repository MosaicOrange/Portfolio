package Miscellaneous;

import java.util.Scanner;

public class ToDosWithEnumSwitch
	{
		public enum Day { THURS, FRI, SAT, SUN, MON, TUES, WED } 
	
		public static void main(String[] args)
			{
				String message = "";
				String endMessage= "";
				Scanner keyboard = new  Scanner(System.in);
				
				for ( Day d: Day.values() )
					{
						switch (d)
							{
								case MON:
									System.out.println("Please input a Monday TO DO.");
									message = keyboard.nextLine();
									endMessage = endMessage + "Mon:\t" + message + "\n";
									break;

								case TUES:
									System.out.println("Please input a Tuesday TO DO.");
									message = keyboard.nextLine();
									endMessage = endMessage + "Tue:\t" + message + "\n";
									break;

								case WED:
									System.out.println("Please input a Wednesday TO DO.");
									message = keyboard.nextLine();
									endMessage = endMessage + "Wed:\t" + message + "\n";
									break;

								case THURS:
									System.out.println("Please input a Thursday TO DO.");
									message = keyboard.nextLine();
									endMessage = endMessage + "Thurs:\t" + message + "\n";
									break;

								case FRI:
									System.out.println("Please input a Friday TO DO.");
									message = keyboard.nextLine();
									endMessage = endMessage + "Fri:\t" + message + "\n";
									break;
									
								case SAT:
									System.out.println("Please input a Saturday TO DO.");
									message = keyboard.nextLine();
									endMessage = endMessage + "Sat:\t" + message + "\n";
									break;

								case SUN:
									System.out.println("Please input a Sunday TO DO.");
									message = keyboard.nextLine();
									endMessage = endMessage + "Sun:\t" + message + "\n";
									break;

								default:
									System.out.println("This should never be reached!");
									break;
							}
					}
				System.out.println("The week's To Do list is:  \n");
				System.out.println(endMessage);
			}
	}