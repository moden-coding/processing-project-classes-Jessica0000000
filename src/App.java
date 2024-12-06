import processing.core.*;
import java.util.*;

public class App extends PApplet {

    ArrayList<Circle> circles;
    double timer;

    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        circles = new ArrayList<>();
        int numCircles = 0;
        while (numCircles < 100) {
            int x = (int) random(700);
            int y = (int) random(400);
            Circle c = new Circle(x, y, this);
            circles.add(c);
            numCircles++;
           
        }

    }

    public void settings() {
        size(900, 600);

    }

    public void draw() {
        background(0);

        for (Circle d : circles) {
            d.display();
        }

        fill(255);
        textSize(25);
        timer = millis();
        text("Time: " + timer*.001*1.00,width - 150, 50);

    }
}
