package vectorOrdenado;


import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //try {
        Scanner sc = new Scanner(System.in);
        Vector vector = null;
        int op1 =-1;
        int op2=-1;
        String lote1="lote01.txt";
        String lote2="lote02.txt";
        String lote3="mss01.txt";
        String lote4="mss02.txt";
        String lote5="mss03.txt";
        String lotePrueba="lotePrueba.txt";

        File f=null;


            System.out.println("Debe ingresar 1- para procesar con  el lote01.txt");
            System.out.println("Debe ingresar 2- para procesar con  el lote02.txt");
            System.out.println("Debe ingresar 3- para procesar con  el msso01.txt");
            System.out.println("Debe ingresar 4- para procesar con  el msso02.txt");
            System.out.println("Debe ingresar 5- para procesar con  el msso03.txt");
            System.out.println("Debe ingresar 6- para procesar con  el lotePrueba.txt");
            System.out.println("Debe ingresar 7- para procesar con funciones");

            System.out.print("ingrese su opcion: ");
            op1=sc.nextInt();
            switch (op1)
            {
                case 1:  System.out.println("Lectura de numeros en un archivo de texto...");
                          f= new File(lote1); break;
                case 2:  System.out.println("Lectura de numeros en un archivo de texto...");
                          f = new File(lote2);break;
                case 3:System.out.println("Lectura de numeros en un archivo de texto...");
                          f = new File(lote3);break;
                case 4: System.out.println("Lectura de numeros en un archivo de texto...");
                          f = new File(lote4);break;
                case 5:System.out.println("Lectura de numeros en un archivo de texto...");
                         f = new File(lote5);break;
                case 6:System.out.println("Lectura de numeros en un archivo de texto...");
                         f = new File(lotePrueba);break;
                case 7:
                    System.out.println("**Funciones***");
                    f = new File(lotePrueba);break;


                default:
                    System.out.println("ingreso mal , reinicie el programa");
                    System.exit(0);
            }



        do {
            System.out.println("");
            System.out.println("\n****Menu de Arreglo de Numeros ****");

            System.out.println("ingrese - 1 para Inicializar el Arreglo (sino lo inicializa no devolvera nada!) ");
            System.out.println("ingrese - 2 para Obtener Listado de Arreglo ");
            System.out.println("ingrese - 3 para obtener el conteo de inversiones ");
            System.out.println("ingrese - 4 para metodo contar(punto3) ");
            System.out.println("ingrese - 5 para metodo maxSumSubsequence1()(punto4) ");
            System.out.println("ingrese - 6 para metodo maxSumSubsequence2()(punto5) ");
            System.out.println("ingrese - 7 para metodo maxSumSubsequence3()(punto6) ");
            System.out.println("ingrese - 8 para verificar el orden ");
            System.out.println("ingrese - 9 para Ordenar el vector");
            System.out.println("ingrese - 10 para entrar al menu de funciones");

            System.out.println("ingrese - 0 para cortar!!!");
            System.out.print("ingrese su opcion:");
            op2 = sc.nextInt();
            switch (op2) {


                case 1:
                    System.out.print("ingrese el tamaño del array ( lote01.txt:30.000, lote92.txt:300.000," +
                            "\n Atencion aca :mss01.txt(15.000) ,mss02.txt mss02.txt(150.000) y mss03.txt(1.500.000 números): ");
                    int tam = sc.nextInt();
                    vector = new Vector(tam);
                    System.out.println("Lectura de numeros en un archivo de texto , aguarde un momento por favor ....");
                    vector.InicializarVector(f);
                    System.out.println("Se ha leido el lote de numeros de forma exitosa!");
                    break;

                case 2:
                    System.out.println("****Listado***** \n");
                    System.out.println(vector.toString() + "\n\tFin de Listado de "+  vector.size()+ " numeros");
                    break;
                case 3:
                    System.out.println("*****conteo de inversiones*****");
                    vector.contarInversionesVoid();
                    break;

                case 4:
                    System.out.println("\n*****metodo contar()*****");
                    System.out.println(vector.contar());
                   //System.out.println(vector.toString());
                case 5:
                    System.out.println("*******maxSumSubsequence()1*********");
                    vector.maxSumSubsequence1();
                    break;
                case 6:
                    System.out.println("*******maxSumSubsequence()2*********");
                    vector.maxSumSubsequence2();
                    break;
                case 7:
                    System.out.println("*******maxSumSubsequence()3*********");
                   vector.maxSumSubsequence3();
                    break;
                case 8:
                    System.out.print("\nVector ordenado?: " + vector.checkOrder()); break;

                case 9:
                    System.out.println("**********vector Ordenado*************");
                    vector.OrdenarVector();
                    System.out.println(vector.toString());
                    break;
                case 10:
                    vector = new Vector(500);
                    vector.InicializarVector(f); //esto es para que no tire error , no tiene nada que ver con las fiunciones

                    //char op = 'k';
                   // do{
                        System.out.println("\n**Menu de funciones**");
                        System.out.println("ingrese  a - f(n) = n * 2n");
                        System.out.println("ingrese  b - f(n) = n * log(n)");
                        System.out.println("ingrese  c - f(n) = 2n");
                        System.out.println("ingrese  d - f(n) = log2(n) * n3");
                        System.out.println("ingrese  e - f(n) = n2 * 2n");
                        System.out.println("ingrese  j - para cortar");
                        System.out.print("\n ingrese su opcion: ");
                        sc.skip("");
                        String in=sc.next();
                        switch (in.charAt(0))
                        {
                            case 'a':
                                System.out.print("ingrese el valor de n para la funcion => f(n) = n * 2n: ");
                                double v1=sc.nextDouble();
                                System.out.print("\nEl valor de la funcion es : " + vector.funcion_a(v1) + "\n");
                                break;

                            case 'b':System.out.print("ingrese el valor de n para la funcion => f(n) = n * log(n): ");
                                    double v2=sc.nextDouble();
                                    System.out.print("\nEl valor de la funcion es : " + vector.funcion_b(v2) + "\n");
                                break;

                            case 'c':System.out.print("ingrese el valor de n para la funcion => f(n) = 2n: ");
                                double v3=sc.nextDouble();
                                System.out.print("\nEl valor de la funcion es : " + vector.funcion_c(v3) + "\n");
                                break;

                            case 'd':System.out.print("ingrese el valor de n para la funcion => f(n) = log2(n) * n3 ");
                                double v4=sc.nextDouble();
                                System.out.print("\nEl valor de la funcion es : " + vector.funcion_d(v4) + "\n");
                                break;

                            case 'e':System.out.print("ingrese el valor de n para la funcion => f(n) = n2 * 2n ");
                                double v5=sc.nextDouble();
                                System.out.print("\nEl valor de la funcion es : " + vector.funcion_e(v5) + "\n");
                                break;

                            case 'j':
                                System.out.println("Ha ingresado zeta, se cerrara el swicth.. ");
                                System.out.println("Fin de menu de funciones");
                                break;
                            default:
                                System.out.println("Opcion incorecta,verifique..");break;
                        }break;

                    //}while(op != 'j');

                case 0:
                    System.out.println("\nUps 🙄😥😯😯😯😯 Corto el programa.");
                    break;
                default:
                    System.out.println("Ha seleccionado incorrectamente");
                    break;
            }


        } while (op2 != 0);

        System.out.println("🏍🏍🏍🏍🏍🏍🏍🏍🏍🏍🏍🏍🏍 Ha finalizado el menu 🚀🚀🚀🚀🚀");


        //} catch (FileNotFoundException ex) {
        //	System.out.println("No existe el archivo...");
        //}
    }
}


