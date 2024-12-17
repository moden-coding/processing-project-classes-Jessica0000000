import processing.core.PApplet;

public class Sword {

    private int size;
    private int x;
    private int y;
    private int yTwo;
    private PApplet canvas;
  //  private int color;

    public Sword(int xPos, int yPos, int yPost, PApplet c) {
        x = xPos+ 40;
        y = yPos+50;
        yTwo= yPost+400;
        size = 4;
        canvas = c;
    //    color=randomColor();
    }
    public void displaySword() {
    //    canvas.fill(color);
        canvas.strokeWeight(size);
        canvas.line(x, y,x,yTwo);//add another y value and add strokeweight with strokeweight(1) after I create the line
  // System.out.println(color);//right now color isn't working, it's constantly changing and the swords look black
    }

    // public void increaseAttack(){
    // attack += 5;
    // }
    public int randomColor() {
        return canvas.color(canvas.random(255), canvas.random(255), canvas.random(255));
    }
}
