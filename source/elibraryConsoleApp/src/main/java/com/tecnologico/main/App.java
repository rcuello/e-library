package com.tecnologico.main;

import com.tecnologico.view.AddBookInfoMenu;
import com.tecnologico.view.ApplicationMenu;
import com.tecnologico.view.ListAllBookMenu;
import com.tecnologico.view.ListAllBooksByAuthorMenu;
import com.tecnologico.view.ListCountBookMenu;

/**
 *
 * @author ronald.cuello
 */
public class App {

    public static void main(String[] args) {
        try{
            
            startApplication();
            
        } catch(Exception ex){
            System.out.println("Something horrible happend o.O ");
            ex.printStackTrace();
        }
    }
    
    public static void startApplication(){
        int opcion = 0;
        
        while(opcion!= 5){
            
            opcion = ApplicationMenu.showMenuOption();
            
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
}
