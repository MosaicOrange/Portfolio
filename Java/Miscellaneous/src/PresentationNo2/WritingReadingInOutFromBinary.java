package PresentationNo2;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WritingReadingInOutFromBinary
	{
	// Writing/Reading In/Out from a binary file
		public static void main(String[] args)
			{
				String fileName = "numbers.dat";
	
				// Writing to a binary File
				try
					{
						ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
						Scanner keyboard = new Scanner(System.in);
						System.out.println("Enter nonnegative integers.");
						System.out.println("Place a negative number at the end.");
						int anInteger;
						do //recursion in action
							{
								anInteger = keyboard.nextInt();
								outputStream.writeInt(anInteger);
							} while (anInteger >= 0);
						System.out.println("Numbers and sentinel value");
						System.out.println("written to the file " + fileName);
						outputStream.close();
					}
				catch(FileNotFoundException e)
					{
						System.out.println("Problem opening the file " + fileName);
					}
				catch(IOException e)
					{
						System.out.println("Problem with output to file " + fileName);
					}
	
				// Reading from a binary File
				
				try
					{
						ObjectInputStream inputStream =
						new ObjectInputStream(new
						FileInputStream(fileName));
						System.out.println("Reading ALL the integers");
						System.out.println("in the file " + fileName);
						try
							{
								while (true)
									{
										int anInteger = inputStream.readInt();
										System.out.println(anInteger);
									}
							}
						catch(EOFException e)
							{
								System.out.println("End of reading from file.");
							}
							inputStream.close();
					}
				catch(FileNotFoundException e)
					{
						System.out.println("Cannot find file " + fileName);
					}
				catch(IOException e)
					{
						System.out.println("Problem with input from file " + fileName);
					}
			}
	}
//End part 2