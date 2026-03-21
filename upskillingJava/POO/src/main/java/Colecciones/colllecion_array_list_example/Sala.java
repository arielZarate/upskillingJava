package array_list;

import java.util.List;

public class Sala{
  /*
    Programar una clase Sala que represente una sala de reuniones.
    La misma debe poseer un número que la identifica
    y un conjunto de reuniones que se desarrollan en ella.
    Cada reunión tiene un horario de inicio planificado (formato hhmm)
    y un grupo de participantes(personas).
   */




    private int num; //numero de sala
    private List <Reunion> reuniones;   //realcion 1 a N  es decir una sala tiene N reuniones

    public Sala(){}



    public Sala(int num, List <Reunion> reunion) {
        this.num=num;
        this.reuniones=reunion;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Reunion> getReunion() {
        return reuniones;
    }


    /**
     *
     * @retur
     *Este metodo devuelve la cant de reuniones
     */
    public  int cantidadReuniones() {

        int cont =0;
        for (int i = 0; i < reuniones.size(); i++) {
            cont ++;
        }
        return cont;
    }


    @Override
    public String toString() {
        return "Sala{" +
                "num=" + num +
                ", reunion=" + reuniones +
                '}';
    }
}
