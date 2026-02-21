package POO.Matrices;

public class Main {
    public static void main(String[] args) {

        SumaRestaMatrices sr = new SumaRestaMatrices();

        sr.mostrarMatriz1();
        sr.mostrarMatriz2();


        sr.SumarMatriz();

        System.out.println("\nResultado de la suma\n");
        sr.mostrarResultadoMatriz();



        sr.RestarMatriz();
        System.out.println("\nResultado de la Resta\n");
        sr.mostrarResultadoMatriz();


    }
}
