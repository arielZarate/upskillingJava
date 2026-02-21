package POO.Matrices;

public class MainMultMatric {
    public static void main(String[] args) {
        MultiplicacionMatrices mm=new MultiplicacionMatrices();

        mm.inicializarMatrices();

        mm.cargarMatrices();

        mm.mostrarMa1();
        System.out.println("");
        mm.mostrarMa2();

        mm.multiplicarMatrices();
        mm.mostrarMatrizResultante();
    }
}
