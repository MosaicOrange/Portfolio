package Lab13;
import java.io.*;
import java.util.*;
public class IntLinkedListDemo
{
  public static void main ( String [] args)throws IOException
  {
       IntLinkedListClass   myList  = new IntLinkedListClass();
       Scanner  keyboard = new Scanner ( System.in);
       System.out.println ( "Enter a positive integer to add on to the linked lists - - use -1 to terminate");
       int number =  keyboard.nextInt();
       while ( number >=0)
       {
           myList.insertAtBeginning(number);
           System.out.println ( "Enter a positive integer to add on to the linked lists - - use -1 to terminate");
           number =  keyboard.nextInt();
       }
       
       if (myList.isEmpty())
       {
    	   System.out.println ("The list is empty");
       }
       
       
       else
       {
    	   System.out.println ( " The list is now" );
           
    	   myList.printList();
       }
      
  }

}
