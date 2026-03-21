package Comuna;

import java.util.Calendar;

public class Vehiculo implements Tributable {
    private int id;
    private int modelo;
    private float valor;

    public Vehiculo(int id, int modelo, float valor) {
        this.id = id;
        this.modelo = modelo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", modelo=" + modelo +
                ", valor=" + valor +
                ", impuestos=" + calcularImpuestos() +
                '}';
    }


    @Override
    public float calcularImpuestos() {
        Calendar calendar = Calendar.getInstance();
        int antiguedad = calendar.get(Calendar.YEAR) - modelo;
        if (antiguedad > 20)
            return 0;
        else
            return valor * 1 / 100;
    }
}



