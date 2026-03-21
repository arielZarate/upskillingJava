package clases;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Una clase de prueba mostrar el uso de objetos Scanner para leer archivos de
 * texto.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Agosto de 2017.
 */
public class Test 
{
    @Override
    public String toString() {
        return "Test{}";
    }

    public static void main(String args[])
    {
        System.out.println("Lectura de numeros en un archivo de texto...");

        File f = new File("numeros.txt");
        try (Scanner sc = new Scanner(f)) 
        {
            while (sc.hasNextInt())
            {
                int num = sc.nextInt();
                System.out.println(num);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("No existe el archivo...");
        }


    } 
}
