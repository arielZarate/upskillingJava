/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones_2.Datos;

import Excepciones_2.Excepciones.AccesoDatosEx;

/**
 *
 * @author ArielZarate
 */


//cambiamos class a interface
public interface AccesoDatos {
    
  public abstract void insertar() throws AccesoDatosEx;  
    public abstract void listar() throws AccesoDatosEx;

      public abstract void simularError(boolean simula) throws AccesoDatosEx;
    
    
}
