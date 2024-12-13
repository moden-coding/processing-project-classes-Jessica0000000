import processing.core.PApplet;

public class Sword {

    private int size;
    private int x;
    private int y;
    private PApplet canvas;

    public Sword(int attackStat, int xPos, int yPos, PApplet c) {
        x = xPos;
        y = yPos;
        size = 40;
        canvas = c;
    }
    public void displaySword() {
        canvas.fill(0);
        canvas.line(x, y);//add another y value and add strokeweight with strokeweight(1) after I create the line
    }

    // public void increaseAttack(){
    // attack += 5;
    // }

}
