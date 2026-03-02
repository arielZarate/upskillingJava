package homework.Ejercicio1;


import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", "25", "programar"));
        personas.add(new Persona("Alan", "22", "programar"));
        personas.add(new Persona("María", "30", "leer"));
        personas.add(new Persona("Pedro", "17", "patinar"));
        personas.add(new Persona("Ana", "22", "trekking"));
        personas.add(new Persona("Luis", "19", "deporte"));
        personas.add(new Persona("Ariel", "28", "nadar"));
        personas.add(new Persona("Sofia", "35", "pescar"));
        personas.add(new Persona("Natalia", "26", "bicicleta"));
        personas.add(new Persona("Martin", "39", "ajedrez"));


        //- a)  Filtrar las personas que sean mayores de 18 años y
        // cuyos hobbies incluyan la palabra "programar". Utiliza la operación filter para realizar este filtrado.

        System.out.println("Personas mayores de 18 años y cuyo hobby incluye 'programar':");
       personas.stream()
               .filter( p->Integer.parseInt(p.getEdad()) > 18 && p.getHobby().contains("programar"))
               .forEach(System.out::println);


       //b) Obtener una lista con los nombres de todas las personas. Utiliza la operación map para mapear cada objeto Persona a su nombre.

        System.out.println("\nNombres de todas las personas:");
        List<String> nombres = personas.stream()
                .map(p-> p.getNombre())
                .toList();
        nombres.forEach(System.out::println);



        //- c) Limitar la lista de personas a un máximo de 3 personas. Utiliza la operación limit para establecer este límite.

        System.out.println("\nLista limitada a un máximo de 3 personas:");
        personas.stream()
                .limit(3)
                .forEach(System.out::println);


        //d) Imprimir los nombres de todas las personas en la lista utilizando la operación forEach.

        System.out.println("\nNombres de todas las personas:");
        personas.stream()
                .map(Persona::getNombre)
                .forEach(System.out::println);

    }
}
