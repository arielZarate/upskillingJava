package InterfazFunccional_T_R;

/*
Function<T, R>
La interfaz funcional `Function<T, R>` representa una función que toma un argumento de tipo `T` y
devuelve un resultado de tipo `R`. Tiene un método llamado `apply`.


Osea  toma un parametro de tipo Int y devuelve String
* */
import java.util.function.Function;

public class MainFuncionalTR {
    public static void main(String[] args) {

        Function<Integer,String> intToString=(num)->"El valor es :"+ num;

        String result=intToString.apply(42);
        System.out.println(result);
    }
}
