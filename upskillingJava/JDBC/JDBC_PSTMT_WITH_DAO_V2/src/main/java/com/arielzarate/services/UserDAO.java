package com.arielzarate.services;

import com.arielzarate.models.User;
import java.util.List;

public interface UserDAO {

    // ==========PATRON DAO====================

     public int insertUser(User user);
     public User findUserById(int  id);
     public List<User> findAll();
     public int updateUser(int id,User user);
     public int deleteUser(int id);


}
