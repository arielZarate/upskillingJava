
package clasesAbstractas;

/**
 *
 * @author ariel
 */


//esta clase heredara la clase figura 
public class Circulo extends Figura{


    private double radio;

    public Circulo( double radio, double x, double y) {
        super(x, y);
     
        this.radio = radio;
    }

    
    //aca yo reescribo el metodo asbtracto definido en figura
    @Override
    public double calcularArea() {
     //pow recibe el el primer params el radio y el segundo es la potencia elevada
     
        double pi=Math.PI;
        double area=pi* Math.pow(radio,2);
        return area;
        
    }
    
}
