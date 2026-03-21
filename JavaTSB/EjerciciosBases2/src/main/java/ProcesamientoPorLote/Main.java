package ProcesamientoPorLote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {


    /*
    Procesamiento básico de lotes
Cargar un conjunto de números desde un archivo de texto (lote1.txt). El archivo contiene en la primera linea la cantidad de números que se presentan a continuación.
Con ese conjunto calcular y mostrar:
•	Promedio
•	Cantidad de mayores que el promedio
•	Mediana
•	Cantidad de negativos
•	Cantidad de apariciones de cada número entre 0 y 9 inclusive

     */

        System.out.println("Lectura de numeros en un archivo de texto...");

        File f = new File("lote.txt");
        try (Scanner sc = new Scanner(f)) {


            //sc.useDelimiter("[- ,;\\n\\r]+");

            System.out.println("suma: " + Suma(f)+"\n");
            System.out.println("Cantidad: " + CantidadDeNumeros(f)+"\n");
            System.out.println("Promedio o media aritmetica es : " + Promedio(f)+"\n");
            System.out.println("Cantidad de mayores que el promedio :" + cantidadMayoresPromedio(f)+"\n");
            System.out.print("La mediana es : "+CalcularMediana(f) +"\n\n" );
            System.out.println("Cantidad de Negativos: "+ CantidadDeNumerosNegativos(f)+"\n");
            System.out.println(CantidadDeAparicionesDeNumerosEntre0_y_9(f)+"\n");



           // System.out.println("Listado \n" );
            //Imprimir(f);
            //ArrayOrdenado(f);
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo...");
        }
    }

    //fin del psvm

    /**
     * ***********METODOS ESTATICOS**********************
     */


    /**Metodo auxiliar sirve como funcion para resolver otros metodos*/
    public static void  ArrayOrdenado(File f) {

        int[] arr =VectorNumeros(f);
       Arrays.sort(arr);

        for (int i : arr) {

            System.out.print(i + " + ");

        }
    }


    /**  Mediana =(n+1)/2  */
    public  static String  CalcularMediana(File f){

        //Scanner sc=new Scanner(System.in);
        int[] numeros =VectorNumeros(f);
        Arrays.sort(numeros);
        // Ordenamos los numeros de menor a mayor
        Arrays.sort(numeros);

        String result;

        if (numeros.length % 2 == 0) {

            //importante notar el -2 porque como el vector arranca en 0 y no en 1
            //la posicion real es la 2 , que seria la 3 si contas desde 1
            int pos = (numeros.length - 2) / 2;
            result = "" + (((numeros[pos] * 1.0) + numeros[pos + 1]) / 2);
        } else {
            int pos = (numeros.length - 1) / 2;
            result = "" + numeros[pos];
        }

        return result;

        }




    /**Cantidad de numerosMayoresAlPromedio*/
    public static int cantidadMayoresPromedio(File f) {
        int cant=0;

        float promedio= Promedio(f);
        try (Scanner sc = new Scanner(f)) {
            sc.useDelimiter("[ ,;\\n\\r]+");
            while (sc.hasNextInt()) {

                int x = sc.nextInt();
                if(x>promedio)
                {
                    cant++;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo...");
        }
        return cant;
    }

    /**metodo auxiliar*/
    public static Float Suma(File f)
    {
        float sum = 0;

        try (Scanner sc = new Scanner(f)) {
            sc.useDelimiter("[ ,;\\n\\r]+");
        //no olvidar que el lote tiene numeros negativos tambien

            while (sc.hasNextInt()) {
                int x = sc.nextInt();
                sum =sum+ x;

            }

        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo...");
        }

        return sum;
    }

    /**metodo auxiliar*/
    public static int CantidadDeNumeros(File f)
    {

        int cont = 0;

        try (Scanner sc = new Scanner(f)) {
            sc.useDelimiter("[ ,;\\n\\r]+");

            while (sc.hasNextInt()) {
                int x = sc.nextInt();

                cont++;

            }

        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo...");
        }
        catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return cont;
    }

    /**
     * Promedio
     */
    public static Float Promedio(File f)
    {
        float promedio = 0;
        try{
            promedio=Suma(f)/CantidadDeNumeros(f);
    }catch(Exception e)
        {
            e.getMessage();
        }

        return promedio;
    }


    /**
     * Cantidad de Numeros negativos
     * @return
     */
    public static int CantidadDeNumerosNegativos(File f)
    {

        int cont = 0;

        try (Scanner sc = new Scanner(f)) {
            sc.useDelimiter("[ ,;\\n\\r]+");

            while (sc.hasNextInt()) {
                int x = sc.nextInt();
                    if(x < 0)
                    {
                        cont++;
                    }

            }

        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo...");
        }

        return cont;
    }




    /**
     *
     Cantiudad de Apariciones de numeros enteros entre 0 y 9
     */
    public static String CantidadDeAparicionesDeNumerosEntre0_y_9(File f)
    {
        //array de contadores , donde cada indice tiene la cantidad total
        // de cada contador
       int []contador=new int [10];

       String Salida="Cantidad de Aparciones de Numeros entre 0 y 9 \n";
        try (Scanner sc = new Scanner(f)) {
            sc.useDelimiter("[ ,;\\n\\r]+");

            while (sc.hasNextInt()) {
                int x = sc.nextInt();
                if (x >= 0 && x <= 9) {

                    for (int i = 0; i < contador.length; i++) {

                        if (x == 0 & i == x) {
                            contador[i] = i + 1;
                            break;
                        }

                        if (x == 1 & i == x) {
                            contador[i] = i + 1;

                        }
                        if (x == 2 & i == x) {
                            contador[i] = i + 1;

                        }
                        if (x == 3 & i == x) {
                            contador[i] = i + 1;

                        }
                        if (x == 4 & i == x) {
                            contador[i] = i + 1;

                        }
                        if (x == 5 & i == x) {
                            contador[i] = i + 1;
                        }
                        if (x == 6 & i == x) {
                            contador[i] = i + 1;

                        }
                        if (x == 7 & i == x) {
                            contador[i] = i + 1;

                        }
                        if (x == 8 & i == x) {
                            contador[i] = i + 1;

                        }
                        if (x == 9 & i == x) {
                            contador[i] = i + 1;

                        }
                    }
                }
            }
            for (int i = 0; i < contador.length; i++) {

                       Salida+="hay " + contador[i] + " Numeros iguales a  " + i+"\n" ;
                    }
        }
        catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo...");
        }
        return Salida;
    }

    /**
     * Listado de Numeros
     */
    public static int[] VectorNumeros(File a)
    {
                        //cantidadDeNumeros es el tamaño
            int [] array=new int [CantidadDeNumeros(a)];
        int num = 0;

        try (Scanner sc = new Scanner(a)) {
            sc.useDelimiter("[ ,; \\n\\r]+");

            int i=0;
            while (sc.hasNextInt()) {
                array[i]=sc.nextInt();
                i++;

            }

        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo...");
        }

        return array;
    }

    public static void Imprimir(File f)
    {
        //cantidadDeNumeros es el tamaño
       int []array=VectorNumeros(f);

        try  {

            for (int i = 0; i < array.length ; i++) {

                System.out.println(array[i]);
            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }

    }




}
