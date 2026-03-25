package JDBC_PSTMT_V1;

import java.util.Scanner;

public class Mainv1 {

    public static void main(String[] args) {

        RequestJDBC requestJDBC = new RequestJDBC();
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.println("************* MENU *************");
            System.out.println("1. Mostrar todos los usuarios");
            System.out.println("2. Mostrar usuario por ID");
            System.out.println("3. Insertar usuario");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Salir");
            System.out.print("Ingrese opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Mostrando todos los usuarios:");
                    requestJDBC.getUsuarios();
                    break;
                case 2:
                    System.out.print("Ingrese ID del usuario a mostrar: ");
                    int idMostrar = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    requestJDBC.getUsuarioPorId(idMostrar);
                    break;
                case 3:
                    System.out.print("Ingrese nombre del usuario a insertar: ");
                    String nombreInsertar = scanner.nextLine();
                    requestJDBC.InsertUsuario(nombreInsertar);
                    break;
                case 4:
                    System.out.print("Ingrese ID del usuario a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Ingrese nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    requestJDBC.updateUsuario(idActualizar, nuevoNombre);
                    break;
                case 5:
                    System.out.print("Ingrese ID del usuario a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    requestJDBC.deleteUsuario(idEliminar);
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        requestJDBC.CloseConnectionJDBC();
        scanner.close();
        System.out.println("Programa terminado.");

    }
}
