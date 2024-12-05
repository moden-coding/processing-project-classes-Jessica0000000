import processing.core.*;
import java.util.*;

public class App extends PApplet{
    
    ArrayList<Circle> circles;
    public static void main(String[] args)  {
        PApplet.main("App");
        
    }

    public void setup(){
        circles = new ArrayList<>();
       
        int numCircles =0;
     
        while(numCircles<4)
        {int x = (int)random(800);
        int y = (int)random(500);
        Circle c = new Circle(x,y,this);
        circles.add(c);
        numCircles++;}
        
    }

    public void settings(){
        size(900,600);
    }

    public void draw(){
       background(0);

       for (Circle d: circles){
        d.display();
    }
    }
}
