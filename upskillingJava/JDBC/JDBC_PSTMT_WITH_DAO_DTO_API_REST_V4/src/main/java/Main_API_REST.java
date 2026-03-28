import Capa_Presentacion.UserController;
import spark.Spark;

public class Main_API_REST {

    public static void main(String[] args) {
        // Configuración de Spark
        Spark.port(3000);
        System.out.println("ejecutandose en el port " + 3000);

        // Configuración de rutas
        Spark.path("/api", () -> {
            Spark.path("/users", () -> {
                Spark.get("/", UserController::getAllUsers);
                Spark.get("/:id", UserController::getUserById);
                Spark.post("/", UserController::createUser);
                Spark.put("/:id", UserController::updateUser);
                Spark.delete("/:id", UserController::deleteUser);
            });
        });
    }
}






