package POO.Matrices;

import java.util.Scanner;


/**
 * 👉 Columnas de la PRIMERA = Filas de la SEGUNDA
 * <p>
 * Esa es la única condición.
 * <p>
 * Después, el resultado siempre es:  (m×n)⋅(n×p)=(m×p)
 * <p>
 * donde:
 * <p>
 * m = filas de la primera
 * <p>
 * n = columnas de la primera (y también filas de la segunda)
 * <p>
 * p = columnas de la segunda
 * <p>
 * Ejemplo simple
 * <p>
 * Matriz A:2×3
 * <p>
 * Matriz B:3×4
 * <p>
 * <p>
 * 👉 Se puede multiplicar, porque 3 (columnas de la primera) = 3 (filas de la segunda).
 * 👉 El resultado es 2×4
 */
public class MultiplicacionMatrices {

    private int[][] ma_1, ma_2, ma_res;
    private int f1, c1, f2, c2;
    Scanner scan = new Scanner(System.in);


    public void inicializarMatrices() {

        do {
            System.out.println("===========Sistema de carga de matrices============\n");
            System.out.println("======Primera Matriz==========");
            System.out.println("Ingrese el Nº Filas de la 1 matriz");
            f1 = scan.nextInt();
            System.out.println("Ingrese el Nº de columnas de la 1 matriz");
            c1 = scan.nextInt();
            System.out.println("\n====== Segunda matriz======= ");
            System.out.println("Ingrese el Nº Filas de la 1 matriz");
            f2 = scan.nextInt();
            System.out.println("Ingrese el Nº de columnas de la 1 matriz");
            c2 = scan.nextInt();

            if (c1 != f2) {
                System.out.println("Ha ingresado incorrectamente, El numero de columnas de la 1 matriz deben ser igual al numero de filas de la 2 matriz  ");
            }

        } while (c1 != f2);

        ma_1 = new int[f1][c1];
        ma_2 = new int[f2][c2];
        ma_res = new int[f1][c2];

        System.out.println("Se ha cargado la matriz correctamente");

    }

    public void cargarMatrices() {
        System.out.println("\nCargar valores para la primera matriz:");
        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.print("Valor en [" + i + "][" + j + "]: ");
                ma_1[i][j] = scan.nextInt();
            }
        }

        System.out.println("\nCargar valores para la segunda matriz:");
        for (int i = 0; i < f2; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print("Valor en [" + i + "][" + j + "]: ");
                ma_2[i][j] = scan.nextInt();
            }
        }

    }


    public void mostrarMa1() {
        for (int i = 0; i < ma_1.length; i++) {
            for (int j = 0; j < ma_1[0].length; j++) {  //al recorrer en mat_1[0].length tengo que si la fila[0] tiene 3 columnas , recorrera 3 lugares
                System.out.print(ma_1[i][j] + "\t");
            }
            System.out.println(" ");
        }
    }

    public void mostrarMa2() {
        for (int i = 0; i < ma_2.length; i++) {
            for (int j = 0; j < ma_2[0].length; j++) {  //al recorrer en mat_2[0].length tengo que si la fila[0] tiene 3 columnas , recorrera 3 lugares
                System.out.print(ma_2[i][j] + "\t");
            }
            System.out.println(" ");
        }
    }

    public void multiplicarMatrices() {
        int aux;
        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c2; j++) {

                for (int k = 0; k < c1; k++) {
                     ma_res[i][j]= ma_1[i][k] * ma_2[k][j];
                }
            }
        }
    }

  public void multiplicarMatricesConDetalles() {
        int aux;
        for (int i = 0; i < f1; i++) {
            System.out.println("se ejecuta el 1 for con i="+i);
            for (int j = 0; j < c2; j++) {
                System.out.println("se ejecuta el 2 for con j="+j);
                for (int k = 0; k < c1; k++) {
                    System.out.println("se ejecuta el 3 for con k="+k+"\n");
                    System.out.println("vamos a multiplicar la ma_1["+i+"]["+k+"]="+ma_1[i][k]+" * "+ "la ma_2["+k+"]["+j+"]="+ma_2[k][j]);
                     aux= ma_1[i][k] * ma_2[k][j];
                    System.out.println("El resultado de la multiplicacion dio "+ aux);
                    System.out.println("ahora sumamos eso a lo que teniamos antes en la misma posicion de la ma_res[i][j]="+ma_res[i][j]);
                    ma_res[i][j] +=aux;
                    System.out.println("El nuevo valor es ahora de ma_res[i][j]"+ma_res[i][j]);
                }
            }
        }
    }


    public void mostrarMatrizResultante() {
        for (int i = 0; i < ma_res.length; i++) {
            for (int j = 0; j < ma_res[0].length; j++) {
                System.out.print("[" + ma_res[i][j] + "]\t");
            }
            System.out.println(" ");
        }

    }

}
