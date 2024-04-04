public class RobotTest {
   public static void main(String[] args) {
      // Create a Robot instance
      Robot robot = new Robot(20, 5);
   
      // Testing the simulate method with print
      System.out.println("testing simulate() #1");
      boolean result1 = robot.simulate(true);
      System.out.println(result1);
   
      System.out.println("testing simulate() #2");
      boolean result2 = robot.simulate(true);
      System.out.println(result2);
   
      System.out.println("testing simulate() #3");
      boolean result3 = robot.simulate(true);
      System.out.println(result3);
   
      System.out.println("testing simulate() #4");
      boolean result4 = robot.simulate(true);
      System.out.println(result4);
   
      System.out.println("testing simulate() #5");
      boolean result5 = robot.simulate(true);
      System.out.println(result5);
   
      // Testing runSimulations with simulations
      int numSimulations = 100;
      double successRate = robot.runSimulations(numSimulations);
      System.out.println(numSimulations + " sims of distance=24, max attempts=5 -> " + successRate);
   }
}
