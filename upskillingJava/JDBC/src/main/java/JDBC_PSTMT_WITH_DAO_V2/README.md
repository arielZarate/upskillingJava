# CRUD JAVA CON JDBC USANDO PATRON SINGLETON Y DAO


##  patrón DAO (Data Access Object) 
se utiliza para separar las preocupaciones entre la lógica de negocio y la lógica de acceso a datos


### Lógica de Negocio
La lógica de negocio se refiere a las reglas y procesos que dictan cómo se manejan los datos y cómo interactúan entre sí para cumplir con los requisitos de la aplicación. Esto incluye las operaciones de crear, leer, actualizar y eliminar (CRUD) que se aplican a los objetos de negocio.

### Lógica de Acceso a Datos
La lógica de acceso a datos se refiere a cómo se almacenan, recuperan y manipulan los datos en una base de datos u otro sistema de almacenamiento. Esto incluye las consultas SQL, la gestión de conexiones a la base de datos, el manejo de transacciones y el tratamiento de errores relacionados con la base de datos.

### Patrón DAO: Separación de Responsabilidades
En el patrón DAO, se crean clases específicas (DAO) que se encargan exclusivamente de las operaciones de acceso a datos. Estas clases DAO contienen métodos que realizan las operaciones CRUD, pero no contienen ninguna lógica de negocio adicional.



## El patrón Singleton 
Asegura que una clase tenga una única instancia y proporciona un punto de acceso global a esa instancia. En el caso de la clase ConnectionDB, el patrón Singleton se utiliza para gestionar la conexión a la base de datos, asegurando que solo haya una única instancia de la conexión.


````java
public class ConnectionDB {
    
    // Instancia estática de la clase
    private static ConnectionDB instance = null;

    // Constructor privado: impide la creación de nuevas instancias desde fuera de la clase
    private ConnectionDB() { }


   // Método getInstance (Singleton)
    public static synchronized ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;   //esta es la unica instancia que tendremos de la bd 
    }


}


````






## Clases de proyecto  

EN EL PROYECTO CREE UNA CLASE DAO

```java
package JDBC_PSTMT_WITH_DAO_V2.interfaces;

import JDBC_PSTMT_WITH_DAO_V2.models.User;

import java.util.List;

public interface UserDAO {

    //solo defino las firmas de los metodos que implementare


    // ==========PATRON DAO====================

     public int insertUser(User user);
     public User findUserById(int  id);
     public List<User> findAll();
     public int updateUser(int id,User user);
     public int deleteUser(int id);


}

```
 LA IMPLEMENTACON DE DAO 

