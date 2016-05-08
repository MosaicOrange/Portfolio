package PresentationNo1;

public class ForEachStatements
	{
		public static void main(String[] args)
			{
				int[] ar ={1, 2, 3};
				int sum = 0;
				for (int d : ar)
					{
						sum += d;
						System.out.print(sum + ", ");
					}
		
				System.out.println("\nFinal Evaluation is: " + sum + "\n\nThe proceeding is using a ~for-each~ statement. Next we have the same loop done as a traditional ~for~ loop.\n");
				
				sum = 0;
		
				for (int i = 0; i < ar.length; i++)
					{
						sum +=ar[i];
						System.out.print(sum + ", ");
					}
		
				System.out.println("\nFinal Evaluation is: " + sum);
		
				System.out.println("\nResource used is http://www.leepoint.net/notes-java/flow/loops/foreach.html");
			}
	}