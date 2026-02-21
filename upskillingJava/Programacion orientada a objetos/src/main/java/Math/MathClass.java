package POO.Math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class MathClass {

    public static void main(String[] args) {

        System.out.println("El resultado de Math.E : " + Math.E);
        System.out.println("El resultado de Math.PI : " + Math.PI);
        System.out.println("El resultado de Math.PI : " + Math.PI);


        double angule_Grades=45;
        System.out.println("El valor del angulo :" +angule_Grades);

        System.out.println("El angulo en radianes es " + Math.toRadians(angule_Grades));

        System.out.println("Ahora pasamos de " + Math.toRadians(angule_Grades) + "a radianes");
        System.out.println("El valor en radianes : " + Math.toRadians(Math.toRadians(angule_Grades)));


        System.out.println("\n");
        System.out.println("==============Funciones trigonomentricas===============");

        System.out.println("El seno de " + (int)angule_Grades + " grados es "  +  Math.sin(angule_Grades) );
        System.out.println("El seno de " + Math.round(angule_Grades) + " grados es "  +  Math.sin(angule_Grades) );
        System.out.println("Para formatear con String.format('%.0f', 45.0) es  " + String.format("%.0f",angule_Grades));

        System.out.println("\n");
        Scanner scan =new Scanner(System.in);
       /// System.out.println("ingrese un valor para sacar la raiz cuadrada");
       // int x= scan.nextInt();

        int x=16;

        DecimalFormat df=new DecimalFormat();

        System.out.println("La  raiz cuadrada de " + x + " es "+ df.format(Math.sqrt(x)) +" con DecimalFormat");

        System.out.println("La  raiz cuadrada de " + x + " es "+ String.format("%.0f",Math.sqrt(x)) + " con String.format");


        System.out.println("La  raiz cuadrada de " + x + " es "+  Math.round(Math.sqrt(x)) + " con Math");



         BigDecimal bg= BigDecimal.valueOf(Math.sqrt(x));
        System.out.println("La  raiz cuadrada de " + x + " es "+ bg.setScale(4, RoundingMode.DOWN) + " con BigDecimal");


        System.out.println("\n");
        System.out.println("***********Numeros aleatorios**********");
        System.out.println("generando numeros aleatorios con Math.random()");
        int  aleat=(int)(Math.random()*100); //todo: el random()  te da un double
        System.out.println("el numero aleatorio es  "+ aleat);


        System.out.println("\nUsando clase ramdom()\n");

        Random r=new Random();

        System.out.println("Numero aleat genearado es : " + r.nextDouble(10) );

    }

}
