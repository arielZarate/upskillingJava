package ClaseString;

public class Inmutable {

    public static void main(String[] args) {
        String s1="Hello";
        s1="hello world";

        System.out.println("es inmutable?  :" +s1); //inmutable :hello world

        s1.concat(" people");
        System.out.println("se agrego people pero no lo hizo  : "+ s1);//return hello world no lo modifico

        /**notar el cambio ahora no se modifica directamente sino que se crea una nueva referencia*/
        s1=s1.concat( " people");
        System.out.println("se agrego people y lo hizo : "+ s1);//return hello world people


        System.out.println("\n **********probando string vs StringBuilder****************");
        String str="probando clase String en MEMORIA   ";

        for (int i = 1; i <= 20; i++) {
            System.out.println("Nuevo objeto  ");
            str= str.concat(" "+i);
            System.out.println(str);
        }
    StringBuilder str2= new StringBuilder("probando clase StringBuilder en MEMORIA");
        System.out.println("*******mismo objeto******");
        for (int i = 1; i <= 20; i++) {
            System.out.println(str2.append(" ").append(i).toString());
        }

    }
}
