package PolimorfismoMio;

public class Main {

    public static void main(String[] args) {

        /***
         * Herencia
         */

         /*
         atributos de animal
           private String name="";
            private  String  poder="";
            private String habitat ="";
             private String tipoAnimal="";
         */

        System.out.println("\t\t **Herencia** ");
        //Animal animal=new Animal("Humano", "Conciencia", "TodoTerreno","Depredador");
       // System.out.println(animal.toString());

        Oso o=new Oso("Oso","Garras", "pradera" ,"Tierra","omnivoro");
        Pescado p=new Pescado("Pescado ","Nadar" ,"Agua","Dorado","dulce");
        Aguila a=new Aguila("Aguila ","Volar y garras" ,"Aereo","Real","20 kg");


        System.out.println(o.toString());
        System.out.println(a.toString());
        System.out.println(p.toString());
        System.out.println("");


        /**
         * Aplicando polimorfismo.

         */

        /*

         */
        System.out.println("\n\t ***Polimorfismo**");
        Animal x=new Animal("Humano", "Conciencia", "TodoTerreno","Depredador");
        System.out.println(x.toString());
        Animal xo=new Oso("Oso","Garras", "pradera" ,"Tierra","omnivoro");
        Animal xp=new Pescado("Pescado ","Nadar" ,"Agua","Dorado","dulce");
        Animal xa=new Aguila("Aguila ","Volar y garras" ,"Aereo","Real","20 kg");

       // System.out.println(x.toString());
        System.out.println(xo.toString());
        System.out.println(xa.toString());
        System.out.println(xp.toString());


        System.out.println("\n****Polimorfismo con vectores****");
        Animal []v =new Animal[4];
        v[0]=new Animal("Humano", "Conciencia", "TodoTerreno","Depredador");
        v[1]=new Oso("Oso","Garras", "pradera" ,"Tierra","omnivoro");
        v[2]=new Pescado("Pescado ","Nadar" ,"Agua","Dorado","dulce");
        v[3]=new Aguila("Aguila ","Volar y garras" ,"Aereo","Real","20 kg");


        /**
        mostrando los datos con un foreach
         */

        for (Animal m: v) {
            System.out.println(m.toString());
        }

    }
}
