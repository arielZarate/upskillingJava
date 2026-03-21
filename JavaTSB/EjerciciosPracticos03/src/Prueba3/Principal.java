package Prueba3;

public class Principal {


    public static void main(String args[]) {
        Persona p = new Cliente(10, "Ana", 2344);
        float sal = ((Cliente) p).getSaldo();
        System.out.println("Saldo actual: " + sal);
    }

}
