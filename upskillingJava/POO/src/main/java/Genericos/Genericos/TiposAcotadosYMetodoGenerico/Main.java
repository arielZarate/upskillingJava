package Genericos.TiposAcotadosYMetodoGenerico;


public class Main{


    public static void main(String[] args) {

       ClaseGenerica<Integer> listaNumber=new ClaseGenerica<>(14);

       listaNumber.ObtenerTipo();


        System.out.println("************Ahora con un metodo generico que muestre el tipo**********+");

        listaNumber.metodoGenericoObtenerTipo("Hola");



    }


}



//creao una clase Generica
 class ClaseGenerica<Tipo extends Number> {

    Tipo objeto;

    public ClaseGenerica(Tipo objeto) {
        this.objeto = objeto;
    }



    public void ObtenerTipo() {
        System.out.println("El tipo  T es de: " + this.objeto.getClass().getName());
    }


    public <Tipo> void metodoGenericoObtenerTipo(Tipo Tipoobjeto)
    {
        System.out.println("El tipo  T es de: " + Tipoobjeto.getClass().getName());
    }

}

