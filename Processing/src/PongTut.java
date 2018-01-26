import processing.core.PApplet;

public class PongTut extends PApplet {
/*   float ballX;
    float ballY;
    float dX;
    float dY;
    float paddleX;
    float paddleY;
    float paddleW;
    float paddleH;
    int width = 600;
    int height = 400;

    Ball ball;
    Paddle paddle;


    public void reset() {
        ballX = 20;                                           //Starting X position of the ball
        ballY = 20;                                           //Starting Y position of the ball
        dX = random(1,2);                                     //Moving the ball to the left by 2 pixels each time
        dY = random(1,2);                                     //Moving the ball up by 2 pixels
        paddleX = width -15;
        paddleY = 10;
        paddleW = 10;
        paddleH = 30;
    }


    public void settings(){
        size(width,height);
        reset();
        ball = new Ball();
        paddle = new Paddle();

    }

    public void draw(){
        background(0);                                        //Sets the colour of the background
        //ellipse(ballX,ballY,20,20);                             //Draws the ball
        //color(0);

        ball.draw();
        ball.update();
        ball.edges();
        paddle.draw();
        //ballX = ballX + dX;                                     //Moves the ball
        //ballY = ballY + dY;


    }

    public class Ball{
        float x = width/2;
        float y = height/2;

        void update(){
            ballX = ballX + dX;
            ballY = ballY + dY;
        }

        void reset(){
            ballX = width /2;
            ballY = height /2;
        }

        void edges(){
            if(ballX > width){                                        //If the ball hits the right side of the screen
                dX *= -1;                                           //the ball bounces back
            }
            if(ballX < 0){                                          //Same as previous but for the left side
                dX *= -1;
            }
            if (ballY > height){
                reset();
            }
            if (ballY < 0){
                reset();
            }
        }

        void draw(){
            //fill(0);
            ellipse(ballX, ballY, 24, 24);

        }
    }

    public class Paddle{

        float paddleX = width - 15;
        float paddleY = mouseY;

        void draw(){
            rect(paddleX, paddleY, 100,50);
        }
    }

   /* public class Player {
        int xpos; int ypos;
        color paddlecolor = color(50);
        Player(int screen_y)
        {
            xpos=SCREENX/2;
            ypos=screen_y;
        }
        void move(int x){
            if(x>SCREENX-PADDLEWIDTH) xpos = SCREENX-paddleH;
            else xpos=x;
        }
        void draw()
        {
            fill(paddlecolor);
            rect(xpos, ypos, PADDLEWIDTH, paddleH);
        }
    }

    */

    float ballX = 20;
    float ballY = 20;
    float ballR = 10;
    float dX = random(1, 2);
    float dY = random(1, 2);
    float paddleX;
    float paddleY = 10;
    float paddleW = 10;
    float paddleH = 30;



    public void settings() {
        size(400, 400);
        paddleX = width - 15;
    }

    public void draw() {
        background(255, 255, 255);
        ellipse(ballX, ballY, 2 * ballR, 2 * ballR);

        rect(paddleX, paddleY, paddleW, paddleH);

        if (ballRight() > width) {
            fill(255, 0, 0, 100);
            rect(0, 0, width, height);
            noLoop();
        }

        if (collision()) {
            dX = -dX; // if dX == 2, it becomes -2; if dX is -2, it becomes 2
        }

        if (ballLeft() < 0) {
            dX = -dX; // if dX == 2, it becomes -2; if dX is -2, it becomes 2
        }

        if (ballBottom() > height) {
            dY = -dY; // if dY == 2, it becomes -2; if dY is -2, it becomes 2
        }

        if (ballTop() < 0) {
            dY = -dY; // if dY == 2, it becomes -2; if dY is -2, it becomes 2
        }

        ballX = ballX + dX;
        ballY = ballY + dY;
    }

    boolean collision() {
        boolean returnValue = false; // assume there is no collision
        if ((ballRight() >= paddleX) && (ballLeft() <= paddleX + paddleW)) {
            if ((ballBottom() >= paddleY) && (ballTop() <= paddleY + paddleH)) {
                returnValue = true;
            }
        }
        return returnValue;
    }

    float ballLeft() {
        return ballX - ballR;
    }

    float ballRight() {
        return ballX + ballR;
    }

    float ballTop() {
        return ballY - ballR;
    }

    float ballBottom() {
        return ballY + ballR;
    }

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == UP) {
                paddleY = paddleY - paddleH;
            } else if (keyCode == DOWN) {
                paddleY = paddleY + paddleH;
            }
        }
    }
    public void mouseMoved() {
        paddleY = mouseY;
    }

    public static void main(String[] args){
        PongTut p = new PongTut();
        PApplet.runSketch(new String[]{"Pong"}, p);
    }
}
