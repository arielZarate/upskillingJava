package TSBHerencia;

public class Cuenta extends Object
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

    public void retirar (float imp)
    {
      if (saldo - imp >= 0)
      {
         saldo -= imp;   
      }
    }
    
    public void depositar (float imp)
    {
         saldo += imp;   
    }

    public String toString()
    {
        return "Numero: " + numero + " - Saldo: " + saldo;
    }
}