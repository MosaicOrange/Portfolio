package PresentationNo1;

public class ForStatements
	{
		public static void main(String[] args)
			{
				int countDown;
				for (countDown = 3; countDown > 0; countDown = countDown - 1) {
																// The ~ for ~ statement assigns a value to a given variable,
																// the evaluates the boolean expression and keeps going while
																// it's true, then it adds a modifier to the variable.
					System.out.print(countDown);
					System.out.println(" and counting.");
				}												// Ends the ~ for ~ statement
	
				System.out.println("0 and BLAST OFF!");
			}
	}