package Municipio;


import java.util.Calendar;

public class Principal {
    public static void main(String[] args) {


        /*
    Desarrollar un programa para un Municipio, que permita administrar el conjunto de
     autos, taxis yremises de una ciudad.
•	Por cada auto, se conoce: patente, marca y modelo.
•	Los taxis se registran como autos, agregando además un número de licencia de taxi.
•	Los remises también se registran como autos, agregando licencia e
     identificador de agencia a la que pertenecen (un número del 0 al 9).



    Cargar por teclado los datos de un auto, un remis y un taxi y luego determinar
    qué monto total percibe por impuestos la municipalidad. Tener en cuenta que:
o	Los autos de menos de 10 años de antigüedad pagan $200, entre 10 y 20 años
    pagan $150 y no pagan impuestos los que tienen más de 20 años.
o	Los taxis pagan impuestos como auto, más $150 por la licencia de taxi.
o	Los remis pagan un 10% adicional a su impuesto como auto.


         */



        System.out.println("SISTEMA MUNICIPAL");


         Auto auto = new Auto("AB 123 XY","Ford",2019);
        //System.out.println(auto);
        Taxi taxi = new Taxi("AC 789 XX","Fiat",2016,"T1222");
        System.out.println(taxi);
        Remis remis = new Remis("AA 567 JJ","Fiat",2015,"R4333",3);
        System.out.println(remis);
        //double impuestos = auto.calcularImpuestos() + taxi.calcularImpuestos() + remis.calcularImpuestos();
        double impuestos =  taxi.calcularImpuestos() + remis.calcularImpuestos();
        System.out.println("El total recaudado es $" + impuestos);



    }
}

