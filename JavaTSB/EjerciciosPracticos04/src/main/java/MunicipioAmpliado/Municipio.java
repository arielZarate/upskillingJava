package MunicipioAmpliado;

public class Municipio {

    
    private Auto vehiculos[];

    public Municipio() {
        vehiculos = new Auto[5];
        vehiculos[0] = new Auto("AB 123 JJ", "Fiat", 2016);
        vehiculos[1] = new Taxi("AB 888 BB", "Fiat", 2014, "T1234");
        vehiculos[2] = new Remis("AC 456 JJ", "Honda", 2010, "R7890", 1);
        vehiculos[3] = new Taxi("AC 788 AB", "Ford", 2015, "T7412");
        vehiculos[4] = new Remis("AC 456 ZZ", "Fiat", 2011, "R1234", 2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Auto a : vehiculos) {
            sb.append("\n" + a.toString());
        }
        return sb.toString();
    }

    public Auto buscarMayorImpuesto() {
        Auto mayor = vehiculos[0];
        for (int i = 1; i < vehiculos.length; i++) {
            if (vehiculos[i].calcularImpuestos() > mayor.calcularImpuestos())
                mayor = vehiculos[i];
        }
        return mayor;
    }

    public String mostrarTaxisViejos(int anio) {
        StringBuilder sb = new StringBuilder();
        for (Auto a : vehiculos) {
            if (a.getModelo() < anio && a instanceof Taxi)
                sb.append("\n" + a.toString());
        }
        return sb.toString();
    }

    public String mostrarRemisesDeAgencia(int agencia) {
        StringBuilder sb = new StringBuilder();
        for (Auto a : vehiculos) {
            if (a instanceof Remis) {
                Remis r = (Remis) a;
                if (r.getAgencia() == agencia)
                    sb.append("\n" + a.toString());
            }
        }
        return sb.toString();

    }
}
