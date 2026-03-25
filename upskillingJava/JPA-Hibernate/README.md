

# CRUD JPA CON HIBERNATE



Estructura del Proyecto Mejorada
```java

capa_datos
User.java
capa_persistencia
UserDAO.java
UserDaoImp.java
capa_negocio
UserServiceDAO.java
UserService.java
capa_presentacion
UserController.java
Routes.java (Nueva clase para las rutas)
Main.java


```








## Resumen de la Estructura del Proyecto
Capa de Datos: Contiene la entidad User.
Capa de Persistencia: Contiene UserDAO y UserDaoImp.
Capa de Servicios: Contiene UserService y UserServiceImpl.
Capa de Presentación: Contiene UserController y UserRoutes.
Main: Configuración de Spark para manejar las solicitudes HTTP.
Esta estructura te permitirá manejar de manera efectiva las solicitudes HTTP,
aplicar lógica de negocio en la capa de servicios y realizar operaciones CRUD en 
la capa de persistencia utilizando JPA y Hibernate.



### CAPA DE SERVICIO
En la capa de servicios (UserServiceImpl), se utiliza UserServiceDAO para mantener una separación
clara de responsabilidades y promover una arquitectura limpia y mantenible.
Aquí están las razones específicas:

- Separación de Responsabilidades: La capa de servicios se encarga de la lógica de negocio y la
 capa de persistencia se encarga de las operaciones de acceso a datos. 
 Al inyectar UserDAO en UserServiceImpl, se mantiene esta separación de responsabilidades. 
 Esto significa que UserServiceImpl delega las operaciones de acceso a datos a UserDAO.

- Facilidad de Pruebas: Al usar una interfaz UserDAO, es más fácil realizar pruebas unitarias.
 Se puede crear un mock o stub de UserDAO para probar UserServiceImpl sin necesidad de acceder
 a la base de datos real.

- Flexibilidad y Extensibilidad: Al definir y usar interfaces, es más fácil cambiar la 
 implementación concreta de UserDAO sin afectar al código que usa UserService. 
 Si en el futuro decides cambiar la implementación de UserDAO, solo necesitas modificar 
 la clase concreta sin cambiar UserServiceImpl.