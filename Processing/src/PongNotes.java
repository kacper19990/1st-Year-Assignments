import processing.core.PApplet;

import java.awt.event.MouseEvent;

public class PongNotes extends PApplet{

    final int SCREENX = 300;
    final int SCREENY = 200;
    final int PADDLEHEIGHT = 15;
    final int PADDLEWIDTH = 50;
    final int MARGIN = 10;

    int leftscore = 0;
    int rightscore = 0;
    Player thePlayer;
    Ball theBall;
    Computer theComputer;

    public class Player {
        int xpos; int ypos;
        int paddlecolor = color(50);
        Player(int screen_y)
        {
            xpos=SCREENX/2;
            ypos=screen_y;
        }
        void move(int x){
            if(x>SCREENX-PADDLEWIDTH) xpos = SCREENX-PADDLEWIDTH;
            else xpos=x;
        }
        void draw()
        {
            fill(paddlecolor);
            rect(xpos, ypos, PADDLEWIDTH, PADDLEHEIGHT);


        }

    }
    public class Computer {
        int xpos;
        int ypos;

        Computer(){
            xpos = SCREENX/2;
            ypos = MARGIN;
        }

        void move(int x){
            if(xpos>SCREENX - PADDLEWIDTH){
                xpos = SCREENX - PADDLEWIDTH;
            }else if(xpos > x){
                xpos--;
            }else{
                xpos++;
            }
        }

        void draw(){
            fill(255);
            rect(xpos,ypos,PADDLEWIDTH,PADDLEHEIGHT);
        }
    }

    public void settings(){
        size(SCREENX, SCREENY);
    }
    public void setup(){
        thePlayer = new Player(SCREENY-MARGIN-PADDLEHEIGHT);
        theComputer = new Computer();
        theBall = new Ball();
        ellipseMode(RADIUS);
    }
    public void draw() {
        background(0);
        thePlayer.move(mouseX);
        theBall.move();
        theBall.collide(thePlayer);
        theBall.collideComp(theComputer);
        theBall.collideEdges();
        thePlayer.draw();
        theBall.draw();
        theBall.edges();
        theComputer.draw();
        theComputer.move((int) theBall.x);

        fill(255);
        textSize(32);
        text(leftscore, 32, 40);
        text(rightscore, width-64, 40);

    }

    public class Ball {
        float x;
        float y;
        float dx;
        float dy;
        int radius;
        int ballColor = color(200, 100, 50);

        Ball() {
            reset();
            x = random(SCREENX / 4, SCREENX / 2);
            y = random(SCREENY / 4, SCREENY / 2);
            dx = random(1, 2);
            dy = random(1, 2);
            radius = 5;

        }

        void move(){
            x = x+dx; y = y+dy;
        }
        void draw(){
            fill(ballColor);
            ellipse(x, y, radius,
                    radius);
        }

        void collide(Player tp){

            if(y+radius >= tp.ypos &&
                    y-radius<tp.ypos+PADDLEHEIGHT &&
                    x >=tp.xpos && x <=
                    tp.xpos+PADDLEWIDTH){
                println("collided!");
                dy=-dy;
            }
        }
        void collideComp(Computer tp){
            if(y+radius >= tp.ypos &&
                    y-radius<tp.ypos+PADDLEHEIGHT &&
                    x >=tp.xpos && x <=
                    tp.xpos+PADDLEWIDTH){
                dy=-dy;
            }
        }

        void reset() {
            x = width/2;
            y = height/2;
            float angle = random(-PI/4, PI/4);
            //angle = 0;
            dx = 5 * cos(angle);
            dy = 5 * sin(angle);

            if (random(1) < 0.5) {
                dx *= -1;
            }
        }
        void edges() {
            if (y - radius > height) {
                leftscore++;
                if(leftscore == 3){
                    //background(255);
                    textSize(50);
                    text("YOU LOSE", 0, 100);
                    frameRate((float) 0.002);
                    if(mousePressed) {
                        reset();
                        rightscore = 0;
                        leftscore = 0;
                        frameRate((float) 30);
                    }
                }
                else
                reset();
            }

            if (y + radius < 0) {
                rightscore++;
                if(rightscore == 3){
                    //background(255);
                    textSize(50);
                    text("YOU WIN", 0, 100);
                    frameRate((float) 0.002);
                    if(mousePressed){
                        reset();
                        rightscore = 0;
                        leftscore = 0;
                        frameRate((float) 30);
                    }
                }
                else
                reset();
            }
        }

        void collideEdges(){
            if(x-radius <=0) dx=-dx;
            else if(x+radius>=SCREENX) dx=-dx;
        }

    }

    public static void main(String[] args){
        PongNotes p = new PongNotes();
        PApplet.runSketch(new String[]{"Pong"}, p);
    }

}
