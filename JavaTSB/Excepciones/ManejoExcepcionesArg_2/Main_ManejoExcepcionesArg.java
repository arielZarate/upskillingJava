/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoExcepcionesArg_2;

import Excepciones_1.Division;
import Excepciones_1.OperationException;

/**
 *
 * @author ArielZarate
 */
public class Main_ManejoExcepcionesArg {
    
    
    //
    public static void main(String[] args) throws OperationException
    {
        
        try{
            int op1=Integer.parseInt(args[0]);
             int op2=Integer.parseInt(args[1]);
             
             Division d=new Division(op1,op2);
             d.Visualizar();
        }
        //un bloque catch para cada tipo de error con su excepcion tratada
        catch(ArrayIndexOutOfBoundsException aioe)
        {
            System.out.println("Ocurrio un Error se selleciono un elemento fuera del rango");
           aioe.printStackTrace();
        }
        catch(NumberFormatException nfe){
        System.out.println("Ocurrio un Error se seleciono un elemento no entero");
          nfe.printStackTrace();
    }
     catch(OperationException oe){
         System.out.println("Ocurrio un Error se trato de realizar una operacion erronea");
          oe.printStackTrace();
    }
        
        //se ejecuta siempre el finally no importa si es por try o por el catch
        finally{
            System.out.println("Se terninaron de ver las excepciones");
        }
     
}
}


/*
 * PARA EJECUTARLO IR A LA CARPETA DE INICIO PRINCIPAL : Excepciones (padre de todos los paquetes)
 * 
 * click derecho propiedades 
 * ir a Run (ejecutar)
 * 
 * y en la ventana agregar los parametros
 * 
 * luego ir a aexaminar(browser) y seleccionar el main lanzador desde el cual ejecutara su codigo
 * 
 * guardar todo
 * 
 * por ultimo ejecutar el proyecto desde la clase padre
 */