
package com.tecnologico.view.options;

import com.tecnologico.util.ConvertHelper;
import com.tecnologico.view.BookMenu;
import com.tecnologico.view.ReportMenu;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class TeacherOption {
    private static int showOptions(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""
               +"+-----------------------------------------------+"
               +"\n+ MENU                                          |"
               +"\n+-----------------------------------------------+"
               +"\n             .::Book section::.               |"
               +"\n1. List all Books                             |" 
               +"\n2. Add new Book                               |"
               +"\n3. Delete Book                                |"
               +"\n4. List all books of given author             |"
               +"\n             .::Reports section::.            |"
               +"\n5. List the count of books in the library     |"
               +"\n6. Exit                                       |"
               +"\n+-----------------------------------------------+"
               +"\n"); 
        
        System.out.println("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
    
    public static void runApplication() throws IOException{
        int opcion = 0;
        
        while(opcion!= 6){
            
            opcion = TeacherOption.showOptions();
            
            switch (opcion) {
                case 1:
                    BookMenu.showAllBooks();
                    break;
                case 2:
                    BookMenu.showAddNewBook();
                    break;
                case 3:
                    BookMenu.showDeleteBook();
                    break;
                    
                case 4:
                    BookMenu.showListBookByAuthor();
                    break;
                    
                case 5:
                    ReportMenu.showCountBooks();
                    break;
                    
                case 6:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
