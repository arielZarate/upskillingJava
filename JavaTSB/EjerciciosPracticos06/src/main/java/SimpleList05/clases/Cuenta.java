package SimpleList05.clases;

public abstract class Cuenta implements Comparable
{   
    private int numero;
    private float saldo;
    
    public Cuenta()
    {
    }

    public Cuenta(int num, float sal)
    {
      numero = num;
      saldo  = sal;
    }
    
    public int getNumero()
    {
       return numero;   
    }

    public float getSaldo()
    {
       return saldo;   
    }
    
    public void setNumero( int num )
    {
       numero = num;   
    }

    public void setSaldo( float sal )
    {
       saldo = sal;   
    }

    public abstract void retirar (float imp);
    
    public void depositar (float imp)
    {
         saldo += imp;   
    }

    @Override
    public String toString()
    {
       return "Cuenta número: " + numero +  " - Saldo: " + saldo;
    }
    
    @Override
    public int compareTo (Object x)
    {
        Cuenta p = (Cuenta) x;
        return this.numero - p.numero;
    }
}