package Excepciones;

public class Main {
    public static void main(String[] args) {

       //DESCOMENTAR Y PROBAR CADA CASO

        //TODO: 1 CASO ,  CAPTURAMOS Y RETORNAMOS CON UN THROW Y LO ENVOLVEMOS CON UN CUSTOM EXCEPTION
        //  System.out.println(Operaciones.divide(12, 0));



        //TODO: 2 CASO  ACA CAPTURO YO EL ERROR PROPAGADO DEL METODO , PERO ORIGINALMENTE ES ARITHMETIC EXCEPTION
//        try {
//            System.out.println(Operaciones.divideV2(20, 0));
//        } catch (ArithmeticException e) {
//            System.out.println("Caso 2 Error de operacion Arithmetic Esception retorna " + e.getMessage());
//        }

        //TODO: 3 CASO, ACA YA CAPTURO CON TRY CATCH PERO DESDE EL METODO ENVOILVEMOS EL ERROR CON UN OPERACION EXCEPTION PARA QUE LLEGUE ASI

        try {
            System.out.println(Operaciones.divideV3(20, 0));
        } catch (OperacionExcepcion e) {
            System.out.println("Caso 3 Error de operacion propagado y con exception customizada  " + e.getMessage());
            System.out.println("Causa " +e.getCause());
        }

    }
}
