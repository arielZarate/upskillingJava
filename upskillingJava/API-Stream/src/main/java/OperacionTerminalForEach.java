import java.util.ArrayList;
import java.util.List;

public class OperacionTerminalForEach {
    public static void main(String[] args) {

        List<String> nombres = new ArrayList<>(List.of("Juan", "María", "Pedro", "Ana", "Luis"));

        //puedo agregar mas
        nombres.add("Ariel");

        //====================================================

        System.out.println("Imprimir la lista con un for sin stream:");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(nombres.get(i));
        }

        //====================================================

        System.out.println("\n ****** operacion terminal **********");
        System.out.println("\nImprimir la lista con un forEach con stream:");
        nombres.stream().forEach(System.out::println);

         //====================================================
    }
}
