package com.tecnologico.controller;

import com.tecnologico.model.Book;
import com.tecnologico.model.User;
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
    
    public boolean addUser(User newUser) throws IOException{
        
        ArrayList<User> users=this.getUsers();
        
        User userEncontrado=null;
        
        //Verificar que el libro no se encuentre almacenado en el archivo
        for(User item : users){
            if(item.getUsername().equals(newUser.getUsername())){
                userEncontrado = item;
            }
        }
        
        //El codigo ya existe en el archivo, por lo tanto el nuevo libro
        //no se debe almacenar
        if(userEncontrado!=null){
            return false;
        }
        
        users.add(newUser);
        
        //Se procede a guardar todos los libros en el archivo plano
        String rutaArchivo = ParameterHelper.getInstance().getParameter("users.file");
        File archivo = new File(rutaArchivo);

        FileWriter myWriter = new FileWriter(archivo);
        for(User item : users){
            //ID01,admin,admin,administrator,Jorge,Pascual,dsoler@morales.net
            String line= item.getId()
                    +","
                    +item.getUsername()
                    +","
                    +item.getPassword()
                    +","
                    +item.getRoleName()
                    +","
                    +item.getName()
                    +","
                    +item.getLastName()
                    +","
                    +item.getEmail()
                    +"\n"

            ;
            myWriter.write(line);
        }

        myWriter.close();
        
        return true;
    }
    
    public boolean deleteByUsername(String username) throws IOException{
        
        ArrayList<User> users = this.getUsers();
        
        int position=-1;
        
        for(int i=0;i< users.size();i++){
            User user= users.get(i);
            
            if(user.getUsername().equals(username)){
                position=i;
                break;
            }
        }
        
        if(position!=-1){
            users.remove(position);
            
            String rutaArchivo = ParameterHelper.getInstance().getParameter("users.file");
            File archivo = new File(rutaArchivo);

            FileWriter myWriter = new FileWriter(archivo);
            for(User item : users){
                //ID01,admin,admin,administrator,Jorge,Pascual,dsoler@morales.net
                String line= item.getId()
                        +","
                        +item.getUsername()
                        +","
                        +item.getPassword()
                        +","
                        +item.getRoleName()
                        +","
                        +item.getName()
                        +","
                        +item.getLastName()
                        +","
                        +item.getEmail()
                        +"\n"

                ;
                myWriter.write(line);
            }

            myWriter.close();
            
            return true;
        }
        
        return false;
    }
}
