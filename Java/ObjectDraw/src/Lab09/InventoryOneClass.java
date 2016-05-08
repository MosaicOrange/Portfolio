package Lab09;
import java.io.*;
public class InventoryOneClass
{
        private  int numTitles;
	private BookClass[] list;


  public InventoryOneClass ()
	{

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
  private  void swap ( int first, int second )   // first and second are just subscripts
  {  
               BookClass temp;
               temp = list[first];
               list[first] = list[second];
               list[second] = temp;
    }

  public void sort ()
  {
                 int i, j, minSubscript;

                 for ( i = 0; i < numTitles-1; i++)
                 { 
                        minSubscript = i;
                        for ( j = i ; j < numTitles; j ++ )
                                 {
                                      if ( list [j].getQuantity( )   < list[minSubscript].getQuantity ( ))
                                               minSubscript = j;
                                  }

                        swap ( i, minSubscript );
                 } 
     }
  
	public void getData() throws IOException
	{
		BufferedReader input = new BufferedReader(new FileReader("indata.txt"));

		String str = input.readLine();
		numTitles = Integer.parseInt(str);

		list = new BookClass [numTitles];


		for(int i = 0; i < numTitles; i++)
		{
			 list[i] = new BookClass();
			 list[i].readInput(input);
		}
	}



	public void displayInventory()
	{
	    System.out.println( "The inventory is now");
	    System.out.println( " Title        Quantity");
	    for (int  i = 0; i <= numTitles -1; i++)
	   	   list[i].writeOutput();
	}




}