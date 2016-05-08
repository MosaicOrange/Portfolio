package Lab06;

import objectdraw.*;
import java.awt.*;


        // Skeletal definition of class of objects used to represent bar magnets
        //
        // Please complete the implementation of these methods and add the others
        //  described in the lab handout.
public class Magnet {

        private static final double MAGNET_WIDTH = 150;	// dimensions of magnets
        private static final double MAGNET_HEIGHT = 50;
        private static final double POLE_DISTANCE = MAGNET_HEIGHT/2;


        Pole northPole, southPole;				// North pole & South pole
        FramedRect magSquare;                                      	// Box representing perimeter of magnet

    public Magnet ( Location point, DrawingCanvas canvas)
    	{
    		magSquare = new FramedRect ( point, MAGNET_WIDTH, MAGNET_HEIGHT, canvas);
	    	northPole = new Pole ( this, point.getX() + POLE_DISTANCE, point.getY() + POLE_DISTANCE, "N", canvas);
	    	southPole = new Pole ( this, point.getX() + (magSquare.getWidth() - POLE_DISTANCE), point.getY() + POLE_DISTANCE, "S", canvas);
    	}

        // accessor methods
        // returns the upper-left coordinates of the magnet
        public Location getLocation()
        {
        	return magSquare.getLocation();
        }

        public Pole getNorth ()
        {
        	return northPole;        	
        }

        public Pole getSouth ()
        {
        	return southPole;
        }

        // This should return true if the given point is within the magnet.  The current
        // implementation does not do this!!!  You must change the body of this method so
        // that it has the proper functionality!!!
        public boolean contains( Location point ) {
            return magSquare.contains(point);   // REPLACE THIS LINE OF CODE WITH THE CORRECT IMPLEMENTATION
        }

        // returns the width of the magnet
        public double getWidth() {
                return magSquare.getWidth();
        }

        // returns the height of the magnet
        public double getHeight() {
            return magSquare.getHeight();
        }


        public void move(double xoff, double yoff)
        {
        	magSquare.move(xoff, yoff);
        	northPole.move(xoff, yoff);
        	southPole.move(xoff, yoff);
        }

        // mutator methods
        public void moveTo( Location point)
        {
            double dx, dy;
            dx = point.getX() - magSquare.getX();
            dy = point.getY() - magSquare.getY();
            magSquare.move(dx,dy);
            northPole.move(dx,dy);
            southPole.move(dx,dy);
        }

      public void flip ()
        {
    	  double x1, x2;
          x2 = northPole.getX();
          x1 = southPole.getX();
          northPole.move(x1-x2, 0);
          southPole.move(x2-x1, 0);
        }


      public void interact ( Magnet other)
       {
    	  northPole.attract(other.getSouth());
    	  southPole.attract(other.getNorth());
    	  northPole.repel(other.getNorth());
    	  southPole.repel(other.getSouth());
        }

}
