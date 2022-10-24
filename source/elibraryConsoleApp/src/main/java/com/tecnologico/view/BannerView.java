
package com.tecnologico.view;

import com.tecnologico.util.ConsoleColors;
import com.tecnologico.util.ParameterHelper;

/**
 *
 * @author ronald.cuello
 */
public class BannerView {
    
    public static void show(){
        //Ascii banner generator
        //https://www.askapache.com/online-tools/figlet-ascii/
        //System.out.println
        ConsoleColors.printLineInRed("""
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
        System.out.println("");
        
    }
}