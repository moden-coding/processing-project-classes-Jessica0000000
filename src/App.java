import processing.core.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;

public class App extends PApplet {

    ArrayList<Circle> circles;// creates array list for circles
    ArrayList<Sword> swords;// creates array list for swords
    double timer;
    double highscore;// time it takes to pop circles
    int scene = 0;
    int attackStat = 0;
    int monsterHealth = 60;// health of the monster
    double score;// initial score

    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        circles = new ArrayList<>();
        int numCircles = 0;
        int circlesWanted=400;
        while (numCircles < circlesWanted) {
            int x = (int) random(30, 660);
            int y = (int) random(40, 560);
            Circle c = new Circle(x, y, this);
            circles.add(c);
            numCircles++;
            attackStat++;// create attack stat equal to the number of circles spawning

        } // creates 60 circles

        // start of text

    }

    public void saveHighscore() {
        if (score > highscore) {
            highscore = score;
        } 
        try (PrintWriter writer = new PrintWriter("highscore.text")) {
            writer.println(highscore); // Writes the integer to the file
            writer.close(); // Closes the writer and saves the file
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();

        }
    }

    public void textreading() {
        try (Scanner scannerTwo = new Scanner(Paths.get("highscore.text"))) {

        while (scannerTwo.hasNextLine()) {
        // we read one line
        String row = scannerTwo.nextLine();
        highscore=Double.valueOf(row);//changing highscore to row
        if(score>highscore){
        highscore= score;
        }
        saveHighscore();

        }
        } catch (Exception e) {
        System.out.println("Reading the file " + "highscore.text" + " failed.");
        // System.out.println("Error: " + e.getMessage());
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

            fill(255);
            textSize(25);
            timer = 15 - millis() / 1000;
            text("Time: " + timer, width - 150, 50);// creating the timer counting down from 10 in the first part of the

            if (timer == 0) {
                scene++;
                sceneOne();// changing the background and transitioning to the next part of the game
            }
        }

        if (scene == 1) {

            background(0, 35, 255); // ensures objects moving don't leave imprint on screen
            textreading();
            saveHighscore();
            fill(255);
            textSize(25);
            text("Highscore: " + highscore, width - 250, 100);
            text("Score: " + score, width - 250, 50);
            //below is code I commented out because I wasn't able to integrate it into my game
            // // creates monster, done partly by ChatGPT
            // // Calculate position and size
            // float monsterX = width / 2;
            // float monsterY = height / 2;
            // float monsterSize = min(width, height) / 2; // Quarter of the screen

            // // Draw body (circle)
            // fill(200, 100, 255); // Light purple
            // ellipse(monsterX, monsterY - 50, monsterSize, monsterSize);
            // fill(0);
            // ellipse(294, 215, 70, 40);
            // ellipse(400, 215, 70, 40);

            // for (Sword s : swords) {
            // s.displaySword();
            // } // when the scene changes make the swords appear

        }
    }

    public void sceneOne() {
        background(0, 35, 255);// changing the background for the next part of the game
        score = 400 - attackStat;//score is equal to the number of circles you popped
        //below is code that I unfortunately was not able to implement in my final game because I ran out of time
        swords = new ArrayList<>();// creating new array list for swords
        int attack;// how many swords should spawn to attack the monster
        attack = attackStat;
        while (attack > 0) {
            int x = (int) random(0, 650);
            int y = (int) random(400, 250);
            int yTwo = 200;
            Sword s = new Sword(x, y, yTwo, this);
            swords.add(s);
            attack--;
        }
        System.out.println("attackStat is " + attackStat);// attackStat is the number of circles removed so it acts as the highscore here
        // creates number of swords equal to the attackStat
        //I wasn't able to get to displaying the swords
    }

    public void mousePressed() {
        for (int i = 0; i < circles.size(); i++) {
            Circle c = circles.get(i);
            if (c.checkIfMouseTouch(mouseX, mouseY) == true) {
                circles.remove(c);
                attackStat = attackStat - 1;
            } // removing circles when clicked
        }

    }
}