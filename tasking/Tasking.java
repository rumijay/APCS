public class Tasking        
{ 

public static void main( String[] args) 

   {
      System.out.println("\nRunning main() in Tasking class!\n");
      System.out.println("\nTrying mission()");
      Tasking.mission();
      System.out.println(" \nTrying favorite()");
      System.out.println("nbr1=" + Task.favorite());
      System.out.println("nbr2=" + Task.favorite());
      System.out.println(" \nTrying wasted()");
            double dpm = 3.75;
            int days = 30;
            Task.wasted( dpm, days ); // 11 gallons
            Task.wasted( 7.50,  5 );  // 4 gallons
      
      System.out.println(" \nTrying count()");
      System.out.println(Task.count( 1.5, 0.9, 500 ) + " beans");   //: 438 beans
      System.out.println(Task.count( 2.0, 1.0, 25) + " beans");   //: 13 beans
         
   }
    public static void mission() {
		System.out.println("The Liberal Arts and Science Academy cultivates responsible leaders, problem solvers, and thinkers by offering a nationally recognized, rigorous, innovative, evolving curriculum.");
   } 
}