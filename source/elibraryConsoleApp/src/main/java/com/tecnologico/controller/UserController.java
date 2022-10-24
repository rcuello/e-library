package com.tecnologico.controller;

import com.tecnologico.model.Book;
import com.tecnologico.model.User;
import com.tecnologico.util.ConstantHelper;
import com.tecnologico.util.ConvertHelper;
import com.tecnologico.util.ParameterHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ronald.cuello
 */
public class UserController {
    public User findUser(String username,String password){
        
        ArrayList<User> users = this.getUsers();
        
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        
        return null;
    }
    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<User>();
        
        try{
            String rutaArchivoUsuario = ParameterHelper.getInstance().getParameter("users.file");
            File archivo = new File(rutaArchivoUsuario);
            Scanner scan=new Scanner(archivo);
            
            while(scan.hasNextLine()){
                String[] atributos = scan.nextLine().split(",");
                
                User usuario = new User();
                usuario.setId(atributos[0]);
                usuario.setUsername(atributos[1]);
                usuario.setPassword(atributos[2]);
                usuario.setRoleName(atributos[3]);
                usuario.setName(atributos[4]);
                usuario.setLastName(atributos[5]);
                usuario.setEmail(atributos[6]);
                
                users.add(usuario);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return users;
    }
}
