package ManejoFechas;

import java.text.SimpleDateFormat;
import java.util.Date;
public class FechasMain {

    public static void main(String[] args) {


                Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate

                System.out.println("imprimimos el objeto Date " + objDate);
                String strDateFormat = "hh: mm: ss dd-MMM-yyyy"; // El formato de fecha está especificado
                SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
                // La cadena de formato de fecha se pasa como un argumento al objeto
                //de formato de fecha
                System.out.println(objSDF.format(objDate)); // El formato de fecha se aplica a la fecha actual

            }
        }


