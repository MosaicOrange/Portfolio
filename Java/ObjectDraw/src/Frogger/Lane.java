package Frogger;

import objectdraw.*;
import java.awt.*;

// The lane on which cars drive.  This class is responsible for generating new cars,
// keeping a gap between the cars.
public class Lane extends ActiveObject
{
        // Location and size of the lane.
        private int top;
        private int left;
        private int right;
        private int width;	// This is the width of the lane as viewed by a moving car.

        // The image for the vehicles that should drive on a lane.
        private Image vehicleImage;

        // The canvas that the vehicles should be drawn on.
        private DrawingCanvas canvas;

        // The frog that is trying to cross the highway.
        private Frog theFrog;

        // Car speed in pixels/millisecond
        private double speed;

        // Construct a new lane at the given location and size.
        // Parameters:
        //	top - the top edge of the lane on the canvas
        //	left - the left edge of the lane
        // 	right - the right edge of the lane
        // 	width - the distance between the top and bottom of the lane
        //	goingRight - true means cars should drive from left to right
        //	vehicleImage - the picture of the vehicles that should drive in the lane
        //	frog - the frog trying to cross the highway
        //	canvas - the canvas to draw on
      public Lane( int    top, int left,  int  right, int   width,  boolean     goingRight,
                        Image         vehicleImage,  Frog      frog,  DrawingCanvas       canvas )
        {
                // Figure out how fast the cars should go.  Use a negative speed if the car should
                // go from right to left.
                RandomIntGenerator speedGenerator = new RandomIntGenerator (1, 4);
                speed = speedGenerator.nextValue() / 25.0;
                if (!goingRight) {
                        speed = -speed;
                }

                // Remember the other information so that vehicles can be generated correctly.
                this.top = top;
                this.left = left;
                this.right = right;
                this.width = width;
                this.speed = speed;
                this.canvas = canvas;
                this.vehicleImage = vehicleImage;
                this.theFrog = frog;

                // Start generating vehicles
                start();

        }
   
        // Continuously generate vehicles until the applet stops.
      public void run()
    {
            // The length of the longest vehicle.  This was determined by examining the gif.
            int maxVehicleLength = 139;

            // Randomly generate the gap that this lane uses
            RandomIntGenerator gapGenerator = new RandomIntGenerator (maxVehicleLength,
                                                                                                            right - left - 2*maxVehicleLength);
            int nextGap = gapGenerator.nextValue();

            // Delay between checking if we should generate a new car
            int delay = 50;

            // The next car
            Vehicle nextVehicle;

            // Generate the cars until the applet stops
            while ( true )
            {
                        nextVehicle = new Vehicle ( vehicleImage   , speed    ,  top  , left   , right    , width    ,  theFrog   , canvas      );

                        // Only generate a car when we have traveled at least the desired gap distance
                        while (tooClose (nextVehicle, nextGap)) {
                          pause (delay);
                        }
        }
    }

        // Return true if the last vehicle is the desired distance away from the start
        // Parameters:
        //	 lastVehicle - the last vehicle created
        //	 desiredGap - the distance we want to keep from the last vehicle
   public boolean tooClose (Vehicle lastVehicle, int desiredGap) {
            // We are not too close if the last vehicle has already reached the end.
            if (lastVehicle.atLaneEnd ()) {
                    return false;
            }
            // See how far the vehicle has gone.  If it has driven more than the gap we want,
            // we can add another car.
            else {
                    return lastVehicle.distanceTraveled() < desiredGap + lastVehicle.getLength();
            }
    }// end method tooClose
 
}