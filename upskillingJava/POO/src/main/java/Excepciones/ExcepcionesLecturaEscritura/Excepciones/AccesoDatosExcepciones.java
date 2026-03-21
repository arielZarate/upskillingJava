/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones.ExcepcionesLecturaEscritura.Excepciones;

/**
 @author ArielZarate
 */


//ESTA ES LA CLASE QUE MANEJA LA EXCEPCION

                                  //podria ser Runtime Exception
public class AccesoDatosExcepciones extends Exception{
    
    
    public AccesoDatosExcepciones(String mensaje)
    {
        //llamo al constructor padre
        super(mensaje);
    }
}
