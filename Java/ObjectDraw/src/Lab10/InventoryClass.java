package Lab10;
import java.io.*;
import java.util.Scanner;
public class InventoryClass
{
  private  int numTitles;
	private NewBookClass[] list;

  InventoryClass ()
	{ }

	public void getData() throws IOException
	{
		BufferedReader input = new BufferedReader (new FileReader("inventory.txt"));

                String str = input.readLine();
		numTitles = Integer.parseInt(str);

		list = new NewBookClass [numTitles];

		for(int i = 0; i < numTitles; i++)
		{
			 list[i] = new NewBookClass();
			 list[i].readInput(input);
		}
	}

	public void discount()
	{
		for ( NewBookClass f : list )
       	if (f.getSold() <= 0 )
         {
       		f.setCost((f.getCost()*0.9));
         }
	}

	public void displayInventory()
	 {
	   System.out.println( "The inventory is now");;
	   System.out.println( "Title\t\tQuantity\tCost\t\tBooks Sold");
	   for (int  i = 0; i <numTitles; i++)
	   	list[i].writeOutput();
	 }

	public void updateInventory() throws IOException
	{
          int subscript, quantitySold, numberTransactions;
           boolean found;
           String transactionTitle;
           Scanner keyboard = new Scanner (System.in);
           System.out.println("How many transactions do you have?");
           numberTransactions = keyboard.nextInt();

           for ( int i = 1; i <=numberTransactions; i++)
           {
               String emptyString = keyboard.nextLine();
            System.out.println("Enter the title of the transaction");
            transactionTitle = keyboard.nextLine();

            System.out.println("Enter amount");
            quantitySold = keyboard.nextInt();
            subscript = search( transactionTitle);
            if ( subscript >=0)
            {
                   list[subscript].setQuantity( list[subscript].getQuantity() - quantitySold);
            list[subscript].setSold(quantitySold);
            }
            else
                   System.out.println( transactionTitle + "was never found");
		}
	}


	  public int search(String key)
	  {
	   boolean found = false;
	    int i = 0;
	   while ( ! found && i < numTitles )
	   {
	  		  if( list[i].getTitle().equals(key)  ) {found = true;}
			  else {i++;}
	   }
	 	if ( found ) { return i; }
	 	else {return(-1);}
	  }

                public void sort ()
                {
                  int i, j, minSubscript;
                  for ( i = 0; i < numTitles -1; i++)
                  { minSubscript = i;
                    for ( j = i ; j < numTitles; j ++ )
                       if ( list [j]. getQuantity() < list[minSubscript].getQuantity() )
                         minSubscript = j;
                    swap ( i, minSubscript );
                  }
                }

                public void swap ( int first, int second )
                {  NewBookClass temp;
                   temp = list[first];
                   list[first] = list[second];
                   list[second] = temp;
         }

}