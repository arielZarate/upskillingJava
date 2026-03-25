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