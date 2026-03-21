package expresiones;
public class Resta extends Operacion {


    public Resta(Termino izq, Termino der) {
        super(izq, der);
    }

    @Override
    public int valuar() {
        return izq.valuar() - der.valuar();
    }
}
