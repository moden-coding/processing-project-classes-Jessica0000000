import processing.core.PApplet;
import processing.core.*;

public class Circle {

    private int size;
    private int color;
    private int x;
    private int y;
    private PApplet canvas;

    public Circle(int xPos, int yPos, PApplet c) {
        x = xPos;
        y = yPos;
        size = 80;
        canvas = c;
        color = randomColor();
    }

    public void display() {
        canvas.fill(color);
        canvas.circle(x, y, size);
    }

    public int randomColor() {
        return canvas.color(canvas.random(255), canvas.random(255), canvas.random(255));
    }

    public boolean checkIfMouseTouch(int mouseX, int mouseY) {
        float distanceFromCenter = canvas.dist(x, y, mouseX, mouseY);
        if (distanceFromCenter < size / 2) {
            return true;
        }else{
            return false;
        }

    }
}
