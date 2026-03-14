package Homework.repositories.entitie;

import java.util.*;
import java.util.stream.Collectors;

public class BaseRepository<T extends EntityUser> implements DaoInterface<T> {

    protected Map<Integer, T> storage = new HashMap<>();
    protected Integer nextId = 1;

    @Override
    public T findById(Integer id) {
        return storage.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Integer create(T entity) {
        entity.setId(nextId++);
        storage.put(entity.getId(), entity);
        return entity.getId();
    }

    @Override
    public void update(T entity) {
        if (entity.getId() != null && storage.containsKey(entity.getId())) {
            storage.put(entity.getId(), entity);
        }
    }

    @Override
    public void delete(Integer id) {
        storage.remove(id);
    }

    @Override
    public List<T> findByIds(List<Integer> ids) {
        return storage.values().stream()
                .filter(entity -> ids.contains(entity.getId()))
                .collect(Collectors.toList());
    }

    public List<T> findAllById(List<Integer> ids) {
        return findByIds(ids);
    }

    public void copyFrom(List<? extends T> sourceList, List<T> destinationList) {
        destinationList.addAll(sourceList);
    }

    public void copySubtypesToSuper(List<? extends T> subtypes, List<T> destination) {
        destination.addAll(subtypes);
    }
}
