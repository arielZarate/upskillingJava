package TSBHerencia;

public class Principal {
    public static void main(String args[])
    {
       /*
       Cuenta a = new Cuenta(1, 1000);
       Inversion b = new Inversion(2, 2000, 2.31f);
       Corriente c = new Corriente(3, 1500, true);

       System.out.println("\nValores originales: ");
       System.out.println("Cuenta a: " + a);
       System.out.println("Cuenta b: " + b);
       System.out.println("Cuenta c: " + c);

       a.setNumero(4);

         //a.setDescubierto(true);  // no compila: setDescubierto esta definido mas abajo de la clase Cuenta

       b.setNumero(5);
       b.actualizar();
       b.retirar(3000);  // podra??? NO... esta invocando al metodo definido en la clase Inversion, que controla el saldo

       c.setNumero(6);
       //c.actualizar();  // no compila: no esta en la base, ni definido en Corriente.
       c.retirar(2000); // podra??? SI... invoca al definido en Corriente, que permite sobregiro si la cuenta esta autorizada

       System.out.println("\nNuevos valores: ");
       System.out.println("Cuenta a: " + a.toString());
       System.out.println("Cuenta b: " + b);
       System.out.println("Cuenta c: " + c);
        */


       Cuenta a = new Cuenta(1, 1000);
       Cuenta x=new Inversion(); /**polimorfica*/
       Inversion b = new Inversion(2, 2000, 2.31f);
       Corriente c = new Corriente(3, 1500, true);

       System.out.println("\nValores originales: ");
       System.out.println("Cuenta a: " + a);
       System.out.println("Cuenta b: " + b);
       System.out.println("Cuenta c: " + c);

       a.setNumero(4);

       //a.setDescubierto(true);  // no compila: setDescubierto esta definido mas abajo de la clase Cuenta

       b.setNumero(5);
       b.actualizar();
       b.retirar(3000);  // podra??? NO... esta invocando al metodo definido en la clase Inversion, que controla el saldo

       c.setNumero(6);
       //c.actualizar();  // no compila: no esta en la base, ni definido en Corriente.
       c.retirar(2000); // podra??? SI... invoca al definido en Corriente, que permite sobregiro si la cuenta esta autorizada

       System.out.println("\nNuevos valores: ");
       System.out.println("Cuenta a: " + a.toString());
       System.out.println("Cuenta b: " + b);
          System.out.println("Cuenta c: " + c);
    }


}
