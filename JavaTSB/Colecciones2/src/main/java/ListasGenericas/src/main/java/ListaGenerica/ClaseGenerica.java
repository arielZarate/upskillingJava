package ListaGenerica;

public class ClaseGenerica <T> {

    T atributo;

    public ClaseGenerica ()
    {
        this.atributo=null;
    }


    public void setAtributo( T nuevoValor)
    {
        this.atributo=nuevoValor;
    }


    public T getAtributo()
    {
        return  this.atributo;
    }
}
