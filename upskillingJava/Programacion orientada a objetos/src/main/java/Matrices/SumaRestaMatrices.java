package POO.Matrices;

import java.util.Scanner;

public class SumaRestaMatrices {

    private int[][] ma_1 = new int[3][3];
    private int[][] ma_2 = new int[3][3];
    private int[][] ma_res = new int[3][3];

    Scanner scan = new Scanner(System.in);


    public SumaRestaMatrices() {
        cargar_Matriz1();
        cargar_Matriz2();
    }

    public void cargar_Matriz1() {
        System.out.println("vamos a cargar la matriz 1");
        for (int f = 0; f < ma_1.length; f++) {
            for (int c = 0; c < ma_1.length; c++) {
                System.out.println("ingrese el valor para la posicion de la fila " + (f + 1) + ", columna " + (c + 1));
                ma_1[f][c] = scan.nextInt();
            }
        }
    }

    public void cargar_Matriz2() {
        System.out.println("vamos a cargar la matriz 2");
        for (int f = 0; f < ma_2.length; f++) {
            for (int c = 0; c < ma_2.length; c++) {
                System.out.println("ingrese el valor para la posicion de la fila " + (f + 1) + ", columna " + (c + 1));
                ma_2[f][c] = scan.nextInt();
            }
        }
    }

    public void mostrarMatriz1() {
        for (int f = 0; f < ma_1.length; f++) {
            for (int c = 0; c < ma_1.length; c++) {
                System.out.print("[ " + ma_1[f][c] + " ]");
            }
            System.out.println(" ");
        }
    }

    public void mostrarMatriz2() {
        for (int f = 0; f < ma_2.length; f++) {
            for (int c = 0; c < ma_2.length; c++) {
                System.out.print("[ " + ma_2[f][c] + " ]");
            }
            System.out.println(" ");
        }
    }


    public void SumarMatriz() {
        for (int f = 0; f < ma_res.length; f++) {
            for (int c = 0; c < ma_1.length; c++) {
                ma_res[f][c] = ma_1[f][c] + ma_2[f][c];
            }
        }
    }  public void RestarMatriz() {
        for (int f = 0; f < ma_res.length; f++) {
            for (int c = 0; c < ma_1.length; c++) {
                ma_res[f][c] = ma_1[f][c] - ma_2[f][c];
            }
        }
    }

    public void mostrarResultadoMatriz() {
        for (int f = 0; f < ma_res.length; f++) {
            for (int c = 0; c < ma_res.length; c++) {
                System.out.print("[ " + ma_res[f][c] + " ]");
            }
            System.out.println(" ");
        }
    }


}
