package Lab13;

import java.io.*;
import java.util.Scanner;
public class LinkedListDemo
{


	public static void main ( String [] args)throws IOException
	{
		Scanner keyboard = new Scanner (System.in);
		LinkedListClass facultyList = new LinkedListClass ( );
		BufferedReader input = new BufferedReader ( new FileReader ("faculty.txt"));
		String numString = input.readLine ();
		int numberOfFaculty = Integer.parseInt (numString );
		for ( int i = 1; i <= numberOfFaculty; i ++ )
		{
			String name = input.readLine ();
                        facultyList.insertInOrder( name );
			System.out.println ( "inserting name " + name );
		}

		System.out.println ( "The list at the end is " );
		facultyList.displayList ();
      
		System.out.println("Please enter another name"); 
		facultyList.insertAtEnd ("Mr. McGoo");
		facultyList.displayList ();
		
		String delete;
		System.out.println("What name would you like to delete?");
		delete= keyboard.nextLine();
		facultyList.delete(delete);
		facultyList.displayList(); 
		
		 String oldName = (String)   facultyList.getFirst ();
	     System.out.println("Printing the first name " + oldName ) ;
	}
}