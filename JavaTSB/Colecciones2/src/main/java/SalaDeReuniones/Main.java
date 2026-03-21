package SalaDeReuniones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

    /*

1. Listado de reuniones, ordenado por horario.
2. Cantidad de reuniones
3. Cantidad total de participantes
4. Todos los datos de la última reunión
5. Cantidad de reuniones a las que asistió Juan Perez

     */


        Date hora = new Date();

        String horaActual = hora.toString();


        /**
         * creamos los objetos personas
         */
        Persona p1 = new Persona("Nicolas", "Mora");
        Persona p2 = new Persona("Javier", "Milei");
        Persona p3 = new Persona("Victoria", "villaruel");
        Persona p4 = new Persona("JoseLuis", "espert");
        Persona p8 = new Persona("Mauricio inutil ", "Macri");
        Persona p5 = new Persona("alicia ", "Carrio");
        Persona p6 = new Persona("Cristina (chora) ", "Fernandez");
        Persona p7 = new Persona("Leandro ", "Santoro");
        //creo listas de tipo Persona


        /**
         * arrayPersona de tipò List
         */
        List arrayPersona1 = new ArrayList<Persona>();
        List arrayPersona2 = new ArrayList<Persona>();
       // List arrayPersona3 = new ArrayList<Persona>();

        /**
         * ArrayPersonas
         *
         * List arrayPersona2 = new ArrayList<Persona>();
         * List arrayPersona3 = new ArrayList<Persona>();
      4);
         *
         */

       // aca agregamos cada persona a la List
        arrayPersona1.add(p1);
        arrayPersona1.add(p8);

        arrayPersona1.add(p7);
        arrayPersona1.add(p5);
        arrayPersona1.add(p6);
        arrayPersona1.add(p7);
        arrayPersona2.add(p5);
        arrayPersona2.add(p6);
        arrayPersona2.add(p7);
       // arrayPersona3.add(p2);
        //arrayPersona3.add(p3);
        //arrayPersona3.add(p2);






     //******************Reunion************************
        /**
         * creamos  la variables de tipo Reunion
         */
        //primera forma de agregar
        Reunion r1 = new Reunion(hora, arrayPersona1);
       Reunion r2 = new Reunion(hora, arrayPersona2);
       // Reunion r3 = new Reunion(hora, arrayPersona3);

        /**
         * creamos el array de tipo List de reunion
         */
        List arrayReunion = new ArrayList<Reunion>();

        /**Agregamos las personas a la reunion
         */
        arrayReunion.add(r1);
        arrayReunion.add(r2);
       // arrayReunion.add(r3);

        /**
         * array de Reunion
         */
        /*
        for (Object s : arrayReunion) {
            System.out.println(s.toString());
        }
         */


        //********************Sala*****************************************
        /**
         * instanciamos objetos e tipo Sala
         */
        Sala s1 = new Sala(1, arrayReunion);
        Sala s2 = new Sala(2, arrayReunion);
        Sala s3 = new Sala(3, arrayReunion);
        Sala s4 = new Sala(4, arrayReunion);
        //primera forma de mostrar
        //System.out.println(s1.toString());

        /**
         *creamos un  array de tipo Sala
         */

        List arraySala = new ArrayList<Sala>();



        /**
         * agregamos elemenetos reunion al array sala
         */
        arraySala.add(s1);
        arraySala.add(s2);
        arraySala.add(s3);


        /**
         *recorremos con foreach
          */



        /**
         * mostramos por pantalla los resultados
         */

        for (Object s : arraySala) {
            System.out.println(s.toString());
        }
    /*

        1. Listado de reuniones, ordenado por horario.
        2. Cantidad de reuniones
        3. Cantidad total de participantes
        4  . Todos los datos de la última reunión
        5. Cantidad de reuniones a las que asistió Juan Perez

     */

        int n1=s1.cantidadReuniones();
        int n2= s2.cantidadReuniones();
        int sum=n1+n2;
        System.out.println("cantidad de Reuniones es :" + sum );

        int num1=r1.cantidadParticipantes();
        int num2=r2.cantidadParticipantes();
      //  int num3=r3.cantidadParticipantes();

        int suma=num1+num2;
        System.out.println("cantidad de participantes es :" + suma  );


        Scanner sc=new Scanner(System.in);

        System.out.print("ingrese el nombre del participante para buscar: ");
        String nom=sc.nextLine();
             // sc.nextLine();
            int cant1= r1.cantidadReunionesAsistio(nom);
            int cant2= r2.cantidadReunionesAsistio(nom);

           // int sumanombre=cant1+cant2;
        System.out.println("cantidad de reuniones a las que asistio  es :" +  r1.cantidadReunionesAsistio(nom) );

    }


}




