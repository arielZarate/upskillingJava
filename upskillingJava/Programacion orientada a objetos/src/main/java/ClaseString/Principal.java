package ClaseString;


import java.sql.SQLOutput;

/**
 * @author ariel Zarate
 * @see "ver Readme ClaseString"
 * */

public class Principal {
    public static void main(String[] args) {

        String s1="Hola";
        String s2="Hola";
        String s3="Hola";


        String s4=new String("Hola");

        System.out.println(s4);
        System.out.println("s1==s3 :" + (s1==s3)); //true
        System.out.println("s2==s3 :" + (s2==s3)); //true
        System.out.println("El equals compara el contenido :)");
        System.out.println("S1.equals(s4) : " + (s1.equals(s4)));


        System.out.println("*****************************");
        StringBuilder sb1=new StringBuilder("Hello");
        StringBuilder sb2=new StringBuilder("Hello");

        System.out.println("sb1.equals(sb2) :" + sb1.equals(sb2));//return false


        Estudiante e1=new Estudiante("Juan",20);
        Estudiante e2=new Estudiante("Juan",20);

        System.out.println("e1.equals(e2) :"+ e1.equals(e2));
        System.out.println("e1==e2 :"+ (e1==e2));

        System.out.println("Ahora igualo e2=e1");
        e2=e1;

        System.out.println("e1 ==e2 :"+ (e1 == e2));


    }
}
