import processing.core.*;
import java.util.*;
import java.util.Scanner;

public class App extends PApplet{
    ArrayList<circles> circle;
    public static void main(String[] args)  {
        PApplet.main("App");
        
    }

    public void setup(){
        circle = new ArrayList<>();
    }

    public void settings(){
        size(900,600);
    }

    public void draw(){
       background(0);


    }
}
