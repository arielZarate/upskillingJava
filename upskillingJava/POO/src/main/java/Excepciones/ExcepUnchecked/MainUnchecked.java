package excepciones.ExcepUnchecked;





/*
: Subclases de `RuntimeException`. Estas
no están obligadas a ser capturadas o declaradas y suelen ser errores en el código del programador
* */



public class MainUnchecked  {

    public static void main(String[] args) {

      try{
      int [] arr= new int[3];

      arr[5]=10;
      }catch(ArrayIndexOutOfBoundsException | NullPointerException e){

          System.out.println("Exception atrapada " + e.getMessage());
      }
      finally {
          System.out.println("ESte bloque se ejecuta siempre");
      }


    }
}
