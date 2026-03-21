/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones.Excepciones_1;

/**
 *
 * @author ArielZarate
 */



//HEREDA EXCEPTION
public class OperationException extends Exception
{
    
    
    //construtor
    public OperationException(String mensaje)
    {
        super(mensaje);
    }
    

    
}
