import java.util.Arrays;
import java.util.Scanner;

public class CollatzTest {
    public static void main(String[] args) {
        // start
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting number: ");
        int startingNumber = scanner.nextInt();
        scanner.close();

        //object
        Collatz collatz = new Collatz(startingNumber);

        // Print :D
        System.out.println(collatz);
        System.out.println("steps() returns " + collatz.steps());
        System.out.println("sequence() returns " + Arrays.toString(collatz.sequence()));
        System.out.println("maxValue() returns " + collatz.maxValue());
        System.out.println("minOddValue() returns " + collatz.minOddValue());
        System.out.println("oddValues() returns " + Arrays.toString(collatz.oddValues()));
        System.out.println("sumValues() returns " + collatz.sumValues());
    }
}
