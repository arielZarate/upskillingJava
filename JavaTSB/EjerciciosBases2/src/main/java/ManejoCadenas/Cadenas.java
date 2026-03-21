package ManejoCadenas;

public class Cadenas {



    public boolean ExisteCaracter( String cadena, char c)
    {

        boolean existe=false;
        for (int i = 0; i < cadena.length(); i++) {

            if( cadena.charAt(i)== c )
            {
                //si existe corta
                existe=true; break;

            }

        }
        return existe;
    }


}
