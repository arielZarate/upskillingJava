
package Polimorfismo;


public class Estudiante extends Persona {
    
    private String curso;
    private String carrera;
    private double promedio;

    
    
    public Estudiante ()
    {
        
    }
    public Estudiante(String curso, String carrera, double promedio, String nombre, String apellido, int edad, int dni) {
        super(nombre, apellido, edad, dni);
        this.curso = curso;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    
    //metodos de la clase estudiante
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    
    
    //metodos heredado de persona
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

    @Override
    public String toString() {
        
        //agreamos el super.tostring y nos trae todos los datos
        return "Estudiante{"+ super.toString() + "curso=" + curso + ", carrera=" + carrera + ", promedio=" + promedio +   "}";
    }

 
    
    
    
    
}
