package Frogger;

import objectdraw.*;
import java.awt.*;

public class Frogger extends WindowController{

        // Constants defining the sizes of the background components.
        private static final int HIGHWAY_LENGTH = 700;
        private static final int LANE_WIDTH = 100;
        private static final int NUM_LANES = 4;
        private static final int HIGHWAY_WIDTH = LANE_WIDTH * NUM_LANES;
        private static final int LINE_WIDTH = LANE_WIDTH / 10;

        // Constants defining the locations of the background components
        private static final int HIGHWAY_LEFT = 50;
        private static final int HIGHWAY_RIGHT = HIGHWAY_LEFT + HIGHWAY_LENGTH;
        private static final int HIGHWAY_TOP = 100;
        private static final int HIGHWAY_BOTTOM = HIGHWAY_TOP + HIGHWAY_WIDTH;
        private static final int LINE_SPACING = LINE_WIDTH / 2;

        // The frog that tries to jump across the road.
        private Frog theFrog,secondFrog;

        // Remembers if the mouse is in the window.  Ignore mouse releases outside the window.
        private boolean inWindow = true;

        public void begin()
        {
                // Draw the background
                FilledRect highway = new FilledRect (HIGHWAY_LEFT, HIGHWAY_TOP, HIGHWAY_LENGTH, HIGHWAY_WIDTH, canvas);
               // highway.setColor( Color.green) ;
                new FilledRect(0,0,HIGHWAY_LEFT,canvas.getHeight(), canvas).setColor(Color.white);
                new FilledRect(HIGHWAY_LEFT+HIGHWAY_LENGTH, 0, canvas.getWidth() - HIGHWAY_LEFT+HIGHWAY_LENGTH,
                               canvas.getHeight(),canvas).setColor(Color.white);

                // Draw the lane dividers
                int whichLine = 1;
                while (whichLine < NUM_LANES) {
                  if (whichLine == NUM_LANES / 2) {
                          // The middle line is a no passing line
                          drawNoPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) - (LINE_SPACING / 2 + LINE_WIDTH));
                  }
                  else {
                      drawPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) - (LINE_WIDTH / 2));
                  }
                  whichLine = whichLine + 1;
                }

                // Add the frog

                // Image frogImage = getImage ("bunnyThree.gif"); 
                Image frogImage = getImage("froggy.gif");
                 theFrog = new Frog (frogImage,(HIGHWAY_RIGHT - HIGHWAY_LEFT) /2 , HIGHWAY_BOTTOM,LANE_WIDTH, canvas);
                //  Image carImage = getImage ( "jeep_right.gif" );
                //  Vehicle car = new Vehicle(carImage, .10, HIGHWAY_TOP + 70, HIGHWAY_LEFT, HIGHWAY_RIGHT, HIGHWAY_WIDTH,  theFrog, canvas);


                // Get the cars moving
                int lane = 1;

                // There are 4 types of vehicles.  Pick the type for a lane randomly.
                RandomIntGenerator vehicleGenerator = new RandomIntGenerator (1, 4);
                int nextVehicleNum;		// Next type of vehicle
                Image nextVehicle;		// Image corresponding to the next type
                String direction;		// Direction the vehicle will travel
                boolean goingRight;		// True if the vehicle is driving from left to right

                // Create the lanes
                while (lane <= NUM_LANES) {
                        // The bottom half lanes go to the right
                        if (lane > NUM_LANES / 2) {
                               // direction = "right";
                                direction= "right";
                                goingRight = true;
                        }
                        else {
                                direction = "left";
                                goingRight = false;
                        }

                        // Figure out the next vehcile type and load the appropriate image for that type and the direction
                        // it should travel.
                        nextVehicleNum = vehicleGenerator.nextValue ();
                        //System.out.println ( "here" + nextVehicleNum);
                        if (nextVehicleNum == 1) {
                                nextVehicle = getImage ("jeep_" + direction + ".gif");
                        }
                        else if (nextVehicleNum == 2) {
                                nextVehicle = getImage ("oldcar_" + direction + ".gif");
                        }
                        else if (nextVehicleNum == 3) {
                                nextVehicle = getImage ("taxi_" + direction + ".gif");
                        }
                        else {
                                nextVehicle = getImage ("van_" + direction + ".gif");
                        }

                        // Create the lane telling it where it is, which direction its cars should go, what its cars should
                        // look like, and what the frog is.
                        new Lane (HIGHWAY_TOP + (lane - 1) * LANE_WIDTH, HIGHWAY_LEFT, HIGHWAY_RIGHT, LANE_WIDTH,
                                          goingRight, nextVehicle, theFrog, canvas);

                    lane = lane + 1;
                }

        }

        // Draws a pair of solid yellow lines to represent a no passing divider between lanes
        // Parameter:  y - the top of the top line
    private void drawNoPassingLine (int y) {
                   // Draw the solid dividing lines
                FilledRect topLine = new FilledRect (HIGHWAY_LEFT, y, HIGHWAY_LENGTH, LINE_WIDTH, canvas);
               // topLine.setColor (Color.PINK);
               topLine.setColor(Color.YELLOW);
                FilledRect bottomLine = new FilledRect (HIGHWAY_LEFT, y + LINE_WIDTH + LINE_SPACING,
                                                                                                HIGHWAY_LENGTH, LINE_WIDTH, canvas);
                bottomLine.setColor(Color.yellow); 
                //bottomLine.setColor (Color.PINK);
   }

        // Draws a dashed white line to represent a passing line dividing two lanes of traffic
        // Parameters:  y - the top of the line.
        private void drawPassingLine (int y) {
           int x = HIGHWAY_LEFT;
           final int DASH_LENGTH = LANE_WIDTH / 3;
           final int DASH_SPACING = DASH_LENGTH / 2;
           FilledRect dash;

           while (x < HIGHWAY_RIGHT) {
                           // Draw the next dash.
                           dash = new FilledRect (x, y, DASH_LENGTH, LINE_WIDTH, canvas);
                           dash.setColor(Color.white) ;
                           //dash.setColor (Color.MAGENTA);
                           x = x + DASH_LENGTH + DASH_SPACING;
           }

        }

        // If the mouse is alive, tell the mouse which direction to move.  If the mouse is not alive, ignore
        // mouse releases except for ones in the starting area.  Ignore all mouse releases outside the window.
    public void onMousePress(Location point)
        {
                if (inWindow) {
                        if (theFrog.isAlive ()) 
                        {
                           theFrog.hopToward(point); 

                         }
                        else if (point.getY() > HIGHWAY_BOTTOM)
                         {
                             theFrog.reincarnate();
                        }
                }
        }
    
     /*   // Remembers if the user enters the window so we can start paying attention to mouse presses again.
        public void onMouseEnter(Location point){
                inWindow = true;
        }

        // Remembers if the user leaves the window so we can ignore mouse presses.
    public void onMouseExit(Location point){
            inWindow = false;
        }
   */
}

