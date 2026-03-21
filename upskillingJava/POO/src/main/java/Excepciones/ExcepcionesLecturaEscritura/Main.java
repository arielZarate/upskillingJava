/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones.ExcepcionesLecturaEscritura;

import excepciones.Excepciones.Excepciones_2.Datos.ImplementacionMySql;
import excepciones.ExcepcionesLecturaEscritura.Datos.AccesoDatos;
import excepciones.ExcepcionesLecturaEscritura.Excepciones.AccesoDatosExcepciones;
import excepciones.ExcepcionesLecturaEscritura.Excepciones.EscrituraDatosExcepciones;
import excepciones.ExcepcionesLecturaEscritura.Excepciones.LecturaDatosExcepciones;

/**
 *
 * @author ArielZarate
 */
public class Main {
    
    public static void main(String[] args) throws AccesoDatosExcepciones {
        
        
        
        //ATENTO ACA creamos un OBEJTO DE TIPO MYSQL
        AccesoDatos datos=new ImplementacionMySql();
        datos.simularError(false);
        
       //ESTE METODO ES PRIVADO Y ESTATICO (NO SE CREA IUNSTANCIA) Y EJECUTA CIERTA FUNCIONALIDAD
        Main.Ejecutar(datos,"listar");
     
         datos.simularError(false);
         System.out.println("");
 
        Main.Ejecutar(datos,"listar");
    } 
    
    
    
    
    
    
    //METODO PRIVADO ESTATICO RECIBE 2 PARAMETROS
    private static void Ejecutar(AccesoDatos datos, String accion) throws AccesoDatosExcepciones
  {
   if(accion.equals("listar"))
   {
   
       try{
           datos.listar();
       }
       
       //DE ACUERDO A1L TIPO DE ERROR PRODUCIDO BUSCARA ELTIPO DE EXCEPCION CORRECTA Y LANZARA SU CORRESPONDIENTE MENSAJE
       //DEJAMOS DECLARADO QUE LA JERARQUIA DE EXCEPCIONES EMPIEZA DESDE LA MAS PARTICULAR A LA MAS GRAL O MAS ALTA1
       
       catch(LecturaDatosExcepciones ex)
       {
           System.out.println("Error Lectura");  
       }
        catch(AccesoDatosExcepciones ex)
       {
           System.out.println("Error AccesoDatos");  
       }
        catch(Exception ex)
       {
           System.out.println("Error gral Exception");  
       }
       finally{
           System.out.println("ProcesarFinally es opcional");
       }
   }
   
   else 
       if(accion.equals("insertar"))
    {
       try{
           datos.insertar();
       }
       
         catch(EscrituraDatosExcepciones ex)
        {
           System.out.println("Error Escritura");  
         }
        catch(AccesoDatosExcepciones ex)
        {
           System.out.println("Error AccesoDatos");  
        }
      
       finally{
           System.out.println("Procesar Finally es opcional");
        }
     }
        else System.out.println("No se proposiono ninguna accion reconocida");
      
    }
    
    
    
    
    
}
