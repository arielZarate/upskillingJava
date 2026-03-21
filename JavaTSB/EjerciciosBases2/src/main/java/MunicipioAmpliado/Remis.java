package MunicipioAmpliado;


public class Remis extends Auto{
    private String licencia;
    private int agencia;

    public Remis(String patente, String marca, int modelo, String licencia, int agencia) {
        super(patente, marca, modelo);
        this.licencia = licencia;
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Remis{");
        sb.append(super.toString());
        sb.append(" licencia='").append(licencia).append('\'');
        sb.append(", agencia=").append(agencia);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcularImpuestos() {
        return super.calcularImpuestos()*1.1;
    }

    public int getAgencia() {
        return agencia;
    }
}



