package Genericos.ManejoGenericos;


//una clase generica es una clase que puede ser usada con cualquier tipo

  public class ClaseGenerica<Tipo>{

      Tipo objeto;

      public ClaseGenerica(Tipo objeto)
      {
          this.objeto=objeto;
      }

      public void ObtenerTipo(){
          System.out.println("El tipo  T es de: " + objeto.getClass().getName());
      }

  }













/*

//Definimos una clase generica con el operador diamante <>
public class ClaseGenerica<T> {
    //Definimos una variable de tipo generico
    T objeto;

    //Constructor que inicializa el tipo a utilizar
    public ClaseGenerica(T objeto) {
        this.objeto = objeto;
    }

    public void obtenerTipo() {
        System.out.println("El tipo T es: " + objeto.getClass().getName());
    }
}
* */