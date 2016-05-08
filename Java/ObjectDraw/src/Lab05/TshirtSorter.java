package Lab05;

import objectdraw.*;
import java.awt.*;

// João Pinto, Lab #3

public class TshirtSorter extends WindowController
	{
		private final int SHIRT_X_POS = 30;
		private final int SHIRT_Y_POS = 30;
		private final int BASKET_SIZE = 50;
		private final int Y_POSITION = 200;
		private final int WHITE_X_POSITION = 20;
		private final int DARK_X_POSITION = 120;
		private final int COLOR_X_POSITION = 220;
		private final Location RIGHT_TEXT_POSITION = new Location ( 20, 300);
        private final Location WRONG_TEXT_POSITION = new Location ( 100, 300);

        private Tshirt shirtOne, shirtTwo;
        private Location intialPointOne, intialPointTwo;
		private Text rightCountText, wrongCountText;
		private FramedRect whiteFrame, colorFrame, darkFrame, correctBasket;
		private Text whiteWords, colorWords, darkWords;

        private Boolean draggingOne, draggingTwo;
		private int rightCounter = 0, wrongCounter = 0;
		private RandomIntGenerator colored = new RandomIntGenerator (0,2);

		public void begin()
			{
				shirtOne = new Tshirt (SHIRT_X_POS,SHIRT_Y_POS,canvas);
				shirtTwo = new Tshirt (SHIRT_X_POS+150,SHIRT_Y_POS,canvas);

				whiteFrame = new FramedRect (WHITE_X_POSITION, Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
				whiteWords = new Text ("White", WHITE_X_POSITION + 5, Y_POSITION + 5, canvas);

				darkFrame = new FramedRect (DARK_X_POSITION, Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
				darkWords = new Text ("Dark", DARK_X_POSITION + 5, Y_POSITION + 5, canvas);

				colorFrame = new FramedRect (COLOR_X_POSITION, Y_POSITION, BASKET_SIZE, BASKET_SIZE, canvas);
				colorWords = new Text ("Color", COLOR_X_POSITION + 5, Y_POSITION + 5,canvas);

		        rightCountText= new Text ("Correct = 0", RIGHT_TEXT_POSITION, canvas);
		        wrongCountText= new Text ("Wrong = 0", WRONG_TEXT_POSITION, canvas);
			}

		public void onMouseDrag(Location point)
			{
				if (draggingOne)
					{
						shirtOne.move(point.getX()-intialPointOne.getX(), point.getY()-intialPointOne.getY());
						intialPointOne = point;
					}

				if (draggingTwo)
					{
						shirtTwo.move(point.getX()-intialPointTwo.getX(), point.getY()-intialPointTwo.getY());
						intialPointTwo = point;
					}
			}

		public void onMousePress(Location point)
			{
				if (shirtOne.contains(point))
					{
						if (shirtOne.getColor() == Color.red)
							{
								correctBasket = colorFrame;
							}
						else if (shirtOne.getColor() == Color.white)
							{
								correctBasket = whiteFrame;
							}
						else if  (shirtOne.getColor() == Color.black)
							{
								correctBasket = darkFrame;
							}
						else {}
						draggingOne = shirtOne.contains(point);
					}
				else if (shirtTwo.contains(point))
					{
						if (shirtTwo.getColor() == Color.red)
							{
								correctBasket = colorFrame;
							}
						else if (shirtTwo.getColor() == Color.white)
							{
								correctBasket = whiteFrame;
							}
						else if  (shirtTwo.getColor() == Color.black)
							{
								correctBasket = darkFrame;
							}
						else {}
						draggingTwo = shirtTwo.contains(point);
					}
				else {}
			}

		public void onMouseRelease(Location point)
			{
				int colNumOne = colored.nextValue ();
				int colNumTwo = colored.nextValue ();
				if (draggingOne)
					{
						if (correctBasket.contains (point))
							{
								if (colNumOne == 2)
									{
										shirtOne.setColor (Color.white);
									}
								else if (colNumOne == 1)
									{
										shirtOne.setColor (Color.black);
									}
								else
									{
										shirtOne.setColor (Color.red);
									}
								rightCounter++;
							}
						else
							{
								wrongCounter++;
							}
					}
				else if (draggingTwo)
					{
						if (correctBasket.contains (point))
							{
								if (colNumTwo == 2)
									{
										shirtTwo.setColor (Color.white);
									}
								else if (colNumTwo == 1)
									{
										shirtTwo.setColor (Color.black);
									}
								else
									{
										shirtTwo.setColor (Color.red);
									}
								rightCounter++;
							}
						else
							{
								wrongCounter++;
							}
					}
				else 
					{}
				rightCountText.setText("Correct = " + rightCounter);
				wrongCountText.setText("Wrong = " + wrongCounter);

				shirtOne.moveTo(SHIRT_X_POS,SHIRT_Y_POS);
				shirtTwo.moveTo(SHIRT_X_POS+150,SHIRT_Y_POS);
			}
	}

