package soporte;

import java.io.*;

public class TextFile {

    private File f;



    public TextFile(String path)
    {
        f=new File(path);
    }



    public void LeerArchivo() {

        System.out.println("Leyendo el archivo : " + f);
        try {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        long lineas = 0;
        long inicio = System.currentTimeMillis();

        String linea;


            while ((linea = br.readLine()) != null) {
                // String []datos=linea.replace("\"", ",").split(",");
                String[] datos = linea.split(",");

                System.out.println(linea);

                lineas++;
                if (lineas % 10000000 == 0) {
                   // System.out.println(lineas + datos[2]);
                }
            }

            br.close();
            fr.close();

            long fin = System.currentTimeMillis();
            float time = (fin - inicio) / 1000.0f;

            System.out.println("Tiempo ocupado: " + time);
        }catch (FileNotFoundException e)
        {
            System.out.println("No se pudo leer el archivo");

        } catch (IOException e) {
            System.out.println("Error en el dispositivo de lectura .. Error IO.Exception");
            System.out.println("Salida");
            e.printStackTrace();
        }



    }




}
