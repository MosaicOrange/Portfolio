package PresentationNo2;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReadingInOutFromText
	{
	// Reading In/Out from a text file
		public static void main(String[] args)
			{
				System.out.print("Enter file name: ");
				Scanner keyboard = new Scanner(System.in);
				String file = keyboard.next();
				String fileName = "c:/java\\" + file;
				File fileLoc = new File("c:\\java/" + file); // When defining a path it must exist, cannot create
				if (!fileLoc.exists()) //checks to see if it exists
					{
						System.out.println("No file by that name.");
						System.exit(0);
					}
				if (!fileLoc.canRead()) //checks to see if allowed to read from file
					{
						System.out.println("You are disallowed access to that file.");
						System.exit(0);
					}
				// Reading out to a file
				PrintWriter outputStream = null; //allows ability to recall outside try/catch block
				try // necessary for data streams because they inherently create unnecessary errors
					{
						outputStream = new PrintWriter(new FileOutputStream(fileName, true));//appending
					}
				catch(FileNotFoundException e)
					{
						System.out.println("Error opening the file" + fileName);
						System.exit(0);
					}
				System.out.println("Enter three lines of text:");
				keyboard.nextLine();
				for (int count1 = 0; count1 < 3; count1++)
					{
						String line = keyboard.nextLine();
						outputStream.println(count1 + " " + line);
					}
				outputStream.close();
				System.out.println("Those lines were written to " + fileName);

				// Reading in from a file
				Scanner inputStream = null;
				System.out.print("\n\nThe file \"" + fileName + "\" contains the following lines:\n");
				try
					{
						inputStream = new Scanner(new File(fileName));// inputstream pulls in data
					}
				catch(FileNotFoundException e)
					{
						System.out.println("Error opening the file" + fileName);
						System.exit(0);
					}
				while (inputStream.hasNextLine())
					{
						String line = inputStream.nextLine();
						System.out.println(line);
					}

				// Methods in the class *File*
				System.out.println(fileLoc.getName());
				System.out.println(fileLoc.canRead());
				System.out.println(fileLoc.canWrite());
				System.out.println(fileLoc.exists());
				System.out.println(fileLoc.getPath());
				System.out.println(fileLoc.length());
				System.out.println(fileLoc.delete());				
				inputStream.close();
				keyboard.close();

				String fileName1 = "Transactions1.txt";
				try
					{
						Scanner inputStream1 = new Scanner(new File(fileName1));
						// Skip the header line by reading and ignoring it
						String line = inputStream.nextLine();
						// Total sales
						double total = 0;
						// Read the rest of the file line by line
						while (inputStream.hasNextLine()) // recursion in action
							{
								// Contains SKU,Quantity,Price,Description
								line = inputStream.nextLine();
								//Turn the string into an array of strings
								String[] ary = line.split(",");
								//Extract each item into an appropriate 
								//variable
								String SKU = ary[0];
								int quantity = Integer.parseInt(ary[1]);
								double price = Double.parseDouble(ary[2]);
								String description = ary[3];
								//Output item
								System.out.printf("Sold %d of %s (SKU: %s) at " + "$%1.2f each.\n", quantity, description, SKU, price);
								//Compute total
								total += quantity * price;
							}
						System.out.printf("Total sales: $%1.2f\n",total);
						inputStream.close( );
					}
				catch(FileNotFoundException e)
					{
						System.out.println("Cannot find file " + fileName1);
					}
				catch(IOException e)
					{
						System.out.println("Problem with input from file " + fileName1);
					}


				if (keyboard.hasNextInt())
					{
						System.out.println("Integers found!");
					}
			}
	}
//End part 1