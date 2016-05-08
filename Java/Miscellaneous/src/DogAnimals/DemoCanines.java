package DogAnimals;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class DemoCanines
	{
		public static void main(String[] args)
			{
				
				Canine[] K9s 	= new Canine[3];
				K9s[0]		= new Dog ("Fido", "Woof",  20.4 );
				K9s[1]		= new Dog ("Buddy", "Bark",  10.1 );
				K9s[2]		= new Wolf("Lobo", "Howl",  75.5 );
				Arrays.sort(K9s);
				System.out.println(K9s[0]);
				System.out.println(K9s[1]);
				System.out.println(K9s[2]);
				
				String fileName = "h:/RIFCanine.txt";  //must use "/" to indicate the fully qualified path
		
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

		        outputStream.println("Ronald I. Frank + K9s[0]" + K9s[0]);
		        outputStream.println("Ronald I. Frank + K9s[1]" + K9s[1]);
		        outputStream.println("Ronald I. Frank + K9s[2]" + K9s[2]);
		        outputStream.close( );
		        System.out.println("My dat was written to " +  fileName + "\n");
			}
	}