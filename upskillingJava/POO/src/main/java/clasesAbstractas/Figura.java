


/*
Las clases abstractas en Java son una forma de crear clases que no se pueden instanciar directamente
, pero pueden ser utilizadas como base para otras clases. 


# aunque sea un solo de su metodo debe ser abstracto 
#solo declaro la firma (solo digo que hacer)
   -public abstract void dibujar();

#si un metodo es abstracto la clase debe ser abstracta
# una clase no puede heredar mas de una clase abstracta 


¿Cómo se usan las clases abstractas?

Para utilizar una clase abstracta, debes crear una subclase que extienda la clase abstracta. 
En la subclase, debes proporcionar implementaciones para todos los métodos abstractos de la clase abstracta. Una vez que hayas implementado todos los métodos abstractos, puedes crear objetos de la subclase.
*/




package clasesAbstractas;


public abstract class Figura //declaramos la clase abstracta
{
 protected double x;
 protected double y;

    public Figura(double x, double y) {
        this.x = x;
        this.y = y;
    }
 
 
 
 //metodo abstracto
 public abstract double calcularArea();
    
}
