package Switch;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int op=-1;

        while(op !=0)
        {

            do{
                System.out.println("");
                System.out.println("*********MENU DE DIAS DE LA SEMANA ************");
            System.out.println("ingrese un numero entre 1 y 7  para saber el dia de la semana");
            System.out.println("ingrese 0 para cortar");
                System.out.println("");

            op = sc.nextInt();
            if(op==0){
                System.out.println("ingreso 0 el programa finalizara  😥");
                System.out.println("copyright @arielZarate 😎😎😎😎😎");
            }

        //opciones switch case

                switch (op){
                    case 1:
                        System.out.println("dia Lunes 🚗");break;
                    case 2:
                        System.out.println("dia Martes ✈");break;
                    case 3:
                        System.out.println("dia Miercoles 🛸");break;
                    case 4:
                        System.out.println("dia Jueves 🚁");break;
                    case 5:
                        System.out.println("dia viernes 🛴");break;
                    case 6:
                        System.out.println("dia Sabado 🚂");break;
                    case 7:
                        System.out.println("dia Domingo 🚲");break;

                    default:
                      //  System.out.println("ha ingresado un dato Erroneo");

                }


            }while(op<1&&op>7);


        }
    }
}


