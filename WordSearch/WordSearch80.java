

import java.util.Arrays;

public class WordSearch80 {
    private char[][] wordArray; // 2D array to store letters

    public WordSearch80(int row, int col) {
        wordArray = new char[row][col];
    }

    public void setSpot(char s, int row, int col) {
        wordArray[row][col] = s;
    }

    public boolean inGrid(String s) {
        String rowString, colString, revRowString, revColString;

        // Check for word horizontally
        for (int i = 0; i < wordArray.length; i++) {
            rowString = new String(wordArray[i]);
            revRowString = new StringBuilder(rowString).reverse().toString();

            if (rowString.toLowerCase().contains(s.toLowerCase()) || revRowString.toLowerCase().contains(s.toLowerCase())) {
                return true;
            }
        }

        // Check for word vertically
        for (int j = 0; j < wordArray[0].length; j++) {
            char[] colArray = new char[wordArray.length];
            for (int i = 0; i < wordArray.length; i++) {
                colArray[i] = wordArray[i][j];
            }

            colString = new String(colArray);
            revColString = new StringBuilder(colString).reverse().toString();

            if (colString.toLowerCase().contains(s.toLowerCase()) || revColString.toLowerCase().contains(s.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (char[] row : wordArray) {
            result.append(Arrays.toString(row)).append("\n");
        }
        return result.toString();
    }
}


