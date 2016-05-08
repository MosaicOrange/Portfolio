package lab15;
import javax.swing.*;
import java.awt.event.*;
public class FirstSwingDemo 
{
	  public static final int WIDTH = 500;
	  public static final int HEIGHT = 400;
	 
   public static void main (String [] args)
	{
		 JFrame myWindow = new JFrame();
		 myWindow. setSize( WIDTH,HEIGHT);
		 
		 JLabel myLabel = new JLabel( "Please don't eat the daisies");
		 JLabel secondLabel = new JLabel( "I don't like to eat the daisies");
		 myWindow.getContentPane ().add(myLabel);
		 myWindow.getContentPane ().add(secondLabel);
		 
		 WindowDestroyer listener = new WindowDestroyer();
		 myWindow.addWindowListener( listener);
		 
		 myWindow. setVisible ( false);
		 
		 JFrame myWindow1 = new JFrame();
		 myWindow1. setSize( HEIGHT, WIDTH);
		 
		 myWindow1.getContentPane ().add(myLabel);
		 myWindow1.getContentPane ().add(secondLabel);
		 
		 WindowDestroyer listener1 = new WindowDestroyer();
		 myWindow1.addWindowListener( listener1);
		 
		 myWindow1. setVisible ( true);

	}
	
}