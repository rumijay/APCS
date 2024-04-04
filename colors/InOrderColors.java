public class InOrderColors
{ 
   private String colorOne;
   private String colorTwo;
   private String colorThree;
   public InOrderColors()
   {
            colorOne   =   "red";
      colorTwo   = "green";
      colorThree =  "blue";
   }
   public InOrderColors(String c1, String c2, String c3)
   {
      colorOne   = c1;
      colorTwo   = c2;
      colorThree = c3;
   }

   public void setColorOne(String s1)
   {
      colorOne = s1;
   }
   
   public void setColorTwo(String s2) {colorTwo = s2;}
   public void setColorThree(String s3) {colorThree = s3;}
   public String getColorOne(){return colorOne;}
   public String getColorTwo() {return colorTwo;}
   public String getColorThree() {return colorThree;}
     public static int wavelength(String in_String) {
      switch(in_String) {
         case "red":
            return 700;
         case "orange":
            return 600;
         case "yellow":
            return 580;
         case "green":
            return 540;
         case "blue":
            return 500;
         case "indigo":
            return 450;
         case "violet":
            return 400;
         default:
            return 0;
         
      }
   }


    public static boolean areTheyInOrder(int first_wavelength, int second_wavelength, int third_wavelength) {
      if(first_wavelength <= second_wavelength && second_wavelength <= third_wavelength) {
         return true;
      }
      else { return false;}
   }
 
    public void sortThem() {
      int wl1   = wavelength(colorOne);
      int wl2   = wavelength(colorTwo);
      int wl3 = wavelength(colorThree);
      String c1 = colorOne;
      String c2 = colorTwo;
      String c3 = colorThree;
      if (areTheyInOrder(wl1,wl3 ,wl2)) { colorOne = c1; colorTwo = c3; colorThree = c2;}
      if (areTheyInOrder(wl2,wl3 ,wl1)) { colorOne = c2; colorTwo = c3; colorThree = c1;}
      if (areTheyInOrder(wl2,wl1 ,wl3)) { colorOne = c2; colorTwo = c1; colorThree = c3;}
      if (areTheyInOrder(wl3,wl1 ,wl2)) { colorOne = c3; colorTwo = c1; colorThree = c2;}
      if (areTheyInOrder(wl3,wl2 ,wl1)) { colorOne = c3; colorTwo = c2; colorThree = c1;}

   }
   
   public String toString()
   {
      return "" + colorOne + " " + colorTwo + " " + colorThree;   
   }
}
