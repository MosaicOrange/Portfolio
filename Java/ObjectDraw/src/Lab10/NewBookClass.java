package Lab10;
import java.io.*;
public class NewBookClass
{
	private  String title;
	private int quantity, booksSold = 0;
	private double cost;

	NewBookClass()
	{
		 title = "No name";
		 quantity = 0;
		 cost = 0.0;
	}



public void readInput(BufferedReader input) throws IOException
	{
		title = input.readLine();

		String str = input.readLine();
		quantity = Integer.parseInt(str);

        str = input.readLine();
		cost = Double.parseDouble(str);
	}

	public void writeOutput()
	{
		System.out.print(title + "     \t" + quantity + "\t\t"); 
				System.out.printf("%.2f",cost);
				System.out.println("\t\t" + booksSold);				
	}


	public String getTitle()
	{
		return title;
	}


	public int getQuantity()
	{
		return quantity;
	}


	public double getCost()
	{
		 return cost;
	}
	
	public void setCost ( double z)
	{
		cost = z;
	}
	
	public int getSold()
	{
		 return booksSold;
	}

	public void setQuantity( int y)
	{
		quantity = y;
	}

	public void setSold( int x)
	{
		booksSold = x;
	}
}