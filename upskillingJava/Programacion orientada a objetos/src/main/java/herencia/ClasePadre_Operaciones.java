package POO.herencia;


import java.util.Scanner;

/****
 * Herencia
 */

public class ClasePadre_Operaciones{

Scanner scanner = new Scanner(System.in);
protected int valor1, valor2, result;


public void PedirDatos(){
    System.out.print("Dame el primer valor :");
    valor1 = scanner.nextInt();


    System.out.print("Dame el segundo valor :");
    valor2 = scanner.nextInt();
}

//este metodo muestra el resultado
  public void MostrarResultados(){
    System.out.println(result);
}

}
