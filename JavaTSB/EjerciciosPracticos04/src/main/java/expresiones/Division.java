package expresiones;
public class Division extends Operacion {


    public Division(Termino izq, Termino der) {
        super(izq, der);
    }

    @Override
    public int valuar() {
        return izq.valuar() / der.valuar();
    }
}
