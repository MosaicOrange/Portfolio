package Lab04;
import objectdraw.*;
import java.awt.*;

/**
        Include your name, lab section and a description of the program here.

 */
public class LaundryThree extends WindowController
{
        // place constant and variable declarations here
        private final int WHITE_BASKET_X_POSITION = 20;
        private final int WHITE_BASKET_Y_POSITION = 200;
        private final int BASKET_SIZE = 50;
        private final int BASKET_SPACING = 100;

        private final Location RIGHT_TEXT_POSITION = new Location ( 20, 300);
        private final Location WRONG_TEXT_POSITION = new Location ( 100, 300);

        private  FramedRect  whiteBasket;
        private FramedRect darksBasket;
        private FramedRect colorsBasket;
        private FramedRect dirtyBasketFrame;
        private FilledRect dirtyBasket;

        private final Location DIRTY_BASKET_POSITION = new Location ( 60, 20);


        private FramedRect  correctBasket;

        private Text rightCountText, wrongCounterText;
        private int rightCounter = 0;
        private int wrongCounter = 0;
        private RandomIntGenerator  generator = new RandomIntGenerator ( 1,3);

        private boolean dragging = false;
        private Location initialPoint;


  public void begin()
  {
        whiteBasket = new FramedRect (WHITE_BASKET_X_POSITION, WHITE_BASKET_Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
        darksBasket = new FramedRect (WHITE_BASKET_X_POSITION + BASKET_SPACING, WHITE_BASKET_Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
        colorsBasket = new FramedRect (WHITE_BASKET_X_POSITION + 2* BASKET_SPACING, WHITE_BASKET_Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);

        // SET UP THE DIRTY BASKET
        dirtyBasket = new FilledRect(DIRTY_BASKET_POSITION,  BASKET_SIZE, BASKET_SIZE, canvas);
        dirtyBasketFrame = new FramedRect ( DIRTY_BASKET_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
        dirtyBasket.setColor(Color.white);

        // generate labels for the baskets
        new Text ( "whites", WHITE_BASKET_X_POSITION + 10, WHITE_BASKET_Y_POSITION + 20, canvas);
        new Text ( "darks", WHITE_BASKET_X_POSITION + BASKET_SPACING + 10, WHITE_BASKET_Y_POSITION + 20, canvas);
        new Text ( "colors", WHITE_BASKET_X_POSITION + 2* BASKET_SPACING + 10, WHITE_BASKET_Y_POSITION + 20, canvas);

        // initialize the target basket to the white basket
        correctBasket = whiteBasket;


        // display initial counters
        rightCountText= new Text ( "correct = 0", RIGHT_TEXT_POSITION, canvas);
        wrongCounterText = new Text ( "incorrect = 0", WRONG_TEXT_POSITION, canvas);
  }


  public void onMousePress(Location point)
  {
     if ( dirtyBasket.contains (point) )
      {
        dragging = true;
        initialPoint = point;
      }
  }

  public void onMouseDrag(Location point)
 {
    if ( dragging)
    {
      dirtyBasket.move ( point.getX() - initialPoint.getX(), point.getY() - initialPoint.getY () );
      dirtyBasketFrame.move (point.getX() - initialPoint.getX(), point.getY() - initialPoint.getY () );
       initialPoint = point;
  }
  }
  public void onMouseRelease(Location point)
  {
     if ( dragging)
     {
        dragging = false;
        dirtyBasket.moveTo(DIRTY_BASKET_POSITION);
        dirtyBasketFrame.moveTo ( DIRTY_BASKET_POSITION);

        if ( correctBasket.contains (point))
          {
            rightCounter = rightCounter + 1;
            rightCountText.setText ( "correct = " + rightCounter);
            int next = generator.nextValue ();
            if ( next == 1)
            {
              dirtyBasket.setColor (Color.white);
              correctBasket = whiteBasket;
            }
            else if ( next == 2)
            {
              dirtyBasket.setColor (Color.black);
              correctBasket = darksBasket;
            }
            else
            {
               dirtyBasket.setColor (Color.red) ;
               correctBasket = colorsBasket;
            }
           }
          else
            {
              wrongCounter = wrongCounter + 1;
              wrongCounterText.setText ( "incorrect = " + wrongCounter);
            }
       }

  }

}





