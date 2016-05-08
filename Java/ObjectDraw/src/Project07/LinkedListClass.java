package Project07;
import java.lang.*;
import java.util.Scanner;
public class LinkedListClass {
	private LinkedNode  head;

	public LinkedListClass() { head = null; }

	public boolean isEmpty( ) {
		if ( head == null) { return true; }
		else { return false; }
	}
	
	public void deleteStudent (String studentName) {
		LinkedNode current = head;
		LinkedNode previous = null;
		boolean found = false;
		while ( !found&&current!=null ) {
			if ( current.data.equals(studentName) ) { found = true; }
			else {
    			 previous=current;
    			 current=current.next;
			}
		}
		if ( previous == null && found ) { head=head.next; }
		else {
			if ( found == true ) {
				previous.next=current.next;
			} else { System.out.println( studentName + " never found"); }
		}
	}

	public void searchStudent (String studentName) {
		LinkedNode current = head, previous = null;
		boolean found = false;
		while ( !found && current != null ) {
			if ( current.data.equals(studentName) ) { found = true; }
			else {
    			 previous=current;
    			 current=current.next;
			}
		}
		if ( previous == null && found ) {
				head=head.next;
		} else { 
			if ( found == true ) {  System.out.print("\n" + studentName + " is a CS Major");  }
    		else { System.out.print("\n" + studentName + " never found"); }
		}
	}
	
	public void addStudent (String studentName) {
		LinkedNode  previous, current;
		LinkedNode temp = new LinkedNode ( studentName);
		boolean found = false;
		current = head;
		previous = null;
		String key = (String ) studentName;
		while ( !found && current != null ) {
			String firstValue = (String)  current.data;
			if ((key).compareTo (firstValue) <0 ) { found = true; }
			else {
				previous = current;
				current = current.next ;
			}
		}
		temp.next = current;
		if (previous == null ) { head = temp; }
		else { previous.next =temp; }
	}

	public void printList () {
		LinkedNode current = head;
		while ( current != null ) {
			current.displayNode();
			current = current.next;
		}
		System.out.print ( "null" );
	}
	
}