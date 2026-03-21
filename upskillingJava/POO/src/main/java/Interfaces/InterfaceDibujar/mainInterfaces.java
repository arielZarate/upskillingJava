
package interfaces.InterfaceDibujar;


public class mainInterfaces {


    public static void main(String[] args) {
  
        
        Circulo cir=new Circulo (5);
        
        
        System.out.println(cir.calcularArea());
         cir.dibujar();
         cir.rotar();
        
        Cuadrado cua=new Cuadrado (4);
        
        
        System.out.println(cua.calcularArea());
        cua.dibujar();
        
    }
    
}
