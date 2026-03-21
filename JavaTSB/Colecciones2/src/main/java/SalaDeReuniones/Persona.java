package SalaDeReuniones;
//Por cada participante de las reuniones se conoce apellido y nombre.
public class Persona {

    /**
     * variables con sus modificadores de la clases
     */
    private String nombre;
    private String apellido;


    /**
     * constructores con parametros y sin parametros
     */
    public Persona() {
    }

    public Persona(String nombre, String apellido) {


        this.nombre = nombre;
        this.apellido = apellido;
    }



    /**
     *
     * @return @set
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    /**
     *
     * toString()
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
