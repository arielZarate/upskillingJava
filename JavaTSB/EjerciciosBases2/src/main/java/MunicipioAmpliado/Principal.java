package MunicipioAmpliado;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anio, agencia;
        System.out.println("SISTEMA MUNICIPAL");
        Municipio municipio = new Municipio();
        System.out.println("\nListado de Vehiculos");
        System.out.println(municipio);
        System.out.println("\nEl vehiculo que paga mas impuestos es");
        System.out.println(municipio.buscarMayorImpuesto());
        System.out.print("\nIngrese año para control de taxis: ");
        anio = scanner.nextInt();
        System.out.println(municipio.mostrarTaxisViejos(anio));
        System.out.print("\nIngrese agencia a buscar: ");
        agencia = scanner.nextInt();
        System.out.println(municipio.mostrarRemisesDeAgencia(agencia));
    }
}

/**  ******Enunciado*******
 *
 *1. Municipio (ampliado)
 * Desarrollar un programa para un Municipio, que permita administrar el conjunto de autos, taxis y remises de una ciudad.
 * •Por cada auto, se conoce: patente, marca y modelo.
 * •Los taxis se registran como autos, agregando además un número de licencia de taxi.
 * •Los remises también se registran como autos, agregando licencia e identificador de agencia a la que pertenecen (un número del 0 al 9).
 * Una vez cargados los datos, el programa deberá:
 * 1) Generar un listado, con una línea por vehículo, mostrando toda la información disponible decada uno de ellos.
 * 2) Informar datos del vehículo que paga mayor monto de impuestos. Tener en cuenta que:
 * •	Los autos de menos de 10 años de antigüedad pagan $200, entre 10 y 20 años pagan $150 y no pagan impuestos los que tienen más de 20 años.
 * •	Los taxis pagan impuestos como auto, más $1500 por la licencia de taxi.
 * •	Los remis pagan un 10% adicional a su impuesto como auto.
 * 3) Mostrar datos de los taxis con modelo previo a un año ingresado por teclado, para informar que deberán renovar su vehículo.
 * 4) Listar los remises que pertenecen a una cierta agencia cuyo código se ingresa por teclado

 */
