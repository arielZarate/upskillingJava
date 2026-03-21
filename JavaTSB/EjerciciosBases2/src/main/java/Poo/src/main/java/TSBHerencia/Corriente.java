package TSBHerencia;
public class Corriente extends Cuenta
{
    private boolean descubierto;  // true si se autoriza girar en descubierto - false si no. 

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
      if (getSaldo() >= imp || getDescubierto())
      {
         float s = getSaldo();
         setSaldo(s - imp);   
      }
    }

    @Override
    public String toString()
    { 
       return super.toString() + " - Autorización de giro en rojo: " + descubierto;
    }
}
