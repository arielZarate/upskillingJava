package Comparable;

/**
 * Una clase muy elemental para representar un arreglo genérico.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Julio de 2013.
 */
public class Array
{
    private Comparable v[];
    
    public Array()
    {

        this(5);
    }
    
    public Array(int n)
    {
        if(n <= 0) n = 5;
        v = new Comparable[n];
    }
    
    public Comparable get(int i)
    { 
        Comparable r = null;
        
        try
        {
           r = v[i];
        }
        catch(IndexOutOfBoundsException e)
        {
        }
        
        return r;
    }
    
    public void set(int i, Comparable x)
    {
        if(x == null) return;
        
        try
        {
            v[i] = x;
        }
        catch(IndexOutOfBoundsException e)
        {
        }
    }
    
    public void sort()
    {
        int n = v.length;
        for(int i = 0; i < n - 1; i++)
        { 
            for(int j = i + 1; j < n; j++)
            {
                int r = v[i].compareTo(v[j]);
                if( r > 0)
                {
                    Comparable aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
    }
    
    @Override
    public String toString()
    {
        StringBuilder r = new StringBuilder("[");
        for(int i = 0; i < v.length; i++)
        {
            r.append(v[i].toString());
            if(i != v.length - 1) r.append(" - ");
        }    
        r.append("]");
        return r.toString();
    }
}
