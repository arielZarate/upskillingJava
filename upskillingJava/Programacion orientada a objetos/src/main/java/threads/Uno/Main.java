package POO.threads.Uno;

public class Main {
    public static void main(String[] args) {

//    for (int i = 0; i <= 5; i++) {
//        System.out.println("Proceso 1");
//    }
//
//    System.out.println("");
//
//
//    for (int i = 0; i <= 5; i++) {
//        System.out.println("Proceso 2");
//    }


        Proces1 hilo1 = new Proces1();
        /**
         *
         * para ajecutar el proceso 2 se debe crear de forma distinta
         **/
        Thread hilo2 = new Thread(new Proceso2());

        hilo1.run();
        System.out.println(" ================================");
        hilo2.run();
    }
}
