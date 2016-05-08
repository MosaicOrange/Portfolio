package Lab07;
import objectdraw.*;

import java.awt.*;

public class BoxBallGame extends WindowController{



	// Name:

	// Lab:

	// Boxball is a game in which the user drops a ball from a height trying to get
	// the ball to land in a box.  There are 3 difficulty levels.  Increasing
	//difficulty makes the box smaller and increases the height from which the
	// ball must be dropped
  // constants for the court
	   private static final int COURT_LEFT = 50;
	   private static final int COURT_TOP = 50;
	   private static final int COURT_HEIGHT = 400;
	   private static final int COURT_WIDTH = 400;
	   private static final int COURT_BOTTOM = COURT_TOP + COURT_HEIGHT;
	   private static final int COURT_RIGHT = COURT_LEFT + COURT_WIDTH;

	   private FramedRect court;// name the class

	   // location of score text
	   private static final int SCORE_BOTTOM = COURT_BOTTOM + 10;
	   private static final int SCORE_LEFT = COURT_LEFT + (COURT_WIDTH/2) - 50;

	   // constants for the location and dimensions of the easy, medium, and hard buttons
	   private static final int BUTTON_HEIGHT = 50;
	   private static final int BUTTON_WIDTH = COURT_WIDTH/ 5;
	   private static final int BUTTON_TOP = SCORE_BOTTOM + 20;
	   private static final int BUTTON_SPACING = COURT_WIDTH/10;
	   private static final int EASY_BUTTON_LEFT = COURT_LEFT + BUTTON_SPACING;
	   private static final int MEDIUM_BUTTON_LEFT = EASY_BUTTON_LEFT + BUTTON_WIDTH + BUTTON_SPACING;
	   private static final int HARD_BUTTON_LEFT = MEDIUM_BUTTON_LEFT+ BUTTON_WIDTH + BUTTON_SPACING;

	   // constants for the heights of the three lines
	   private static final int LEVEL_SPACING = COURT_HEIGHT/ 4;
	   private static final int HARD_HEIGHT = COURT_TOP + LEVEL_SPACING;
	   private static final int MEDIUM_HEIGHT = HARD_HEIGHT + LEVEL_SPACING;
	   private static final int EASY_HEIGHT = MEDIUM_HEIGHT + LEVEL_SPACING;
	    // size of the ball
	   private static final int BALL_SIZE =20;
	   // constant for the size of the boxes
	   private static final int EASY_BOX_SIZE = BALL_SIZE * 2;
	   private static final int MEDIUM_BOX_SIZE = BALL_SIZE + BALL_SIZE/2;
	   private static final int HARD_BOX_SIZE = BALL_SIZE + BALL_SIZE /4;

	    // location of the button labels
	   private static final int BUTTON_LABEL_BOTTOM = BUTTON_TOP + BUTTON_HEIGHT/2 -5;
	   private static final int BUTTON_TEXT_OFFSET = BUTTON_WIDTH/3;

	   private FilledRect easyButton, mediumButton, hardButton;
	   private Box targetBox;

	  //private instance variables
	   // size of the box currently being used
	   private int boxSize;

	   // height at which the ball must currently be dropped.  Determined by the level of dificult

	   private int clickHeight;

	   // the line above which the ball must be dropped
	   private Line startingLine;

	   // place to write scores, etc
	   private Text scoreText;

	   private Text easyText, mediumText, hardText;

	  public void begin()

	 {   // code for the constructor for the court using the above constants
	     court = new FramedRect (COURT_LEFT,COURT_TOP,COURT_HEIGHT,COURT_WIDTH,canvas);

	     Text name = new Text ( "Box Ball!!!" ,200, 10, canvas);//for the name of the game
	     name.setFontSize (30);
	     name.setColor ( new Color (102, 0,0));

	     scoreText = new Text ( "Let's Play", SCORE_LEFT, SCORE_BOTTOM, canvas);//initialize to Let's Play
	     scoreText.setFontSize (14);
	     scoreText.setBold();
	     // code the constructors for the three game=level buttons: easy, hard and medium

	     easyButton = new FilledRect (EASY_BUTTON_LEFT,BUTTON_TOP,BUTTON_WIDTH,BUTTON_HEIGHT,canvas);
	     mediumButton = new FilledRect (MEDIUM_BUTTON_LEFT,BUTTON_TOP,BUTTON_WIDTH,BUTTON_HEIGHT,canvas);
   	     hardButton = new FilledRect (HARD_BUTTON_LEFT,BUTTON_TOP,BUTTON_WIDTH,BUTTON_HEIGHT,canvas);

	     easyText = new Text ("Easy", EASY_BUTTON_LEFT + BUTTON_TEXT_OFFSET, BUTTON_LABEL_BOTTOM, canvas);
	     mediumText = new Text ("Medium", MEDIUM_BUTTON_LEFT + BUTTON_TEXT_OFFSET, BUTTON_LABEL_BOTTOM, canvas);
	     hardText = new Text ("Hard", HARD_BUTTON_LEFT + BUTTON_TEXT_OFFSET, BUTTON_LABEL_BOTTOM, canvas);

	     easyButton.setColor(Color.pink);
	     mediumButton.setColor(Color.gray);
   	     hardButton.setColor(Color.yellow);

	       
	        // initalize the game to easy mode
	        boxSize = EASY_BOX_SIZE;
	        targetBox = new Box( boxSize, COURT_LEFT, COURT_RIGHT - boxSize, COURT_BOTTOM - boxSize, canvas );


	        clickHeight = EASY_HEIGHT;
	        // draw the line for the easy situation
	       startingLine = new Line (COURT_LEFT, EASY_HEIGHT, COURT_RIGHT, EASY_HEIGHT, canvas);
	       
	  }// end begin method





	public void onMouseClick(Location point)

	{
	   if (court.contains (point))
	     {
	      // make sure the user clicked above the starting line
	      if ( point.getY() < clickHeight)
	        {
	        Ball b = new Ball (BALL_SIZE, point, canvas, targetBox, COURT_BOTTOM, scoreText);
	        }
	     }
	   // check to see if the user clicked on a button
	   else if ( easyButton.contains ( point ) )
	          {
	           targetBox.setSize (EASY_BOX_SIZE);
	           clickHeight = EASY_HEIGHT;
	           startingLine.moveTo (COURT_LEFT,EASY_HEIGHT);
	          }
	  else if ( mediumButton.contains ( point ) )
	          {
          targetBox.setSize (MEDIUM_BOX_SIZE);
          clickHeight = MEDIUM_HEIGHT;
          startingLine.moveTo (COURT_LEFT,MEDIUM_HEIGHT);
	          }
	  else if ( hardButton.contains ( point ) )
	          {
          targetBox.setSize (HARD_BOX_SIZE);
          clickHeight = HARD_HEIGHT;
          startingLine.moveTo (COURT_LEFT,HARD_HEIGHT);
	          }
	  else {}
	   } // ends method onMouseClick()


	
}
