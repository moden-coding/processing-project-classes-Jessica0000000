import processing.core.*;
import java.util.*;

public class App extends PApplet {

    ArrayList<Circle> circles;// creates array list for circles
    ArrayList<Sword> swords;// creates array list for swords
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
            attackStat++;// create attack stat equal to the number of circles spawning

        } // creates 60 circles

    }

    public void settings() {
        size(700, 600);// establishing size of screen

    }

    public void draw() {

        if (scene == 0) {
            background(0);
            for (Circle d : circles) {
                d.display();
            } // make the circle appear on screen

            fill(255);
            textSize(25);
            timer = 1 - millis() / 1000;
            text("Time: " + timer, width - 150, 50);// creating the timer counting down from 10 in the first part of the

            if (timer == 0) {
                scene++;
                sceneOne();// changing the background and transitioning to the next part of the game
            }
        }

        if (scene == 1) {

            background(0, 35, 255); // ensures objects moving don't leave imprint on screen
            fill(255);// figure out where x and y values are to create shapes
            text("pos" + mouseX + "," + mouseY, 50, 199);
            // creates monster, done partly by ChatGPT
            // Calculate position and size
            float monsterX = width / 2;
            float monsterY = height / 2;
            float monsterSize = min(width, height) / 2; // Quarter of the screen

            // Draw body (circle)
            fill(200, 100, 255); // Light purple
            ellipse(monsterX, monsterY - 50, monsterSize, monsterSize);
            fill(0);
            ellipse(294, 215, 70, 40);
            ellipse(400, 215, 70, 40);

            for (Sword s : swords) {
                s.displaySword();
            } // when the scene changes make the swords appear

        }
    }

    public void sceneOne() {
        background(0, 35, 255);// changing the background for the next part of the game

        swords = new ArrayList<>();// creating new array list for swords
        while (attackStat > 0) {
            int x = (int) random(0, 650);
            int y = (int) random(400, 250);
            int yTwo = 200;
            Sword s = new Sword(x, y, yTwo, this);
            swords.add(s);
            attackStat--;
        }

        // creates number of swords equal to the attackStat

        // int times=0;
        // times++;
        // System.out.println("gone" +times);
    }

    public void mousePressed() {
        for (int i = 0; i < circles.size(); i++) {
            Circle c = circles.get(i);
            if (c.checkIfMouseTouch(mouseX, mouseY) == true) {
                circles.remove(c);
                attackStat = attackStat - 1;
            } // removing circles when clicked
        }

        // boss snakeBoss = new boss(attackStat);
        // boss caterpillarBoss = new boss(attackStat/2);
    }
}