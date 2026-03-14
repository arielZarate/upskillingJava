package Homework;

import java.util.List;

public interface DaoInterface<T> {
    T findById(Integer id);
    List<T> findAll();
    Integer create(T entity);
    void update(T entity);
    void delete(Integer id);
    List<T> findByIds(List<Integer> ids);
}
