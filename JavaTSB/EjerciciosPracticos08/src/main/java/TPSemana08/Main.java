package TPSemana08;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        long t1, t2, tf;
        int op;

        Scanner sc = new Scanner(System.in);
    	Vector v = null;
    	do
    	{
    	    System.out.println ("\nOpciones de Ordenamiento");
    	    System.out.println ("0. Generar el Arreglo");
    	    System.out.println ("1. Intercambio Directo (Burbuja)");
    	    System.out.println ("2. Seleccion Directa");
    	    System.out.println ("3. Insercion Directa");
    	    System.out.println ("4. Quick Sort");
    	    System.out.println ("5. Heap Sort");
    	    System.out.println ("6. Shell Sort");
    	    System.out.println ("7. Merge Sort");
    	    System.out.println ("8. Verificar si esta ordenado");
    	    System.out.println ("9. Salir");
    	    System.out.print ("Ingrese opcion: ");
    	    op = sc.nextInt();
    	    switch (op)
    	    {
				case 0:
					  System.out.print ("Ingrese cantidad del elementos del vector: ");
					  int n = sc.nextInt();
					  v = new Vector(n);
					  System.out.print("Se vuelve a generar el vector...");
					  v.generate();
					  System.out.print("\nVector generado...");
					  break;

				case 1:
					  if(v == null) {
						  System.out.println("El arreglo no ha sido generado aún...");
						  continue;
					  }
					  System.out.print("Se ordena el vector por Intercambio...");
					  t1 = System.currentTimeMillis();
					  v.bubbleSort();
					  t2 = System.currentTimeMillis();
					  tf = t2 - t1;
					  System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
					  break;

				case 2:
					  if(v == null) {
						  System.out.println("El arreglo no ha sido generado aún...");
						  continue;
					  }
					  System.out.print("Se ordena el vector por Seleccion...");
					  t1 = System.currentTimeMillis();
					  v.selectionSort();
					  t2 = System.currentTimeMillis();
					  tf = t2 - t1;
					  System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
					  break;

				case 3:
					  if(v == null) {
						  System.out.println("El arreglo no ha sido generado aún...");
						  continue;
					  }
					  System.out.print("Se ordena el vector por Insercion... ");
					  t1 = System.currentTimeMillis();
					  v.insertionSort();
					  t2 = System.currentTimeMillis();
					  tf = t2 - t1;
					  System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
					  break;

				case 4:
					  if(v == null) {
					  	  System.out.println("El arreglo no ha sido generado aún...");
						  continue;
					  }
					  System.out.print("Se ordena el vector por Quick Sort...");
					  t1 = System.currentTimeMillis();
					  v.quickSort();
					  t2 = System.currentTimeMillis();
					  tf = t2 - t1;
					  System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
					  break;

				case 5:
					  if(v == null) {
						  System.out.println("El arreglo no ha sido generado aún...");
						  continue;
					  }
					  System.out.print("Se ordena el vector por Heap Sort...");
					  t1 = System.currentTimeMillis();
					  v.heapSort();
					  t2 = System.currentTimeMillis();
					  tf = t2 - t1;
					  System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
					  break;

				case 6:
					  if(v == null) {
						  System.out.println("El arreglo no ha sido generado aún...");
						  continue;
					  }
					  System.out.print("Se ordena el vector por Shell Sort...");
					  t1 = System.currentTimeMillis();
					  v.shellSort();
					  t2 = System.currentTimeMillis();
					  tf = t2 - t1;
					  System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
					  break;

				case 7:
					  if(v == null) {
					  	  System.out.println("El arreglo no ha sido generado aún...");
						  continue;
					  }
					  System.out.print("Se ordena el vector por Merge Sort...");
					  t1 = System.currentTimeMillis();
					  v.mergeSort();
					  t2 = System.currentTimeMillis();
					  tf = t2 - t1;
					  System.out.print("\nVector ordenado en: " + tf + " milisegundos...");
					  break;

				case 8:
					  if(v == null) {
						  System.out.println("El arreglo no ha sido generado aún...");
						  continue;
					  }
					  System.out.println("Se verifica si esta ordenado...");
					  if(v.checkOrder()) { System.out.println("Esta ordenado..."); }
					  else { System.out.println ("No esta ordenado..."); }
					  break;

				case 9: ;
    	    }
    	 }
    	 while (op != 9);
        }
}
