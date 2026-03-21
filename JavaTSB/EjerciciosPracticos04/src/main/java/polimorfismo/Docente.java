package  polimorfismo;
public class Docente extends Persona {
    String materia;

    public Docente(int dni, String materia) {
        super(dni);
        this.materia = materia;
    }

    public void mostrar() {
        System.out.println("Docente");
    }
}
