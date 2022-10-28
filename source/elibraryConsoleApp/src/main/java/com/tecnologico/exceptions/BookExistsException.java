
package com.tecnologico.exceptions;

/**
 *
 * @author ronald.cuello
 */
public class BookExistsException extends Exception{
    public BookExistsException(String errorMessage){
        super(errorMessage);
    }
}
