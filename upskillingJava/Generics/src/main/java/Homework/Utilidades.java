package Homework;


import java.util.List;

/**
 *
 * @autor: Ariel Zarate
 * <p>
 * <p>
 * Crear una clase llamada Utilidades con 2 métodos para manipular listas:
 * <p>
 * 1. Un método será imprimirElementos() -> donde se recorrerá la lista, los elementos pueden ser de cualquier tipo
 * <p>
 * 2. Otro método será copiarElementos() -> donde se deberá usar bounded generic para asegurar que la lista de destino sea de un tipo igual o superclase del tipo de la lista de origen
 * <p>
 * 3. Además, utilizar una wildcard para indicar que la lista de origen puede ser de cualquier tipo.
 *
 */
public class Utilidades {

    public static void imprimirElementos(List<?> lista) {

        lista.forEach(System.out::println);
    }

    public static <T> void copiarElementos(List<? extends T> origen, List<? super T> destino) {
        for (T elemento : origen) {
            destino.add(elemento);
        }
    }

    public static <T> T obtenerElemento(List<T> lista, int indice) {
        if (indice < 0 || indice >= lista.size()) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return lista.get(indice);
    }

    public static <T> void agregarSiNulo(List<T> lista, T elemento) {
        if (elemento == null) {
            lista.add(elemento);
        }
    }


}
