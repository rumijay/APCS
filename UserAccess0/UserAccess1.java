import java.io.*;
import java.util.*;

public class UserAccess1 {
    
    // Keyboard scanner shared by all methods
   public static final Scanner scanInput = new Scanner(System.in);
   public static void main(String[] args) throws FileNotFoundException, IOException {
      File userFile = new File("users1.dat"); //  File object to represent the users1.dat file
      System.out.print("(l)ogin or (r)egister? "); // Prompt the user for login or register
      String choice = scanInput.nextLine(); // Read the user's choice
   
      if (choice.equals("r")) {
         register(userFile); // Call the register method if the user chose to register
      } else if (choice.equals("l")) {
         if (login(userFile)) { // Call the login method if the user chose to login
            System.out.println("Welcome!!!"); // If login is successful, print a welcome message
         } else {
            System.out.println("Username and/or password do not match. Try again."); // If login fails, print an error message
         }
      }
   }

   public static boolean login(File userFile) throws FileNotFoundException { // login
     Boolean foundPass = false;  
     while (!foundPass)
     {
      System.out.print("Username? "); // Prompt the user for their username
      String username = scanInput.nextLine(); // Read the username input
      System.out.print("Password? "); // Prompt the user for their password
      String password = scanInput.nextLine(); // Read the password input
      try {
         Scanner scanner = new Scanner(userFile); // Create a scanner to read the user data file
         while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Read a line from the file
            String[] parts = line.split(" "); // Split the line into parts using space as a delimiter
            if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
               scanner.close();
               return true; // If a matching username and password are found, return true
            }
         }
         scanner.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace(); // Handle exceptions?? 
      }
      System.out.println("Username and/or password do not match. Try again.");
       } 
      return false; // If no matching username and password are found, return false
   }

   public static void register(File userFile) throws FileNotFoundException, IOException { // register
      boolean badUser = false;
      String username;
      do {
         badUser = false;
         Scanner in = new Scanner (new File("users1.dat"));
         System.out.print("Username? "); //   username
         username = scanInput.nextLine(); // Read the username input
         
         while (in.hasNext())
         {
            String user = in.next();
            if (user.equals(username)) {
               badUser = true;
               System.out.println("Username already taken. Please choose a different one.");
            
            }
            in.next();
         }
         if (badUser)
            continue;
         in.close();
      } while(badUser == true);
      boolean badPass = false;
      do {
         badPass = false;
         System.out.print("Password? "); // password
         String password = scanInput.nextLine(); // Read the password input
         System.out.print("Verify Password? "); // verify the password
         String verifyPassword = scanInput.nextLine(); // Read the password verification input
      
         if (password.equals(verifyPassword)) {
            try {
            
               FileWriter fw = new FileWriter("users1.dat", true); // Open the file in append mode
               PrintWriter pw = new PrintWriter(fw); // Create a PrintWriter to write to the file
               pw.println( username +" " + password); // Write the username and password to the file
               fw.close();
               System.out.println("Welcome!!!"); // If registration is successful, print a welcome message
            } catch (IOException e) {
               e.printStackTrace(); // Handle any exceptions
            }
         
         
         } else {
            System.out.println("Passwords do not match. Try again."); // If passwords do not match, print an error message
            badPass = true;
         }
      } while (badPass == true);
   
   }
}
