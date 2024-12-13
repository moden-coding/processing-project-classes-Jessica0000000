import processing.core.*;
import java.util.*;

public class App extends PApplet {

    ArrayList<Circle> circles;//creates array list for circles
    ArrayList<Sword> swords;//creates array list for swords
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
        swords= new ArrayList<>();
       while(attackStat>0){
        int xTwo = (int) random(30, 660);
        int yTwo= (int) random(40, 560);
        Sword s = new Sword(xTwo, yTwo, this);
        swords.add(s);
       }

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
            //make sword appear
            for (Sword s : swords) {
                s.displaySword();
            }

            fill(255);
            textSize(25);
            timer = 10 - millis() / 1000;
            text("Time: " + timer, width - 150, 50);// creating the timer counting down from 10 in the first part of the

            // game
            if (timer == 0) {
                scene++;
                sceneOne();// changing the background and transitioning to the next part of the game
            }
        }
    }

    public void sceneOne() {
        background(0, 35, 255);// changing the background for the next part of the game

        System.out.println(attackStat);

        line(200, 200, 200, 400);

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

//etra code for sword:
 // Sword blade
//  fill(220);
//  stroke(0);
//  strokeWeight(2);
//  beginShape();
//  vertex(195, 200); // Top point
//  vertex(205, 200);
//  vertex(210, 300);
//  vertex(210, 400);
//  vertex(190, 400);
//  vertex(190, 300);
//  endShape(CLOSE);

//  // Blade outline
//  line(200, 200, 200, 400);

//  // Sword guard
//  fill(150);
//  noStroke();
//  arc(200, 410, 40, 20, PI, TWO_PI);

//  // Guard details
//  stroke(0);
//  strokeWeight(1);
//  line(180, 410, 220, 410);

//  // Handle grip
//  fill(139, 69, 19);
//  rect(195, 420, 10, 50);

//  // Handle wrapping details
//  stroke(0);
//  for (int i = 0; i < 5; i++) {
//      line(195, 420 + i * 10, 205, 425 + i * 10);
//      line(205, 420 + i * 10, 195, 425 + i * 10);
//  }

//  // Pommel
//  fill(200);
//  ellipse(200, 475, 15, 15);