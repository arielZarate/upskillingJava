package BuscarOrdenar;

public class Vector {

    private int[] vector;


    //new vector con el tamaño
    public Vector(int tam) {
        this.vector = new int [tam];
    }


    public void generate()
    {
        for (int i = 0; i < vector.length ; i++) {
                //llena el vector de forma aleatoria con unn math de 100
            vector[i] = (int) Math.round(100 * Math.random());
        }
    }


    public void OrderAscendent()
    {
        for (int i = 0; i < vector.length-1 ; i++) {

            for (int j = i+1; j < vector.length; j++) {

                if(vector[i]>vector[j])
                {
                    int aux=vector[i];
                    vector[i]=vector[j];
                    vector[j]=aux;
                }
            }
        }
    }



    /*
      Buscar un elemento x dentro del arreglo (x se ingresa por teclado).
          Si no existe, informarlo. Si existe, cambiar su signo.
     */



    public boolean ExisteElemento(int x)
    {

        boolean estado=false;
        for (int i = 0; i < vector.length; i++) {

            if (x == vector[i])
            {

                estado = true;
               // System.out.println("El vector tiene el  valor:" + vector[i] + " en el indice: " +i);
                break;
            }
            else
            { estado=false;}
        }
        return estado;
    }



    public int CambiarValorANegativo(int x) {
        int nuevoValor = 0;
        for (int pos = 0; pos < vector.length; pos++) {
            if (vector[pos] == x) {
                vector[pos] = vector[pos] * (-1);
                nuevoValor = vector[pos];
                break;
            }

        }
        return nuevoValor;
    }

    public void MostrarVectorForEach()
    {
        for (int x :vector) {
            System.out.print(x+" ");
        }
    }



}