```java
package JDBC_PSTMT_WITH_DAO_V2.models;

import JDBC_PSTMT_WITH_DAO_V2.db.ConnectionDB;
import JDBC_PSTMT_WITH_DAO_V2.interfaces.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;
//import static java.lang.Math.random;

public class UserDAOImpl  implements UserDAO {
    Connection cnn;

  String TABLE_USERS="usuarios";


    //metodo publico crea la instancia y queda disponible para usarse
    public UserDAOImpl(){
        this.cnn= ConnectionDB.getInstance().getConnection();
    }


  //==================create table users=====================================
    public void createTable(){
        String createTableQuery="CREATE TABLE IF NOT EXISTS " +TABLE_USERS+ " "+
                "(id INT AUTO_INCREMENT PRIMARY KEY,  " +
                "name VARCHAR(50))" ;


        try(PreparedStatement pstmt= cnn.prepareStatement(createTableQuery)){
            pstmt.executeUpdate();
            System.out.println("tabla creada");

        }catch (SQLException e){
            System.out.println("error para crear tabla: " + e.getMessage());
            e.printStackTrace();
        }
    }



   //================INSERT USER===================
    @Override
    public int insertUser(User user) {
        String sql_insert="INSERT INTO "+ TABLE_USERS + " (name) VALUES(?) ";

        int rowsAffected=0;
        try(PreparedStatement pstmt= cnn.prepareStatement(sql_insert)){
            pstmt.setString(1,user.getName());
            rowsAffected=pstmt.executeUpdate();

        }catch (SQLException e){
            System.out.println("error para crear usuario: " + e.getMessage());
            e.printStackTrace();
        }

        // este enfoque de tener la variable fuera del try catch tambien es valido
        return rowsAffected;

    }


    //===========findById============================
    @Override
    public User findUserById(int id) {
        String sql="SELECT * FROM " +TABLE_USERS + " WHERE id=?";
        User user=null;
        try(PreparedStatement pstmt=cnn.prepareStatement(sql)){

            pstmt.setInt(1,id);
            ResultSet res=   pstmt.executeQuery();
            while(res.next())
            {
               // System.out.println("Nombre :" +  res.getString("name"));
                // en vez de mostrar un sout de aca devolvere los datos del User en su metodo toSring()
             user=new User(); //creo un usuario con constructor sin parametros
             user.setId(res.getInt("id"));
             user.setName(res.getString("name"));
            }
        }catch(SQLException e)
        {
            System.out.println("Error al actualizar usuario ");
            e.printStackTrace();
        }

        return user;
    }



    // ===============findAll====================0
    @Override
    public List<User> findAll() {
    String sql_findall="SELECT * FROM " +TABLE_USERS;
     List <User> list_users=new ArrayList<User>();
        try(
                PreparedStatement pstmt = cnn.prepareStatement(sql_findall);
                ResultSet res = pstmt.executeQuery();
        )
        {
            //ahora itero
            while (res.next()) {
              //  System.out.println("ID:" + res.getInt("id")+ " "+ "Nombre: " + res.getString("name") );
             User user=new User();
             user.setId(res.getInt("id"));
             user.setName(res.getString("name"));
             list_users.add(user);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return list_users;

    }

    @Override
    public int updateUser(int id, User user) {
        String sql_check = "SELECT COUNT(*) FROM " + TABLE_USERS + " WHERE id=?";
        String sql_update="UPDATE " +TABLE_USERS+" SET name=? WHERE id=?";
        int rows_affected=0;
        try(PreparedStatement pstmt= cnn.prepareStatement(sql_update))
        {

                // Usuario existe, proceder con la actualización
                pstmt.setString(1, user.getName());
                pstmt.setInt(2, id);
                rows_affected = pstmt.executeUpdate();

        }catch (SQLException e){
            System.out.println("error para aptualizar : " + e.getMessage());
            e.printStackTrace();

        }
       //solo retorno las filas afectadas
        return rows_affected;
    }

    @Override
    public int deleteUser(int id) {
        String sql="DELETE FROM " +TABLE_USERS+"  WHERE id=?";
        int rowsAffected=0;
        try(PreparedStatement pstmt=cnn.prepareStatement(sql)){

            //pstmt.setString(1,name);
            pstmt.setInt(1,id);
            rowsAffected=   pstmt.executeUpdate();

        }catch(SQLException e)
        {
            System.out.println("Error al actualizar usuario ");
            e.printStackTrace();
        }

        return rowsAffected;
    }


    public void CloseConnection(){
        try
      {
          if(cnn != null)
          {
              cnn.close();
              System.out.println("conexion cerrada ");
          }
      }
      catch (SQLException e){
          System.out.println("Error al cerrar conexion de JDBC ");
          e.printStackTrace();
      }

    }

}

```

LA CLASE USER 

````java
package JDBC_PSTMT_WITH_DAO_V2.models;

public class User {

        private int id;
        private String name;
      //  private String email;


    //constructor sin  parametros
    public User()
    {}

    public User( String name){
        this.name=name;
    }

        // Getters y Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

       // public String getEmail() { return email; }
       // public void setEmail(String email) { this.email = email; }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}




````

LA CLASE CONECTIONJDBC QUE USA UN SINGLETON

````java
package JDBC_PSTMT_WITH_DAO_V2.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private  String url="jdbc:mysql://localhost:3306/test?useSSL=false";
    private  String username="root"; //usuario de bd;
    private  String password="admin";  //contraseña de bd

    //atencion aca creo uns instancia estatica de la clase
    private static ConnectionDB instance=null;

    //CONSTRUCTORI PRIVADO NO SE PUEDE CREAR NUEVAS INSTANCIAS SOLO SE ACCEDE POR LA UNICA ESTATICA
    private ConnectionDB()
    {

    }


    //PATRON SINGLETON APLICAOD SINO EXISTE INSTANCIA DE LA CONEXION SE CREA UNA NUEVA
    public static synchronized ConnectionDB getInstance() {

       if(instance == null)
       {
       instance =new ConnectionDB();
       }

       return instance;

    }


/*
se utiliza a getInstance para poder conectarse a la bd ,es decir la unica instancia
* */
    public Connection getConnection() {
        Connection cnn = null;
        try {
            cnn = DriverManager.getConnection(url, username, password);
            if (cnn != null) {
                System.out.println("Conexion establecida con la bd ");
            }

        } catch (Exception e) {

            System.out.println("Error el conectar con la BD " + e.getMessage());
            e.printStackTrace();
        }

        return cnn;
      }
      
}

````