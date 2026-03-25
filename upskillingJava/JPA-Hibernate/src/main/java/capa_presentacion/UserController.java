package capa_presentacion;

import capa_datos.User;
import capa_negocio.UserServiceDAO;

import java.util.List;

public class UserController {

    //creacion por instancia de la interface de la capa de negocio o los services
        private final UserServiceDAO userService;


        //patron inyecion de dependencias
        public UserController(UserServiceDAO userService) {
            this.userService = userService;
        }

        public List<User> getAllUsers() {
            return userService.getAllUser();
        }

        public Long addUser(User user) {
            return userService.createUser(user);
        }

        public User getUserById(Long id) {
            return userService.findUserById(id);
        }

        public int updateUser(Long id, User user) {
            return userService.updateUser(id, user);
        }

        public int deleteUser(Long id) {
            return userService.deleteUser(id);
        }
    }