/**
 * codigo viejo
 * long t1, t2, tf;
 * int op;
 * <p>
 * Scanner sc = new Scanner(System.in);
 * Vector v = null;
 * do
 * {
 * System.out.println ("\nOpciones de Ordenamiento");
 * System.out.println ("0. Generar el Arreglo");
 * System.out.println ("1. Intercambio Directo (Burbuja)");
 * System.out.println ("2. Seleccion Directa");
 * System.out.println ("3. Insercion Directa");
 * System.out.println ("4. Quick Sort");
 * System.out.println ("5. Heap Sort");
 * System.out.println ("6. Shell Sort");
 * System.out.println ("7. Merge Sort");
 * System.out.println ("8. Verificar si esta ordenado");
 * System.out.println ("9. Salir");
 * System.out.print ("Ingrese opcion: ");
 * op = sc.nextInt();
 * switch (op)
 * {
 * case 0:
 * System.out.print ("Ingrese cantidad del elementos del vector: ");
 * int n = sc.nextInt();
 * v = new Vector(n);
 * System.out.print("Se vuelve a generar el vector...");
 * v.generate();
 * System.out.print("\nVector generado...");
 * break;
 * <p>
 * case 1:
 * if(v == null) {
 * System.out.println("El arreglo no ha sido generado aún...");
 * continue;
 * }
 * System.out.print("Se ordena el vector por Intercambio...");
 * t1 = System.currentTimeMillis();
 * v.bubbleSort();
 * t2 = System.currentTimeMillis();
 * tf = t2 - t1;
 * System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
 * break;
 * <p>
 * case 2:
 * if(v == null) {
 * System.out.println("El arreglo no ha sido generado aún...");
 * continue;
 * }
 * System.out.print("Se ordena el vector por Seleccion...");
 * t1 = System.currentTimeMillis();
 * v.selectionSort();
 * t2 = System.currentTimeMillis();
 * tf = t2 - t1;
 * System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
 * break;
 * <p>
 * case 3:
 * if(v == null) {
 * System.out.println("El arreglo no ha sido generado aún...");
 * continue;
 * }
 * System.out.print("Se ordena el vector por Insercion... ");
 * t1 = System.currentTimeMillis();
 * v.insertionSort();
 * t2 = System.currentTimeMillis();
 * tf = t2 - t1;
 * System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
 * break;
 * <p>
 * case 4:
 * if(v == null) {
 * System.out.println("El arreglo no ha sido generado aún...");
 * continue;
 * }
 * System.out.print("Se ordena el vector por Quick Sort...");
 * t1 = System.currentTimeMillis();
 * v.quickSort();
 * t2 = System.currentTimeMillis();
 * tf = t2 - t1;
 * System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
 * break;
 * <p>
 * case 5:
 * if(v == null) {
 * System.out.println("El arreglo no ha sido generado aún...");
 * continue;
 * }
 * System.out.print("Se ordena el vector por Heap Sort...");
 * t1 = System.currentTimeMillis();
 * v.heapSort();
 * t2 = System.currentTimeMillis();
 * tf = t2 - t1;
 * System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
 * break;
 * <p>
 * case 6:
 * if(v == null) {
 * System.out.println("El arreglo no ha sido generado aún...");
 * continue;
 * }
 * System.out.print("Se ordena el vector por Shell Sort...");
 * t1 = System.currentTimeMillis();
 * v.shellSort();
 * t2 = System.currentTimeMillis();
 * tf = t2 - t1;
 * System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
 * break;
 * <p>
 * case 7:
 * if(v == null) {
 * System.out.println("El arreglo no ha sido generado aún...");
 * continue;
 * }
 * System.out.print("Se ordena el vector por Merge Sort...");
 * t1 = System.currentTimeMillis();
 * v.mergeSort();
 * t2 = System.currentTimeMillis();
 * tf = t2 - t1;
 * System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
 * break;
 * <p>
 * case 8:
 * if(v == null) {
 * System.out.println("El arreglo no ha sido generado aún...");
 * continue;
 * }
 * System.out.println("Se verifica si esta ordenado...");
 * if(v.checkOrder()) { System.out.println("Esta ordenado..."); }
 * else { System.out.println ("No esta ordenado..."); }
 * break;
 * <p>
 * case 9: ;
 * }
 * }
 * while (op != 9);
 * }
 */