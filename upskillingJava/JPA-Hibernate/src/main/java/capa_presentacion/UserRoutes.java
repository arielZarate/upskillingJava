package capa_presentacion;

//import static spark.Spark.*;

import capa_datos.User;
import com.google.gson.Gson;
import spark.Spark;


public class UserRoutes {



    private final UserController controller;
    private final Gson gson;

    //inyeccion de dependencias :)
    public UserRoutes(UserController controller) {
        this.controller = controller;
        this.gson = new Gson();
    }




    public void configure(){

        Spark.port(3001);
        System.out.println("http://localhost:3001/api/users");




        // Definimos el prefijo base para las rutas
        String basePath = "/api";

        // Traer todos los usuarios
        Spark.get(basePath + "/users", (req, res) -> {
            res.type("application/json");
            return gson.toJson(controller.getAllUsers());
        });

        // Crear un nuevo usuario
        Spark.post(basePath + "/users", (req, res) -> {
            res.type("application/json");
            User user = gson.fromJson(req.body(), User.class);
            return gson.toJson(controller.addUser(user));
        });

        // Obtener un usuario por ID
        Spark.get(basePath + "/users/:id", (req, res) -> {
            res.type("application/json");
            Long id = Long.parseLong(req.params(":id"));
            return gson.toJson(controller.getUserById(id));
        });

        // Actualizar un usuario por ID
        Spark.put(basePath + "/users/:id", (req, res) -> {
            res.type("application/json");
            Long id = Long.parseLong(req.params(":id"));
            User user = gson.fromJson(req.body(), User.class);
            return gson.toJson(controller.updateUser(id, user));
        });

        // Eliminar un usuario por ID
        Spark.delete(basePath + "/users/:id", (req, res) -> {
            res.type("application/json");
            Long id = Long.parseLong(req.params(":id"));
            return gson.toJson(controller.deleteUser(id));
        });
    }

}
