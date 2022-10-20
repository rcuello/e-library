# E -Library Management System
En este proyecto, discutiremos el enfoque para crear un sistema de administración de bibliotecas electrónicas donde el usuario tiene las siguientes opciones:

1. Add book information
2. List all books 
3. List all books of given author           
4. List the count of books in the library  
5. Exit  

El proyecto hace uso de archivos para cargar los libros, para modificar la ruta de lectura del archivo debe modificar la clase ConstantHelper:

```java
public class ConstantHelper {
    public static final String BookFilePath="C:\\source\\books.txt";
}
```      
