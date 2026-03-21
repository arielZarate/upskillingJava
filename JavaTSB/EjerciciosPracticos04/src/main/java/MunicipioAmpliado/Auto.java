package MunicipioAmpliado;

import java.util.Calendar;

public class Auto {
    private String patente;
    private String marca;
    private int modelo;

    public Auto(String patente, String marca, int modelo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Auto{");
        sb.append("patente='").append(patente).append('\'');
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", modelo=").append(modelo);
        sb.append(", impuestos=").append(calcularImpuestos());
        sb.append('}');
        return sb.toString();
    }

    public double calcularImpuestos()
    {
        Calendar calendar = Calendar.getInstance();
        int antiguedad = calendar.get(Calendar.YEAR) - modelo;
        if (antiguedad >= 20)
            return 0;
        else
        if (antiguedad >= 10)
            return 150;
        else
            return 200;
    }

    public int getModelo() {
        return modelo;
    }
}
