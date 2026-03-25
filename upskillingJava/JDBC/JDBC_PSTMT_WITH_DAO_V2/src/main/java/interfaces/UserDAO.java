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
