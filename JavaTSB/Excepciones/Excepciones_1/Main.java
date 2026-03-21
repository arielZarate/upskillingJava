/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones_1;
/**
 *
 * @author ArielZarate
 */
public class Main {

  
    public static void main(String[] args) {
       
        
        //OBSERVAR que el constructor de la clase division tiene una exception que obliga tratarla
        //por eso el try-catch
//        try{
//           Division d=new Division(10,0); 
//           d.Visualizar();
//        }
//        catch(OperationException oe)
//        {
//            System.out.println("Ha ocurrido un error " );
//            oe.printStackTrace();
//        }
        
        
        
    }
}


/*
 * excepciones TEORIA
 *© 
En esta lección vamos a estudiar el tema de excepciones. Una excepción es una situación no esperada en la ejecución de 
* un programa. Un ejemplo de excepción es por ejemplo, si un argumento es válido o no, si una conversión de tipo de datos 
*  es incompatible, si existe una falla enla conexión a la base de datos, etc.
* 
* Todas las clases en Java descienden de la clase Throwable y posteriormente existen una jerarquía de clases, 
* sin embargo en general existen dos tipos de excepciones con las que vamos a trabajar, las que se conocen 
* como checked exceptions y las uncheked exceptions.
* 
* A) Checked Exceptions o Excepciones que heredan de la clase Exception: Si nuestro programa arroja este tipo
de excepción el compilador solicitará realizar alguna actividad con este tipo de excepción. Más adelante
veremos como procesar una excepción de este tipo, por ejemplo procesarlas dentro de un bloque try/catch o
arrojándolas en la declaración del método. Un ejemplo de este tipo de excepción de tipo checked exception es
la clase SQLException, la cual desciende de la clase Exception y es arrojada cuando existen algún problema con
temas relacionados con el uso y manejo de bases de datos.
* 
* B) Uncheked Exceptions o Excepciones que heredan de la clase RuntimeException: Este tipo de excepciones NO
estamos obligados a procesarlas, por lo que es opcional el uso del bloque try/catch o en la declaración del
método. Este tipo de excepciones también se les conoce como excepciones en tiempo de ejecución. Ejemplos
de este tipo de excepciones son: NullPointerException, ArrayOutOfBoundsException, entre muchas otras.
* 
* Bloque Finally:
* El bloque finally es opcional, pero si se pone, siempre se va a ejecutar, aunque no ocurra la
excepción, por ello es que en ocasiones lo utilizaremos para asegurarnos que
independientemente del problema que ocurra, se ejecute el código del bloque finally.
* 
* 
* 
* Jerarquia
* 
* ***********************Throwable*************************
* 
* ***Error*********     **************Excecption*********************
*                           (todas estas para abajo estamos abligados a tratarlas ya que no son de clase padre)
*                      ****RuntimeException*******      ******IOException*******      *******AWTexception****
*                       **NulPointerException
*                       **IndexOutBoundException
*                       Etc
* 
* 
* 
* RuntimeException es una subclase de la clase Exception, sin embargo el compilador tratará las excepciones
* de manera distinta a todas las excepciones que descienda de la clase RuntimeException, de tal manera
que debemos saber y tener claro esta división y cómo trabajar con cada uno de los tipos de excepción que hemos mencionado.
* Estas serán provocadas por nuestro código o el código de otros que estemos utilizando en nuestro programa
* 
* 
* Las excepciones de tipo Error son las que normalmente son arrojadas por la máquina virtual de Java, por lo
que normalmente serán errores de los que no nos podremos recuperar
* 
* 
* 
* StackTrace
* El stacktrace (traza de la pila de errores) de una excepción es el conjunto de mensajes de error desde el 
* origen del error hasta la última clase que recibe el error. De esta manera es precisamente como su nombre lo dice,
un rastreo del error de la excepción y con ello podemos conocer más fácilmente el origen del error y por lo 
* tanto cómo corregirlo.
* 
* 
* Si una excepción no se atrapa con un bloque try/catch, se propaga la
excepción al método que lo mando llamar, y así sucesivamente hasta que
algún método lo atrapa, o sino el último método que lo recibe (por
ejemplo el método main) arroja finalmente la excepción, terminando de
manera anormal el programa.
 */