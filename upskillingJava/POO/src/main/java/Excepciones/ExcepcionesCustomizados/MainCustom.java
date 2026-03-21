package excepciones.ExcepcionesCustomizados;

/*
*
* Excepciones customizadas
En Java, tenemos la flexibilidad de crear nuestras propias excepciones personalizadas al extender la clase
base Exception. Esto nos permite definir nuestras propias excepciones que se adaptan específicamente a
las necesidades de nuestro programa y nos brindan un mayor control sobre el manejo de errores. Veamos
un video introductorio al tema y después, veremos algunas consideraciones https://youtu.be/v43Tl9dM_PE
La personalización de excepciones es especialmente útil cuando queremos capturar y manejar situaciones
excepcionales que son específicas de nuestro programa o dominio. Por ejemplo, si estamos desarrollando
una aplicación bancaria, podríamos definir una excepción personalizada llamada
`SaldoInsuficienteException` para manejar los casos en los que un cliente intenta realizar una transacción
con un saldo insuficiente en su cuenta.
*
*
* Al crear nuestras excepciones personalizadas, podemos agregar información adicional y mensajes
descriptivos que ayuden a comprender la causa del error. Esto es útil tanto para los desarrolladores que
trabajarán con nuestro código como para los usuarios finales que puedan encontrar estas excepciones.
* */




public class MainCustom {
    public static void main(String[] args) {

        try {
            validarEdad(15);
        } catch (CustomException e) {
            System.err.println("Error: " + e.getMessage());
            // Aquí puedes manejar la excepción de acuerdo a tus necesidades
        }
    }

    public static void validarEdad(int edad) throws CustomException {
        if (edad < 18) {
            throw new CustomException("La persona debe ser mayor de edad.");
        }
        // Código adicional si la validación es exitosa


    }

}