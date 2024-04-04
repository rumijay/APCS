import java.io.*;
import java.util.*;

class QuickSortTester {


   public static void main (String [] args) throws IOException {
      testQuickSort();
   }

   public static void testQuickSort () throws IOException {
      String[] test = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
      MergeSort.sort(test);
      System.out.println("test  = " + Arrays.toString(test));
      String[] prefixes = {"small", "medium", "large"};
      String[] suffixes = {"ascending.txt", "descending.txt", "random.txt"};
      for (String prefix : prefixes) {
         for (String suffix : suffixes) {
            String filename = prefix + "_" + suffix;
            String[] array = load(filename);
            long start, end;
         
            System.out.println("Sorting " + filename + " with " + array.length + " words");
         
            String[] copy = Arrays.copyOf(array, array.length);
            start = System.currentTimeMillis();
            Arrays.sort(copy);
            end = System.currentTimeMillis();
            System.out.println("\tArrays.sort() took:\t" + (end - start) + " ms");
         
            start = System.currentTimeMillis();
            String[] sortedArray = QuickSort.sort(array);
            end = System.currentTimeMillis();
            if (Arrays.equals(sortedArray, copy)) {
               System.out.println("\tYour sort method took:\t" + (end - start) + " ms");
            } else {
               System.err.println("\tYour sort does not properly sort the array in ascending order!");
            }
         
            System.out.println();
         }
      }
   }


  /**
   * Reads an entire file into an array of Strings, where each element
   * represents a new line in the file. Assumes the file's first line is an
   * integer indicating the number of following lines.
   * @param filename The filename of the file to read.
   * @return An array of strings read from the file.
   * @throws IOException If the file doesn't exist or an error occurs during the
   *     reading.
   */
   public static String[] load (String filename) throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String[] lines = new String[Integer.parseInt(reader.readLine())];
      for (int i = 0; i < lines.length; i++) {
         lines[i] = reader.readLine();
      }
      return lines;
   }




  
  
}

