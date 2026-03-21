package Homework;

import Homework.models.Estudiante;
import Homework.models.Par;
import Homework.models.Persona;
import Homework.models.Profesor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        List<String> frutas = Arrays.asList("Manzana", "Banana", "Naranja");

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan", 20, "Java"));
        estudiantes.add(new Estudiante("Maria", 22, "Python"));

        List<Profesor> profesores = new ArrayList<>();
        profesores.add(new Profesor("Carlos", 40, "Matematicas"));
        profesores.add(new Profesor("Ana", 35, "Fisica"));





        System.out.println("=== IMPRIMIR ELEMENTOS (Wildcard ?) ===");
        System.out.println("\n--- Numeros ---");
        Utilidades.imprimirElementos(numeros);

        System.out.println("\n--- Frutas ---");
        Utilidades.imprimirElementos(frutas);

        System.out.println("\n--- Estudiantes ---");
        Utilidades.imprimirElementos(estudiantes);

        System.out.println("\n--- Profesores ---");
        Utilidades.imprimirElementos(profesores);

        System.out.println("\n=== COPIAR ELEMENTOS (Bounded Wildcards) ===");

        List<Persona> personas = new ArrayList<>();
        System.out.println("\n--- Copiar Estudiantes a Personas (extends T en origen) ---");
        System.out.println("Antes: " + personas);
        Utilidades.copiarElementos(estudiantes, personas);
        System.out.println("Despues: " + personas);

        System.out.println("\n--- Copiar Profesores a Personas ---");
        Utilidades.copiarElementos(profesores, personas);
        System.out.println("Personas total: " + personas);

        List<Number> numeros2 = new ArrayList<>();
        List<Integer> enteros = Arrays.asList(10, 20, 30);
        System.out.println("\n--- Copiar Integer a Number (Integer extiende Number) ---");
        Utilidades.copiarElementos(enteros, numeros2);
        System.out.println("Numeros: " + numeros2);

        System.out.println("\n--- Demostracion de polimorfismo ---");
        boolean esPersonaEstudiante = estudiantes.get(0) instanceof Persona;
        boolean esPersonaProfesor = profesores.get(0) instanceof Persona;
        System.out.println("Estudiantes son Personas: " + esPersonaEstudiante);
        System.out.println("Profesores son Personas: " + esPersonaProfesor);

        System.out.println("\n--- NO SE PUEDE: Copiar Persona a Estudiante ---");
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        System.out.println("Lista estudiantes: " + listaEstudiantes);
        // Utilidades.copiarElementos(personas, listaEstudiantes); // ERROR: Persona no es subtipo de Estudiante
        System.out.println("Si descomentamos la linea anterior -> ERROR DE COMPILACION");
        System.out.println("Motivo: 'personas' es List<Persona> y 'listaEstudiantes' es List<Estudiante>");
        System.out.println("El metodo espera destino List<? super Estudiante> (Estudiante o superclase)");
        System.out.println("Persona es superclase de Estudiante, pero la lista es de Personas, no de Estudiante");

        System.out.println("\n=== CLASE GENERICA Par<K,V> (Simula JSON) ===");
        List<Par<String, Object>> usuarioJson = new ArrayList<>();
        usuarioJson.add(new Par<>("nombre", "Juan"));
        usuarioJson.add(new Par<>("edad", 30));
        usuarioJson.add(new Par<>("activo", true));
        usuarioJson.add(new Par<>("promedio", 8.5));

        System.out.println("Usuario JSON:");
        for (Par<String, Object> campo : usuarioJson) {
            System.out.println("  " + campo.getClave() + ": " + campo.getValor() + " (" + campo.getValor().getClass().getSimpleName() + ")");
        }

        System.out.println("\n=== METODOS GENERICOS ===");
        String nombre = Utilidades.obtenerElemento(frutas, 0);
        System.out.println("Primer elemento de frutas: " + nombre);

        Integer numero = Utilidades.obtenerElemento(numeros, 2);
        System.out.println("Tercer numero: " + numero);

        System.out.println("\n--- agregarSiNulo (solo agrega si es null) ---");
        List<String> listaConNulo = new ArrayList<>();
        Utilidades.agregarSiNulo(listaConNulo, null);
        Utilidades.agregarSiNulo(listaConNulo, "No se agrega");
        System.out.println("Lista con nulo: " + listaConNulo);
    }
}
