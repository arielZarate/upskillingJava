package programacionOrientadaaObjetos.cuentabancaria;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria c=new CuentaBancaria("A123fVf",800.000,"Ariel Zarate");

        System.out.println(c.toString());

        System.out.println("depositar 200.000");
        System.out.println(  c.depositar(200.000));

        System.out.println("\nextraer 50.000");
        System.out.println(c.extraer(50.000));

        System.out.println(c.mostrarSaldo());
        System.out.println(" ");
        System.out.println(c.toString());
    }
}
