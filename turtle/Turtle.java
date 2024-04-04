import java.util.*;
import java.awt.*;

public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////
 
  public Turtle (int x, int y, Picture picture) 
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
 
  public Turtle (int x, int y, 
                 ModelDisplay modelDisplayer) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  
  public Turtle (ModelDisplay modelDisplay) 
  {
    super(modelDisplay);
  }
  
  
  public Turtle (Picture p)
  {
    super(p);
  }  
  
  /////////////////// methods ///////////////////////
  
  Picture turtlePic = new Picture ("images.jpg");
  
  public void makeSquare() {
      forward();
      drop(turtlePic);
      turnRight();
      forward();
      drop(turtlePic);
      turnRight();
      forward();
      drop(turtlePic);
      turnRight();
      forward();
      drop(turtlePic);
  }
  
  public void makeTriangle() {
      drop(turtlePic);
      turn(120);
      forward();
      drop(turtlePic);
      turn(120);
      forward();
      drop(turtlePic);
      turn(120);
      forward();
      
  
  }
  
  public void shape(int Sides, int Side_Length) {
  
  
  for (int i = 0; i < Sides; i++) {
  
  drop(turtlePic);
  turn(360/Sides);
  forward(Side_Length);
  }
  
  
  
  }




} 