package Lab09;
import java.io.*;
public class BookClass
{
	private  String title;
	private int quantity;



	BookClass()
	{
		 title = "No name";
		 quantity = 0;
	}


	public void readInput(BufferedReader  input) throws IOException
	{
		title = input.readLine();

		String str = input.readLine();
		quantity = Integer.parseInt(str);
	}



	public void writeOutput()
	{
		System.out.print(title + "    ");
		System.out.println( " \t " +quantity);
	}

	public int getQuantity( )
    {   return quantity;      }

public void setQuantity ( int newQuantity )
    {   quantity = newQuantity;     }

public void setTitle ( String newTitle )
     {    title = newTitle;      }

public String  getTitle ( )
  {   return title;   }


}