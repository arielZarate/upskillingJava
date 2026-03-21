/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones.Excepciones.Excepciones_2.Datos;

import excepciones.ExcepcionesLecturaEscritura.Datos.AccesoDatos;
import excepciones.ExcepcionesLecturaEscritura.Excepciones.AccesoDatosExcepciones;
import excepciones.ExcepcionesLecturaEscritura.Excepciones.EscrituraDatosExcepciones;
import excepciones.ExcepcionesLecturaEscritura.Excepciones.LecturaDatosExcepciones;


/**
 *
 * @author ArielZarate
 */


//implementa todos los metodos de AccesoDatos
public class ImplementacionMySql implements AccesoDatos {

    private boolean simularError=false;
    

    //esto es solo una simulacion en realidad deberia llamar a la bd desde aca o al modelo


    @Override
    public void insertar() throws AccesoDatosExcepciones {
        if(simularError)
        {
           throw new EscrituraDatosExcepciones("Error de Escritura de Datos");
        }else{
            System.out.println("Escribir desde MySql");
        }
    }

    @Override
    public void listar() throws AccesoDatosExcepciones {
        if(simularError)
        {
            throw new LecturaDatosExcepciones("Error de Lectura de Datos");
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
    public void simularError(boolean simula) {
       this.simularError=simula;
    }


}
