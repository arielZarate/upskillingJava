package  polimorfismo;
public class Persona {
    int dni;

    public Persona(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void mostrar() {
        System.out.println("Persona: dni:" + this.dni);
    }
}
