import processing.core.PApplet;


public class Pong extends PApplet{

    Puck puck;

    Paddle left;
    Paddle right;

    int leftscore = 0;
    int rightscore = 0;

    public void settings() {
        size(600,400);
        puck = new Puck();
        left = new Paddle(true);
        right = new Paddle(false);
    }

    public void draw(){
    background(0);

    left.show();
    right.show();

    puck.update();
    puck.show();
    puck.edges();
    }

    public class Puck{
        float x = width/2;
        float y = height/2;
        float xspeed;
        float yspeed;
        float r = 12;

        Puck() {
            reset();
        }

        void checkPaddleLeft(Paddle p) {
            if (y - r < p.y + p.h/2 && y + r > p.y - p.h/2 && x - r < p.x + p.w/2) {
                if (x > p.x) {
                    float diff = y - (p.y - p.h/2);
                    float rad = radians(45);
                    float angle = map(diff, 0, p.h, -rad, rad);
                    xspeed = 5 * cos(angle);
                    yspeed = 5 * sin(angle);
                    x = p.x + p.w/2 + r;
                    //xspeed *= -1;
                }
            }
        }
        void checkPaddleRight(Paddle p) {
            if (y - r < p.y + p.h/2 && y + r > p.y - p.h/2 && x + r > p.x - p.w/2) {
                if (x < p.x) {
                    //xspeed *= -1;
                    float diff = y - (p.y - p.h/2);
                    float angle = map(diff, 0, p.h, radians(225), radians(135));
                    xspeed = 5 * cos(angle);
                    yspeed = 5 * sin(angle);
                    x = p.x - p.w/2 - r;
                }
            }
        }




        void update() {
            x = x + xspeed;
            y = y + yspeed;
        }

        void reset() {
            x = width/2;
            y = height/2;
            float angle = random(-PI/4, PI/4);
            //angle = 0;
            xspeed = 5 * cos(angle);
            yspeed = 5 * sin(angle);

            if (random(1) < 0.5) {
                xspeed *= -1;
            }
        }

        void edges() {
            if (y < 0 || y > height) {
                yspeed *= -1;
            }

            if (x - r > width) {
                leftscore++;
                reset();
            }

            if (x + r < 0) {
                rightscore++;
                reset();
            }
        }


        void show() {
            fill(255);
            ellipse(x, y, r*2, r*2);
        }
    }

    public class Paddle{
        float x;
        float y = height /2 ;
        float w = 10;
        float h = 100;

        Paddle(boolean left){
            if(left) {
                x = w;
            }
            else{
                x = width - w;
            }
        }
        void show(){
            rectMode(CENTER);
            rect(x, y, w, h);
        }
    }

    /*public void keyPressed() {
        if (key == 'a') {
            left.move(-10);
        } else if (key == 'z') {
            left.move(10);
        }

        if (key == 'j') {
            right.move(-10);
        } else if (key == 'm') {
            right.move(10);
        }
    }
    public static void main(String[] args){
        Pong p = new Pong();
        PApplet.runSketch(new String[]{"Pong"}, p);
    }
*/
}
