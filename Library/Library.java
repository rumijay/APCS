import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

   private ArrayList<Book> books;

   public Library(String filename) throws FileNotFoundException
   {
      File top100 = new File(filename);
      Scanner topReader = new Scanner(top100);
      books = new ArrayList<Book>();

      while (topReader.hasNextLine()) {
         Scanner lineReader = new Scanner(topReader.nextLine()).useDelimiter("\\t");

         String title, author;
         int rating;

         if (lineReader.hasNext()) {
            title = lineReader.next();
         } else {
            continue;
         }

         if (lineReader.hasNext()) {
            author = lineReader.next();
         } else {
            continue;
         }

         if (lineReader.hasNextInt()) {
            rating = lineReader.nextInt();
         } else {
            continue;
         }
         addBook(new Book(title, author, rating));
      }
   }
   
   public Library()
   {
      books = new ArrayList<Book>();
   }
   
   public Library(ArrayList<Book> b)
   {
      books = new ArrayList<Book>(b);
   }

   public Library(Library other)
   {
      books = new ArrayList<Book>(other.getBooks());
   }

   public void setBooks(ArrayList<Book> b)
   {
      books.clear();
      books.addAll(b);
   }

   public ArrayList<Book> getBooks()
   {
      return new ArrayList<Book>(books);
   }

   public Library union(Library other)
   {
      Library newLibrary = new Library(this);
      newLibrary.books.addAll(other.getBooks());
      return newLibrary;
   }

   public Book getBook(int index)
   {
      return books.get(index);
   }

   public void setBook(int index, Book b)
   {
      books.add(index, b);
   }

   public void addBook(Book addMe)
   {
      books.add(addMe);
   }

   public void addBooks(ArrayList<Book> addUs)
   {
      books.addAll(addUs);
   }

   public Book removeBook(int index)
   {
      return books.remove(index);
   }

   public boolean removeBook(Book b)
   {
      return books.remove(b);
   }

   public boolean contains(Book findMe)
   {
      return books.contains(findMe);
   }

   public int indexOf(Book b)
   {
      return books.indexOf(b);
   }

   public Library searchByTitle(String title)
   {
      Library result = new Library();
      for (Book book : books) {
         if (book.titleContains(title)) {
            result.addBook(book);
         }
      }
      return result;
   }

   public Library searchByAuthor(String author)
   {
      Library result = new Library();
      for (Book book : books) {
         if (book.authorContains(author)) {
            result.addBook(book);
         }
      }
      return result;
   }

   public Library searchByRating(int rating)
   {
      Library result = new Library();
      for (Book book : books) {
         if (book.getRating() >= rating) {
            result.addBook(book);
         }
      }
      return result;
   }

   public boolean equals(Object obj)
   {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      Library otherLibrary = (Library) obj;
      return books.equals(otherLibrary.getBooks());
   }

   public String toString()
   {
      return books.toString();
   }
}
