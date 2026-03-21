package expresiones;
public class Multiplicacion extends Operacion {

    public Multiplicacion(Termino izq, Termino der) {
        super(izq, der);
    }

    @Override
    public int valuar() {
        return izq.valuar() * der.valuar();
    }
}
