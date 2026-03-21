package Herencia;



/**
 *
 * @author ariel
 */
public class main {

    public static void main(String[] args) {
        //legajo-sueldo-nombre-apellido-edad-dni
        Empleado e = new Empleado(4646, 250.576, "Ariel", "Zarate", 37, 32785551);

        //PUEDO MODIFICAR LOS DATOS TAMBIEN
        e.setNombre("juan"); //modificamos el nombre
        e.setApellido("Torres");//modifcamos el apellido

        //mostramos 
        System.out.println(e.toString());

        //podriamos crear nuevos objetos 
        Empleado e2 = new Empleado(434, 89054, "Ariel", "Zarate", 35, 32455551);

        System.out.println(e2.toString());
        
        
        System.out.println("");
        //ahgora creamos estudiantes
        
        Estudiante e1=new Estudiante("3K5","Sistemas" ,8.75,"Jorge" ,"Santos" ,60525,78974564);

       // mostramos datos
        System.out.println(e1.toString());
        
    }

}
