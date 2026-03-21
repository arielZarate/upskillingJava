package Homework.models;

public class Profesor extends Persona {
    private String materia;

    public Profesor(String nombre, int edad, String materia) {
        super(nombre, edad);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Profesor{nombre='" + getNombre() + "', edad=" + getEdad() + ", materia='" + materia + "'}";
    }
}
