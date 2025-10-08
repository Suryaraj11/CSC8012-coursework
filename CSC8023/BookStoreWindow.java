package CSC8023;

import java.text.DecimalFormat;
import java.util.*;

public class BookStoreWindow {

    public static void main(String[] args) throws Exception {
        try {
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println("Welcome to the Book Store!");
            Scanner sc = new Scanner(System.in);

            BookStoreWindowIO bookStore = new BookStoreWindowIO();
            while (true) {
                System.out.print("kindly choose one of the book store options below:\n");
                HashMap<Integer, String> namesList = bookStore.getStoresList();
                int i = 0;
                for (i=0; i < namesList.size(); i++) {
                    String name = namesList.get(i + 1);
                    System.out.println(i + 1 + ". " + name);
                }
                System.out.println(i+1+". Quit");
                int bookStoreName = 0;
                try{
                    bookStoreName = sc.nextInt();
                }
                catch(Exception e){
                    int size = namesList.size() + 1;
                    System.out.println("\nPlease select an option(Number) which is within the range of 1-"+size);
                    sc.nextLine();
                    continue;
                }
                if(bookStoreName<1 || bookStoreName>namesList.size()+1){
                    int size = namesList.size() + 1;
                    System.out.println("\nPlease select an option which is within the range of 1-"+size);
                    continue;
                }
                if(bookStoreName == i+1) {
                    System.out.println("\nThank you for visiting our Book Store!");
                    break;
                }
                List<Book> booksList = bookStore.bookStoreToBooks.get(namesList.get(bookStoreName));
                System.out.println("Boook shop name: " + namesList.get(bookStoreName));
                for (int j = 0; j < booksList.size(); j++) {
                    Book book = booksList.get(j);
                    System.out.println(book.toString());
                }

                System.out.println("\nThe statistics on highest value, oldest book, and average value of the books:");
                bookStore.getBooksStatistics(namesList.get(bookStoreName));
                System.out.println("Highest value book: " + bookStore.highValueBook.getBookTitle() + " (published " + bookStore.highValueBook.getPublishedYear() + "), £" + df.format(bookStore.highValueBook.getValue()));
                System.out.println("Oldest book: " + bookStore.oldestBook.getBookTitle() + " (published " + bookStore.oldestBook.getPublishedYear() + ")");
                System.out.println("Average value of books: £" + df.format(bookStore.getAverageValue())+"\n");
            }
        }
        catch (Exception e) {
            System.out.println("Sorry for the inconvenience, kindly restart the program.");
        }
    }

}
