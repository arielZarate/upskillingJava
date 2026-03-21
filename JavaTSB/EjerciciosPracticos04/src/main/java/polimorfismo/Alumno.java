
package  polimorfismo;
public class Alumno extends Persona {
    int legajo;

    public Alumno(int dni, int legajo) {
        super(dni);
        this.legajo = legajo;
    }

    public int getLegajo() {
        return legajo;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Alumno: legajo: " + legajo);
    }
}
