package capa_negocio;

import capa_datos.User;

import java.util.List;

public interface UserServiceDAO {

    List<User> getAllUser();
    Long  createUser(User user);
    User findUserById(Long id);
    int updateUser(Long id,User user);
    int deleteUser(long id);

}
