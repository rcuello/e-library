package com.tecnologico.main;

import com.tecnologico.util.ParameterHelper;
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

        //Mostrar banner de la aplicación
        showBanner();
        
        try{
            
            //Iniciar aplicación
            startApplication();
            
        } catch(Exception ex){
            System.out.println("Something horrible happend o.O ");
            ex.printStackTrace();
        }
    }
    
    public static void showBanner(){
        //Ascii banner generator
        //https://www.askapache.com/online-tools/figlet-ascii/
        System.out.println("""
                            ______      _      _ _                          
                           |  ____|    | |    (_) |                         
                           | |__ ______| |     _| |__  _ __ __ _ _ __ _   _ 
                           |  __|______| |    | | '_ \\| '__/ _` | '__| | | |
                           | |____     | |____| | |_) | | | (_| | |  | |_| |
                           |______|    |______|_|_.__/|_|   \\__,_|_| \\__, |
                                                                       __/ |
                                                                      |___/ 
                           """);
        String author = ParameterHelper.getInstance().getParameter("app.author");
        String version = ParameterHelper.getInstance().getParameter("app.version");
        String url=ParameterHelper.getInstance().getParameter("app.url");
        
        System.out.println("-------< version "+version+" >--------");
        System.out.println("-------< author: "+author+" >--------");
        System.out.println("<<  url: "+url+" >>");
        
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
