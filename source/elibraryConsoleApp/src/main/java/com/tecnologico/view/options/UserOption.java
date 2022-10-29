/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnologico.view.options;

import com.tecnologico.controller.UserController;
import com.tecnologico.model.User;
import com.tecnologico.util.ParameterHelper;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class UserOption {
    
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
    
    public static void showInvalidCrentials(){
        System.out.println("Invalid credentials.");
        System.out.println("Good bye!");
    }
}
