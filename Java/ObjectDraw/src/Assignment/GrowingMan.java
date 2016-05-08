package Assignment;


import objectdraw.*;
import java.awt.*;

public class GrowingMan extends WindowController
	{
		private static final int GROW = 2;
		private static final int HEAD_SIZE = 6;
		private static final int LIMB_SIZE = 5;
		private static final int HEAD_START = 50;
		private static final int BODY_X = HEAD_START + HEAD_SIZE / 2;
		private static final int NECK_Y = HEAD_START + HEAD_SIZE;
		private static final int ARMPIT_Y = HEAD_START + 2 * HEAD_SIZE;
		private static final int BODY_END = HEAD_START + 3 * HEAD_SIZE;
		private static final int FEET_Y = BODY_END + LIMB_SIZE;
		private static final int ARMS_Y = ARMPIT_Y - LIMB_SIZE;
		private static final int LEFT_X = BODY_X - LIMB_SIZE;
		private static final int RIGHT_X = BODY_X + LIMB_SIZE;
		
		private int clickCount = 1;
		private FramedOval head;
		private Line body, leftArm, rightArm, leftLeg, rightLeg;
		
		public void begin ()
			{
				head = new FramedOval (HEAD_START,HEAD_START,HEAD_SIZE,HEAD_SIZE,canvas);
				body = new Line (BODY_X,NECK_Y,BODY_X,BODY_END,canvas);
				leftArm = new Line (BODY_X,ARMPIT_Y,LEFT_X,ARMS_Y,canvas);
				rightArm = new Line (BODY_X,ARMPIT_Y,RIGHT_X,ARMS_Y,canvas);
				leftLeg = new Line (BODY_X,BODY_END,LEFT_X,FEET_Y,canvas);
				rightLeg = new Line (BODY_X,BODY_END,RIGHT_X,FEET_Y,canvas);
			}

		public void onMouseClick(Location point)
			{
				canvas.clear();
				int growth = GROW * clickCount;
				head = new FramedOval (HEAD_START,HEAD_START,HEAD_SIZE+(clickCount*2),HEAD_SIZE+(clickCount*2),canvas);
				body = new Line (BODY_X+clickCount,NECK_Y+growth,BODY_X+clickCount,BODY_END+(growth*2),canvas);

				leftArm = new Line (BODY_X+clickCount,ARMPIT_Y+growth+clickCount,LEFT_X-clickCount,ARMS_Y+clickCount,canvas);
				rightArm = new Line (BODY_X+clickCount,ARMPIT_Y+growth+clickCount,RIGHT_X+(clickCount*3),ARMS_Y+clickCount,canvas);
				leftLeg = new Line (BODY_X+clickCount,BODY_END+(growth*2),LEFT_X-clickCount,FEET_Y+(growth*3),canvas);
				rightLeg = new Line (BODY_X+clickCount,BODY_END+(growth*2),RIGHT_X+(clickCount*3),FEET_Y+(growth*3),canvas);

				clickCount = clickCount + 1;
			}
	}
