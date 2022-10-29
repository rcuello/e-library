package com.tecnologico.view.options;

import com.tecnologico.util.ConvertHelper;
import com.tecnologico.view.BookMenu;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class StudentOption {
    
    private static int showOptions(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""
               +"+-----------------------------------------------+"
               +"\n+ MENU                                          |"
               +"\n+-----------------------------------------------+"
               +"\n               .::Book section::.             |"
               +"\n1. List all books                             |" 
               +"\n2. List all books of given author             |"           
               +"\n3. Exit                                       |"    
               +"\n+-----------------------------------------------+"
               +"\n"); 
        System.out.println("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
    
    public static void runApplication(){
        int opcion = 0;
        
        while(opcion!= 3){
            
            opcion = StudentOption.showOptions();
            
            switch (opcion) {
                case 1:
                    BookMenu.showAllBooks();
                    break;
                case 2:
                    BookMenu.showListBookByAuthor();
                    break;
                case 3:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
