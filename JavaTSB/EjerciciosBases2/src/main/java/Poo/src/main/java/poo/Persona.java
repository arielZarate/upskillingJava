package poo;

public class
Persona {
    private String nombre;

    private String apellido;
    private int nacimiento;


    public Persona(String name,String lastName,int age ) {
        this.nombre=name;
        this.apellido=lastName;
        this.nacimiento=age;

    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacimiento=" + nacimiento +
                '}';
    }



    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;

    }

}
