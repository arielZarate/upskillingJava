package JDBC_PSTMT_WITH_DAO_V2;

import JDBC_PSTMT_WITH_DAO_V2.models.UserDAOImpl;

import java.util.List;
import JDBC_PSTMT_WITH_DAO_V2.models.User;
import java.util.Scanner;

public class MainV2 {

    public static void main(String[] args) {
        UserDAOImpl requestJDBC=new UserDAOImpl();
        requestJDBC.createTable();  //creo las talas por defecto apenas inicia el programa por si acaso
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


            switch (opcion) {
                case 1:
                    System.out.println("Mostrando todos los usuarios: \n");
                     List <User> users=requestJDBC.findAll();  //esto me devuelve una lista
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
                    User user= requestJDBC.findUserById(idShow);
                    System.out.println(user.toString());
                    break;
                case 3:
                    System.out.print("Ingrese nombre del usuario a insertar: ");

                    String name_insert = scanner.nextLine();
                    User newUser=new User(name_insert);
                     int rowsAffected=requestJDBC.insertUser(newUser);
                    if(rowsAffected > 0)
                    {
                        System.out.println("Usuario creada exitosamente " );
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
                    String newName = scanner.nextLine();
                    //esta vez creare asi
                    User userUp= new User();
                     userUp.setName(newName);
                     int rows_affected=requestJDBC.updateUser(id,userUp);
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
                    int rows= requestJDBC.deleteUser(id_delete);

                    if (rows > 0) {
                        System.out.println("Usuario Eliminado ");
                    } else {
                        System.out.println("Error, usuario no eliminado");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    requestJDBC.CloseConnection();
                    scanner.close(); //cerrar el scanner

                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        }
        while(opcion != 6);
      //  System.exit(0); NO HACE FALTA CORTA SOLO EL SISTEMA

    }
}
