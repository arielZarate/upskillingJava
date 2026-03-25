package InterfazConsumer_T;





/*
Consumer<T>
La interfaz funcional `Consumer<T>` representa una operación que toma un argumento de tipo `T` y no
devuelve ningún resultado. Tiene un método llamado `accept`
*
* */

import java.util.function.Consumer;

public class MainConsumer {

    public static void main(String[] args) {

        Consumer<String> printMessage= message -> System.out.println("Mensaje:" + message);

  printMessage.accept("Hola , mundo!");

    }

}
