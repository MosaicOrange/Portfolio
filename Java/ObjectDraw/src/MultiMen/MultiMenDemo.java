package MultiMen;

import objectdraw.*;
import java.awt.*;

public class MultiMenDemo extends WindowController
	{
		private Man jumpingMan;

		public void begin ()
			{
				jumpingMan = new Man (150, 100, canvas);
			}

		public void onMouseRelease(Location point)
			{
				Location depressed = point;
				double xx = depressed.getX();
				double yy = depressed.getY();
				jumpingMan = new Man ( xx, yy, canvas);
			}
		public void onMouseExit(Location point)
			{
				jumpingMan.setColor(Color.white);		
			}

		public void onMouseEnter(Location point)
			{
				jumpingMan.move(20,20);		
			}

		public void onMouseDrag(Location point)
			{
				jumpingMan.removeFromCanvas();		
			}

		public void onMouseClick(Location point)
			{
				Location clicked = point;
				double xy = clicked.getX();
				double yx = clicked.getY();
				jumpingMan.moveTo(xy,yx);		
			}
	}
