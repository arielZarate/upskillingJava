package SalaReuniones;

import java.util.*;


public class Main {
    public static void main(String[] args) {

    /*

1. Listado de reuniones, ordenado por horario.
2. Cantidad de reuniones
3. Cantidad total de participantes
4. Todos los datos de la última reunión
5. Cantidad de reuniones a las que asistió Juan Perez

1. Sala de Reuniones (con iterator y generics)
Planteamos la ultima evolución de este ejemplo, implementando los recorridos con iteradores:
Agregar al proyecto Sala de Reuniones la siguiente funcionalidad:
•	Indicar cuántas reuniones requieren catering y cuál es el total de participantes esperado
•	Mostrar horarios de las reuniones a las cuales asistirá una persona cuyo nombre y apellido se ingresan por teclado

     */


        Calendar h1 = Calendar.getInstance();
        h1.set(2021, 9, 4, 19, 40, 24);
        Calendar h2 = Calendar.getInstance();
        h2.set(2021, 9, 10, 14, 30, 16);
        Calendar h3 = Calendar.getInstance();
        h3.set(2021, 9, 24, 10, 9, 29);

        //podria haber utilizado la clase Date hora=new Date(); es lo mismo



        /**
         * ArrayList tipo Persona
         */
        ArrayList<Persona> arrayPersona1 = new ArrayList<Persona>();
      //  ArrayList<Persona> arrayPersona2 = new ArrayList<Persona>();
        //ArrayList<Persona> arrayPersona3 = new ArrayList<Persona>();
        // List arrayPersona3 = new ArrayList<Persona>();


        //System.out.println("Agregamos los elementos al ArrayList ");
        arrayPersona1.add(new Persona("Nicolas", "Mora", 32864545));
        arrayPersona1.add(new Persona("Javier", "Milei", 25564487));
        arrayPersona1.add(new Persona("Victoria", "villaruel", 545564564));
        arrayPersona1.add(new Persona("JoseLuis", "espert", 54564456));
        arrayPersona1.add(new Persona("Mauricio inutil ", "Macri", 53564));
        arrayPersona1.add(new Persona("alicia ", "Carrio", 53456));
        arrayPersona1.add(new Persona("Cristina (chora) ", "Fernandez", 545455));
        arrayPersona1.add(new Persona("Leandro ", "Santoro", 564564));


        // System.out.println("\n Eliminamos algun elementos del ArrayList con remove");
       /* arrayPersona1.remove(3);
        arrayPersona1.remove(2);
        arrayPersona2.remove(1);

        */

        //System.out.println("\n Buscar algun elemento como una persona en el array");
        /*System.out.println(arrayPersona2.contains(p1));
        System.out.println("");
       */


        //******************Reunion************************
        /**
         * creamos  la variables de tipo Reunion
         */
        //primera forma de agregar
        // System.out.println("Agregamos una lista de personas(ArrayList a la reunion)");
       // Reunion r1 = new Reunion(h1, arrayPersona1);

        /**
         * creamos el array de tipo List de reunion
         */
        ArrayList<Reunion> arrayReunion = new ArrayList<Reunion>();

        /**Agregamos las personas a la reunion
         */
       arrayReunion.add(new Reunion(h1, arrayPersona1));
       arrayReunion.add(new Reunion(h2, arrayPersona1));
       arrayReunion.add(new Reunion(h3, arrayPersona1));

        /**
         * ordenarr el array
         */
        // arrayReunion.sort(arrayReunion);





         //********************Sala*****************************************





         //creamos un  array de tipo Sala

        ArrayList<Sala> arraySala = new ArrayList<Sala>();

        /**
         * agregamos elemenetos reunion al array sala
         */

        arraySala.add(new Sala(1, arrayReunion));
        arraySala.add(new Sala(2, arrayReunion));
        arraySala.add(new Sala(3, arrayReunion));
        arraySala.add(new Sala(4, arrayReunion));


        /**
         * 1. Listado de salas
          */
        System.out.println("*********Listado de Salas********** ");
        Iterator<Sala> sala = arraySala.iterator();


        while(sala.hasNext())
        {
        System.out.println(sala.next().toString());
            System.out.println("****Fin de listado de Salas****");

        }






        /**
         * Listado de reuniones,ordenados por horario!!
         */
        System.out.println("");
        System.out.println("**********Listado de Reuniones*********** ");
        Iterator<Reunion>reunion=arrayReunion.iterator();

        while(reunion.hasNext())
        {
            System.out.println(reunion.next().toString());
        }




        /**
         * 2. Cantidad de reuniones
          */
        Iterator<Sala> sala2 = arraySala.iterator();
        int contR=0;
        while(sala2.hasNext())
        {
           contR=contR+ sala2.next().cantidadReuniones();

        }
        System.out.println("Cantidad de reuniones: " +contR);


        /**
         *  3. Cantidad total de participantes
          */
        Iterator<Reunion> reunion2 = arrayReunion.iterator();
        int contP=0;
        while(reunion2.hasNext())
        {
            contP+=reunion2.next().cantidadParticipantes();
        }
        System.out.println("");
        System.out.println("Cantidad de participantes: " + contP);



        /**
         4  . Todos los datos de la última reunión
         */
        System.out.println("");
       System.out.println("Datos de la Ultima Reunion: " + arraySala.listIterator().next().DatosUltimaReunion());

        // 5. Cantidad de reuniones a las que asistió Juan Perez






    }


}



