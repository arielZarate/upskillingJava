package JDBC_PSTMT_WITH_DAO_DTO_V3;



import JDBC_PSTMT_WITH_DAO_DTO_V3.Capa_Presentacion.UserController;

public class Mainv3 {

    public static void main(String[] args) {

        //el main llama a la clase controlladora de la capa de presentacion

        UserController controler= new UserController();

        controler.ShowMenu();

    }
}











/*
//codigo viejo del main todo junto
// ahora lo saque y lo puse en la capa de presentacion como controladores y services

//==========================================================

UserDAOImpl UserImpl=new UserDAOImpl();
//==========================================================
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
User userUp= new User();
                    userUp.setName(name2);
                    userUp.setLastName(lastName2);
                    userUp.setAge(age2);
                    userUp.setEmail(email2);
int rows_affected=UserImpl.updateUser(id,userUp);
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

                            }
                            while(opcion != 6);
        //  System.exit(0); NO HACE FALTA CORTA SOLO EL SISTEMA

        }

/*/