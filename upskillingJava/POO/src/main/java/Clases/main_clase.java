
package Clases;


public class main_clase {


    public static void main(String[] args) {
     
        
        //creo una instancia de la clase 
        
        
        //constructor sin parametros
        Persona personaSinParams=new Persona();
        
        
       personaSinParams.getApellido();  //con el punto (.) puedo acceder a los metodos de la clase 
        
       
       //constructor con parametros 
       Persona p1=new Persona("Ariel","Zarate",37,32785551);
       
       
       //y asi puedo acceder mostrar los datos
        System.out.println("Apellido:" +   p1.getApellido());
        System.out.println("#######Todos los datos########");
        System.out.println(p1.toString());
       
       
    }
    
}
