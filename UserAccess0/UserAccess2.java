import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class UserAccess2 {

    // Keyboard scanner shared by all methods
    public static final Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        File userFile = new File("users2.dat");

        while (true) {
            System.out.print("(l)ogin or (r)egister? ");
            String choice = scanInput.nextLine();

            if (choice.equals("r")) {
                register(userFile);
                break;
            } else if (choice.equals("l")) {
                if (login(userFile)) {
                    System.out.println("Welcome!!!");
                    break; //                     
                } else {
                    System.out.println("Username and/or password do not match. Try again.");
                 

                }
            } else {
                System.out.println("Please enter either 'l' or 'r'.");
            }
        }
    }

    public static boolean login(File userFile) throws FileNotFoundException, NoSuchAlgorithmException {
        System.out.print("Username? ");
        String username = scanInput.nextLine();
        System.out.print("Password? ");
        String password = scanInput.nextLine();
            
        try {
            Scanner scanner = new Scanner(userFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 3 && parts[0].equals(username)) {
                    String storedHash = parts[1];
                    String salt = parts[2];
                    String inputHash = generateHash(password, salt);

                    if (storedHash.equals(inputHash)) {
                        scanner.close();
                        return true;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void register(File userFile) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        String username = enterDifferent(userFile);
        String password = enterPassword();
        String salt = makeSalt();
        String hashedPassword = generateHash(password, salt);

        try (FileWriter fw = new FileWriter(userFile, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(username + " " + hashedPassword + " " + salt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Welcome!!!");
       
    }

    public static String enterDifferent(File userFile) {
        String username;
        while (true) {
            System.out.print("Username? ");
            username = scanInput.nextLine();
            if (!isUsernameTaken(username, userFile)) {
                return username;
            }
            System.out.println("Username already taken. Please choose a different one.");
        }
    }

    public static boolean isUsernameTaken(String username, File userFile) {
        try (Scanner scanner = new Scanner(userFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length >= 1 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String enterPassword() {
        while (true) {
            System.out.print("Password? ");
            String password = scanInput.nextLine();
            System.out.print("Verify Password? ");
            String verifyPassword = scanInput.nextLine();
            if (password.equals(verifyPassword)) {
                return password;
            }
            System.out.println("Passwords do not match. Try again.");
        }
    }

    public static String makeSalt() {
        char[] ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder salt = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 25; i++) {
            salt.append(ALPHANUMERIC[rand.nextInt(ALPHANUMERIC.length)]);
        }
        return salt.toString();
    }

    public static String generateHash(String password, String salt) throws NoSuchAlgorithmException {
        String input = password + salt;
        byte[] hash = getSHA(input);
        return toHexString(hash);
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
