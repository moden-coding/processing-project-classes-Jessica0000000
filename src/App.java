import processing.core.*;
import java.util.*;

public class App extends PApplet {

    ArrayList<Circle> circles;
    double timer;
    int scene = 0;
    int attackStat = 0;

    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        circles = new ArrayList<>();
        int numCircles = 0;
        while (numCircles < 60) {
            int x = (int) random(30, 660);
            int y = (int) random(40, 560);
            Circle c = new Circle(x, y, this);
            circles.add(c);
            numCircles++;

        }

    }

    public void settings() {
        size(700, 600);

    }

    public void draw() {
        background(0);

        if (scene == 0) {
            for (Circle d : circles) {
                d.display();
            } // make the circle appear on screen

            fill(255);
            textSize(25);
            timer = 20 - millis() / 1000;
            text("Time: " + timer, width - 150, 50);
            if (timer == 0) {
                scene++;
                sceneOne();
            } // changing the background and transitioning to the next part of the game
        }
    }

    public void sceneOne() {

            attackStat = circles.size();

            System.out.println(attackStat);
         // calculate the strength of your attack
    }

    public void mousePressed() {
        for (int i = 0; i < circles.size(); i++) {
            Circle c = circles.get(i);
            if (c.checkIfMouseTouch(mouseX, mouseY) == true) {
                circles.remove(c);
            } // removing circles when clicked
        }
    }
}