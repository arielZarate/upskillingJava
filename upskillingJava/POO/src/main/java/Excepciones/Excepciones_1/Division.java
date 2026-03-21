/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones.Excepciones_1;

/**
 *
 * @author ArielZarate
 */
public class Division {
    
    
    private int numerador ,denominador;
    
    
    
    //le decimos que este metodo puedo lanzar un tipo de Exception OperationException
    //OJO CON EL THROWS  VA CON LA S AL FINAL
    public Division(int num,int den) throws OperationException
    {
        
        if(den==0)
        {
            //si es cero lanzo la exception especializada 
            throw new OperationException("Denominador igual a cero");
        }
        else{
        this.numerador=num;
        this.denominador=den;        
        }
    }
    
    
    
      public void Visualizar()
    {
        System.out.println("El Resultado de la operacion es: " + this.numerador/this.denominador);
    }
}
