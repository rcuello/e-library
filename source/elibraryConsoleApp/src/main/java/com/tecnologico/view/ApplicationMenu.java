
package com.tecnologico.view;

import com.tecnologico.util.ConvertHelper;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class ApplicationMenu {
    
    public static int showMenuOption(){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""" 
            ********###### WELCOME TO E-LIBRARY "#####********
            """);
        System.out.println("""
               1. Add book information
               2. List all books 
               3. List all books of given author           
               4. List the count of books in the library  
               5. Exit           
               """); 
        System.out.print("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
}
