package lab16;
import java.io.*;
import java.util.*;
public class HeliDemo
{
  public static void main (String [] args )throws IOException
	{     int number, time, seatsLeft;
		HeliClass helicopter = new HeliClass();

		BufferedReader input = new BufferedReader ( new FileReader ( "fly.txt"));
		String newString = input.readLine ();

		String code;
		while ( newString !=null )
			{
				//System.out.println ( "echo printing " + newString );
				StringTokenizer tokens = new StringTokenizer (newString );
				code = tokens.nextToken ();
				System.out.println ( "\nCode is " + code);
				if ( code.equals ( "Arrival") )
					{     String name = tokens.nextToken ();
						String strTime = tokens.nextToken ();
						time = Integer.parseInt (strTime);
		
						helicopter.add( time,name );
					}
				else if ( code.equals ("Print" ))
					{
						String strnumber = tokens.nextToken ();
						number = Integer.parseInt (strnumber);
						helicopter.print (number);
					}
				else if (code.equals ("Seats"))
					{	
						String seatString = tokens.nextToken();
						seatsLeft = Integer.parseInt(seatString);
						helicopter.seatsLeft(seatsLeft);
					}
				else if ( code.equals ("Cancel"))
					{
						String name = tokens.nextToken ();
						String strTime = tokens.nextToken ();
						time = Integer.parseInt ( strTime );
						String strFlight = tokens.nextToken ();
						int flight = Integer.parseInt ( strFlight);
						helicopter.cancel ( name, time,flight);
					}
				     else
				     	System.out.println ( "Error" );
				newString = input.readLine ();
				}
			}
	}