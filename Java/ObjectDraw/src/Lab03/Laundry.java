package Lab03;
import objectdraw.*;
import java.awt.*;

// João Pinto, Lab #3

public class Laundry extends WindowController
	{
		private final int DIRTY_X_POSITION = 120;
		private final int DIRTY_Y_POSITION = 100;
		private final int BASKET_SIZE = 50;
		private final int Y_POSITION = 200;
		private final int WHITE_X_POSITION = 20;
		private final int DARK_X_POSITION = 120;
		private final int COLOR_X_POSITION = 220;
		private final Location RIGHT_TEXT_POSITION = new Location ( 20, 300);
        private final Location WRONG_TEXT_POSITION = new Location ( 100, 300);

        private Location intialPoint;
		private Text rightCountText, wrongCountText;
		private FramedRect dirtyFrame, whiteFrame, colorFrame, darkFrame, correctBasket;
		private FilledRect dirtyBasket;
		private Text dirtyWords, whiteWords, colorWords, darkWords;

        private Boolean dragging;
		private int rightCounter = 0, wrongCounter = 0;
		private RandomIntGenerator colorRed = new RandomIntGenerator (0,255);
		private RandomIntGenerator colorGreen = new RandomIntGenerator (0,255);
		private RandomIntGenerator colorBlue = new RandomIntGenerator (0,255);
		

		public void begin()
			{

				dirtyBasket = new FilledRect (DIRTY_X_POSITION, DIRTY_Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
				dirtyFrame = new FramedRect (DIRTY_X_POSITION, DIRTY_Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
				dirtyWords = new Text ("Dirty", DIRTY_X_POSITION + 5, DIRTY_Y_POSITION + 25, canvas);
				dirtyBasket.setColor(Color.white);

				whiteFrame = new FramedRect (WHITE_X_POSITION, Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
				whiteWords = new Text ("White", WHITE_X_POSITION + 5, Y_POSITION + 5, canvas);

				darkFrame = new FramedRect (DARK_X_POSITION, Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
				darkWords = new Text ("Dark", DARK_X_POSITION + 5, Y_POSITION + 5, canvas);

				colorFrame = new FramedRect (COLOR_X_POSITION, Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
				colorWords = new Text ("Color", COLOR_X_POSITION + 5, Y_POSITION + 5,canvas);

				correctBasket = whiteFrame;
		        rightCountText= new Text ("Correct = 0", RIGHT_TEXT_POSITION, canvas);
		        wrongCountText= new Text ("Wrong = 0", WRONG_TEXT_POSITION, canvas);
			}

		public void onMouseClick(Location point){}

		public void onMouseDrag(Location point)
			{
				if (dragging)
					{
						dirtyWords.move(point.getX()-intialPoint.getX(), point.getY()-intialPoint.getY());
						dirtyFrame.move(point.getX()-intialPoint.getX(), point.getY()-intialPoint.getY());
						dirtyBasket.move(point.getX()-intialPoint.getX(), point.getY()-intialPoint.getY());
						intialPoint = point;
					}
			}

		public void onMousePress(Location point)
			{
				intialPoint = point;
				dragging = dirtyBasket.contains(point);
			}

		public void onMouseRelease(Location point)
			{
				if (correctBasket.contains (point))
					{
						int redNum = colorRed.nextValue ();
						int greenNum = colorGreen.nextValue ();
						int blueNum = colorBlue.nextValue ();
						Color generatedColor = new Color (redNum, greenNum, blueNum);
						int summation = redNum + greenNum + blueNum;
						
						if (summation >= 600)
							{
								dirtyBasket.setColor (generatedColor);
								dirtyWords.setColor (Color.black);
								correctBasket = whiteFrame;
							}
						else if (summation <= 230)
							{
								dirtyBasket.setColor (generatedColor);
								dirtyWords.setColor (Color.white);
								correctBasket = darkFrame;
							}
						else
							{
								dirtyBasket.setColor (generatedColor);
								dirtyWords.setColor (Color.red);
								correctBasket = colorFrame;
							}
						rightCounter++;
					}
				else
					{
						wrongCounter++;
					}
				rightCountText.setText("Correct = " + rightCounter);
				wrongCountText.setText("Wrong = " + wrongCounter);

				dirtyWords.moveTo(DIRTY_X_POSITION + 5, DIRTY_Y_POSITION + 25);
				dirtyFrame.moveTo(DIRTY_X_POSITION, DIRTY_Y_POSITION);
				dirtyBasket.moveTo(DIRTY_X_POSITION, DIRTY_Y_POSITION);
			}
	}

