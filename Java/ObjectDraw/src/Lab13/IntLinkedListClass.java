package Lab13;
import java.util.*;
public class  IntLinkedListClass
{
  private  IntLinkedNode   head;

  public IntLinkedListClass()
  {   head = null;
  }

  public boolean isEmpty ()
  {
    if ( head == null)
      return true;
    else
      return false;
   }

  public void insertAtBeginning ( int newValue)
  {
       IntLinkedNode  temp = new IntLinkedNode ( newValue);
       temp.next = head;
       head = temp;
  }

  public void printList ()
  {     IntLinkedNode  trav = head;
        while ( trav !=null)
        {
            trav.displayNode();
            trav = trav.next;
          }
        //System.out.println ( " null  ");
  }

  public void deleteFirst ()   throws NoSuchElementException
  {
       IntLinkedNode   temp = head;
       if ( head != null)
         head = head.next;
       else
       {
         throw   new NoSuchElementException ( " can't delete, no item on the list" );
       }
  }

  public void insertAtEnd ( int newValue)
  {
        IntLinkedNode   trav, temp;
        temp = new IntLinkedNode ( newValue);
        temp.next = null;
        trav = head;
        if ( trav == null )
          head = temp;
        else
        {
           while ( trav.next !=null)
             trav = trav.next;
           trav.next = temp;
        }
  }


}
