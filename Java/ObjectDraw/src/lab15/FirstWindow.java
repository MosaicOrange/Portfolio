package lab15;
import javax.swing.*;

public class FirstWindow extends JFrame
{
	  public static final int WIDTH = 500;
	  public static final int HEIGHT = 400;
	 
    public FirstWindow () 
	  { 
	  	super ()	;
		  setSize( WIDTH,HEIGHT);
		 
		  JLabel myLabel = new JLabel ( " Please don't eat the daisies." );
		  getContentPane (). add(myLabel);
		  
		  WindowDestroyer listener = new WindowDestroyer();
		  addWindowListener( listener);
		 
		  setVisible ( true);
	}
	
	
}