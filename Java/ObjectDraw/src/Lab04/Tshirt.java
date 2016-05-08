package Lab04;
import objectdraw.*;
import java.awt.*;

public class Tshirt
{
	  private static final double SIZE = 120;

	  private static final double SLEEVE_WIDTH = SIZE;
	  private static final double SLEEVE_HEIGHT = 0.2 * SIZE;

	  private static final double  BODY_WIDTH = 0.6 * SIZE;


    private static final double BODY_HEIGHT = (0.65)*SIZE;

        // horizontal inset of body from sleeve
    private static final double BODY_INSET = 0.2*SIZE;

        // size of neck
    private static final double NECK_WIDTH = 0.3*SIZE;
    private static final double NECK_HEIGHT = 0.06*SIZE;

        // horizontal inset of neck from sleeve
    private static final double NECK_INSET = 0.35*SIZE;


    private FramedRect sleeveTrim, bodyTrim;    // rectangles that form a
    private FramedOval neckTrim;                // border around the shirt

    private FilledRect body, sleeves;           // rectangles that form the
    private FilledOval neck;                    // interior color of the shirt


    // create a new T-shirt with its upper left corner at (x,y)
    public Tshirt( double x, double y, DrawingCanvas canvas )
    {
            // create boundary rectangles
        sleeveTrim = new FramedRect( x, y + NECK_HEIGHT/2, SLEEVE_WIDTH,
                                         SLEEVE_HEIGHT, canvas);
        bodyTrim = new FramedRect( x + BODY_INSET, y + NECK_HEIGHT/2,
                                         BODY_WIDTH, BODY_HEIGHT, canvas);

            // create interior rectangles
        sleeves = new FilledRect( x+1, y+NECK_HEIGHT/2+1, SLEEVE_WIDTH-1,
                                      SLEEVE_HEIGHT-1, canvas);
        body = new FilledRect( x+BODY_INSET+1, y+NECK_HEIGHT/2+1,
                                   BODY_WIDTH-1, BODY_HEIGHT-1, canvas);

            // give it a neck hole
        neck = new FilledOval( x + NECK_INSET, y, NECK_WIDTH,
                                   NECK_HEIGHT, canvas);
        neckTrim = new FramedOval( x + NECK_INSET, y, NECK_WIDTH,
                                       NECK_HEIGHT, canvas);

            // set the interior to white
        body.setColor(Color.white);
        neck.setColor(Color.white);
        sleeves.setColor(Color.white);
    }



    // move the t-shirt by specified offsets.
    public void move( double xOffset, double yOffset )
    {
        body.move(xOffset,yOffset);
        neck.move(xOffset,yOffset);
        sleeves.move(xOffset,yOffset);
        bodyTrim.move(xOffset,yOffset);
        sleeveTrim.move(xOffset,yOffset);
        neckTrim.move(xOffset,yOffset);
    }

    // move the t-shirt to a new upper-left coordinate position
    public void moveTo( double x, double y)
    {
        move( x - sleeves.getX(), y - neck.getY());
    }

    // returns true if the t-shirt contains the point; false otherwise
    public boolean contains( Location pt)
    {
        return body.contains(pt) || sleeves.contains(pt) ||
               neck.contains(pt);
    }
}