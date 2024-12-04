import processing.core.PApplet;
import processing.core.*;

public class AttackCircles {

    private int size;
    private int color;
    private int x;
    private int y;
    private PApplet canvas;

    public void Circle(int xPos, int yPos, PApplet c){

        x = xPos;
        y = yPos;
        size = 50;
        canvas = c;
        color = (0);
    }
    public void display(){
        canvas.fill(color);
        canvas.circle(x,y,size);
    }
}
