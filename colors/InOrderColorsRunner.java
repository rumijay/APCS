import java.util.*;
import java.util.Scanner;

public class InOrderColorsRunner
{
   public static void main( String[] args ) 
   {     
     
      System.out.println("FIRST InOrderColors OBJECT INSTANCE");  // DO NOT MODIFY
      
      InOrderColors threeCols1 = new InOrderColors();
      System.out.println("  Object -> " + threeCols1);   // DO NOT MODIFY
 
      if ( threeCols1.areTheyInOrder(threeCols1.wavelength(threeCols1.getColorOne()), threeCols1.wavelength(threeCols1.getColorTwo()), threeCols1.wavelength(threeCols1.getColorThree())))  {
         System.out.println("  Currently the colors are in wavelength order.");  // DO NOT MODIFY
      }                                                                          // DO NOT MODIFY
      else {                                                                     // DO NOT MODIFY
         System.out.println("  Currently colors are NOT in wavelength order.");  // DO NOT MODIFY
      }                                                                          // DO NOT MODIFY
      
       
      threeCols1.sortThem();
      System.out.println("  Object -> " + threeCols1);  // DO NOT MODIFY
                  
      if ( threeCols1.areTheyInOrder(threeCols1.wavelength(threeCols1.getColorOne()), threeCols1.wavelength(threeCols1.getColorTwo()), threeCols1.wavelength(threeCols1.getColorThree()))) {               
         System.out.println("  Currently the colors are in wavelength order.");  // DO NOT MODIFY
      }                                                                          // DO NOT MODIFY
      else {                                                                     // DO NOT MODIFY
         System.out.println("  Currently colors are NOT in wavelength order.");  // DO NOT MODIFY
      }          
         
      
      System.out.println("SECOND InOrderColors OBJECT INSTANCE");   // DO NOT MODIFY
      
      InOrderColors threeCols2  = new InOrderColors();
      
      Scanner scan = new Scanner(System.in);
      
      System.out.print( "  Enter three colors: " );    // DO NOT MODIFY
      
      String color1 = scan.next();
      String color2 = scan.next();
      String color3 = scan.next();
      scan.nextLine();
      
      threeCols2.setColorOne(color1); threeCols2.setColorTwo(color2); threeCols2.setColorThree(color3);
      System.out.println("Object -> " + threeCols2);
      threeCols2.sortThem();
      System.out.println("Object -> " + threeCols2);
      System.out.println("  The color with the smallest wavelength is " + threeCols2.getColorOne() + ".");   // DO NOT MODIFY     
  
   
      System.out.println("THIRD InOrderColors OBJECT INSTANCE");  // DO NOT MODIFY
      
          InOrderColors threeCols3 = new InOrderColors("orange", "yellow", "violet");
      System.out.println("Object -> " + threeCols3);
      threeCols3.sortThem();
      System.out.println("Object -> " + threeCols3);
      System.out.println("The color with the largest wavelength is " + threeCols3.getColorThree() + ".");  // DO NOT MODIFY     
      

   }
}