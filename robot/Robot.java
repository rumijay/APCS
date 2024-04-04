import java.util.Random;

public class Robot {
   private int goalDistance;
   private int maxMoves;
   Random random = new Random(27000);

   public Robot() {
      goalDistance = 100;
      maxMoves = 10;
   }

   public Robot(int dist, int numMoves) {
      goalDistance = dist;
      maxMoves = numMoves;
   }
   
   public void setRobot(int dist, int numMoves) {
      goalDistance = dist;
      maxMoves = numMoves;
   }

   public int moveDistance() {
      double randNum = random.nextFloat();
      int move = (int) (randNum * 27) - 6;
      return move;
   }

   public boolean simulate(boolean printInfo) {
      int currentPosition = 0;
      int moveNumber = 1; 
       
      while (moveNumber < maxMoves) {
         int move = moveDistance();
               
         if (printInfo) {
            System.out.print(currentPosition + "(" + move + ") ");
         
         }
      
         if (currentPosition >= goalDistance) {
            if (printInfo) {
               System.out.println("final position is " + currentPosition);
            }
            return true;
         } 
         else if (currentPosition < 0) {
            if (printInfo) {
               System.out.println("final position is " + currentPosition);
            }
            return false;
         }
         currentPosition += move;
         moveNumber++;
      }
   
      if (printInfo) {
         System.out.println("final position is " + currentPosition);
      }
      return false;
   }

   public double runSimulations(int test) {
      double successfulSimulations = 0;
      int f = 0; 
      boolean result = false;
      
      while (f <= test) {
         result = simulate(false);
         if (result) {
            successfulSimulations++;
         }
         f++;
      }
      return successfulSimulations / test;
   }
}
