package Homework.repositories.mapper;

import Homework.repositories.entitie.EntityUser;
import Homework.User;

public class EntityUserMapper {

    public static EntityUser toEntity(User user) {
        EntityUser entity = new EntityUser() {
            private Integer id;
            @Override
            public Integer getId() { return id; }
            @Override
            public void setId(Integer id) { this.id = id; }
        };
        entity.setId(user.getId());
        return entity;
    }

    public static User toDomain(EntityUser entity) {
        if (entity == null) return null;
        return new User(
            entity.getId(),
            null,
            null,
            null
        );
    }

    public static User toDomainFull(EntityUser entity, String name, String email, Integer age) {
        if (entity == null) return null;
        return new User(
            entity.getId(),
            name,
            email,
            age
        );
    }
}
