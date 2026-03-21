package Willcards_Comodines;

import java.util.ArrayList;
import java.util.List;

public class MainComodines {

    public static void main(String[] args) {


        Generico generico =new Generico();


        List<Number> lista=new ArrayList<>();

        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);



        List<String> cadena=new ArrayList<>();
        //lista.addAll(cadena); esto da error porque es string



        generico.mostrar(lista);



    }
}
