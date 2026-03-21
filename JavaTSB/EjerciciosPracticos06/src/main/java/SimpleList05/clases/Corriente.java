package SimpleList05.clases;

public class Corriente extends Cuenta
{
    private boolean descubierto;

    public Corriente()
    {
    }

    public Corriente(int num, float sal, boolean des)
    {
        super(num, sal);
        descubierto = des;
    }
	
    public boolean getDescubierto()
    {
       return descubierto;   
    }
    
    public void setDescubierto( boolean des )
    {
       descubierto = des;   
    }

    @Override
    public void retirar (float imp)
    {
      float s = getSaldo();
      if (s >= imp || getDescubierto())
      {
         setSaldo(s - imp);   
      }
    }

    @Override
    public String toString()
    { 
       return super.toString() + " - Autorización de giro en rojo: " + descubierto;
    }
}
