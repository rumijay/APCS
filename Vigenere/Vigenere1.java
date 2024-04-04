import java.lang.reflect.Array;
import java.security.spec.ECField;
import java.util.Arrays;

public class Vigenere1
{
   // declare instance variables for text and keyword
   private String plainText;
   private String key;

   // default constructor
   public Vigenere1 ()
   {
	   
   }
    
   // initialization constructor
   public Vigenere1 (String theMsg, String theKey) {
      plainText = theMsg;
      key = theKey;

   }
    
   // modifier method for plainText
   public void setPlainText(String in) { plainText = in; }
    
   // modifier method for key
   public void setKey(String in) { key = in; }
    
   // accessor method for plainText
   public String getPlainText() { return plainText; }
    
   // accessor method for key
   public String getKey() { return key; }

    
   // encrypt method
   //   return a String
   //   no parameters
   public String encrypt() {
      char[] PT_array = plainText.toCharArray();
      int[] PT_ASCII = new int[plainText.length()];
      char[] KW_array = key.toCharArray();
      int[] KW_ASCII = new int[key.length()];
      int[] EC_ASCII = new int[plainText.length()];
      char[] EC_array = new char[plainText.length()];
      // int key_counter = 0;

      for (int counter = 0; counter < plainText.length(); counter++) {
         PT_ASCII[counter] = ((int)PT_array[counter]-65); 
         KW_ASCII[counter%KW_ASCII.length] = ((int)KW_array[counter%KW_ASCII.length]-65);
         // key_counter++; if (key_counter > 2) { key_counter = 0; }

         EC_ASCII[counter] = ((PT_ASCII[counter] + KW_ASCII[counter%KW_ASCII.length])%26);
         EC_array[counter] = ((char)(EC_ASCII[counter]+65));
      }
      
      String EC_str = new String(EC_array);

      return EC_str;
   }
   
    
   // decrypt method
   //   return a String
   //   String parameter 
   public String decrypt(String in) {
      char[] EC_array = in.toCharArray();
      int[] EC_ASCII  = new int[in.length()];
      char[] PT_array = new char[in.length()];
      int[] PT_ASCII  = new int[in.length()];
      char[] KW_array = key.toCharArray();
      int[] KW_ASCII  = new int[key.length()];
      int difference = 0;

      for (int counter = 0; counter < in.length(); counter++) {

         EC_ASCII[counter] = ((int)(EC_array[counter])-65);
         KW_ASCII[counter%(key.length())] = ((int)(KW_array[counter%(key.length())])-65);
         difference = (EC_ASCII[counter] - KW_ASCII[counter%(key.length())]%26);
         
         if (difference < 0) { difference = (26+difference); }
         PT_ASCII[counter] = difference;
         PT_array[counter] = ((char)(PT_ASCII[counter]+65));
          

      }
      String str = new String(PT_array);
      return str;
   }
    
   
   // equals method
   //   return a boolean
   //   parameter must be Object obj
   public boolean equals(Object obj) {

      Vigenere1 v = (Vigenere1) obj;
      if(plainText.equals(v.plainText) && key.equals(v.key)) { return true;}
      return false;
   }
    
   
   // toString() method
   public String toString()
   {
        return("plain Text     = " + plainText + "\nkey            = " + key + "\nencrypted Text = " + encrypt());    // Do NOT modify 
   }
    
}