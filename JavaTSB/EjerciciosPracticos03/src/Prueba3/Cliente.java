package Prueba3;

public class Cliente extends Persona
{
    private float saldo;

    public Cliente (int cod, String nom, float sal)
    {
        super(cod, nom);
        saldo = sal;
    }

    public float getSaldo()
    {
        return saldo;
    }

}