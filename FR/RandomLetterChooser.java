public class RandomLetterChooser extends RandomStringChooser
{
/** Constructs a random letter chooser using the given string str.
* Precondition: str contains only letters.
*/
   public RandomLetterChooser(String str)
   {     super(getSingleLetters(str));
   }
   
/** Returns an array of single-letter strings.
* Each of these strings consists of a single letter from str. Element k
* of the returned array contains the single letter at position k of str.
* For example, getSingleLetters("cat") returns the
* array { "c", "a", "t" }. */
   public static String[] getSingleLetters(String str) 
    { /* implementation not shown in AP FRP document, but included here so you can submit the whole class */  String[] l = new String[str.length()]; for (int i = 0; i < str.length(); i++) l[i] = str.substring(i, i+1); return l; }
}