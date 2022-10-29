package com.tecnologico.main;

import com.tecnologico.model.User;
import com.tecnologico.util.ParameterHelper;
import com.tecnologico.view.options.AdministratorOption;
import com.tecnologico.view.options.StudentOption;
import com.tecnologico.view.options.TeacherOption;
import com.tecnologico.view.options.UserOption;
import java.io.File;
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
        User user = UserOption.showLogin();
        
        if(user!=null){
            
            UserOption.showWelcomeMessage(user);
            
            try{
                switch (user.getRoleName()) {
                    case "administrator":
                        AdministratorOption.runApplication();
                        break;

                    case "student":
                        StudentOption.runApplication();
                        break;

                    case "teacher":
                        TeacherOption.runApplication();
                        break;

                    default:
                        System.out.println("Invalid rolename");
                }
            } catch(Exception ex){
                System.out.println("Something horrible happend o.O ");
                ex.printStackTrace();
            }
        }else{
            UserOption.showInvalidCrentials();
        }
        
        
    } 
}
