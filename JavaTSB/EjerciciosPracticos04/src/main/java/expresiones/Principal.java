package expresiones;
public class Principal {

    public static void main(String[] args) {

        Numero a = new Numero(3);
        Numero b = new Numero(2);
        Numero c = new Numero(4);

        Suma s2 = new Suma(c, c);
        Multiplicacion m1 = new Multiplicacion(b, s2);
        Suma s1 = new Suma(a, m1);
        Resta r1 = new Resta(s1, c);
        System.out.println("El resultado es: " + r1.valuar());



    }
}
