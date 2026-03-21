package interfaces.InterfaceDibujar;

/**
 *
 * @author ariel
 */
//esta clase heredara la clase figura 
public class Circulo implements Figura, Dibujable, Rotable {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    //aca yo reescribo el metodo asbtracto definido en figura
    @Override
    public double calcularArea() {
        //pow recibe el el primer params el radio y el segundo es la potencia elevada

        double pi = Math.PI;
        double area = pi * Math.pow(radio, 2);
        return area;

    }

    
    //metodo de la interface Dibujable
    @Override
    public void dibujar() {
        System.out.println("Estoy dibujando un circulo");
    }

    
    //metodo de la interface Rotable
    @Override
    public void rotar() {
        System.out.println("Estoy rotando el circulo");
    }

}
