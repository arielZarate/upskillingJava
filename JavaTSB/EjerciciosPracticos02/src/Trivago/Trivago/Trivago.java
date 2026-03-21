package Trivago;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Trivago {

    String [] hotelesAleatorios ;
    String [] onlyNames;
    int [] onlyNumber;


    String[] nombres = {"Paris Hotel ", "Indian Flat", "Sheraton garden", "Sheraton Prime", "Johanson Usa", "Prince Royal", "Hotel Habanas3", "Hotel de Sydney 5", "Balduino",
            "Erdwin", "Harrinson Ford", "Barry", "Dinam Hotel"};
    int[] precio = {1250, 3000, 2500, 4500, 6000, 8000, 2600};



    public String [] generarHotelesAleatorios(int cantidad) {
        hotelesAleatorios = new String[cantidad];
        onlyNames=new String[cantidad];
        onlyNumber= new int [cantidad];

       // int cantidad = 0;
        for (int i = 0; i < cantidad; i++) {
            onlyNames[i]= nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))];
            onlyNumber[i]=precio[(int) (Math.floor(Math.random() * ((precio.length - 1) - 0 + 1) + 0))];
            //tengo separado el vector de solo nombres y precio para luego usarlo en la busqueda de otros varios
          //  hotelesAleatorios.add(onlyNames + onlyNumber.toString());//+ "****** "
            hotelesAleatorios[i]=onlyNames[i]+ "*********" + onlyNumber[i];

        }
        return hotelesAleatorios;
    }

    public String [] getHotelesAleatorios() {
        return hotelesAleatorios;
    }


    public void setHotelesAleatorios(String []hotelesAleatorios) {
        this.hotelesAleatorios = hotelesAleatorios;
    }

    public String[] getNombres() {
        return nombres;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public int[] getPrecio() {
        return precio;
    }

    public void setPrecio(int[] precio) {
        this.precio = precio;
    }


    public void Mostrarciudades() {

        System.out.println("-------------------------\nSeleccionar Ciudad ");
        System.out.println(" " +
                "-Paris\n " +
                "-Londres\n " +
                "-New York\n " +
                "-Roma\n " +
                "-Tokio\n " +
                "-Buenos Aires\n " +
                "-Stambull ");

        //System.out.println("\n0. Salir");
        //System.out.print("Ingrese su opcion: ");
    }


    //     • Mostrar los resultados de la búsqueda (arreglo)
    public String BuscarNombreHotel (String name)
    {
        String rtdo = "";

        String[] vectorAux = this.QuitarEspaciodeVectorNombres();

        //2 lo recorro y comparo
        for (int i = 0; i < vectorAux.length; i++) {
            if (vectorAux[i].equals(name)) {
                rtdo = "****Hotel encontrado******";
                break;
            } else rtdo = "Hotel con nombre " + name + " NO encontrado";
        }
        return rtdo;
    }


    public String[] QuitarEspaciodeVectorNombres ()
    {
        String[] aux = new String[onlyNames.length];
        for (int i = 0; i < onlyNames.length; i++) {
            for (int j = 0; j < aux.length; j++) {
        // onlyNames[i].replaceAll(" ", "");
                aux[i] =onlyNames[i].replaceAll(" ", "");

            }
        }
        return aux;
    }


    // • Informar el precio promedio para cada sitio ,lo hice en forma general ya que desetime por sitio
    public int PrecioPromedio () {

        int suma = 0;
        int cant = 0;
        int [] aux=new int[onlyNumber.length] ;
        for (int i = 0; i < onlyNumber.length; i++) {

            for (int j = 0; j < aux.length; j++) {
                suma+=onlyNumber[i];
                cant++;
            }
        }
        return suma / cant;
    }

    //• Generar un nuevo listado conteniendo, para cada hotel, el mejor precio de los 3 sitios
    public float MejorPrecioPorHotel (String name) {


        int mayor=999999999;
        int menor=0;
        String[] vectorAux = this.QuitarEspaciodeVectorNombres();


       // System.out.println("se ha ingresado " + name);
        //2 lo recorro y comparo
        for (int i = 0; i < vectorAux.length; i++) {
            if (vectorAux[i].equals(name)) {
               // for (int n = 0; n < onlyNumber.length ; n++) {
                    if(onlyNumber[i]<mayor)
                    {
                       menor=onlyNumber[i];
                       mayor=onlyNumber[i]+1;

                    }

              //  }

            }
        }
        return menor;
    }

    public void Imprimir (String [] vector){
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }




}
