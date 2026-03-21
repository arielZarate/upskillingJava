package Comparable;

/**
 * Representa una cuenta de Inversion, como subclase de la clase Cuenta. Una cuenta de 
 * inversion da cierto monto de interes a su propietario, aunque no permite girar cheques ni es
 * de libre disponibilidad.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Abril de 2004.
 */
public class Inversion extends Cuenta
{
    private float tasa;  // la tasa de interes pactada para la cuenta. 

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
