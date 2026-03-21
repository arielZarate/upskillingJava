
package clasesAbstractas;

/**
 *
 * @author ariel
 */
public class mainAbstractas {


    public static void main(String[] args) {
      
        
        //ejecutamos la clase 
        
                            //radio - x, y
        
        Circulo cir=new Circulo(234, 4,6);
        Cuadrado cua=new Cuadrado(234, 2,7);
        
        
        
        System.out.println("Area del circulo \t" +cir.calcularArea());
        System.out.println("Area de cuadrado\t"+cua.calcularArea());
        
    }
    
}
