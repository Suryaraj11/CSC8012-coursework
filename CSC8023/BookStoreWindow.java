package CSC8023;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BookStoreWindow {

    public static void main(String[] args) throws Exception {
        try {

            System.out.println("Welcome to the Book Store! \nkindly choose one of the book store options below:");
            Scanner sc = new Scanner(System.in);

            BookStoreWindowIO bookStore = new BookStoreWindowIO();

            HashMap<Integer, String> namesList = bookStore.getStoresList();
            for(int i=0;i<namesList.size();i++){
                String name = namesList.get(i+1);
                System.out.println(i+1 + ". "+name);
            }
            int bookStoreName = sc.nextInt();
            List<Book> booksList = bookStore.bookStoreToBooks.get(namesList.get(bookStoreName));
            System.out.println("Boook shop name: "+namesList.get(bookStoreName));
            for(int i=0;i<booksList.size();i++){
                Book book = booksList.get(i);
                System.out.println(book.toString());
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
