public class Book {

   private String title;
   private String author;
   private int rating;
   
   public Book(String t, String a, int r)
   {
      title = t;
      author = a;
      setRating(r);
   }
   
   public String getTitle()
   {
      return title;
   }
   
   public void setTitle(String t)
   {
      title = t;
   }
   
   public String getAuthor()
   {
      return author;
   }
   
   public void setAuthor(String a)
   {
      author = a;
   }
   
   public int getRating()
   {
      return rating;
   }
   
   public void setRating(int newRating)
   {
      if (newRating > 10) {
         rating = 10;
      } else if (newRating < 0) {
         rating = 0;
      } else {
         rating = newRating;
      }
   }

   public boolean equals(Object obj)
   {
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      Book otherBook = (Book) obj;
      return title.equals(otherBook.getTitle()) && author.equals(otherBook.getAuthor());
   }
   
   public boolean titleContains(String target)
   {
      return title.toLowerCase().contains(target.toLowerCase());
   }
   
   public boolean authorContains(String target)
   {
      return author.toLowerCase().contains(target.toLowerCase());
   }
   
   public String toString()
   {
      return "\"" + title + "\" by " + author + " (" + rating + ")";
   }
}
