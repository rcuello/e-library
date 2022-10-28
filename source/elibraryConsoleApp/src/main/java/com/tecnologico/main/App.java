package com.tecnologico.main;

import com.tecnologico.model.User;
import com.tecnologico.view.AddBookInfoMenu;
import com.tecnologico.view.ApplicationMenu;
import com.tecnologico.view.ListAllBookMenu;
import com.tecnologico.view.ListAllBooksByAuthorMenu;
import com.tecnologico.view.ListCountBookMenu;
import java.io.IOException;

/**
 *
 * @author ronald.cuello
 */
public class App {

    public static void main(String[] args) {

        User user = ApplicationMenu.showLogin();
        
        if(user!=null){
            
            ApplicationMenu.showWelcomeMessage(user);
            try{
                switch (user.getRoleName()) {
                    case "administrator":
                        runAdministratorApplication();
                        break;

                    case "student":
                        runStudentApplication();
                        break;

                    case "teacher":
                        runTeacherApplication();
                        break;

                    default:
                        System.out.println("Invalid rolename");
                }
            } catch(Exception ex){
                System.out.println("Something horrible happend o.O ");
                ex.printStackTrace();
            }
        }else{
            System.out.println("Invalid credentials.");
            System.out.println("Good bye!");
        }
    }
    
    
    public static void runAdministratorApplication() throws IOException{
        int opcion = 0;
        
        while(opcion!= 5){
            
            opcion = ApplicationMenu.showAdministratorMenuOption();
            
            switch (opcion) {
                case 1:
                    AddBookInfoMenu.show();
                    break;
                case 2:
                    ListAllBookMenu.show();
                    break;
                case 3:
                    ListAllBooksByAuthorMenu.show();
                    break;
                case 4:
                    ListCountBookMenu.show();
                    break;
                case 5:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    public static void runStudentApplication(){
        int opcion = 0;
        
        while(opcion!= 3){
            
            opcion = ApplicationMenu.showStudentMenuOption();
            
            switch (opcion) {
                case 1:
                    ListAllBookMenu.show();
                    break;
                case 2:
                    ListAllBooksByAuthorMenu.show();
                    break;
                case 3:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    public static void runTeacherApplication(){
        int opcion = 0;
        
        while(opcion!= 4){
            
            opcion = ApplicationMenu.showTeacherMenuOption();
            
            switch (opcion) {
                case 1:
                    ListAllBookMenu.show();
                    break;
                case 2:
                    ListAllBooksByAuthorMenu.show();
                    break;
                case 3:
                    ListCountBookMenu.show();
                    break;
                case 4:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
