package Comparable;

/**
 * Clase sencilla, usada para representar Clientes del Banco. 
 * 
 * @author Ing. Valerio Frittelli.
 * @version Mayo de 2004.
 */
public class Cliente implements Comparable
{
    private int dni;
    private String nombre;
    
    /**
     * Constructor por defecto.  
     */
    public Cliente()
    {
    }

    /**
     * Constructor sobrecargado. Inicializa el dni y el nombre de acuerdo a los parametros.
     * @param d el dni a asignar.
     * @param nom el nombre a asignar.
     */
    public Cliente(int d, String nom)
    {
      dni = d;
      nombre = nom;
    }
    
    /*
     *  Metodo de consulta para el numero de dni.
     *  @return el numero de dni.
     */
    public int getDni()
    {
       return dni;   
    }

    /*
     *  Metodo de consulta para el nombre del cliente.
     *  @return el nombre del cliente.
     */
    public String getNombre()
    {
       return nombre;   
    }
    
    /*
     *  Metodo modificador para el numero de dni.
     *  @param num el nuevo dni.
     */
    public void setDni( int num )
    {
       dni = num;   
    }

    /*
     *  Metodo modificador para el nombre del cliente.
     *  @param nom el nuevo nombre.
     */
    public void setNombre( String nom )
    {
       nombre = nom;   
    }

    /** 
     *  Redefinicion del metodo toString.
     *  @return el contenido del objeto en forma String con formato adecuado para ser visualizado.
     */
    @Override
    public String toString()
    {
       return "Dni del cliente: " + dni +  " - Nombre: " + nombre;
    }

    /**
     * Redefinicion del metodo pedido por la interfaz Comparable.
     * El criterio de comparacion sera en base al dni del cliente.
     * @param x El objeto a comparar contra el par�metro implicito.
     * @return 0 si los dni de ambos objetos son iguales, negativo si el dni del implicito es menor, positivo si es mayor.
     */
    @Override
    public int compareTo(Object x)
    {
       // moldeamos x para que el compilador "vea" un objeto Cliente y no un Object, 
       // pues el metodo getDni() no esta en Object...
       Cliente c = (Cliente) x;
       return this.getDni() - c.getDni(); 
    }
}
