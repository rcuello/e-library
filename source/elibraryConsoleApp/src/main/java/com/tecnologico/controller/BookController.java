
package com.tecnologico.controller;

import com.tecnologico.model.Book;
import com.tecnologico.util.ConstantHelper;
import com.tecnologico.util.ConvertHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class BookController {
    public ArrayList<Book> getBooks(){
        ArrayList<Book> libros = new ArrayList<Book>();
        
        try{
            File archivo = new File(ConstantHelper.BookFilePath);
            Scanner scan=new Scanner(archivo);
            
            while(scan.hasNextLine()){
                String[] atributos = scan.nextLine().split(",");
                
                Book libro = new Book();
                libro.setIsbnCode(atributos[0]);
                libro.setName(atributos[1]);
                libro.setAuthor(atributos[2]);
                
                float precio=ConvertHelper.tryToConvertToFloat(atributos[3]);
                libro.setPrice(precio);
                libro.setPriceCurrency(atributos[4]);
                
                libros.add(libro);
            }
        }catch(Exception ex){
            
        }
        return libros;
    }
    
    public ArrayList<Book> findBooksByAuthor(String author){
        ArrayList<Book> libros=this.getBooks();
        ArrayList<Book> busqueda=new ArrayList<Book>();
        
        for(Book libro : libros){
            
            //Se colocan los datos en minusculas para evitar problemas de busqueda
            if(libro.getAuthor().toLowerCase().startsWith(author.toLowerCase())){
                busqueda.add(libro);
            }
        }
        
        return busqueda;
    }
}
