
package interfaces.InterfaceDibujar;

/**
 *
 * @author ariel
 */
public class Cuadrado implements Figura ,Dibujable {

    private double ladoA;

    public Cuadrado(double ladoA) {
        this.ladoA = ladoA;
    }
    //metodo de la interface Figura
    @Override
    public double calcularArea() {
        double area = ladoA * ladoA;

        return area;
    }

    //metodo de la interface Dibujable
    @Override
    public void dibujar() {
        System.out.println("Estoy dibujando un cudrado");
        
    }

}
