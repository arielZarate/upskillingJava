package CalendarioYFechas;

import java.text.SimpleDateFormat;
import java.util.*;

public class ClaseOrdenada {
    public static void main (String[] args) {
            List<String> dateArray = new ArrayList<String>();
            dateArray.add("2020-03-25");
            dateArray.add("2019-01-27");
            dateArray.add("2020-03-26");
            dateArray.add("2020-02-26");
            System.out.println("The Object before sorting is : "
                    + dateArray);
            dateArray.sort((d1,d2) -> d1.compareTo(d2));
            System.out.println("The Object after sorting is : "
                    + dateArray);
        }




    public static String Formateador(Calendar obj)
    {
        Date hora=obj.getTime();



        String srt= new SimpleDateFormat("HH:mm").format(hora);
        return srt;
    }
    }


