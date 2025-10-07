package CSC8023;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookStoreWindowIO {


    HashMap<String, List<Book>> bookStoreToBooks = new HashMap<String, List<Book>>();
    HashMap<Integer, String> storesList = new HashMap<Integer, String>();

    public BookStoreWindowIO() throws Exception{
        createBooksList();
    }

    public List<Book> getBookStoreList(String bookStoreName) throws Exception {
        return bookStoreToBooks.get(bookStoreName);
    }

    public void createBooksList() throws Exception
    {
        Scanner fileReader = new Scanner(new File("H:\\Desktop\\books.csv"));
        fileReader.useDelimiter(",");

        int index = 1;
        while (fileReader.hasNext()) {
            Book book = new Book();
            List<Book> books = new ArrayList<Book>();
            String bookStoreName = fileReader.next();
            if(bookStoreToBooks.containsKey(bookStoreName))
            {
                books = bookStoreToBooks.get(bookStoreName);
                book.setBookStoreName(bookStoreName);
                book.setBookId(fileReader.next());
                book.setBookTitle(fileReader.next());
                book.setPublishedYear(Long.valueOf(fileReader.next()));
                book.setValue(Float.valueOf(fileReader.next()));
                books.add(book);
            }
            else {
                storesList.put(index, bookStoreName);
                index++;
                book.setBookStoreName(bookStoreName);
                book.setBookId(fileReader.next());
                book.setBookTitle(fileReader.next());
                book.setPublishedYear(Long.valueOf(fileReader.next()));
                book.setValue(Float.valueOf(fileReader.next()));
                books.add(book);
                bookStoreToBooks.put(bookStoreName, books);
            }

        }
    }

    public HashMap<Integer, String> getStoresList() {
        return storesList;
    }

}
