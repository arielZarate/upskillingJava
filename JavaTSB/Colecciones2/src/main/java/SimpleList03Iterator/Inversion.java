package clases;

public class Inversion extends Cuenta
{
    private float tasa;
    
    public Inversion()
    {
    }
	
    public Inversion(int num, float sal, float tas)
    {
        super(num, sal);   
        tasa = tas;
    }
	
    public float getTasa()
    {
       return tasa;   
    }
    
    public void setTasa( float tas )
    {
       tasa = tas;   
    }

    public void actualizar ()
    {
       float monto = getSaldo() * tasa / 100;
       depositar(monto);
    }

    @Override
    public void retirar (float imp)
    {
      float s = getSaldo();
      if (s - imp >= 0)
      {
         setSaldo(s - imp);   
      }
    }
    
    @Override
    public String toString()
    { 
       return super.toString() + " - Tasa: " + tasa;
    }
}
