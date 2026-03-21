package SalaReuniones;

import java.util.ArrayList;
import java.util.Iterator;


public class Sala implements Comparable<Sala> {
  /*
    Programar una clase Sala que represente una sala de reuniones.
    La misma debe poseer un número que la identifica
    y un conjunto de reuniones que se desarrollan en ella.
    Cada reunión tiene un horario de inicio planificado (formato hhmm)
    y un grupo de participantes(personas).
   */


    private int num;
    private ArrayList<Reunion> reuniones;

    public Sala() {
    }


    public Sala(int num, ArrayList<Reunion> reunion) {
        this.num = num;
        this.reuniones = reunion;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ArrayList<Reunion> getReunion() {
        return reuniones;
    }


    /**
     * @retur Este metodo devuelve la cant de reuniones
     */
    public int cantidadReuniones() {
        return reuniones.size();
    }


    @Override
    public String toString() {
        String res="";

        res+= "\nSala{" +
                "num=" + num +
                 ","+reuniones +
                '}' +"\n";
        return res;

    }


    public Reunion DatosUltimaReunion()
    {
        Reunion reunion=null;
        for (int i = 0; i < reuniones.size(); i++) {

            if(i==reuniones.size()-1)
            {
               reunion=reuniones.get(i);

            }

        }
        return reunion;
    }

    @Override
    public int compareTo(Sala otraSala) {
        if (otraSala.getNum() > this.getNum()) {
            return 1;
        } else if (otraSala.getNum() == this.getNum()) {
            return 0;
        } else {
            return -1;
        }
    }
}
