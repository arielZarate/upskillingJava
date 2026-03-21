/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones_2;

import Excepciones_2.Datos.AccesoDatos;
import Excepciones_2.Datos.ImplementacionMySql;
import Excepciones_2.Excepciones.AccesoDatosEx;
import Excepciones_2.Excepciones.EscrituraDatosEx;
import Excepciones_2.Excepciones.LecturaDatosEx;

/**
 *
 * @author ArielZarate
 */
public class Main {
    
    public static void main(String[] args) throws AccesoDatosEx {
        
        
        
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
    private static void Ejecutar(AccesoDatos datos,String accion) throws AccesoDatosEx
  {
   if(accion.equals("listar"))
   {
   
       try{
           datos.listar();
       }
       
       //DE ACUERDO A1L TIPO DE ERROR PRODUCIDO BUSCARA ELTIPO DE EXCEPCION CORRECTA Y LANZARA SU CORRESPONDIENTE MENSAJE
       //DEJAMOS DECLARADO QUE LA JERARQUIA DE EXCEPCIONES EMPIEZA DESDE LA MAS PARTICULAR A LA MAS GRAL O MAS ALTA1
       
       catch(LecturaDatosEx ex)
       {
           System.out.println("Error Lectura");  
       }
        catch(AccesoDatosEx ex)
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
       
         catch(EscrituraDatosEx ex)
        {
           System.out.println("Error Escritura");  
         }
        catch(AccesoDatosEx ex)
        {
           System.out.println("Error AccesoDatos");  
        }
      
       finally{
           System.out.println("ProcesarFinally es opcional");
        }
     }
        else System.out.println("No se proposiono ninguna accion reconocida");
      
    }
    
    
    
    
    
}
