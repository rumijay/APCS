public class TurtleRunner
{
	public static void main(String args[])
	{  
		//create a world
		World turtleWorld = new World(600,800);
		
		//create  first turtle
     Turtle deb = new Turtle(turtleWorld);
     Turtle tim = new Turtle(50,50, turtleWorld);
     Turtle joe = new Turtle(300, 150, turtleWorld);
     Picture turtlePic = new Picture ("images.jpg");
     Turtle dot = new Turtle(50, 250, turtleWorld);
		
      
      deb.makeSquare();
      tim.makeTriangle();
      joe.makeTriangle();
      tim = joe;
      dot.shape(8,50);
      dot.turn(145);
      dot.penUp();
      dot.forward(300);
      dot.penDown();
      dot.shape(5,75);
	}   
}