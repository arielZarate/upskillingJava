package Homework.repositories;

import Homework.User;
import Homework.repositories.entitie.BaseRepository;
import Homework.repositories.entitie.EntityUser;
import Homework.repositories.mapper.EntityUserMapper;



public class UserRepository extends BaseRepository<EntityUser> {

    public void save(User user) {
        EntityUser entity = new EntityUser() {
            private Integer id;
            @Override
            public Integer getId() { return id; }
            @Override
            public void setId(Integer id) { this.id = id; }
        };
        entity.setId(user.getId());
        
        if (user.getId() == null) {
            create(entity);
        } else {
            update(entity);
        }
    }

    public User findUserById(Integer id) {
        EntityUser entity = findById(id);
        if (entity == null) return null;
        
        User user = new User();
        user.setId(entity.getId());
        user.setName("User_" + id);
        user.setEmail("user" + id + "@example.com");
        user.setAge(25 + id);
        return user;
    }

    public User findUserByIdFull(Integer id) {
        EntityUser entity = findById(id);
        return EntityUserMapper.toDomain(entity);
    }
}
