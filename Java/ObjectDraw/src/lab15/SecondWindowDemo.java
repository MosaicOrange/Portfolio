package lab15;
import java.awt.*; // needed for the Color class


public class SecondWindowDemo
{
	public static void main ( String [ ] args)
	{
		 SecondWindow  window1 = new SecondWindow( );
		 window1.setVisible(true);
		 
		 SecondWindow window2 = new SecondWindow(Color.orange);
		 window2.setVisible ( true);
	}
}