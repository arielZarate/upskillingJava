package JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4;




import JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Presentacion.UserController;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import static java.nio.file.Paths.get;

public class Main_API_REST {

    public static void main(String[] args) {
   Gson json =new Gson();
       Dotenv dotenv=Dotenv.configure().directory("/media/ariel/ssd Datos_aux/Java/java 2024/JDBC/src/main/java/JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4/").load();

   //  String PORT=dotenv.get("PORT");
  // Configuración de Spark
       Spark.port(3000);

        System.out.println("ejecutandose en el port " + 3000 );



        // Configuración de rutas
        Spark.path("/api", () -> {
            Spark.path("/users", () -> {

                //localhost:3000/api/users


                Spark.get("/" ,UserController::getAllUsers);
                Spark.get("/:id", UserController::getUserById);
                Spark.post("/", UserController::createUser);
                Spark.put("/:id", UserController::updateUser);
                Spark.delete("/:id", UserController::deleteUser);
            });
        });






    }
}









