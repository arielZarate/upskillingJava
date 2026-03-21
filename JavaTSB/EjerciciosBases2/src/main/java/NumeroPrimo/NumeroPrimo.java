package NumeroPrimo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class NumeroPrimo {

    private double num;

    public NumeroPrimo() {

    }



    /**
     * @param
     * @return esPrimo funcion auxiliar
     */
    public boolean esPrimo(double numero) {
   boolean esPrimo = false;

            // El 0, 1 y 4 no son primos
            if (numero == 0 || numero == 1 || numero == 4 || numero < 0) {

               return false;
            }
            for (int x = 2; x < numero / 2; x++) {

                if ((numero % x) == 0)
                return  false;

            }
            // Si no se pudo dividir por ninguno de los de arriba, sí es primo


                return true;


    }


    public double PrimerNumeroPrimo(double [] vector)
    {

        double val=0.0;
        try {
            for (int i = 0; i < vector.length; i++) {

                if(vector== null || vector.length==0)
                {
                    System.out.println("El vector esta vacio: " + vector.length);
                }
                if(esPrimo(vector[i]))
                {
                    val=vector[i];
                    System.out.println("El primer nº primo es el numero " + vector[i]); break;

                }
                else{
                    //System.out.println("El numero " + vector[i] + " no es primo" );
                    val=-1.0;
                }

            }
        } catch (InputMismatchException ex ) {
            System.out.println("Error:" + ex.getMessage());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return val;
    }

    public void esPrimoVector(double [] vector){

        try {
            for (int i = 0; i < vector.length; i++) {

                if(vector== null || vector.length==0)
                {
                    System.out.println("El vector esta  vacio");
                }
                if(esPrimo(vector[i]))
                {
                    System.out.println("Es primo el numero " + vector[i]);

                }
                else{
                    System.out.println("El numero " + vector[i] + " no es primo" );
                }

            }
        } catch (InputMismatchException ex ) {
            System.out.println("Error:" + ex.getMessage());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }



}

