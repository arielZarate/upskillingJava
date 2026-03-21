package expresiones;
public class Numero implements Termino {

    private int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    @Override
    public int valuar() {
        return valor;
    }
}
