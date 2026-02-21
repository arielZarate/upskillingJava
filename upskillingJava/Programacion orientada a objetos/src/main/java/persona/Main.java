package programacionOrientadaaObjetos.persona;

/**
 @author : Ariel Zarate

 * */

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan", 25,"132161154");
        p1.mostrarInfo();
        p1.setEdad(38);
        System.out.println("Edad actualizada: "+ p1.getEdad());
    }
}
