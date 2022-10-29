/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnologico.view.options;

import com.tecnologico.util.ConvertHelper;
import com.tecnologico.view.BookMenu;
import com.tecnologico.view.ReportMenu;
import com.tecnologico.view.UserMenu;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class AdministratorOption {
    
    private static int showOptions(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""
                 +"+-----------------------------------------------+"
               +"\n+ MENU                                          |"
               +"\n+-----------------------------------------------+"
               +"\n             .::User section::.               |"
               +"\n1. List all Users                             |"
               +"\n2. Add new User                               |"
               +"\n3. Delete User                                |"
               +"\n             .::Book section::.               |"
               +"\n4. List all Books                             |" 
               +"\n5. Add new Book                               |"
               +"\n6. Delete Book                                |"
               +"\n7. List all Books of given author             |"  
               +"\n             .::Reports section::.            |"
               +"\n8. List the count of Books in the library     |"  
               +"\n9. Exit                                       |" 
               +"\n+-----------------------------------------------+"
               +"\n"); 
        System.out.println("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
    public static void runApplication() throws IOException{
        int opcion = 0;
        
        while(opcion!= 9){
            
            opcion = AdministratorOption.showOptions();
            
            switch (opcion) {
                case 1:
                    UserMenu.showAllUsers();
                    break;
                case 2:
                    UserMenu.showAddNewUser();
                    break;
                case 3:
                    UserMenu.showDeleteUser();
                    break;
                case 4:
                    BookMenu.showAllBooks();
                    break;
                case 5:
                    BookMenu.showAddNewBook();
                    break;
                case 6:
                    BookMenu.showDeleteBook();
                    break;
                case 7:
                    BookMenu.showListBookByAuthor();
                    break;
                case 8:
                    ReportMenu.showCountBooks();
                    break;
                case 9:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
