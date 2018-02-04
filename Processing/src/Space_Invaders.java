import processing.core.PApplet;
import processing.core.PImage;

public class Space_Invaders extends PApplet {

    final int A_FORWARD = 0;
    final int A_BACKWARD = 1;
    final int A_DOWN = 2;

    public class Alien {
        float x;
        float y;
        float dx;
        float dy;

        /* declare variables for alien position, direction of movement and appearance */

 /* Constructor is passed the x and y position where the alien is to
 be created, plus the image to be used to draw the alien */

        Alien(int xpos, int ypos, PImage alienImage) {
            /* set up the new alien object */
        }

        void move() {
            /* Move the alien according to the instructions in the exercise */
        }

        void draw() {
            /* Draw the alien using the image() method demonstrated in class */
        }
    }

    /* Declare an array of Aliens */

    public class AlienArray {
        void setup() {

        }
        /* create a new alien array */
        /* load the images */
        /* initialise the array */


        void init_aliens( /* pass in your array, plus the image to use */) {
 /* for each position in the array,  create a new alien at an appropriate
 starting point on the screen */
        }

        void draw() {
            /* clear the screen */
            /* for each alien in the array - move the alien, then draw the alien */

        }
    }
    /* Declare an Alien */

    public class AlienDeclare {
        void setup() {

            /* create a new alien object */
        }

        void draw() {
            background(0);
            /* clear the screen */

            /* move the alien */
            /* draw the alien */
        }
    }
}
