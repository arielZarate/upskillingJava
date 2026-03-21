package Clases;

/**
 *
 * @author ariel
 */
//NOTA: una clase es un modelo , una plantilla de la cual puedo crear objectos o instanciar
public class Persona {

    //definimos la clase Persona
    //- private - protected - public (modificadoes de acceso) relacionados con el Encapsulamiento  
    //atributos
    private String nombre;
    private String apellido;
    private int edad;
    private int dni;

    //constructor para poder crear objectos de esta clase , relaconado con el new 
    public Persona() {
    }

    /// constructor con parametros 
    public Persona(String nombre, String apellido, int edad, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    
    //los metodos que duvuelven  valores se son funciones
    public String getNombre() {
        return nombre;
    }

    
    //los metodos que no devuelven resueltados pero que hacen algo son llamdos procedimientos
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

    
    
    //metodo toString sirve para poder mostrar los datos 
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + '}';
    }
    
    
    //nota: existe una clase Object que es la cual podemos crear todos los objetos 
    //esa clase ya posee metodos y es generica, el metodo toString pertenece a object
    //es por eso que cuando la uso me dice override (sobreescribiendo) 😀
   

}
