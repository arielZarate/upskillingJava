package expresiones;
public abstract class Operacion implements Termino  {

    protected Termino izq;
    protected Termino der;

    public Operacion(Termino izq, Termino der) {
        this.izq = izq;
        this.der = der;
    }

}
