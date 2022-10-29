
package com.tecnologico.view;

import com.tecnologico.controller.UserController;
import com.tecnologico.model.User;
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
        
        User user = userController.findUser(username, password);
        return user;
    }
    
    public static void showWelcomeMessage(User user){
        String author = ParameterHelper.getInstance().getParameter("app.author");
        String version = ParameterHelper.getInstance().getParameter("app.version");
        String url=ParameterHelper.getInstance().getParameter("app.url");
        
        String logo=""
                 +"+-------------------------------------------------------+"
               +"\n+ WELCOME TO E-LIBRARY                                  |"
               +"\n+-------------------------------------------------------+";
        System.out.println(logo);
        System.out.println("\t version "+version);
        System.out.println("\t author: "+author);
        System.out.println("\t url: "+url);
        System.out.println("");
        System.out.println("Hello, "+user.getName());
    }
    
    public static int showAdministratorMenuOption(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""
               +"+-----------------------------------------------+"
               +"\n+ MENU                                          |"
               +"\n+-----------------------------------------------+"
               +"\n1. Add book information                       |"
               +"\n2. Add new user                               |"
               +"\n3. List all books                             |" 
               +"\n4. List all books of given author             |"           
               +"\n5. List the count of books in the library     |"  
               +"\n6. Exit                                       |" 
               +"\n+-----------------------------------------------+"
               +"\n"); 
        System.out.println("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
    
    public static int showStudentMenuOption(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""
               +"+-----------------------------------------------+"
               +"\n+ MENU                                          |"
               +"\n+-----------------------------------------------+"
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
    
    public static int showTeacherMenuOption(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(""
               +"+-----------------------------------------------+"
               +"\n+ MENU                                          |"
               +"\n+-----------------------------------------------+"
               +"\n1. List all books                             |"
               +"\n2. List all books of given author             |"
               +"\n3. List the count of books in the library     |"
               +"\n4. Exit                                       |"
               +"\n+-----------------------------------------------+"
               +"\n"); 
        
        System.out.println("Enter one of the above: ");
        
        String valorOpcion = teclado.next();
        
        int opcion = ConvertHelper.tryToConvertToInt(valorOpcion);
        
        return opcion;
        
    }
}
