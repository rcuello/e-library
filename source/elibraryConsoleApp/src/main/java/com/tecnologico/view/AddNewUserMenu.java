package com.tecnologico.view;

import com.tecnologico.controller.UserController;
import com.tecnologico.model.User;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class AddNewUserMenu {
    public static void show() throws IOException{
        System.out.format("+---------------------+%n");
        System.out.format("| Adding new User     |%n");
        System.out.format("+---------------------+%n");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name : ");
        String name=scanner.nextLine();
        
        System.out.println("Enter lastname: ");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.println("Enter password: ");
        String password=scanner.nextLine();
        
        System.out.println("Enter user role name: 'administrator' - 'teacher' - 'student'");
        String roleName = scanner.nextLine().toLowerCase();
        
        //Texto aleatorio
        String userId = java.util.UUID.randomUUID().toString();
        
        User newUser = new User();
        newUser.setId(userId);
        newUser.setName(name);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRoleName(roleName);
        
        UserController controller = new UserController();
        
        boolean isUserSaved = controller.addUser(newUser);
        
        if(isUserSaved){
            System.out.format("+---------------------+%n");
            System.out.format("| Success             |%n");
            System.out.format("+---------------------+%n");
        }else{
            System.out.format("+-----------------------------+%n");
            System.out.format("| Error: User already exists! |%n");
            System.out.format("+-----------------------------+%n");
        }
        
        
        System.out.println("press any to continue...");
        new Scanner(System.in).nextLine();
        
    }
}
