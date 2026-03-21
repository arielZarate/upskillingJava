package Comparable;

/**
 * Representa una Cuenta Corriente sencilla en un Banco. Estas cuentas no generan interes, 
 * pero permiten librar cheques y eventualmente
 * girar en descubierto.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Abril de 2004.
 */
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

    public void setDescubierto(boolean des) 
    {
        descubierto = des;
    }

    @Override
    public void retirar(float imp) 
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
