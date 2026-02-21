package programacionOrientadaaObjetos.persona;


/**
 * Representa a una persona con nombre, edad y DNI.
 *
 * @author Ariel Zarate
 * @version 1.0
 * @since 2025-02-18
 * @see <a href="https://academiasanroque.com/ejercicios-sobre-programacion-orientada-a-objetos-poo-en-java/">
 *      Ejercicios sobre Programación Orientada a Objetos en Java</a>
 */

public class Persona {
    // Atributos
    private String nombre;
    private int edad;
    private String dni;

    // Constructor
    public Persona(String nombre, int edad,String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni=dni;
    }

    //constructor sin parametros
    public Persona(){}


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Dni: " + dni);
    }


}
