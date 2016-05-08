package Lab05;

import objectdraw.*;
import java.awt.*;

public class Tshirt
	{
		private static final double SIZE = 120;

		private static final double SLEEVE_WIDTH = SIZE;
		private static final double SLEEVE_HEIGHT = 0.2 * SIZE;

		private static final double  BODY_WIDTH = 0.6 * SIZE;

		private static final double BODY_HEIGHT = (0.65)*SIZE;

		private static final double BODY_INSET = 0.2*SIZE;

		private static final double NECK_WIDTH = 0.3*SIZE;
		private static final double NECK_HEIGHT = 0.06*SIZE;

		private static final double NECK_INSET = 0.35*SIZE;

		private Color newColor;
		private FramedRect sleeveTrim, bodyTrim;
		private FramedOval neckTrim;

		private FilledRect body, sleeves;
		private FilledOval neck;

		public Tshirt( double x, double y, DrawingCanvas canvas )
			{
				sleeveTrim = new FramedRect( x, y + NECK_HEIGHT/2, SLEEVE_WIDTH, SLEEVE_HEIGHT, canvas);
				bodyTrim = new FramedRect( x + BODY_INSET, y + NECK_HEIGHT/2, BODY_WIDTH, BODY_HEIGHT, canvas);
				
				sleeves = new FilledRect( x+1, y+NECK_HEIGHT/2+1, SLEEVE_WIDTH-1, SLEEVE_HEIGHT-1, canvas);
				body = new FilledRect( x+BODY_INSET+1, y+NECK_HEIGHT/2+1, BODY_WIDTH-1, BODY_HEIGHT-1, canvas);
				
				neck = new FilledOval( x + NECK_INSET, y, NECK_WIDTH, NECK_HEIGHT, canvas);
				neckTrim = new FramedOval( x + NECK_INSET, y, NECK_WIDTH, NECK_HEIGHT, canvas);
				
				body.setColor(Color.white);
				neck.setColor(Color.white);
				sleeves.setColor(Color.white);
			}
		public void move( double xOffset, double yOffset )
		  	{
				body.move(xOffset,yOffset);
				neck.move(xOffset,yOffset);
				sleeves.move(xOffset,yOffset);
				bodyTrim.move(xOffset,yOffset);
				sleeveTrim.move(xOffset,yOffset);
				neckTrim.move(xOffset,yOffset);
			}

		public void moveTo( double x, double y)
		  	{
			  move( x - sleeves.getX(), y - neck.getY());
		  	}
		public boolean contains( Location pt)
		  	{
			  return body.contains(pt) || sleeves.contains(pt) || neck.contains(pt);
		  	}

		public void setColor (Color newColor)
		  	{
				body.setColor(newColor);
				neck.setColor(newColor);
				sleeves.setColor(newColor);
				bodyTrim.setColor(Color.black);
				sleeveTrim.setColor(Color.black);
				neckTrim.setColor(Color.black);
		  	}

		public Color getColor ()
		  	{
				return body.getColor();
		  	}
	}