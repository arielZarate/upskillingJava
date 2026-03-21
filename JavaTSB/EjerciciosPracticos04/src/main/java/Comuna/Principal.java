package Comuna;
/**
 Enterado de nuestra fama de programadores, otro intendente nos solicita un programa para su gestión de impuestos.
 Se trata de un pueblo pequeño donde se pagan impuestos sobre vehículos e inmuebles. Todos estos elementos se identifican con un id único.
 Para los vehículos, se registra id, modelo y valor fiscal. Los vehículos de más de 20 años están exentos, los demás pagan el 1% de su valor fiscal.
 Para los inmuebles, se registra id, metros de terreno y metros cubiertos. Todos pagan $20 por metro de terreno y $50 por metro cubierto.
 Desarrollar un programa demo, donde se carguen algunos datos arbitrarios y luego:
 1) Muestre un listado de todas las propiedades existentes.
 2) Informe el total de impuestos percibido, el monto para  vehículos y para inmuebles, y que porcentaje representan ambos sobre el total general

 */

public class Principal {
    public static void main(String[] args) {
        Comuna comuna = new Comuna();
        System.out.println("SISTEMA COMUNAL");
        System.out.println("Listado de propiedades");
        System.out.println(comuna);
        float totGeneral = comuna.calcularTotalImpuestos();
        System.out.println("Total de impuestos $" + totGeneral);
        float totInmuebles = comuna.calcularTotalImpuestosPorTipo(Inmueble.class);
        float totVehiculos = comuna.calcularTotalImpuestosPorTipo(Vehiculo.class);
        System.out.println("Total impuestos inmuebles $" + totInmuebles + " Porcentaje: " + totInmuebles * 100 / totGeneral + "%");
        System.out.println("Total impuestos vehículos $" + totVehiculos + " Porcentaje: " + totVehiculos * 100 / totGeneral + "%");
    }
}
