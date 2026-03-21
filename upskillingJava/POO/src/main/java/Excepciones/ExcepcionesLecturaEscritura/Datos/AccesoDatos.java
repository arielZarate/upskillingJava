/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones.ExcepcionesLecturaEscritura.Datos;

import excepciones.ExcepcionesLecturaEscritura.Excepciones.AccesoDatosExcepciones;

/**
 * @author ArielZarate
 */


// interface
public interface AccesoDatos {


  //este es el contrato
  public abstract void insertar() throws AccesoDatosExcepciones;
    public abstract void listar() throws AccesoDatosExcepciones;
    public abstract void simularError(boolean simula);
    
    
}
