
package com.tecnologico.view;

import com.tecnologico.controller.UserController;
import com.tecnologico.model.User;
import com.tecnologico.util.ConsoleColors;
import com.tecnologico.util.ConvertHelper;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class ApplicationMenu {
    
    public static User showLogin(){
        UserController userController = new UserController();
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("------------- E-LIBRARY Login -------------");
        System.out.print("Enter username:");
        String username=teclado.next();
        System.out.print("Enter password:");
        String password=teclado.next();
        System.out.println("-------------------------------------------");
        
        User user = userController.findUser(username, password);
        return user;
    }
    
    
    
    public static int showAdministratorMenuOption(User user){
        Scanner teclado = new Scanner(System.in);
        
        ConsoleColors.printLineInGreenUnderline("********###### WELCOME TO E-LIBRARY #####********");
        System.out.println("Welcome home, "+user.getName());
        System.out.println("\n"
               +"1. Add book information"
               +"2. List all books" 
               +"3. List all books of given author"           
               +"4. List the count of books in the library"  
               +"5. Exit"           
               +"\n"); 
        ConsoleColors.printInYellow("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
    
    public static int showStudentMenuOption(User user){
        Scanner teclado = new Scanner(System.in);
        
        ConsoleColors.printLineInGreenUnderline("********###### WELCOME TO E-LIBRARY #####********");
        System.out.println("Hi there! "+user.getName()+" "+user.getLastName());
        System.out.println("\n"
               +"\n1. List all books" 
               +"\n2. List all books of given author"           
               +"\n3. Exit"           
               +"\n"); 
        ConsoleColors.printInYellow("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
    
    public static int showTeacherMenuOption(User user){
        Scanner teclado = new Scanner(System.in);
        
        ConsoleColors.printLineInGreenUnderline("********###### WELCOME TO E-LIBRARY #####********");
        System.out.println("Hello professor, "+user.getName());
        System.out.println("\n"
               +"\n1. List all books "
               +"\n2. List all books of given author           "
               +"\n3. List the count of books in the library  "
               +"\n4. Exit           "
               +"\n"); 
        
        ConsoleColors.printInYellow("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
}
