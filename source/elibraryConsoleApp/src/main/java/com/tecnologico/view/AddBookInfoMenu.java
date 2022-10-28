
package com.tecnologico.view;

import com.tecnologico.controller.BookController;
import com.tecnologico.model.Book;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class AddBookInfoMenu {
    public static void show() throws IOException{
        
        BookController controller=new BookController();
        System.out.format("+---------------------+%n");
        System.out.format("| Adding new Book     |%n");
        System.out.format("+---------------------+%n");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter isbn code: ");
        String isbn=scanner.nextLine();
        
        System.out.println("Enter book name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter author name: ");
        String author = scanner.nextLine();

        System.out.println("Enter price currency: ");
        String currency=scanner.nextLine();
        
        System.out.println("Enter book price: ");
        float price = scanner.nextFloat();
        
        Book book = new Book();
        book.setIsbnCode(isbn);
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.setPriceCurrency(currency);
        
        controller.addBook(book);
        
        System.out.format("+---------------------+%n");
        System.out.format("| Success             |%n");
        System.out.format("+---------------------+%n");

    }
}
