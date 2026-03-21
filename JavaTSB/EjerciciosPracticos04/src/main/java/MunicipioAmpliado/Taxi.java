package MunicipioAmpliado;
public class Taxi extends Auto{
    private String licencia;

    public Taxi(String patente, String marca, int modelo, String licencia) {
        super(patente, marca, modelo);
        this.licencia = licencia;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Taxi{");
        sb.append(super.toString());
        sb.append(" licencia='").append(licencia).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcularImpuestos() {
        return super.calcularImpuestos() + 150;
    }
}