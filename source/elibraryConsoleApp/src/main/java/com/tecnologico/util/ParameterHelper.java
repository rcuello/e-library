
package com.tecnologico.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author ronald.cuello
 * Clase que ayuda a centralizar la lectura del archivo de configuracion usando el patron de diseño Singleton
 * Referencia : https://www.arquitecturajava.com/utilizando-java-singleton-properties/
 */
public class ParameterHelper {
    private static ParameterHelper instancia=null;
    private Properties property;
    
    private ParameterHelper() {
        property= new Properties();
        
        try {
            property.load(new FileInputStream("./configuracion.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static ParameterHelper getInstance() {
        if (instancia==null) {
            instancia=new ParameterHelper();
        }
        return instancia;
    }
    
    public String getParameter(String key) {
        return property.getProperty(key);
    }

}
