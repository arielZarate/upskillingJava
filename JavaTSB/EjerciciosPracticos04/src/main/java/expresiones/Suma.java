package expresiones;
public class Suma extends Operacion  {

    public Suma(Termino izq, Termino der) {
        super(izq, der);
    }

    @Override
    public int valuar() {
        return izq.valuar() + der.valuar();
    }
}
