
package com.tecnologico.view;

import com.tecnologico.controller.UserController;
import com.tecnologico.model.User;
import com.tecnologico.util.ConsoleColors;
import com.tecnologico.util.ConvertHelper;
import com.tecnologico.util.ParameterHelper;
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
        System.out.print("Enter username: ");
        String username=teclado.next();
        System.out.print("Enter password: ");
        String password=teclado.next();
        System.out.println("-------------------------------------------");
        
        User user = userController.findUser(username, password);
        return user;
    }
    
    public static void showWelcomeMessage(User user){
        String author = ParameterHelper.getInstance().getParameter("app.author");
        String version = ParameterHelper.getInstance().getParameter("app.version");
        String url=ParameterHelper.getInstance().getParameter("app.url");
            
        System.out.println("********###### WELCOME TO E-LIBRARY #####********");
        System.out.println("-------< version "+version+" >--------");
        System.out.println("-------< author: "+author+" >--------");
        System.out.println("<<  url: "+url+" >>");
        System.out.println("");
        System.out.println("Hello, "+user.getName());
    }
    
    public static int showAdministratorMenuOption(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""
               +"\n1. Add book information"
               +"\n2. List all books" 
               +"\n3. List all books of given author"           
               +"\n4. List the count of books in the library"  
               +"\n5. Exit"           
               +"\n"); 
        ConsoleColors.printInYellow("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
    
    public static int showStudentMenuOption(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""
               +"\n1. List all books" 
               +"\n2. List all books of given author"           
               +"\n3. Exit"           
               +"\n"); 
        ConsoleColors.printInYellow("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
    
    public static int showTeacherMenuOption(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""
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
