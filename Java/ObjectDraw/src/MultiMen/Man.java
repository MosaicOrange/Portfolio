package MultiMen;

import objectdraw.*;
import java.awt.*;

public class Man
	{
		public static final int SIZE = 6;
		public int clickCount = 1;
		public FramedOval headFrame;
		public FilledOval headFill;
		public Line body, leftArm, rightArm, leftLeg, rightLeg;
		public Man ( double x, double y, DrawingCanvas canvas )
			{
				headFill = new FilledOval ( x-(SIZE/2), y-SIZE, SIZE, SIZE, canvas );
				headFrame = new FramedOval ( x-(SIZE/2), y-SIZE, SIZE, SIZE, canvas );
				body = new Line ( x, y, x, y+(SIZE*2), canvas );
				leftArm = new Line ( x, y+(SIZE/2), x-SIZE, y-(SIZE/2), canvas );
				rightArm = new Line ( x, y+(SIZE/2), x+SIZE, y-(SIZE/2), canvas );
				leftLeg = new Line ( x, y+(SIZE*2), x-SIZE, y+(SIZE*3), canvas );
				rightLeg = new Line ( x, y+(SIZE*2), x+SIZE, y+(SIZE*3), canvas );
		    }
		public Color getColor()
			{
				return headFill.getColor();
			}
		public void setColor(Color newColor)
			{
				headFill.setColor(newColor);
			}
		public void move(int dx, int dy)
			{
				headFill.move(dx,dy);
				headFrame.move(dx,dy);
				body.move(dx,dy);
				leftArm.move(dx,dy);
				rightArm.move(dx,dy);
				leftLeg.move(dx,dy);
				rightLeg.move(dx,dy);
			}
		public void moveTo(double zx, double zy)
			{
				headFill.moveTo( zx-(SIZE/2), zy-SIZE );
				headFrame.moveTo( zx-(SIZE/2), zy-SIZE );
				body.moveTo( zx, zy );
				leftArm.moveTo( zx, zy+(SIZE/2) );
				rightArm.moveTo( zx, zy+(SIZE/2) );
				leftLeg.moveTo( zx, zy+(SIZE*2) );
				rightLeg.moveTo( zx, zy+(SIZE*2) );
			}
		public void removeFromCanvas()
			{
				headFill.removeFromCanvas();
				headFrame.removeFromCanvas();
				body.removeFromCanvas();
				leftArm.removeFromCanvas();
				rightArm.removeFromCanvas();
				leftLeg.removeFromCanvas();
				rightLeg.removeFromCanvas();
			}
		public Boolean contains(Location point)
			{
				return (headFill.contains(point) || headFrame.contains(point) ||
						body.contains(point) || leftArm.contains(point) ||
						rightArm.contains(point) || leftLeg.contains(point) ||
						rightLeg.contains(point));
			}
	}