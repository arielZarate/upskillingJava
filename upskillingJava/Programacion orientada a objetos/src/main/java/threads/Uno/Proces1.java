package POO.threads.Uno;

public class Proces1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <=5 ; i++) {
            System.out.println("Proceso1");
        }
    }

}
