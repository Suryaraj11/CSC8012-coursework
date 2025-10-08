package CSC8023;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookStoreWindowIO {


    HashMap<String, List<Book>> bookStoreToBooks = new HashMap<String, List<Book>>();
    HashMap<Integer, String> storesList = new HashMap<Integer, String>();

    Book highValueBook = new Book();
    Book oldestBook = new Book();
    Double averageValue = null;

    public Double getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(Double averageValue) {
        this.averageValue = averageValue;
    }

    public Book getOldestBook() {
        return oldestBook;
    }

    public void setOldestBook(Book oldestBook) {
        this.oldestBook = oldestBook;
    }

    public Book getHighValueBook() {
        return highValueBook;
    }

    public void setHighValueBook(Book highValueBook) {
        this.highValueBook = highValueBook;
    }

    public BookStoreWindowIO() throws Exception{
        createBooksList();
    }

    public List<Book> getBookStoreList(String bookStoreName) throws Exception {
        return bookStoreToBooks.get(bookStoreName);
    }

    public void createBooksList() throws Exception
    {
        Scanner fileReader = new Scanner(new File("/Users/charan/Desktop/books.csv"));
        fileReader.useDelimiter(",");

        int index = 1;
        while (fileReader.hasNext()) {
            Book book = new Book();
            List<Book> books = new ArrayList<Book>();
            String bookStoreName = fileReader.next();
            book.setBookStoreName(bookStoreName);
            book.setBookId(fileReader.next());
            book.setBookTitle(fileReader.next());
            book.setPublishedYear(Long.valueOf(fileReader.next()));
            book.setValue(Double.valueOf(fileReader.next()));
            if(bookStoreToBooks.containsKey(bookStoreName))
            {
                books = bookStoreToBooks.get(bookStoreName);
                books.add(book);
            }
            else {
                storesList.put(index, bookStoreName);
                index++;
                books.add(book);
                bookStoreToBooks.put(bookStoreName, books);
            }
        }
        fileReader.close();
    }

    public void getBooksStatistics(String bookStoreName)
    {
        highValueBook = new Book();
        oldestBook = new Book();
        setAverageValue(0.00);
        List<Book> books = bookStoreToBooks.get(bookStoreName);
        Double avgValue = 0.00;
        for(Book book : books)
        {
            if(highValueBook.getValue() == null || highValueBook.getValue()<book.getValue())
            {
                highValueBook.setValue(book.getValue());
                highValueBook.setBookTitle(book.getBookTitle());
                highValueBook.setPublishedYear(book.getPublishedYear());
            }
            if(oldestBook.getPublishedYear() == null || oldestBook.getPublishedYear()>book.getPublishedYear())
            {
                oldestBook.setBookTitle(book.getBookTitle());
                oldestBook.setPublishedYear(book.getPublishedYear());
            }
            avgValue = avgValue + book.getValue();
        }
        setAverageValue(avgValue / books.size());
    }

    public HashMap<Integer, String> getStoresList() {
        return storesList;
    }

}
