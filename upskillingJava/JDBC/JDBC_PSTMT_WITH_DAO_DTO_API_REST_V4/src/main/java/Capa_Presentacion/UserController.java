package JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Presentacion;


import JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Datos.UserDTO;
import JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Persistencia.UserDAO;
import JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Persistencia.UserDAOImpl;


import com.google.gson.Gson;
import spark.*;
import spark.Request;

import java.util.List;


public class UserController  {

  private static UserDAOImpl userDAO=new UserDAOImpl();
  private static Gson gson=new Gson();


  public static Object getAllUsers(Request req, Response res) {
    List<UserDTO> users = userDAO.findAll();
    res.type("application/json");
    return gson.toJson(users);
  }


   public static Object getUserById(Request req ,Response res){

    int id=Integer.parseInt(req.params(":id"));

    UserDTO userdto=userDAO.findUserById(id);
    if(userdto != null){
      res.type("application/json");
      return gson.toJson(userdto);
    }
      res.status(404);
      return "usuario no encontrado";

   }



   public static Object createUser(Request request,Response response) {
    UserDTO userdto= gson.fromJson(request.body(),UserDTO.class);

     int result = userDAO.insertUser(userdto);
     if (result > 0) {
       response.status(201);
       return "Usuario creado con éxito";
     } else {
       response.status(500);
       return "Error al crear el usuario";
     }

   }

  public static Object updateUser(Request request, Response response) {
    int id = Integer.parseInt(request.params(":id"));
    UserDTO userDTO = gson.fromJson(request.body(), UserDTO.class);
    int result = userDAO.updateUser(id, userDTO);
    if (result > 0) {
      response.status(200);
      return "Usuario actualizado con éxito";
    } else {
      response.status(500);
      return "Error al actualizar el usuario";
    }
  }

  public static Object deleteUser(Request request, Response response) {
    int id = Integer.parseInt(request.params(":id"));
    int result = userDAO.deleteUser(id);
    //System.out.println("resuult :" + result);
    if (result == 1) {
      response.status(200);
      return "Usuario eliminado con éxito";
    } else {
      response.status(500);
      return "Error al eliminar el usuario";
    }
  }



}