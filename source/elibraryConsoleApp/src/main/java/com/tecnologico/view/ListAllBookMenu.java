
package com.tecnologico.view;

import com.tecnologico.controller.BookController;
import com.tecnologico.model.Book;
import java.util.ArrayList;

/**
 *
 * @author ronald.cuello
 */
public class ListAllBookMenu {
    
    public static void show(){
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
    }
}
