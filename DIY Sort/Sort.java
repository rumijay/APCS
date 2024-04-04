import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;


public class Sort {

   public static void main(String[] args) {
   
      int[] numbers = new int[10];
      for (int i = 0; i < numbers.length; i++) {
         numbers[i] = (int) (Math.random() * 21) + 1;
      }
      System.out.println("Bubble Sort");
      System.out.println(java.util.Arrays.toString(numbers));
      bubbleSort(numbers);
      System.out.println(java.util.Arrays.toString(numbers));
      
      
      ArrayList<Integer> a = new ArrayList<Integer>();
      for (int i = 0; i < numbers.length; i++) {
         int l =  (int) (Math.random() * 21) + 1;
         a.add(l);
      }
      System.out.println();
      System.out.println("Selection Sort");
      System.out.println(a);
      selectionSort(a);
      System.out.println(a);
      
      
      ArrayList<Integer> b = new ArrayList<Integer>();
      for (int i = 0; i < numbers.length; i++) {
         int l =  (int) (Math.random() * 21) + 1;
         b.add(l);
      }
      System.out.println();
      System.out.println("Ascending Bubble Sort");
      System.out.println(b);
      bubbleSort(b, false); 
      System.out.println(b);
      
      
      
      ArrayList<Integer> c = new ArrayList<Integer>();
      for (int i = 0; i < numbers.length; i++) {
         int l =  (int) (Math.random() * 21) + 1;
         c.add(l);
      }
      
      System.out.println();
      System.out.println("Ascending Selection Sort");
      System.out.println(c);
      bubbleSort(c, true); 
      System.out.println(c);
      
   }
  
  
   public static void bubbleSort(int[] array){
   
      for (int i = 0; i < array.length-1; i++)
      {
         for (int k = 0; k < array.length-i-1; k++){
            if (array[k] > array[k+1])
            {
               int l = array[k];
               array[k] = array[k+ 1];
               array[k+1] =l;
            }     
         }
      }
   }
  
   public static void selectionSort(ArrayList<Integer> list){
   
   
      for(int i=0; i < list.size(); i++){
         int min = list.get(i);
         int indexOfMin = i;
         for(int k=i+1; k < list.size(); k++){
         
            if(list.get(k) < list.get(indexOfMin))
            {
               indexOfMin = k;
            }
         }
         
         if (indexOfMin != i){
            int initial = list.get(i);
            min = list.get(indexOfMin);
            Collections.swap(list, i, indexOfMin);
         
         }
      
      }
   
   
   
   }
   
   
   public static void bubbleSort(ArrayList<Integer> list, boolean ascending)  	
   {
   int count = 0;
      for (int i = 0; i < list.size()-1; i++)
      {
         for (int k = 0; k < list.size()-i-1; k++){
            
            if(ascending){
               if (list.get(k) > list.get(k+1))
               {
                  Collections.swap(list, k, k+1);
                  count++;
               
               }     
            }
            
            else{
               if (list.get(k) < list.get(k+1))
               {
                  Collections.swap(list, k, k+1);
                  count++;
               
               }           
            }
         }
      }
    
   }

  
   public static void selectionSort(ArrayList<Integer> list, boolean ascending){
   
      for(int i=0; i < list.size(); i++){
         int min = list.get(i);
         int indexOfMin = i;
         
         if(ascending){
            for(int k=i+1; k < list.size(); k++){
            
               if(list.get(k) < list.get(indexOfMin))
               {
                  indexOfMin = k;
               }
            }}
         
         else{
            for(int k=i+1; k < list.size(); k++){
            
               if(list.get(k) > list.get(indexOfMin))
               {
                  indexOfMin = k;
               }
            }
         
         
         }
         
         if (indexOfMin != i){
            int initial = list.get(i);
            min = list.get(indexOfMin);
            Collections.swap(list, i, indexOfMin);
         
         }
      
      }
   
   
   
   
   }

}