package Municipio;


public class Remis extends Auto {

    /*
    Los remises también se registran como autos, agregando licencia e
     identificador de agencia a la que pertenecen (un número del 0 al 9).
     */
    private String licencia;
    private int agencia;

    public Remis(String patente, String marca, int modelo, String licencia, int agencia) {
        super(patente, marca, modelo);
        this.licencia = licencia;
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Remis{" +
                "licencia='" + licencia + '\'' +
                ", agencia=" + agencia +
                ", impuestos=" + calcularImpuestos() +
                "\n\t" + super.toString() +
                '}';
    }

    @Override
    public double calcularImpuestos() {
        return (double) super.calcularImpuestos() * 1.10;
    }
}

