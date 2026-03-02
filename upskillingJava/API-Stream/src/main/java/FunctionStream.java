import java.util.Arrays;
import java.util.List;

public class FunctionStream {
    public static void main(String[] args) {

        //TODO: List<String> paises= List.of("Brasil", "Argentina", "Chile", "Peru", "Colombia"); //OTRA FORMA DE CREAR UNA LISTA INMUTABLE

        List<String> paises = Arrays.asList("Brasil", "Brasil", "Argentina", "Chile", "Peru", "Colombia", "Uruguay", "Paraguay", "Venezuela", "Ecuador", "Bolivia");

        System.out.println("Imprimir todos los paises que empiezan con A:");
        paises.stream()
                .filter(p -> p.startsWith("A"))
                .forEach(p -> System.out.println("Pais que comienza con A: " + p));


        System.out.println("\n******* Todos los paises que mayor a 6 letras: *******");
        paises.stream()
                .filter(p -> p.length() > 6)
                .forEach(System.out::println);


        System.out.println("\n******* Todos los paises que terminan con a: *******");
        paises.stream()
                .filter(p -> p.endsWith("a"))
                .forEach(System.out::println);


        System.out.println("\n******* usando el uppercase *******");
        paises.stream()
                .filter(p -> p.startsWith("B"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("\n******* usando el uppercase y ordenando alfabeticamente *******");
        paises.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


        System.out.println("\n********* usando el limit ************");

        paises.stream()
                .limit(3)
                .forEach(System.out::println);


        System.out.println("\n********* usando el skip ************");
        paises.stream()
                .skip(3)
                .forEach(System.out::println);


//1️⃣ count() – cuántos cumplen una condición
        long cantidad = paises.stream()
                .filter(p -> p.startsWith("B"))
                .count();

        System.out.println("\n********* usando el count ************");
        System.out.println("Cantidad de paises que empiezan con B: " + cantidad);


        //2️⃣ allMatch() – ¿todos cumplen?
        boolean todosMasDe4 = paises.stream()
                .allMatch(p -> p.length() > 4);

        System.out.println("\n¿Todos tienen más de 4 letras? " + todosMasDe4);


        // 4️⃣ findFirst() – primer elemento que cumple

        paises.stream()
                .filter(p -> p.length() > 7)
                .findFirst()
                .ifPresent(p -> System.out.println("Primer país con más de 7 letras: " + p));


       //5️⃣ sorted(Comparator) – ordenar por longitud
        paises.stream()
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .forEach(System.out::println);




        //7️⃣ distinct() – eliminar duplicados
        System.out.println("\n********* usando el distinct ************");
        paises.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n********* usando operaciones terminales en colleciones************");
        List<String> countries = paises.stream()
                .filter(p -> p.startsWith("B"))
                .toList();


        countries.forEach(System.out::println);


        System.out.println("\n********* usando operaciones terminales AnyMatch************");

        if (paises.stream()
                .anyMatch(p -> p.startsWith("C"))) {
            System.out.println("Existe algun pais que empiece con C? " + true);
        } else {
            System.out.println("Existe algun pais que empiece con C? " + false);
        }


        System.out.println("\n********* usando operaciones terminales Reduce************");
        String resultado = paises.stream()
                .reduce("", (a, b) -> a + " - " + b);

        System.out.println("Concatenado " + resultado);


        System.out.println("\n********* usando operaciones terminales Reduce para sumar letras************");

        int totalLetras = paises.stream()
                .map(String::length)
                .reduce(0, Integer::sum);

        System.out.println("Total de letras: " + totalLetras);

    }

}
