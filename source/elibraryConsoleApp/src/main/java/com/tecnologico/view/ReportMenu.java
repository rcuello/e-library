
package com.tecnologico.view;

import com.tecnologico.controller.BookController;
import com.tecnologico.model.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class ReportMenu {
    public static void showCountBooks(){
        BookController controller = new BookController();
        
        ArrayList<Book> libros=controller.getBooks();
        
        //How can I create table using ASCII in a console?
        //https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
        
        String leftAlignFormat = "| %-27s | %-10s   |%n";
        System.out.format("+-----------------------------+-------------------+%n");
        System.out.format("| Result                      | Count             |%n");
        System.out.format("+-----------------------------+-------------------+%n");
        System.out.format(leftAlignFormat, "Total Count", libros.size()+" book(s)");
        System.out.format("+-----------------------------+-------------------+%n");
        
        System.out.println("press any to continue...");
        new Scanner(System.in).nextLine();
    }
}
