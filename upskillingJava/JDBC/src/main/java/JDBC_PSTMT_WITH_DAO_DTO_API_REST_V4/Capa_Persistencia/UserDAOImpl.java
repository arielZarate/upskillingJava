package JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Persistencia;





import JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Datos.User;
import JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Datos.UserDTO;
import JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Datos.UserMapper;
import JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.config.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl  implements  UserDAO {
    Connection cnn;

  String TABLE_USERS="users";


    //metodo publico crea la instancia y queda disponible para usarse
    public UserDAOImpl(){
        this.cnn= ConnectionJDBC.getInstance().getConnectionJDBC();
       if(cnn != null)
       {
           System.out.println(cnn);

       }
       else{
           System.out.println("cnn es null ");
       }

    }


  //==================create table users=====================================
    public void createTable(){
        String createTableQuery="CREATE TABLE IF NOT EXISTS " +TABLE_USERS+ " "+
                "(id INT AUTO_INCREMENT PRIMARY KEY,  " +
                "name VARCHAR(50)," +
                "lastName VARCHAR(50)," +
                "age INT ," +
                "email VARCHAR(50) )" ;


        try(PreparedStatement pstmt= cnn.prepareStatement(createTableQuery)){
            pstmt.executeUpdate();
            System.out.println("tabla creada");

        }catch (SQLException e){
            System.out.println("error para crear tabla: " + e.getMessage());
            e.printStackTrace();
        }
    }

  /// aca podria implementarse servicios , es decir llamar a los servicios que ejecutaras los sql
    // podria usarese el patron Repository
    //een vez de User -> UserDTO

   //================INSERT USER===================
    @Override
    public int insertUser(UserDTO user_dto) {

        // Validar los datos del DTO
        try {
            user_dto.validate();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            return 0; // O manejar el error de otra manera
        }


        // aca mapeo la entidad
        User user= UserMapper.toEntity(user_dto);

        String sql_insert="INSERT INTO "+ TABLE_USERS + " (name,lastName,age, email) VALUES(?,?,?,?) ";

        int rowsAffected=0;
        try(PreparedStatement pstmt= cnn.prepareStatement(sql_insert)){
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getLastName());
            pstmt.setInt(3,user.getAge());
            pstmt.setString(4,user.getEmail());
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
    public UserDTO findUserById(int id) {

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
             user.setLastName(res.getString("lastName"));
             user.setAge(res.getInt("age"));
             user.setEmail(res.getString("email"));
            }
        }catch(SQLException e)
        {
            System.out.println("Error al actualizar usuario ");
            e.printStackTrace();
        }

        return user !=null ?UserMapper.toDTO(user):null;


    }



    // ===============findAll====================0
    @Override
    public List<UserDTO> findAll() {
    String sql_findall="SELECT * FROM " +TABLE_USERS;
     List <UserDTO> list_users=new ArrayList<UserDTO>();
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
             user.setLastName(res.getString("lastName"));
             user.setAge(res.getInt("age"));
             user.setEmail(res.getString("email"));

             //agrego los elementos a la lista
             list_users.add(UserMapper.toDTO(user));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return list_users;

    }

    @Override
    public int updateUser(int id, UserDTO userdto) {

        // Validar los datos del DTO
        try {
            userdto.validate();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            return 0; // O manejar el error de otra manera
        }

        User user=UserMapper.toEntity(userdto);
        String sql_update="UPDATE " +TABLE_USERS+" SET name=? ,lastName=?, age=?, email=? WHERE id=?";
        int rows_affected=0;
        try(PreparedStatement pstmt= cnn.prepareStatement(sql_update))
        {

                // Usuario existe, proceder con la actualización
                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getLastName());
                pstmt.setInt(3, user.getAge());
                pstmt.setString(4, user.getEmail());
                pstmt.setInt(5, id);
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

           // System.out.println("rowsafected: "+rowsAffected);

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



/*
==================METODOS VIEJOS  USADOS SIN EL PATRON DAO=========================


//=================INSERT================================0
    public int  insertUser(String name){

      String sql_insert="INSERT INTO usuarios (name) VALUES(?) ";

      int rowsAffected=0;
        try(PreparedStatement pstmt= cnn.prepareStatement(sql_insert)){


            pstmt.setString(1,name);
            rowsAffected=pstmt.executeUpdate();
          if(rowsAffected > 0)
          {
              System.out.println("Usuario creada exitosamente " );
          }
          else {
              System.out.println("Error ,Usuario no creada " );
          }

        //  return rows;

        }catch (SQLException e){
            System.out.println("error para crear usuario: " + e.getMessage());
            e.printStackTrace();
          //  return 0;
        }

        // este enfoque de tener la variable fuera del try catch tambien es valido
        return rowsAffected;

    }




    //================ GET BY ID======================================

    /// Usuarios getbyid

    public void getUserById(int id ){
        String sql="SELECT * FROM  usuarios  WHERE id=?";
        try(PreparedStatement pstmt=cnn.prepareStatement(sql)){

            pstmt.setInt(1,id);
            ResultSet res=   pstmt.executeQuery();
            while(res.next())
            {
                System.out.println("Nombre :" +  res.getString("name"));
            }
        }catch(SQLException e)
        {
            System.out.println("Error al actualizar usuario ");
            e.printStackTrace();
        }
    }


   //===============GET USERS================================
    public void getUsers() {
        try(
                PreparedStatement pstmt = cnn.prepareStatement("SELECT * FROM usuarios");
                ResultSet res = pstmt.executeQuery();
        )
        {  //ahora itero
            while (res.next()) {
                System.out.println("ID:" + res.getInt("id")+ " "+ "Nombre: " + res.getString("name") );
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


//===================UPDATE USER===================================


    public int  updateUser(int id, String name){
        String sql_update="UPDATE users SET name=? WHERE id=?";
        try(PreparedStatement pstmt= cnn.prepareStatement(sql_update)){

            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            //variable dentro del try
            int rows=pstmt.executeUpdate();
            if(rows > 0)
            {
                System.out.println("Usuario actualizado exitosamente " );
            }
            else {
                System.out.println("Error ,Usuario no actualizado " );
            }

            return rows;

        }catch (SQLException e){
            System.out.println("error para aptualizar : " + e.getMessage());
            e.printStackTrace();

            return 0;
        }
    }



    //=============DELETE USERS==========================
    public int  deleteUser(int id ){
        String sql="DELETE FROM usuarios  WHERE id=?";
        int rowsAffected=0;
        try(PreparedStatement pstmt=cnn.prepareStatement(sql)){

            //pstmt.setString(1,name);
            pstmt.setInt(1,id);
            rowsAffected=   pstmt.executeUpdate();

            System.out.println("Filas eliminadas :" +  rowsAffected);
        }catch(SQLException e)
        {
            System.out.println("Error al actualizar usuario ");
            e.printStackTrace();
        }

        return rowsAffected;

    }



* */