
package Polimorfismo;

/**
 *
 * @author ariel
 */
public class mainPolimorfimo {

   /*
    
    
El polimorfismo es un concepto fundamental en la programación orientada a objetos (POO) 
    que se refiere a la capacidad de un objeto para presentar diferentes comportamientos 
    o formas según el contexto en el que se encuentre. Esto significa que un objeto puede 
    comportarse de varias maneras diferentes dependiendo de cómo se le llame o qué tipo 
    de objeto se espera que sea.

Hay dos tipos principales de polimorfismo:

Polimorfismo de subtipos (herencia): Se refiere a la capacidad de una clase hija para sobrescribir
    los métodos de una clase padre para proporcionar su propia implementación. 
    Esto permite que un objeto de la clase hija se utilice donde se espera un objeto de la clase padre,
    y el comportamiento real será el de la clase hija. Esto se logra mediante el uso de la herencia 
    y la anulación (override) de métodos.

Polimorfismo paramétrico (sobrecarga y sobreescritura): Se refiere a la capacidad de una función
    o método para aceptar argumentos de diferentes tipos y realizar diferentes acciones 
    dependiendo del tipo de argumento que se le pase. Esto puede lograrse mediante la 
    sobrecarga de métodos (métodos con el mismo nombre pero diferentes parámetros)
    y la sobreescritura de métodos (anulación) en clases hijas.

El polimorfismo es una característica poderosa de la POO que permite escribir código más flexible, 
    reutilizable y fácil de mantener. Permite trabajar con objetos de manera más abstracta
    y genérica, lo que facilita la creación de sistemas complejos y escalables.
    
    
    */
    public static void main(String[] args) {
      
        
        //un ejemplo de polimorfismo de herencia fue la clase toString() que heredamos de la clase padre 
        //con esta ademas de mostrar los datos de la clase padre pudimos reescribir con datos nuestros
        
        
     Empleado e = new Empleado(4646, 250.576, "Ariel", "Zarate", 37, 32785551);
     
        System.out.println(e.toString());
        
        //ojo pero como empleado es de una forma una persona yo podria hacer esto
        
        
        Persona vector[]=new Persona [3];  //vector de tipo Persona
        
        vector[0]=new Persona();
        vector[1]=new Empleado();
        vector[2]=new Estudiante();
        
        //puedo crear objetos de tipo Empleado y Estudiante poreque heredan de la clase padre 
        
       // vector[3]="hola"  //esto da error no se puede hacer 
       //tapoco puedo crear clase padre con clase hija
       
      Persona per1=new Persona();
      Empleado e2=new Empleado();
      //esto es valido
      per1=e2;  
      
      //pero esto no solo si lo Casteo o aplico casting
      
      e2=(Empleado) per1;
     

      
      
      //mostramos los datos
        for (Persona persona : vector)
        {
            System.out.println(persona.toString());
        }
        
    }
    
}
