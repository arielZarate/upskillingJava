package polimorfismoProfe;
public class Principal {

    public static void main(String[] args) {

        Persona[] v = new Persona[3];

        v[0] = new Alumno(123, 234);
        v[1] = new Persona(234);
        v[2] = new Docente(345, "567");

        for (Persona p : v) {
            p.mostrar();
        }
    }
}
