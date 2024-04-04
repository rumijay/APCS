import java.util.Scanner;
import java.io.*;

public class WordSearchRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("grid.txt"));

        int rows = in.nextInt();
        int cols = in.nextInt();

        WordSearch80 wordSearch = new WordSearch80(rows, cols);

        in.nextLine(); // consume the newline after cols
        for (int i = 0; i < rows; i++) {
            String line = in.nextLine();
            String[] letters = line.split(" ");
            for (int j = 0; j < cols; j++) {
                wordSearch.setSpot(letters[j].charAt(0), i, j);
            }
        }

        int numWords = in.nextInt();
        in.nextLine(); // consume the newline after numWords

        for (int k = 0; k < numWords; k++) {
            String searchWord = in.nextLine();
            boolean found = wordSearch.inGrid(searchWord.toUpperCase());
            System.out.println(searchWord + " -> " + found);
        }
    }
}
