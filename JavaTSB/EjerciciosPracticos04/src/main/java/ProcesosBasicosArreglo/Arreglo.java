package ProcesosBasicosArreglo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Arreglo implements Comparable {

    private ArrayList<Double> arreglo = new ArrayList<Double>();

    public void Arreglo() {

    }

    /**
     * Metodos Set &Get
     *
     * @param i
     * @return
     */
    public List getArreglo(int i) {
        return arreglo;
    }

    public void setArreglo(ArrayList arr) {
        this.arreglo = arr;
    }


    /***
     * Metodo para inicializar el Arreglo de tipo ArrayList
     * @param f
     */
    public void InicializarVector(File f) {

        try {
            Scanner sc = new Scanner(f);
            sc.useDelimiter("[ ,; \\n\\r]+");
            int i = 0;
            while (sc.hasNextInt()) {
                Double x = sc.nextDouble();
                arreglo.add(i, x);
                i++;

            }


        } catch (FileNotFoundException ex) {
            System.out.println("Error de lectura de Archivo.. + " + ex.getMessage());
        }

    }

    /**
     * Primer Numero Primo
     *
     * @return
     */






    public double PrimerNumeroPrimo()
    {

        double val=0.0;

            for (int i = 0; i < arreglo.size(); i++) {

              /*
                if(arreglo== null || arreglo.size()==0)
                {
                    System.out.println("El vector esta vacio: " + arreglo.size());
                }
               */
                if(esPrimo(arreglo.get(i)))
                {
                    val=arreglo.get(i);
                    //System.out.println("El primer nº primo es el numero " + arreglo.get(i));
                    break;

                }

                else{
                    //System.out.println("El numero " + vector[i] + " no es primo" );
                    val=-1.0;
                }


            }


        return val;
    }
    /*
        public void esPrimoVector(double [] vector){

        try {
            for (int i = 0; i < vector.length; i++) {

                if(vector== null || vector.length==0)
                {
                    System.out.println("El vector esta  vacio");
                }
                if(esPrimo(vector[i]))
                {
                    System.out.println("Es primo el numero " + vector[i]);

                }
                else{
                    System.out.println("El numero " + vector[i] + " no es primo" );
                }

            }
        } catch (InputMismatchException ex ) {
            System.out.println("Error:" + ex.getMessage());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    /**
     * @param
     * @return esPrimo funcion auxiliar
     */
    public boolean esPrimo(double numero) {
        boolean esPrimo = false;

        // El 0, 1 y 4 no son primos
        if (numero == 0 || numero == 1 || numero == 4 || numero < 0) {

            return false;
        }
        for (int x = 2; x < numero / 2; x++) {

            if ((numero % x) == 0)
                return  false;

        }
        // Si no se pudo dividir por ninguno de los de arriba, sí es primo


        return true;


    }




    
    /*
    private static double calcularMediana(){
        double mediana;
        if(numElementos % 2 == 0){
            int sumaMedios = numeros[numElementos/2] + numeros[numElementos/2 - 1];
            mediana = (double)sumaMedios / 2;
        } else {
            mediana = numeros[numElementos/2];
        }
        return mediana;
    }



    opcion2


    if (numeros.length % 2 == 0) {
      int pos = (numeros.length - 2) / 2;
      result = "" + (((numeros[pos] * 1.0) + numeros[pos + 1]) / 2);
    } else {
      int pos = (numeros.length - 1) / 2;
      result = "" + numeros[pos];
    }

    return result;
     */

    /**
     * Calculo de la mediana
     */
    public String CalcularMediana() {
        // Arrays.sort(arreglo.toArray());
        // Ordenamos los numeros de menor a mayor

        String result;
        System.out.println("Array Ordenado");
        Collections.sort(arreglo);
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.println(arreglo.get(i) + " posicion: " + (i + 1));
        }

        if (arreglo.size() % 2 == 0) {
            int pos = (arreglo.size() - 1) / 2;
            //(((arreglo.get(pos) * 1.0) + arreglo.get( pos + 1) / 2))
            result = (((arreglo.get(pos) * 1.0) + arreglo.get(pos + 1)) / 2) + "(par) en la posicion: " + (pos + 1.5);
        } else {
            int pos = (arreglo.size() + 1) / 2;
            result = "" + arreglo.get(pos) + "  (impar) en la posicion " + (pos);
        }

        return result;

    }

    /**
     * Devuelve un listado de elementos del vector con un Stringbuffer o stringbuilder
     *
     * @return
     */
    public String toString() {

        StringBuilder sbuffer = new StringBuilder();
        for (Object v : arreglo) {
            sbuffer.append((double) v);

        }
        return sbuffer.toString();
    }


    public Double SumaNumerosArreglo() {

        Double suma = 0.0;
        for (int i = 0; i < arreglo.size(); i++) {
            suma += arreglo.get(i);
        }
        return suma;
    }

    /**
     * Promedio
     *
     * @return
     */
    public Double PromedioArreglo() {
        return SumaNumerosArreglo() / CantidadNumeros();
    }

    public Integer CantidadNumeros() {
        return arreglo.size();
    }


    public String NumeroMayorArreglo() {

        String res = " ";
        int pos = 0;
        Double mayor = 0.0;
        // Recorrer arreglo y ver si no es así
        // (comenzar desde el 1 porque el 0 ya lo tenemos contemplado arriba)
        for (int x = 0; x < arreglo.size(); x++) {
            if (arreglo.get(x) > mayor) {
                mayor = arreglo.get(x);
                pos = x + 1;
            }
        }

        res = "El numero mayor es el " + mayor + ", en la posicion:" + pos;
        return res;
    }


    public String BuscarGrupoDeNumeros(ArrayList grupo) {
        String res = "[";
        for (int i = 0; i < arreglo.size(); i++) {

            for (int g = 0; g < grupo.size(); g++) {

                if (arreglo.get(i).compareTo((Double) grupo.get(g)) == 0) {
                    res += arreglo.get(i).toString() + " - ";
                }
            }
        }
        res += "]";


        return res;

    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}