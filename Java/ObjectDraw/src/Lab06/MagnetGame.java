package Lab06;


import objectdraw.*;
import java.awt.*;

public class MagnetGame extends WindowController
	{
	  private Magnet mag1, mag2;
      private Location intialPoint;
      private boolean magnetDrag1 = false, magnetDrag2 = false;


      public void begin()
	      {
	        Location upperLeft = new Location (150, 150);
	        Location lowerLeft = new Location (300, 300);
	        mag1 = new Magnet( upperLeft, canvas);
	        mag2 = new Magnet( lowerLeft, canvas);


	      }


      public void onMousePress(Location point)
	      {
			intialPoint = point;
			magnetDrag1 = mag1.contains(point);
			magnetDrag2 = mag2.contains(point);

	        if (magnetDrag1)
				{
					mag1.flip();

				}
			else if (magnetDrag2)
				{
					mag2.flip();
				}
			else {}

	      }

      public void onMouseDrag(Location point)
	      {
				if (magnetDrag1)
					{
						mag1.move(point.getX()-intialPoint.getX(), point.getY()-intialPoint.getY());
						intialPoint = point;
						mag1.interact(mag2);
					}
				else if (magnetDrag2)
					{
						mag2.interact(mag1);
						mag2.move(point.getX()-intialPoint.getX(), point.getY()-intialPoint.getY());
						intialPoint = point;
					}
				else {}
	     }

      public void onMouseRelease(Location point)
      	{
			magnetDrag1 = false;
			magnetDrag2 = false;
      	}
	}