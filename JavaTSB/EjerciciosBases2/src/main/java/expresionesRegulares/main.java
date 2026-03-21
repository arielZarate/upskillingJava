package expresionesRegulares;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {


        //*******************************

        Scanner sc = new Scanner(System.in);
        String email;
        System.out.print("Introduce email: ");
        email = sc.nextLine();
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(email);
        if(mat.find()){
            System.out.println("Correo Válido");
        }else{
            System.out.println("Correo No Válido");
        }


        System.out.println("\n" +
                "");



      //  5. Comprobar si el String cadena está formado por un mínimo de 5 letras mayúsculas o minúsculas y un máximo de 10.

        String cadena="" +
                "MGgf";
        Pattern pat1 = Pattern.compile("[\\Sa-zA-Z]{5,10}");
        Matcher mat1 = pat1.matcher(cadena);
        if (mat1.matches()) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }
}
