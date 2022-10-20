
package com.tecnologico.view;

import com.tecnologico.controller.BookController;
import com.tecnologico.model.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class ListAllBooksByAuthorMenu {
    public static void show(){
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
        
    }
}
