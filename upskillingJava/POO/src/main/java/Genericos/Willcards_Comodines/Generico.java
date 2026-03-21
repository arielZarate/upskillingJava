package Willcards_Comodines;

import java.util.List;

public class Generico {



    public void mostrar(List<? extends Number> lista)
    {
        //como es lista recorro

        for(Number l :lista)
        {
            System.out.println("La clase es " +l.getClass().getName());
        }
    }
}
