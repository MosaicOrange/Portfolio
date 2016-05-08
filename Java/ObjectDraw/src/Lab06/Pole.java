package Lab06;


import objectdraw.*;
import java.awt.*;


  // A class of objects used to represent poles of bar magnets
  //
  // T. Murtagh + K. Bruce    9/16/99
public class Pole {

                         // Arbitrarily chosen range within which poles interact
        private static final double AttractionRange = 90.0;

        private Location location;     // Location of the center of the pole
        private Text label;          // The pole's type ("N" or "S").

        private Magnet mom;          // The magnet which contains this pole


          // Create a new pole.
          //
          //    parent - magnet that contains this pole
          //    x,y    - coordinates for center of the pole
          //    name   - "N" or "S"
          //    canvas - the canvas on which magnet and poles should be drawn
          //
        public Pole ( Magnet parent, double x, double y, String name, DrawingCanvas canvas ) {
                mom = parent;
                this.location = new Location(x,y);
                label = new Text( name, location, canvas );
                label.setFontSize(36);
                label.move( -label.getWidth()/2, -label.getHeight()/2);
        }

           // Return the magnet that contains this pole
        public Magnet getParent() {
                return mom;
        }

                // Return x coordinate of pole's center
        public double getX() {
                return location.getX();
        }

                // Return y coordinate of pole's center
        public double getY() {
                return location.getY();
        }

                // Return coordinates of pole's center
        public Location getLocation() {
                return location;
        }

                // Move pole to a location specified relative to its current location
        public void move( double xoff, double yoff){
                location.translate(xoff,yoff);
                label.move(xoff,yoff);
        }


                // Try to attract a pole of opposite polarity.
                //
                //    opposite - another pole whose label ("N" or "S") is the opposite of
                //               this pole's.
                //
                //  If the other pole is within "AttractionRange" of this pole, move the other
                //  magnet so that it is next to this pole's containing magnet
        public void attract( Pole opposite ) {
                double xoff, yoff;

                xoff = opposite.getX() - location.getX();
                yoff = opposite.getY() - location.getY();

                        // Check to see if the poles are close enough
                if ( location.distanceTo(opposite.getLocation()) < AttractionRange ) {

                                 // make the two magnets overlap
                        opposite.getParent().moveTo( mom.getLocation());

                        if ( Math.abs(xoff) >= Math.abs(yoff) ) {
                               // move magnets so that they meet end-to-end
                                if ( xoff < 0 ) {
                                        opposite.getParent().move(-mom.getWidth(), 0);
                                } else {
                                        opposite.getParent().move(mom.getWidth(), 0);
                                }
                        } else {
                               // Move magnets so they will be above one another with attracting pole's
                               // aligned vertically

                                opposite.getParent().move( location.getX()-opposite.getLocation().getX(),0);
                                if ( yoff < 0 ) {
                                        opposite.getParent().move(0,-mom.getHeight());
                                } else {
                                        opposite.getParent().move(0,mom.getHeight());
                                }


                        }
                }
        }

                // Try to repel a pole of opposite polarity.
                //
                //    opposite - another pole whose label ("N" or "S") is the opposite of
                //               this pole's.
                //
                //  If the other pole is within "AttractionRange" of this pole, move the other
                //  magnet so that the other pole is "AttractionRange" away from this one.
        public void repel( Pole opposite ) {

                double xoff, yoff;
                double distance = location.distanceTo( opposite.getLocation());

                xoff = opposite.getX() - location.getX();
                yoff = opposite.getY() - location.getY();

                        // check to see if the poles are close enough
                if ( distance < AttractionRange - 1) {
                                // Push other magnet away in the direction of the line between
                                // the two poles.
                        xoff = (AttractionRange-distance) * xoff /distance;
                        yoff = (AttractionRange-distance) * yoff /distance;

                        opposite.getParent().move( xoff,yoff );
                }

        }


}