package MetodosEstaticos;

public class Main {

    public static void main(String[] args) {

       // No es necesario crear una instancia de Contador para usar sus métodos estáticos

        Contador.incrementarContador();

        Contador.incrementarContador();

        System.out.println("Contador: " + Contador.obtenerContador());


        // Sin embargo, también es posible crear una instancia de Contador, aunque no es necesario para usar los métodos estáticos
        //pero lo hago porque el metodo decrementarContador no es estatico, entonces necesito una instancia para usarlo

        Contador contador1 = new Contador();
        contador1.decrementarContador();

        System.out.println("Contador después de decrementar: " + Contador.obtenerContador());




    }
}
