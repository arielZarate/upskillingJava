package POO.polimorfismo;


import java.util.Scanner;

/****
 * Polimorfismo
 */

public abstract class ClasePadre_Operaciones{

Scanner scanner = new Scanner(System.in);
protected int valor1, valor2, result;


public void PedirDatos(){
    System.out.print("Dame el primer valor :");
    valor1 = scanner.nextInt();


    System.out.print("Dame el segundo valor :");
    valor2 = scanner.nextInt();
}

/**
 * este metodo ahora ademas de ser publico es abstracto , solo sirve para definir
 * <p>
 * // ACA ESTA EL POLIMORFISMO
 * //CUANDO SE IMPLEMENTE EL METODO EN CADA CLASE SE REDIFINIRA A
 * Y AUQNUE EL METODO SE LLAMA MOSTRAR RESULTADO SE MOSTRARA DISTNTO
 */

abstract protected void operaciones();

abstract protected void MostrarResultados();   //solo la firma

}
