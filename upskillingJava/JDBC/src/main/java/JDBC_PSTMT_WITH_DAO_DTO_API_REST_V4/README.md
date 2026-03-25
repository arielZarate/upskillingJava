# JAVA CON JDBC Y PATRONES DAO / DTO / SINGLETON /MVC


Este proyecto es la version 3 de los 2 anteriores , en el cual ahora implemento el patron DTO Y MODELO VISTA CONTROLADOR (MVC)




## Estructura del proeycto 

```bash
¡src
├── main
│   └── java
│       ├── JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4
│       │   ├── Capa_Datos
│       │   │   └── UserDTO.java
│       │   ├── Capa_Persistencia
│       │   │   └── UserDAOImpl.java
│       │   └── Capa_Presentacion
│       │       └── UserController.java
│       └── Main.java


```



## DTO

- Los DTOs (Data Transfer Objects) son objetos utilizados para transferir datos entre las capas de la
  aplicación. Sirven como una representación de los datos que se intercambian entre las capas, evitando la
  exposición directa de las entidades de datos. Los DTOs suelen ser simples y contener solo los datos
  necesarios para la comunicación entre capa

- Las clases de entidad representan los objetos de dominio de la aplicación, es decir, los objetos que
  representan conceptos del mundo real con los que se trabaja en el sistema. Estas clases contienen la
  estructura y el comportamiento asociados con los datos de la aplicación.
  En resumen, en la arquitectura en capas, el patrón DAO se sitúa en la capa de acceso a datos y se utiliza
  para separar la lógica de acceso a datos del resto de la aplicación. Los DTOs se utilizan para transferir
  datos entre las capas y las clases de entidad representan los objetos de dominio de la aplicación. Juntos,
  estos componentes contribuyen a la modularidad y organización de la aplicación, facilitando su
  mantenimiento y escalabilidad.
  ¿Cómo implementamos el pat



## Creacion de aplicaciones en java

En la creación de aplicaciones Java, generalmente se organiza el código en varias capas para separar las responsabilidades y facilitar el mantenimiento, la escalabilidad y la reutilización del código. Estas capas son:


 ![capa](./images/Capas.png)

#### Capa de Presentación (Presentation Layer):

- Responsabilidad: Interactuar con el usuario final y mostrar los datos de la aplicación.
- Contiene: Interfaces de usuario (UIs) como páginas web (utilizando frameworks como JSP, Servlets, JSF), 
  aplicaciones de escritorio (Swing, JavaFX), y controladores (Controllers) que manejan la lógica de la 
  interfaz de usuario.
- En una API REST, los controladores (controllers) manejan las solicitudes HTTP, 
  gestionan las rutas y delegan el procesamiento a los servicios adecuados. 
 
  Ejemplo de un controller en una API REST utilizando Spring boot MVC
 

```javascript
  @RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

```
  
  
#### Capa de Negocio o Servicios (Business Layer):

- Responsabilidad: Implementar la lógica de negocio de la aplicación, es decir, las reglas y operaciones 
   que definen el comportamiento de la aplicación.
- Contiene: Servicios (Services), gestores (Managers) y lógica de negocio pura. 
  También puede incluir validaciones y procesos de negocio.
- En mi caso estan con los controladores son los servicios private que instancian la clase UserImpl DAO 
  para guardar los datos en la capa de persistencia 
  
#### Capa de Persistencia (Persistence/Data Access Layer):

- Responsabilidad: Interactuar con la base de datos y manejar la persistencia de datos.
- Contiene: Objetos de Acceso a Datos (DAOs), repositorios (Repositories) y configuraciones de ORM 
- (como Hibernate). Esta capa se encarga de las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) 
- sobre la base de datos.
- En mi caso tengo el 

#### Capa de Datos (Data Layer):

- Responsabilidad: Definir la estructura de los datos y las entidades de la aplicación.
- Contiene: Clases de modelo (Models/Entities) que representan las tablas de la base de datos en la 
  forma de objetos Java. Estas clases contienen los atributos y métodos relacionados con los datos.



## Spark microframework

Spark es un microframework web para Java que se integra bien con Tomcat como servidor web. 
Te guiaré en la configuración básica y en cómo implementar un proyecto similar al que discutimos anteriormente utilizando Spark.

