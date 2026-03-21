package Accesos.paq01;
public class C 
{
    public void acceder()
    {
        A x = new A();
        // x.a1 = 0; // privado en A: no compila
        x.a2 = 0; // protegido en A
        x.a3 = 0; // p�blico en A
        x.a4 = 0; // default en A
    }
}
