package excepciones.ExcepcionesChecked;




/*

Excepciones verificadas (Checked Exceptions): Subclases de `Exception` que no son subclases
de `RuntimeException`. Deben manejarse explícitamente usando `try-catch` o declararse en la cláusula
`throws` del método
* */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainExcepCheked {
    public static void main(String[] args) {

        try {
            leerArchivo("archivo.txt");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            // Aquí podrías agregar código para manejar la excepción
        }
        catch(Exception e)
        {
            System.out.println("Error: \n" + e.getMessage()  );
        }

    }



    public static void leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }
}
