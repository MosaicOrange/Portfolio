package CatAnimals;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class DemoFelines
	{

		public static void main(String[] args)
			{
				Feline[] kittys 	= new Feline[3];
				kittys[0]		= new Cat ("Joao", "Stripped", "Mew",  24.3 );
				kittys[1]		= new Panther ("Pinto", "Black", "Growl",  90.7 );
				kittys[2]		= new Panther ("Turtle", "Splotchy", "Howl",  78.4 );
	
				Arrays.sort(kittys);
				System.out.println(kittys[0] + "" + kittys[1] + "" + kittys[2]);
				
				if ((kittys[0].compareTo(kittys[1]) == 1) && (kittys[0].compareTo(kittys[2]) == 1))
					{
						if (kittys[1].compareTo(kittys[2]) == 1)
							{
								System.out.println("In size order: " + kittys[0].name + ", " + kittys[1].name + ", " + kittys[2].name + ".");
							}
						else if (kittys[2].compareTo(kittys[1]) == 1)
							{
								System.out.println("In size order: " + kittys[0].name + ", " + kittys[2].name + ", " + kittys[1].name + ".");
							}
						else
							{
								System.out.println("Kittys are not allowed to be the same size.");
							}
					}
				else if ((kittys[1].compareTo(kittys[0]) == 1) && (kittys[1].compareTo(kittys[2]) == 1))
					{
						if (kittys[0].compareTo(kittys[2]) == 1)
							{
								System.out.println("In size order: " + kittys[1].name + ", " + kittys[0].name + ", " + kittys[2].name + ".");
							}
						else if (kittys[2].compareTo(kittys[0]) == 1)
							{
								System.out.println("In size order: " + kittys[1].name + ", " + kittys[2].name + ", " + kittys[0].name + ".");
							}
						else
							{
								System.out.println("Kittys are not allowed to be the same size.");
							}
					}
				else if ((kittys[2].compareTo(kittys[1]) == 1) && (kittys[1].compareTo(kittys[0]) == 1))
					{
						if (kittys[0].compareTo(kittys[1]) == 1)
							{
								System.out.println("In size order: " + kittys[2].name + ", " + kittys[0].name + ", " + kittys[1].name + ".");
							}
						else if (kittys[1].compareTo(kittys[0]) == 1)
							{
								System.out.println("In size order: " + kittys[2].name + ", " + kittys[1].name + ", " + kittys[0].name + ".");
							}
						else
							{
								System.out.println("Kittys are not allowed to be the same size.");
							}
					}
				else
					{
						System.out.println("Kittys are not allowed to weigh the same");
					}
	
				
				String fileName = "Feline.txt";  //must use "/" to indicate the fully qualified path
	
		        PrintWriter outputStream = null;
		        
		        try
			        {
			            outputStream = new PrintWriter(fileName);
			        }
		        catch(FileNotFoundException e)
			        {
			            System.out.println("Error opening the file in OUTPUT " + fileName);
			            System.exit(0);
			        }
		        outputStream.println("Joao M. Pinto + kittys[0]" + kittys[0]);
		        outputStream.println("Joao M. Pinto + kittys[1]" + kittys[1]);
		        outputStream.println("Joao M. Pinto + kittys[2]" + kittys[2]);
		        outputStream.println("");
		        outputStream.close();
		        System.out.println("My dat was written to " +  fileName + "\n");
			}
	}