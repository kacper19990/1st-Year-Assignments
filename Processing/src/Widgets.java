import processing.core.PApplet;
import processing.core.PFont;

public class Widgets extends PApplet{

    final int EVENT_BUTTON1 = 1;
    final int EVENT_BUTTON2 = 2;
    final int EVENT_NULL = 0;
    public class Widget {
        int x, y, width, height;
        String label; int event;
        int widgetColor, labelColor;
        PFont widgetFont;

        Widget(int x, int y, int width, int height, String label,
               int widgetColor, PFont widgetFont, int event){
            this.x=x; this.y=y; this.width = width; this.height= height;
            this.label=label; this.event=event;
            this.widgetColor=widgetColor; this.widgetFont=widgetFont;
            labelColor= color(0);
        }
        void draw(){
            fill(widgetColor);
            rect(x,y,width,height);
            fill(labelColor);
            text(label, x+10, y+height-10);
        }
        int getEvent(int mX, int mY){
            if(mX>x && mX < x+width && mY >y && mY <y+height){
                return event;
            }
            return EVENT_NULL;
        }
    }
    public class main {
        PFont stdFont;
        Widget widget1, widget2;
        void setup() {
            stdFont = loadFont("Chiller-Regular-36.vlw");
            textFont(stdFont);
            widget1 = new Widget(100, 100, 100, 40,
                    "press me!", color(100),
                    stdFont, EVENT_BUTTON1);
            widget2 = new Widget(100, 200, 100, 40,
                    "no, me!", color(100),
                    stdFont, EVENT_BUTTON2);
            size(400, 400);
        }

        void draw() {
            widget1.draw();
            widget2.draw();
        }
    }

    public static void main(String[] args){
        Widgets p = new Widgets();
        PApplet.runSketch(new String[]{"Widget"}, p);
    }
}
