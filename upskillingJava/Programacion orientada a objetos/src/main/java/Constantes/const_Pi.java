package Constantes;

/**
 * @author :Ariel zarate
 * Pi es una constante matemática que representa la relación entre la circunferencia de un círculo y su diámetro. Su valor aproximado es 3.14159, aunque es un número irracional con infinitas cifras decimales. Pi se utiliza en diversas áreas de las matemáticas, la física y la ingeniería para cálculos relacionados con círculos, esferas y ondas, entre otros fenómenos. Es una de las constantes más importantes y conocidas en el mundo de las ciencias exactas.
 * */
 class Pi {


     /**
      La combinación de static y final para crear una constante.
      La palabra clave static permite que la constante sea accesible sin necesidad de crear una instancia de la clase Pi, lo que significa que se puede acceder a ella directamente a través del nombre de la clase (Pi.PI). La palabra clave final indica que el valor de la constante no puede ser modificado después de su inicialización, asegurando que el valor de Pi permanezca constante a lo largo del programa.
      La palabra clave public hace que la constante sea accesible desde cualquier parte del programa, lo que es útil para una constante como Pi que se utiliza ampliamente en cálculos matemáticos. En resumen, esta declaración define una constante pública, estática y final llamada PI con un valor de 3.14159, que representa el valor aproximado de Pi.
      La palabra final es crucial para garantizar que el valor de Pi no pueda ser alterado accidentalmente en el código, lo que podría llevar a errores en los cálculos que dependen de esta constante. Al ser estática, se puede acceder a ella sin necesidad de crear una instancia de la clase Pi, lo que facilita su uso en cualquier parte del programa.

      * */
   public static final double PI = 3.14159;  //TODO: ya se que java tiene su propia constante Math.PI, pero esto es solo un ejemplo de cómo definir una constante personalizada.



    public static void main(String[] args) {
        System.out.println("El valor de Pi es: " + Pi.PI);
    }

}

