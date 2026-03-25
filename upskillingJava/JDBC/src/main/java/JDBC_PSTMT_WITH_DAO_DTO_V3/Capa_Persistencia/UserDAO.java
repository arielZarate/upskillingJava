package JDBC_PSTMT_WITH_DAO_DTO_V3.Capa_Persistencia;



import JDBC_PSTMT_WITH_DAO_DTO_V3.Capa_Datos.User;
import JDBC_PSTMT_WITH_DAO_DTO_V3.Capa_Datos.UserDTO;

public interface UserDAO extends GenericDAO<UserDTO> {
     //solo defino las firmas de los metodos que implementare


}
    // ==========PATRON DAO====================

    // se ha cometado el codifo porque ahora extiende de
     // una clase generica que le pasa el tipo y tiene la misma funconalidad
     //no debo estar repitgiendo el codigo , ya lo heredo de GenericDAO

     /*

         //INSERTA UN OBJETO USER , PODRIA DEVOLVER SOLO  MENSAJE, O EN MI CASO UN INT CON EL RESULTADO DE LA CONSULTA
     public int insertUser(User user);

     //RETORNA UN OBJETO DE TIPO USER
     public User findUserById(int  id);

     // ES UNA LISTA DE USERS
     public List<User> findAll();

     //ACTUALIZA UN OBJETO USER RECIBE EL OBJETO USER Y UN ID , PODRIA DEVOLVER SOLO  MENSAJE, O EN MI CASO UN INT CON EL RESULTADO DE LA CONSULTA
     public int updateUser(int id,User user);

     //ELIMNA UN UBJETO USER , LE PASAS EL ID LO BUSCA Y SI LO ENCUENTA LO ELIMINA
     public int deleteUser(int id);


   **/