```bash
- src
  - main
    - java
      - com
        - example
          - sparkdemo
            - Capa_Datos
              - UserDTO.java
            - Capa_Persistencia
              - UserDAOImpl.java
              - UserDAO.java
            - Capa_Presentacion
              - UserController.java
            - Main.java
    - resources
      - META-INF
        - context.xml

```




### Nota 

 Vamos a usar todo el proyecto anterior y solo la parte del contralador cambiare donde creare: 

- controller con las ruta
-  vere si uso la `Capa_Negocio o Servicio` para inplementar los services que conectaran 
   el controlador con la Capa de Persistencia donde tengo el `UserDAOImpl` 



### MAVEN
```html
<dependencies>
    <dependency>
        <groupId>com.sparkjava</groupId>
        <artifactId>spark-core</artifactId>
        <version>2.9.4</version>
    </dependency>
    <!-- Dependencias de MySQL si las necesitas -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.28</version>
    </dependency>
</dependencies>

```

En el main  de java 

º
```java

public class Main {
    public static void main(String[] args) {
        // Configuración de Spark
        Spark.port(8080);

        // Configuración de rutas
        Spark.path("/api", () -> {
            Spark.path("/users", () -> {
                Spark.get("", UserController::getAllUsers);
                Spark.get("/:id", UserController::getUserById);
                Spark.post("", UserController::createUser);
                Spark.put("/:id", UserController::updateUser);
                Spark.delete("/:id", UserController::deleteUser);
            });
        });
    }
}
```


El controller quedara algo asi 

```java

package com.example.sparkdemo.Capa_Presentacion;

import com.example.sparkdemo.Capa_Datos.UserDTO;
import com.example.sparkdemo.Capa_Persistencia.UserDAOImpl;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.List;

public class UserController {
    private static UserDAOImpl userDAO = new UserDAOImpl();
    private static Gson gson = new Gson();

    public static Object getAllUsers(Request request, Response response) {
        List<UserDTO> users = userDAO.findAll();
        response.type("application/json");
        return gson.toJson(users);
    }

    public static Object getUserById(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        UserDTO user = userDAO.findUserById(id);
        if (user != null) {
            response.type("application/json");
            return gson.toJson(user);
        } else {
            response.status(404);
            return "Usuario no encontrado";
        }
    }

    public static Object createUser(Request request, Response response) {
        UserDTO userDTO = gson.fromJson(request.body(), UserDTO.class);
        int result = userDAO.insertUser(userDTO);
        if (result > 0) {
            response.status(201);
            return "Usuario creado con éxito";
        } else {
            response.status(500);
            return "Error al crear el usuario";
        }
    }

    public static Object updateUser(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        UserDTO userDTO = gson.fromJson(request.body(), UserDTO.class);
        int result = userDAO.updateUser(id, userDTO);
        if (result > 0) {
            response.status(200);
            return "Usuario actualizado con éxito";
        } else {
            response.status(500);
            return "Error al actualizar el usuario";
        }
    }

    public static Object deleteUser(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        int result = userDAO.deleteUser(id);
        if (result > 0) {
            response.status(204);
            return "Usuario eliminado con éxito";
        } else {
            response.status(500);
            return "Error al eliminar el usuario";
        }
    }
}

```


## Explicacion de codigo

- UserDTO: Representa el objeto de transferencia de datos del usuario.

- UserDAOImpl: Implementa los métodos de acceso a la base de datos. En este caso, findAll devuelve una lista simulada de usuarios.

- UserController: Contiene métodos estáticos que manejan las solicitudes HTTP. Estos métodos reciben Request y Response para manejar la solicitud y construir la respuesta.

- Main: Configura las rutas del servidor Spark Java. Para cada ruta, se crea una instancia del controlador y se llama al método correspondiente, pasando Request y Response.




### Despliegue y Ejecución
Compila y empaqueta tu proyecto:

- Utiliza Maven para compilar y empaquetar tu proyecto en un archivo JAR.
  
#### Ejecuta tu aplicación:

- Puedes ejecutar tu aplicación Spark desde tu IDE .

#### Accede a tus endpoints REST:

- Una vez que tu aplicación esté en funcionamiento, puedes acceder a los endpoints definidos (/api/users, /api/users/:id, etc.) desde un cliente HTTP como Postman o un navegador.
  Este enfoque te permite utilizar Spark como un microframework ligero para desarrollar aplicaciones web en Java, facilitando la definición de rutas y el manejo de solicitudes HTTP de manera eficiente.