package CalendarioYFechas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarioMain {

    public static void main(String[] args) {
        /**
         * Probando la Clase Calendar
         */


        Date date=new Date();

        /**
         * DOS FORMAS DE CREAR OBJETOS
         */
        Calendar c1=Calendar.getInstance();

        c1.set(2021,9,4,8,43,59);



        Calendar c2 = new GregorianCalendar(2016,7,5);


        /*************/
        System.out.println("\t\n  Datos de calendario");




        c1.set(Calendar.YEAR, 2014);
        c1.set(Calendar.MONTH, 10);
        c1.set(Calendar.DATE, 20);
        /**devuelvo los datos*/
        System.out.println("Año: " + c1.get( Calendar.YEAR) );
        System.out.println("Año: " + c1.get( Calendar.MONTH) );
        System.out.println("Año: " + c1.get( Calendar.DATE) );


        //System.out.println("Primer dia de la semana " );
        System.out.println("\nFecha de hoy :" + c1.getTime());

        c1.add(Calendar.DATE, 2);

        System.out.println("Fecha 2 dias mas: "+c1.getTime());

        System.out.println("Esto nos indica si una fecha esta después o antes que otra");
        System.out.println(c1.after(c2));
        System.out.println(c1.before(c2));

        System.out.println("");
        System.out.println("Por último, tenemos el método roll, que tiene un funcionamiento curioso. " +
                "Simplemente, es como add, solo que cuando un campo llega la limite no se modifica los otros. " +
                "Por ejemplo, si aumentamos 22 dias a una fecha y esta llega a mas de 31, el mes no aumentará.");


        System.out.println("Date:" + date);
        System.out.println("\nFecha de hoy: "+c1.getTime());
        c1.roll(Calendar.DATE, 28);

        System.out.println("Fecha añadiendo 28 dias: "+ c1.getTime());


        System.out.println("\nFormato de fechas");
        Date obj=new Date();
        FormateadorSimpleDateFormat(obj);


    }

    public static void FormateadorSimpleDateFormat(Date objDate)
    {
        System.out.println("imprimimos el objeto Date " + objDate);
        String strDateFormat = "hh: mm: ss "; // El formato de fecha está especificado
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        // La cadena de formato de fecha se pasa como un argumento al objeto
        //de formato de fecha
        System.out.println(objSDF.format(objDate)); // El formato de fecha se aplica a la fecha actual

    }


}
