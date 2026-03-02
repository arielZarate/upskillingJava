package homework.Ejercicio1;

/**
 * @author: Ariel Zarate
 *

1. Crea una aplicación para realizar operaciones sobre una lista de objetos Persona. Cada objeto Persona debe tener las siguientes propiedades: nombre, edad y hobby, todas de tipo String.

2. Utiliza la Stream API de Java, realiza las siguientes operaciones sobre la lista de personas:

- a)  Filtrar las personas que sean mayores de 18 años y cuyos hobbies incluyan la palabra "programar". Utiliza la operación filter para realizar este filtrado.
- b) Obtener una lista con los nombres de todas las personas. Utiliza la operación map para mapear cada objeto Persona a su nombre.
- c) Limitar la lista de personas a un máximo de 5 personas. Utiliza la operación limit para establecer este límite.
- d) Imprimir los nombres de todas las personas en la lista utilizando la operación forEach.

 * */

public class Persona {

    private String nombre;
    private String edad;
    private String hobby;

    public Persona(String nombre, String edad, String hobby) {
        this.nombre = nombre;
        this.edad = edad;
        this.hobby = hobby;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
