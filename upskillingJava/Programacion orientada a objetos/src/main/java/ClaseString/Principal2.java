package ClaseString;

public class Principal2 {
    public static void main(String[] args) {
        String s3="Hello World";
        String s2;
        String str="Vamos java";
        String s4=s3;


        System.out.println("saludo es igual a=" +s3);
        System.out.println("Despues de hacer s3=null");
        s3=null;
        System.out.println("s4 es igual a s3 " + s4 + " y la referencia de s3 al ser null queda sin referencia");

        System.out.println("srt =" + str);

        System.out.println("\n asignando a saludo=str");
        s2=str;
        System.out.println("Ahora saludo es: " + s2);

    }
}
