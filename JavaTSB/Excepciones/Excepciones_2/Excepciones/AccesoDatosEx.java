/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones_2.Excepciones;

/**
 *
 * @author ArielZarate
 */

                                  //podria ser Runtime Exception
public class AccesoDatosEx extends Exception{
    
    
    public AccesoDatosEx(String sms)
    {
        
        //llamo al constructor padre
        super(sms);
    }
}
