/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones_2.Datos;

import Excepciones_2.Excepciones.AccesoDatosEx;
import Excepciones_2.Excepciones.EscrituraDatosEx;
import Excepciones_2.Excepciones.LecturaDatosEx;

/**
 *
 * @author ArielZarate
 */


//implementa todos los metodos de AccesoDatos
public class ImplementacionMySql implements AccesoDatos{

    private boolean simularError=false;
    
    
    @Override
    public void insertar() throws AccesoDatosEx{
        if(simularError)
        {
            throw new EscrituraDatosEx("Error de Escritura de Datos");
        }else{
            System.out.println("Escribir desde MySql");
        }
    }

    @Override
    public void listar() throws AccesoDatosEx {
        if(simularError)
        {
            throw new LecturaDatosEx("Error de Lectura de Datos");
        } else{
            System.out.println("listar desde MySql");
        }
    }

    
    //esta declarado como isSimulaError
  public boolean isSimularError()
  {
      return simularError;
  }
  
  
  
    @Override
    
    //recibe un booleano y si esta true pasa a false y viceversa
    public void simularError(boolean simula) throws AccesoDatosEx {
       this.simularError=simula;
    }

 
    
    
}
