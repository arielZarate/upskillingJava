package JDBC_PSTMT_WITH_DAO_DTO_V3.Capa_Presentacion;

import JDBC_PSTMT_WITH_DAO_DTO_V3.Capa_Datos.User;
import JDBC_PSTMT_WITH_DAO_DTO_V3.Capa_Datos.UserDTO;
import JDBC_PSTMT_WITH_DAO_DTO_V3.Capa_Persistencia.UserDAOImpl;

import java.util.List;
import java.util.Scanner;

public class UserController {


    private final UserDAOImpl UserImpl;


    public UserController() {
        //IMPORTANTE ACA LA DECLARACION DE LA INTERFAZ A LA IZQ Y SU IMPLEMENTACION A LA DERECHA

        //PROGRAMACION DE OBJETO ORIENTADA A INTERFACE PARA DESACOPLAR EL CODIGO
        this.UserImpl=new UserDAOImpl();
    }




    public void ShowMenu() {
        UserImpl.createTable();  //creo las talas por defecto apenas inicia el programa por si acaso

        int opcion;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println(" \n");
            System.out.println("************* MENU *************");
            System.out.println("1. Mostrar todos los usuarios");
            System.out.println("2. Mostrar usuario por ID");
            System.out.println("3. Insertar usuario");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Salir");
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            //aca  van los sericios del controller , los separe

           handleOption(opcion,scanner);

        }
        while(opcion != 6);
        //  System.exit(0); NO HACE FALTA CORTA SOLO EL SISTEMA

    }


    private void handleOption(int opcion, Scanner scanner){

        switch (opcion) {
            case 1:
                showAllUsers();
                break;
            case 2:
                showUserById(scanner);
                break;
            case 3:
                insertUser(scanner);
                break;
            case 4:
                updateUser(scanner);
                break;
            case 5:
                deleteUser(scanner);
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                break;
        }

    }

//estosson los metodosa privados del menu
    private void showAllUsers()
    {
        System.out.println("Mostrando todos los usuarios: \n");
        List<UserDTO> users=UserImpl.findAll();  //esto me devuelve una lista
        for(UserDTO u: users)
        {
            //debo mostrarlos con sout
            System.out.println(u.toString());
        }
    }


    private void showUserById(Scanner scanner){

        System.out.print("Ingrese ID del usuario a mostrar: ");
        int idShow = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        UserDTO user= UserImpl.findUserById(idShow);
        System.out.println(user.toString());

    }


    private void insertUser(Scanner scanner ){
        //=========loading data============
        System.out.print("Ingrese nombre del usuario a insertar: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese apellido del usuario a insertar: ");
        String lastName = scanner.nextLine();
        System.out.print("Ingrese edad del usuario a insertar: ");
        int  age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese email del usuario a insertar: ");
        String email = scanner.nextLine();
        UserDTO newUser=new UserDTO(name,lastName,age,email);

          int rowsAffected=UserImpl.insertUser(newUser);
        if(rowsAffected > 0)
        {
            System.out.println("Usuario creado exitosamente " );
        }
        else {
            System.out.println("Error ,Usuario no creada " );
        }

    }


    private void updateUser(Scanner scanner){
        System.out.print("Ingrese ID del usuario a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese nuevo nombre: ");
        String name2 = scanner.nextLine();
        System.out.print("Ingrese nuevo apellido: ");
        String lastName2 = scanner.nextLine();
        System.out.print("Ingrese nueva edad: ");
        int  age2 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nuevo email: ");
        String email2 = scanner.nextLine();
        //esta vez creare asi
        UserDTO user_dto= new UserDTO();
        user_dto.setName(name2);
        user_dto.setLastName(lastName2);
        user_dto.setAge(age2);
        user_dto.setEmail(email2);
        int rows_affected=UserImpl.updateUser(id,user_dto);
        if (rows_affected > 0) {
            System.out.println("Usuario actualizado exitosamente");
        } else {
            System.out.println("Error, usuario no actualizado");
        }

    }


    private void deleteUser(Scanner scanner){
        System.out.print("Ingrese ID del usuario a eliminar: ");
        int id_delete = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        int rows= UserImpl.deleteUser(id_delete);

        if (rows > 0) {
            System.out.println("Usuario Eliminado ");
        } else {
            System.out.println("Error, usuario no eliminado");
        }
    }


}



/*

   asi estaba todito 0junto antes
            switch (opcion) {
                case 1:
                    System.out.println("Mostrando todos los usuarios: \n");
                    List<User> users=UserImpl.findAll();  //esto me devuelve una lista
                    for(User u: users)
                    {
                        //debo mostrarlos con sout
                        System.out.println(u.toString());
                    }
                    break;
                case 2:
                    System.out.print("Ingrese ID del usuario a mostrar: ");
                    int idShow = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    User user= UserImpl.findUserById(idShow);
                    System.out.println(user.toString());
                    break;
                case 3:
                    //=========loading data============
                    System.out.print("Ingrese nombre del usuario a insertar: ");
                    String name = scanner.nextLine();
                    System.out.print("Ingrese apellido del usuario a insertar: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Ingrese edad del usuario a insertar: ");
                    int  age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese email del usuario a insertar: ");
                    String email = scanner.nextLine();
                    User newUser=new User(name,lastName,age,email);
                    int rowsAffected=UserImpl.insertUser(newUser);
                    if(rowsAffected > 0)
                    {
                        System.out.println("Usuario creado exitosamente " );
                    }
                    else {
                        System.out.println("Error ,Usuario no creada " );
                    }
                    break;
                case 4:
                    System.out.print("Ingrese ID del usuario a actualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Ingrese nuevo nombre: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Ingrese nuevo apellido: ");
                    String lastName2 = scanner.nextLine();
                    System.out.print("Ingrese nueva edad: ");
                    int  age2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nuevo email: ");
                    String email2 = scanner.nextLine();
                    //esta vez creare asi
                    User user_dto= new User();
                    user_dto.setName(name2);
                    user_dto.setLastName(lastName2);
                    user_dto.setAge(age2);
                    user_dto.setEmail(email2);
                    int rows_affected=UserImpl.updateUser(id,user_dto);
                    if (rows_affected > 0) {
                        System.out.println("Usuario actualizado exitosamente");
                    } else {
                        System.out.println("Error, usuario no actualizado");
                    }

                    break;
                case 5:
                    System.out.print("Ingrese ID del usuario a eliminar: ");
                    int id_delete = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    int rows= UserImpl.deleteUser(id_delete);

                    if (rows > 0) {
                        System.out.println("Usuario Eliminado ");
                    } else {
                        System.out.println("Error, usuario no eliminado");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    UserImpl.CloseConnection();
                    scanner.close(); //cerrar el scanner

                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

**/