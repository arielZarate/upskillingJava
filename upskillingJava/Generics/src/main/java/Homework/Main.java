package Homework;

import Homework.repositories.UserRepository;
import Homework.repositories.entitie.EntityUser;
import Homework.repositories.mapper.EntityUserMapper;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO: Repositorio Genérico con Genéricos Java ===\n");

        UserRepository userRepo = new UserRepository();

        User user1 = new User(null, "Juan", "juan@email.com", 25);
        User user2 = new User(null, "Maria", "maria@email.com", 30);
        User user3 = new User(null, "Pedro", "pedro@email.com", 28);

        System.out.println("--- CREATE ---");
        Integer id1 = userRepo.create(EntityUserMapper.toEntity(user1));
        Integer id2 = userRepo.create(EntityUserMapper.toEntity(user2));
        Integer id3 = userRepo.create(EntityUserMapper.toEntity(user3));

        System.out.println("Creados usuarios con IDs: " + id1 + ", " + id2 + ", " + id3);

        System.out.println("\n--- READ (findById) ---");
        EntityUser found = userRepo.findById(1);
        System.out.println("Encontrado por ID 1: " + found.getId());

        System.out.println("\n--- READ (findAll) ---");
        List<EntityUser> all = userRepo.findAll();
        System.out.println("Total usuarios: " + all.size());

        System.out.println("\n--- WILDCARDS: copyFrom con ? extends ---");

        List<EntityUser> listaOriginal = userRepo.findAll();
        List<EntityUser> listaCopia = new ArrayList<>();

        userRepo.copyFrom(listaOriginal, listaCopia);
        System.out.println("Elementos copiados: " + listaCopia.size());

        System.out.println("\n--- findByIds (recibe List<Integer>) ---");
        List<Integer> ids = List.of(1, 2);
        List<EntityUser> foundByIds = userRepo.findByIds(ids);
        System.out.println("Encontrados por IDs [1,2]: " + foundByIds.size());

        System.out.println("\n--- UPDATE ---");
        EntityUser toUpdate = userRepo.findById(1);
        toUpdate.setId(1);
        userRepo.update(toUpdate);
        System.out.println("Usuario 1 actualizado");

        System.out.println("\n--- DELETE ---");
        userRepo.delete(3);
        System.out.println("Usuario 3 eliminado");
        System.out.println("Total después de delete: " + userRepo.findAll().size());

        System.out.println("\n--- Demo UserRepository específico ---");
        User userFull = userRepo.findUserById(1);
        System.out.println("Usuario completo: " + userFull);

        System.out.println("\n=== FIN DEMO ===");
    }
}
