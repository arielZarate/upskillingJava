package Herencia;



/**
 *
 * @author ariel
 */
//herencia es cuandoi una clae hereda comportamientos y atributos de la clase que hereda
//o sea el hijo o clase hija (subclase) hereda caracteristicas de la clase padre de la cual hereda
//se usa  la palabra clave extends
//la herencia se usa para evitar la duplicacion de codigo , entonces se utiliza una clase que tiene propiedades y comportamientos en comun 
public class Empleado extends Persona {

    // ala vez empleado puede tener su propios atributos
    private int legajo;
    private double sueldo;

    //constructor 
    //notar que esta usando los atributos de la clase padre heredada: nombre apellido edad y dni
    public Empleado(int legajo, double sueldo, String nombre, String apellido, int edad, int dni) {
        //se usa la plabra super()
        super(nombre, apellido, edad, dni);
        this.legajo = legajo;
        this.sueldo = sueldo;
    }

    //metodos setter y geteer
    //METODOS PROPIOS DE LA CLASE EMPLEADO
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    //METODOS HEREDADOS DE LA CLASE PADRE
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    //NOTAMOS QUE LA CLASE EMPLEADO AHORA PUEDE TENER MAS METODOS DE LOS QUE TIENE COMO ATRIBUTOS 
    //Y AHORA IMPORTAMOS EL METODO TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());//muestro los datos de la persona

        //OPCION 2 MAS RUSTICA
        // Agregamos los datos de la persona
//        sb.append("Nombre: ").append(getNombre());
//        sb.append("\nApellido: ").append(getApellido());
//        sb.append("\nEdad: ").append(getEdad());
//        sb.append("\nDNI: ").append(getDni());

        sb.append("Empleado{");
        sb.append("legajo=").append(legajo);
        sb.append(", sueldo=").append(sueldo);
        sb.append('}');

        return sb.toString();
    }

}
