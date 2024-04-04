import java.util.Scanner;

public class AntClimb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Upward progress: ");
        int upward = scan.nextInt(); 
        System.out.print("Downward slide: ");
        int downward = scan.nextInt(); 
        System.out.print("Depth of hole: ");
        int depthOfHole = scan.nextInt();  
        System.out.println("Distance: " + climb(upward, downward, depthOfHole, 0));
    }
    
    public static int climb(int upward, int downward, int depthOfHole, int distance) {
        if (depthOfHole <= 0) {
            return distance;
        } else {
            // Ant makes upward progress
            distance += upward;
            // Ant slips downwards
            distance -= downward;
            // Recur for remaining depth of the hole
            return climb(upward, downward, depthOfHole - (upward - downward), distance);
        }
    }
}
