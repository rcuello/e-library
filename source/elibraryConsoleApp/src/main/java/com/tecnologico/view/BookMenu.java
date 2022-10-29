
package com.tecnologico.view;

import com.tecnologico.controller.BookController;
import com.tecnologico.model.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class BookMenu {
    public static void showAddNewBook() throws IOException{
        
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

        System.out.println("Enter currency simbol: ");
        String currency=scanner.nextLine();
        
        System.out.println("Enter book price: ");
        float price = scanner.nextFloat();
        
        Book book = new Book();
        book.setIsbnCode(isbn);
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.setPriceCurrency(currency);
        
        //Save the book into the plain file
        boolean isBookSaved = controller.addBook(book);
        
        if(isBookSaved){
            System.out.format("+---------------------+%n");
            System.out.format("| Success             |%n");
            System.out.format("+---------------------+%n");
        }else{
            System.out.format("+-----------------------------+%n");
            System.out.format("| Error: Book already exists! |%n");
            System.out.format("+-----------------------------+%n");
        }
        
        System.out.println("press any to continue...");
        new Scanner(System.in).nextLine();
        
    }
    
    public static void showAllBooks(){
        BookController controller = new BookController();
        
        ArrayList<Book> libros=controller.getBooks();
        
        //How can I create table using ASCII in a console?
        //https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
        
        String leftAlignFormat = "| %-30s | %-10s   |%n";
        System.out.format("+--------------------------------+------------------+%n");
        System.out.format("| Book name                      | ISBN             |%n");
        System.out.format("+--------------------------------+------------------+%n");
        
        

        for(Book libro : libros){
            System.out.format(leftAlignFormat, libro.getName(), libro.getIsbnCode());
        }
        
        System.out.format("+--------------------------------+------------------+%n");
        
        System.out.println("press any to continue...");
        new Scanner(System.in).nextLine();
    }
    
    public static void showListBookByAuthor(){
        BookController controlador=new BookController();
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Enter author name: ");
        String author=teclado.next();
        
        ArrayList<Book> busqueda = controlador.findBooksByAuthor(author);
        
        //How can I create table using ASCII in a console?
        //https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
        String leftAlignFormat = "| %-30s | %-10s   | %-10s   |%n";
        System.out.format("+--------------------------------+------------------------------+-------------------+%n");
        System.out.format("| Book name                      |  Author                      | Price             |%n");
        System.out.format("+--------------------------------+------------------------------+-------------------+%n");
        
        

        for(Book libro : busqueda){
            String price = libro.getPriceCurrency()+" "+libro.getPrice();
            
            System.out.format(leftAlignFormat, libro.getName(),libro.getAuthor(), price);
        }
        
        System.out.format("+--------------------------------+------------------------------+-------------------+%n");
        
        System.out.println("press any to continue...");
        new Scanner(System.in).nextLine();
        
    }
    
    public static void showDeleteBook(){
        
    }
}
