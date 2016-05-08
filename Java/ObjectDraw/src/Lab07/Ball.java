package Lab07;
import objectdraw.*;
import java.awt.*;

public class Ball extends ActiveObject {

	// Name:
	// Lab:
	// Ball used in boxball.  It is created at a location and fall toward the bottom
	// of the screen. When it reaches the bottom, it determines if it landed in the
	// box or not and updates a message to the user accordingly.


		      private int ballSize;

		      private FilledOval  theBall;

		      // the box the ball is aiming for
		      private Box theBox;

		      // the bottom of the playing area
		      private int courtBottom;

		      // the message giving feedback to the user
		      private Text score;

	// Construct a new ball and start it falling
	// ballsize - the size of the ball
	//point - where the ball should be displayed initially
	//c- the canvas to draw the ball on
	// the Box- the box to try to land in
	//  score - the mesage to diaply to the uer

	        // Add the parameters that you need.
	        public Ball(int ballSize, Location point, DrawingCanvas c, Box theBox, int courtBottom, Text score)
	        {
	        	theBall = new FilledOval (point,ballSize,ballSize,c);
	        	this.ballSize = ballSize;
	        	this.theBox = theBox;
	        	this.score = score;
	        	this.courtBottom = courtBottom;
	        	start();
	        }

	  
	      // retunrs true if this componet is inside theBox, false otherwise
	      public boolean insideBox ()
		    {
		    	boolean  leftIn, rightIn;
		    	if ( theBall.getX() > theBox.getLeft() )
		    	{ leftIn = true; }
		    	else
		    	{ leftIn = false; }
		    	if (theBall.getX() < theBox.getRight()-ballSize )
		    	{ rightIn = true; }
		    	else
		    	{ rightIn = false; }
		    	if ( leftIn == true && rightIn == true)
		    	{ return true; }
		    	else
		    	{ return false ; }
		    }
	            

	        public void run()
	        {
	                final int dropIncrement = 10;

	                while ( theBall.getY() < courtBottom-(ballSize+dropIncrement) )
	                {
	                        theBall.move ( 0, dropIncrement);
	                        pause(50);
	                }

	                // Add the code that should be executed when you reach the bottom of the
	                // playing area.
	               if ( insideBox () )
	              	{
	              	score.setText ("You got it in!");
	              	theBox.moveBox ();
	              }
	              else
	              {	score.setText ("Try again!");
	              }
	              theBall.hide ();


	        }// end method run
	        

}
