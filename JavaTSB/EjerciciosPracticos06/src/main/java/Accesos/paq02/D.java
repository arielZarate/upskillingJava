package Accesos.paq02;
import Accesos.paq01.*;
public class D extends A
{
    public void acceder()
    {
        // a1 = 0; // privado en A: no compila
        a2 = 0; // protegido en A
        a3 = 0; // p�blico en A
        // a4 = 0; // default en A
    }
}
