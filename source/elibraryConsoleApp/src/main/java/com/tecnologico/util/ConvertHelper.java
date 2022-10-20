
package com.tecnologico.util;

/**
 *
 * @author ronald.cuello
 */
public class ConvertHelper {
    public static int tryToConvertToInt(String value){
       try{
           
           return Integer.parseInt(value);
           
       }catch(NumberFormatException ex){
           ex.printStackTrace();
       }
       return -1;
    }
    
    public static float tryToConvertToFloat(String value){
       try{
           
           return Float.parseFloat(value);
           
       }catch(NumberFormatException ex){
           ex.printStackTrace();
       }
       return -1;
    }
}
