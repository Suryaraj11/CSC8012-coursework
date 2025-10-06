package CSC8023;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookWindowIO {

    List<Book> books = new ArrayList<Book>();
    HashMap<String, List<Book>> bookIdToBook = new HashMap<String, List<Book>>();

    public static void main(String[] args) throws Exception{
        BookWindowIO bookWindowIO = new BookWindowIO();
        bookWindowIO.createBooksList();
    }

    public void createBooksList() throws Exception
    {
        Scanner fileReader = new Scanner(new File("H:\\Desktop\\books.csv"));
        fileReader.useDelimiter(",");

        Book book = new Book();
        while (fileReader.hasNext()) {
            book.setBookStoreName(fileReader.next());
            book.setBookId(fileReader.next());
            book.setBookTitle(fileReader.next());
            book.setPublishedYear(Long.valueOf(fileReader.next()));
            book.setValue(Float.valueOf(fileReader.next()));
            books.add(book);
        }
    }

}
