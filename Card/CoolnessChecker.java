import java.util.Scanner;

public class CoolnessChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their age
        System.out.print("Enter your age: ");

        // Read the user's age
        int age = scanner.nextInt();

        // Check if the person is cool based on age
        if (age >= 14 && age <= 17) {
            System.out.println("You are cool!");
        } else {
            System.out.println("You are not cool.");
        }

        // Close the Scanner to avoid resource leaks
        scanner.close();
    }
}
