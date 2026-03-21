package SalaReuniones;
//Por cada participante de las reuniones se conoce apellido y nombre.
public class Persona implements Comparable<Persona> {

    /**
     * variables con sus modificadores de la clases
     */
    private String nombre;
    private String apellido;
    private int dni;


    /**
     * constructores con parametros y sin parametros
     */
    public Persona() {
    }

    public Persona(String nombre, String apellido , int dni) {


        this.nombre = nombre;
        this.apellido = apellido;
        this.dni=dni;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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
                ", dni='" + dni + '\'' +
                '}'+"\n";
    }



    @Override
    /**
     * si es el mismo dni return 0
     **/

    public int compareTo(Persona otraPersona) {
        if(otraPersona.getDni()==this.getDni())
        {
            return 0;
        }
        else return -1;
    }
}
