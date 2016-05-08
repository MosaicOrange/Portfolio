package Lab13;
import java.lang.*;
public class LinkedListClass
{
	private LinkedNode  head;

	public LinkedListClass( )
		{
			 head = null;
		}

	public boolean isEmpty( )
		{
			if ( head == null)
				return true;
			else
				return false;
		}

	public void insertAtBeginning ( Object newData)
		{
			LinkedNode  newLink = new LinkedNode ( newData);
			newLink.next = head;
			head = newLink;
		}

	public void insertAtEnd ( Object newData)
		{
			LinkedNode  trav, temp;
			temp = new LinkedNode ( newData);
			temp.next = null;
			trav = head;
			if ( trav == null )
				 head = temp;
			else
				{
					while ( trav.next !=null )
					trav = trav.next;
					trav.next = temp;
			   }
		}

	public Object deleteFirst ()
	{
		LinkedNode temp = head;
		head = head.next;
		return temp.data;
	}

        public Object getFirst ()
        {
           return head.data ;
        }
     
     public LinkedNode delete (String key)
     {
    	 LinkedNode current = head;
    	 LinkedNode previous = null;
    	 boolean found = false;
    	 
    	 while(!found&&current!=null)
    	 {
    		 if(current.data.equals(key))
    			 found=true;
    		  else
    		 {
    			 previous=current;
    			 current=current.next;
    					
    		 }
    	 }
    	 if(previous==null&&found==true)
    		 head=head.next;
    		 else 
    			 if(found==true)
    				 previous.next=current.next;
    			 else
    				 System.out.println(key+ "never found");
    	 return current;
     }
     
     
	public void displayList ( )
	{
	   LinkedNode current = head;
	   while ( current !=null)
	     {
		current.displayNode();
		current =current.next;
              }
           System.out.println ( "null" );
	}

  public void insertInOrder (Object newData)
  {  
	  LinkedNode  previous, current;
     LinkedNode temp = new LinkedNode ( newData);
     boolean found = false;
     current = head;
     previous = null;
     String key = (String ) newData;
     while ( ! found &&current!=null )
     {   String firstValue= (String )  current.data;
         //if ( newData .compareTo( current.data)<0 )
         if ((key).compareTo (firstValue) <0 )
                 found = true;
         else
            {
             previous = current;
             current = current.next ;
             }
     }
     temp.next = current;
     if (previous == null )
          head = temp;
     else
          previous.next =temp;
    }

}
