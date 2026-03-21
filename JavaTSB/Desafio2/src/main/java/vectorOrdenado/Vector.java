package vectorOrdenado;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Representa un arreglo de elementos int, y plantea diversos metodos de
 * ordenamiento implementados en forma directa.
 *
 * @author Ing. Valerio Frittelli.
 * @version 2.0 [Agosto de 2018].
 */
public class Vector implements Comparable {
    private long[] v;


    public Vector(int tam) {

        v = new long[tam];
    }


    public void InicializarVector(File f) {

        try {
            Scanner sc = new Scanner(f);
            sc.useDelimiter("[ ,; \\n\\r]+");
            int i = 0;
            while (sc.hasNextInt()) {
                Long x = sc.nextLong();
                v[i] = x;
                i++;

            }


        } catch (FileNotFoundException ex) {
            System.out.println("Error de lectura de Archivo.. + " + ex.getMessage());
        }

    }


    public void set(int i, int x) {
        v[i] = x;
    }


    //metodo generate automatico
    public void generate() {
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) Math.round(100 * Math.random());
        }
    }


    /***
     * metodos
     * @return
     */

    public boolean checkOrder() {
        for (int i = 0; i < v.length - 1; i++) {
            if (v[i] > v[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public long size() {
        return v.length;
    }

    public void OrdenarVector() {
        Arrays.sort(v);
    }


    public void contarInversionesVoid() {
        int cont = 0;
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (v[i] > v[j]) {
                    cont++;
                }
            }
        }
        System.out.println("cantidad de pares: " + cont);

    }


    public long contarInversiones() {
        long count = 0;
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (v[i] > v[j]) count++;
            }
        }
        return count;
    }


    public long contar() {
        int n = v.length;
        long c = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (v[i] > v[j]) {
                    c++;
                    long aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
        return c;
    }

    public void maxSumSubsequence1() {
        long suma = 0;
        int n = v.length;
        int i, j, k;
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                long sumaParcial = 0;
                for (k = i; k <= j; k++) {
                    sumaParcial = sumaParcial + v[k];
                }
                if (sumaParcial > suma) {
                    suma = sumaParcial;
                }
            }
        }
        System.out.print("\nla suma es: " + suma);
    }

    public void maxSumSubsequence2() {
        long suma = 0;
        int n = v.length;
        int i, j;
        long sumaParcial;
        for (i = 0; i < n; i++) {
            sumaParcial = 0;
            for (j = i; j < n; j++) {
                sumaParcial = (sumaParcial + v[j]);
                if (sumaParcial > suma) {
                    suma = sumaParcial;
                }
            }
        }
        System.out.print("\nla suma es: " + suma);
    }

    public void maxSumSubsequence3() {
        long suma = 0;
        int n = v.length;
        long sumaParcial = 0;
        for (int j = 0; j < n; j++) {
            sumaParcial = sumaParcial + v[j];
            if (sumaParcial > suma) {
                suma = sumaParcial;
            } else if (sumaParcial < 0) {
                sumaParcial = 0;
            }
        }
        System.out.print("\nla suma es: " + suma);
    }


    public String toString() {

        StringBuilder sbuffer = new StringBuilder();
        sbuffer.append("[");
        for (double ar : v) {
            sbuffer.append(ar);

        }
        sbuffer.append("]\n");
        return sbuffer.toString();
    }


    /**
     * Funciones
     */


    public double funcion_a(double n) {
       // double pow = Math.pow(2,n);
        n = n * funcion_c(n);


        return n;
    }

    public double funcion_b(double n) {
        //f(n) = n * log(n)
        /**
         * lo calculo con el log en base 10 , aclaro por las dudas , si decea en base 2 modificarlo
         *  Math.log(n);
         *
         */
        double log = Math.log10(n);
        n=n*log;

        return n;
    }

    public double funcion_c(double n)
    {
        //f(n) = 2n

        return Math.pow(2,n);
    }

    public double funcion_d(double n)
    {
        //f(n) = log2(n) * n3
        double log=Math.log(n);
        double pot=Math.pow(n,3);
        double res=log*pot;

        return res;
    }


    public double funcion_e(double n)
    {
        // f(n) = n2 * 2n
        double pot=Math.pow(n,2);
        return pot * funcion_c(n);
    }


    /*


    public void bubbleSort()
    {
        boolean ordenado = false;
        int n = v.length;
        for(int i=0; i<n-1 && !ordenado; i++)
        {
            ordenado = true;
            for(int j=0; j<n-i-1; j++)
            {
                if(v[j] > v[j+1])
                {
                    long aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                    ordenado = false;
                }
            }
        }
    }



    public void selectionSort()
    {

        for(int i=0; i< v.length-1; i++)
        {
            for(int j=i+1; j< v.length; j++)
            {
                if(v[i] > v[j])
                {
                    long aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
    }

    public int linearSearch(double x)
    {
        for(int i=0; i<v.length; i++)
        {
            if(x == v[i]) return i;
        }
        return -1;
    }

    public int binarySearch(int x)
    {
        int n = v.length;
        int izq = 0, der = n-1;
        while(izq <= der)
        {
            int c = (izq + der)/2;
            if(x == v[c]) return c;

            if(x < v[c]) der = c - 1;
            else izq = c + 1;
        }
        return -1;
    }



    public void insertionSort()
    {
          int n = v.length;
          for(int j=1; j<n; j++)
          {
                int k, y = v[j];
                for(k=j-1; k>=0 && y<v[k]; k--)
                {
                    v[k+1]= v[k];
                }
                v[k+1]= y;
          }
    }

    public void quickSort()
    {
          quick(0, v.length-1);
    }

    private void quick(int izq, int der)
    {
          int i = izq, j = der, y;
          int x = v[(izq + der) / 2];
          do 
          {
                while(v[i]<x && i<der) { i++; }
                while(x<v[j] && j>izq) { j--; }
                if(i <= j)
                {
                      y = v[i];
                      v[i] = v[j];
                      v[j] = y;
                      i++;
                      j--;
                }
          }
          while(i <= j);
          if(izq < j) { quick( izq, j ); }
          if(i < der) { quick( i, der ); }
    }        
    
    public void heapSort()
    {
           int n = v.length;

           // crear el grupo inicial...
           for(int i=1; i<n; i++)
           {
                int e = v[i];
                int s = i;
                int f = (s-1)/2;
                while(s>0 && v[f] < e)
                {
                      v[s] = v[f];
                      s = f;
                      f = (s-1)/2;
                }
                v[s] = e;
           }

           // se extrae la raiz, y se reordena el vector y el grupo...
           for(int i = n-1; i>0; i-- )
           {
                int valori = v[i];
                v[i] = v[0];
                int f = 0, s;
                if(i==1) { s = -1; } else { s = 1; }
                if(i>2 && v[2]>v[1])  { s = 2; }
                while(s>=0 && valori<v[s])
                {
                      v[f] = v[s];
                      f = s;
                      s = 2*f + 1;
                      if(s+1<=i-1 && v[s]<v[s+1]) { s++; }
                      if(s>i-1) { s = -1; }
                }
                v[f] = valori;
           }
    }

    public void shellSort()
    {
        int h, n = v.length;
        for(h = 1; h <= n / 9; h = 3*h + 1);
        for (; h > 0; h /= 3)
        {
              for (int j = h; j < n; j++)
              {
                   int k, y = v[j];
                   for(k = j - h; k >= 0 && y < v[k]; k-=h)
                   {
                         v[k+h] = v[k];
                   }
                   v[k+h] = y;
              }
        }
    }
    
    public void mergeSort()
    {
        int n = v.length;
        int temp[] = new int[n];
        sort(0, n-1, temp);
    }

    private void sort(int izq, int der, int temp[])
    {
        if(izq < der) 
        {
            int centro = (izq + der) / 2;
            sort(izq, centro, temp);
            sort(centro + 1, der, temp);
            merge(izq, centro, der, temp);
        }    
    }       

    private void merge(int izq, int centro, int der, int temp[])
    {
        for(int i = izq; i <= der; i++) { temp[i] = v[i]; }

        int i = izq, j = centro + 1, k = izq;
        while(i <= centro && j <= der) 
        {
           if(temp[i] <= temp[j]) 
           {
             v[k] = temp[i];
             i++;
           } 
           else 
           {
             v[k] = temp[j];
             j++;
           }
           k++;
        }

        while(i <= centro) 
        {
           v[k] = temp[i];
           k++;
           i++;
        }
    }
*/


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
