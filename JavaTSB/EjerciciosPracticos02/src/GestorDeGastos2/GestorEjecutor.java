package GestorDeGastos2;
import java.util.Scanner;
public class GestorEjecutor {


        public void Gestor() {
            System.out.println("--------------------------------");
            System.out.println("BIENVENIDO AL GESTOR DE GASTOS!");
            System.out.println("--------------------------------");

            System.out.print("Ingresar la cantidad de datos a cargar: ");
            int opcion, mes, sucursal, importe, monto;
            String descripcion, codigo;
            Scanner scanner = new Scanner(System.in);
            boolean ban = false;
            boolean ban1 = false;
            System.out.print("Ingrese la cantidad de datos que va a cargar: ");
            int num = scanner.nextInt();
            Gestor[] gestor = new Gestor[num];
            String[] letras = new String[4];
            letras[0] = "a";
            letras[1] = "b";
            letras[2] = "c";
            letras[3] = "d";
            int[][] matriz = new int[3][12];
            sucursal = 0;
            mes = 0;


            do {

                System.out.println("-------------------------------");
                System.out.println("MENU DE ARREGLOS");
                System.out.println("1. Cargar gasto");
                System.out.println("2. Mostrar gastos ordenados");
                System.out.println("3. Buscador por codigo");
                System.out.println("4. Gastos totalales por mes y sucursal");
                System.out.println("0. Salir");
                System.out.print("Ingrese su opcion: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        ban = true;
                        for (int i = 0; i < gestor.length; i++) {
                            codigo = letras[(int) (Math.random() * 1000) % 4];
                            descripcion = "Codigo: " + codigo;
                            mes = (int) (Math.random() * 1000) % 12 + 1;
                            sucursal = (int) (Math.random() * 1000) % 3;
                            importe = (int) (Math.random() * 1000);

                            gestor[i] = new Gestor(codigo, descripcion, mes, sucursal, importe);
                        }
                        break;
                    case 2:
                        if (ban == true) {
                            int n = gestor.length;
                            for (int i = 0; i < n - 1; i++) {
                                for (int j = i + 1; j < n; j++) {
                                    if (gestor[i].getImporte() > gestor[j].getImporte()) {
                                        Gestor aux = gestor[i];
                                        gestor[i] = gestor[j];
                                        gestor[j] = aux;
                                    }
                                }
                            }
                            for (int i = 0; i < gestor.length; i++) {
                                System.out.println(gestor[i].toString());
                            }
                        } else System.out.println("Recuerde cargar los datos");
                        break;

                    case 3:
                        System.out.println(" Ingrese el monto a cambiar en el codigo c: ");
                        monto = scanner.nextInt();
                        for (int i = 0; i < gestor.length; i++) {
                            if (gestor[i].getCodigo().equals("a")|| gestor[i].getCodigo().equals("b")) {
                                gestor[i].setImporte(monto);
                                ban1 = true;
                            }
                        }
                        if (ban1 == false) System.out.println("No se encontro ningun codigo con c");
                        break;
                    case 4:
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 12; j++) {
                                matriz[i][j] = 0;
                            }
                        }

                        //Asignarle importes por mes y sucursal
                        for (int i = 0; i < gestor.length; i++) {
                            mes = gestor[i].getMes() - 1;
                            sucursal = gestor[i].getSucursal();
                            matriz[sucursal][mes] += gestor[i].getImporte();
                        }
                        //Mostar datos de la matriz
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 12; j++) {
                                if (matriz[i][j] != 0) {
                                    sucursal = i;
                                    mes = j;
                                    System.out.println(" La sucursal " + sucursal + " en el mes " + (mes + 1) + " tuvo un ingreso de: " + matriz[i][j]);
                                }
                            }
                        }
                        break;
                    case 0:
                        System.out.println(" Nos vemos! Exitos ");
                        break;
                    default:
                        System.out.println("No existe ninguna opcion con el numero " + opcion);
                }


            } while (opcion != 0);
    }


}
