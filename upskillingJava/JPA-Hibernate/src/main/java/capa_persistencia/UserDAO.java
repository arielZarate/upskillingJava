package capa_persistencia;

import capa_datos.User;

import java.util.List;

public interface UserDAO {


    public List<User> findAll();
    public Long create(User user);
    public User findById(Long id);
    public int  update(long id, User user);
    public int delete(Long id);



}
