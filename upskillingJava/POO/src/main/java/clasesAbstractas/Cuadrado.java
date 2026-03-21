/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesAbstractas;

/**
 *
 * @author ariel
 */
public class Cuadrado extends Figura {

    private double ladoA;


    public Cuadrado(double ladoA, double x, double y) {
        super(x, y);
        this.ladoA = ladoA;
    }



 
 
    @Override
    public double calcularArea() {
      double  area = ladoA * ladoA;
      
      return area;
    }
    
}
