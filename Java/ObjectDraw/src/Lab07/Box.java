package Lab07;
import objectdraw.*;
import java.awt.*;

public class Box {

	       private int top;
	       private RandomIntGenerator intGen;
	       private FilledRect theBox;


	        // Constructing a new box
	        // Parameters
	        // boxSize - the Width and height of the box
	        // leftExtreme, right Extreme - the extreme values for the left and right side of the screen -
	        // needed for the random number generator and placing the box on the screen
	        //  theTop is the top row of the box

	       public Box(int boxSize, int leftExtreme, int rightExtreme, int theTop, DrawingCanvas c)
	        {
	          intGen = new RandomIntGenerator (leftExtreme,rightExtreme);
	          int xValue = intGen.nextValue ();
	          Location  topLeftCorner = new Location ( xValue, theTop);
	          top = theTop;  // save the value of theTop in the instance variable top
	          theBox = new FilledRect ( topLeftCorner, boxSize, boxSize, c);

	        }


	        // Move the box to a random location at the bottom of the playing area.
	        public void moveBox()
	        {
	          int xValue = intGen.nextValue();
	          theBox.moveTo(xValue,top);
	        }

	        // Set the width of the box.

	    public void setSize(int boxSize)
	        {
	    		theBox.setWidth(boxSize);
	        }

	        // Return the x position of the left edge of the box
	        // Replace the return statement with the correct code.

	        public double getLeft()
	        {
	                return theBox.getX();
	        }

	        // Return the x position of the right edge of the box
	        // Replace the return statement with the correct code.

	        public double getRight()
	        {
	        		return theBox.getX()+theBox.getWidth();
	        }

}
