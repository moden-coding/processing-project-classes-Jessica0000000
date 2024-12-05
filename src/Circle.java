import processing.core.PApplet;
import processing.core.*;

public class Circle {

    private int size;
    private int color;
    private int x;
    private int y;
    private PApplet canvas;

    public Circle(int xPos, int yPos, PApplet c){
        x = xPos;
        y = yPos;
        size = 100;
        canvas = c;
        color = (255);
    }
    public void display(){
        canvas.fill(color);
        canvas.circle(x,y,size);
    }
    public void checkNumCircles(){
        
    }
}
