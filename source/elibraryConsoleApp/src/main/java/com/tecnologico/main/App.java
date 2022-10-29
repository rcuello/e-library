package com.tecnologico.main;

import com.tecnologico.exceptions.BookExistsException;
import com.tecnologico.model.User;
import com.tecnologico.util.ParameterHelper;
import com.tecnologico.view.AddBookInfoMenu;
import com.tecnologico.view.AddNewUserMenu;
import com.tecnologico.view.ApplicationMenu;
import com.tecnologico.view.ListAllBookMenu;
import com.tecnologico.view.ListAllBooksByAuthorMenu;
import com.tecnologico.view.ListCountBookMenu;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class App {

    public static void main(String[] args) {
        
        //Verificar si existen los archivos
        String booksFilePath = ParameterHelper.getInstance().getParameter("books.file");
        String usersFilePath = ParameterHelper.getInstance().getParameter("users.file");
        
        File bookFile = new File(booksFilePath);
        File usersFile= new File(usersFilePath);
        
        if(bookFile.exists() && usersFile.exists()){
            
            //Iniciar aplicación
            startApplication();
            
        }else{
             String error=""
                 +"+-------------------------------------------------------+"
               +"\n+ ERROR Starting application *                          |"
               +"\n+-------------------------------------------------------+";
             
            if(!bookFile.exists()){
                error+="\n File "+bookFile.getName()+" Not Found";
            }
            
            if(!usersFile.exists()){
                error+="\n File "+usersFile.getName()+" Not Found";
            }
            
            System.out.println(error);
            
            System.out.println("\nPress any key to exit...");
            new Scanner(System.in).nextLine();
        }
        
    }
    
    public static void startApplication(){
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
    public static void runAdministratorApplication() throws IOException, BookExistsException{
        int opcion = 0;
        
        while(opcion!= 6){
            
            opcion = ApplicationMenu.showAdministratorMenuOption();
            
            switch (opcion) {
                case 1:
                    AddBookInfoMenu.show();
                    break;
                case 2:
                    AddNewUserMenu.show();
                    break;
                case 3:
                    ListAllBookMenu.show();
                    break;
                case 4:
                    ListAllBooksByAuthorMenu.show();
                    break;
                case 5:
                    ListCountBookMenu.show();
                    break;
                case 6:
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
