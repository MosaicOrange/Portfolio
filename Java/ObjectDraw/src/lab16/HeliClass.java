package lab16;
public class HeliClass
{
	private  Numbernode heli [];

	public void print (int number )
	{
		Namenode trav;
		trav = heli[number].link;
		System.out.println ( "The reservations for flight " + number + " are");
		if (trav !=null) {
			while ( trav !=null )
			{
				System.out.println ( "\t- " + trav.name );
				trav = trav.next;
			}
		} else {
			System.out.println ( "\t- No reservations have been currently made for this flight.");
		}
	}

	public HeliClass ()
	{
		   heli = new Numbernode[5];
		   int i;
		   for ( i = 0; i < 5; i++)
		      {
		      	heli[i] = new Numbernode ();
		      	heli[i].seatsLeft = 5;
		      	heli[i].link = null;
		      }
		   heli[1].seatsLeft = 4;
		   heli[2].seatsLeft = 4;
	}

	public void seatsLeft (int remainingSeats)
	{
		System.out.println("The numer of the available seats on flight #" + remainingSeats + " are/is " + heli[remainingSeats].seatsLeft);
	}

	public int flightNumber ( int inTime )
	{  int number;
		 if ( inTime >=700 && inTime <=1059)
		 	number = 0;
		 else if ( inTime >=1100 && inTime <=1359)
		 	 number = 1;
		 else if ( inTime >=1400 && inTime <=1559)
		 	 number = 2;
		 else if (inTime >=1600 && inTime <=1759)
		 	 number = 3;
		 else if (inTime >=1800 && inTime <=2359)
		 	 number = 4;
		 else number = -1;
		 return  number;
	}

	public void add ( int inTime, String newName )
	{  Namenode  temp = null, previous, current;
		previous = null;
		int number;
		number = flightNumber (inTime);
		current = heli[number].link;
		boolean found = false;
		
		String key = newName;
		while ( !found && current != null ) {
			if (current.name.compareTo (key) <= 0 ) {
					found = true;
					}
			else {
				previous = current;
				current = current.next ;
			}
		}
		

		 if ( heli[number]. seatsLeft == 0)
		 	System.out.println( " Sorry no seats available" );
		else
		{
		 temp = new Namenode ();
		 temp.name = newName;
		 if(previous == null)
			 heli[number].link = temp;
		 else
			 previous.next = temp;
		 
		 temp.next = current;
		 heli[number].seatsLeft --;
		}
		 System.out.println(newName + " arrives at " + inTime);
	}

	public void cancel ( String oldName, int oldTime, int oldFlightNumber)
	{
		int number;
		number = flightNumber (oldTime);
		if ( number != oldFlightNumber)
			System.out.println( "Not a valid flight number" );
		else
		{
			Namenode previous, current;
			previous = null;
			current = heli[number].link;
			boolean found = false;
			while ( !found && current!=null)
			{
				if ( current.name.equals(oldName))
					found = true;
				else
				{
					previous = current;
					current = current.next; 
				}
			}
			if ( current.next != null && found == true )
			{
				heli[number].link = heli[number].link.next ;
			}
			else if ( found == true )
				heli[number].link = null;
			else
				System.out.println ( oldName + " not scheduled on flight" + number );
		}
		 System.out.println(oldName + "'s reservation has been cancelled on flight #" + oldFlightNumber + " at " + oldTime + " hours");	 	
	}

}