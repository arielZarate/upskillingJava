package Excepciones;

public class Operaciones {


    //TODO: CASO 1
    public static int divide(int a, int b) {
        if (b == 0) throw new OperacionExcepcion("caso 1 throw: No se puede dividir por cero");
        return a / b;
    }


    //TODO: CASO 2
    //voy a PROPAGAR el Error en el Main pero lanza ArithmeticException no OperacionException el throw no transforma la exception
    public static int divideV2(int a, int b) throws ArithmeticException {
        return a / b;
    }


    //TODO: CASO 3

    //Aca voy a devolver un OperacionExcepcion pero para eso debo envolverlo porque sale Arithmetic
    //voy a PROPAGAR  el Error en el Main con  OperacionException y lo  transformo en el catch
    public static int divideV3(int a, int b) throws OperacionExcepcion {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            //TODO:ATENCION CAPTURO Y TRANSFORMO
            throw new OperacionExcepcion("Error", e);
        }
    }


}
