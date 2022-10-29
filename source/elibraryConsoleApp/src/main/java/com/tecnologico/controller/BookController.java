
package com.tecnologico.controller;

import com.tecnologico.model.Book;
import com.tecnologico.util.ConvertHelper;
import com.tecnologico.util.ParameterHelper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            String rutaArchivo = ParameterHelper.getInstance().getParameter("books.file");
            File archivo = new File(rutaArchivo);
            Scanner scan=new Scanner(archivo);
            
            //Sobre escribe el archivo con todos los libros de la coleccion
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
            ex.printStackTrace();
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
    
    
    /**
     * Devuelve un valor logico si el libro es almacenado en el archivo 
     * @return  True si el libro es almacenado en el archivo , false si no se pudo guardar el archivo
     */
    public boolean addBook(Book book) throws IOException{
        
        ArrayList<Book> libros=this.getBooks();
        
        Book libroEncontrado=null;
        
        //Verificar que el libro no se encuentre almacenado en el archivo
        for(Book item : libros){
            if(item.getIsbnCode().toLowerCase().equals(book.getIsbnCode().toLowerCase())){
                libroEncontrado = item;
            }
        }
        
        //El codigo ya existe en el archivo, por lo tanto el nuevo libro
        //no se debe almacenar
        if(libroEncontrado!=null){
            return false;
        }
        
        libros.add(book);
        
        //Se procede a guardar todos los libros en el archivo plano
        String rutaArchivo = ParameterHelper.getInstance().getParameter("books.file");
        File archivo = new File(rutaArchivo);

        FileWriter myWriter = new FileWriter(archivo);
        for(Book item : libros){
            //9780132350884,Clean Code,Robert C. Martin,44.99,USD$
            String line= item.getIsbnCode()
                    +","
                    +item.getName()
                    +","
                    +item.getAuthor()
                    +","
                    +item.getPrice()
                    +","
                    +item.getPriceCurrency()
                    +"\n"

            ;
            myWriter.write(line);
        }

        myWriter.close();
        
        return true;
    }
}
