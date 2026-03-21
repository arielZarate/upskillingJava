package Municipio;



    public class Taxi extends Auto {
        //Los taxis se registran como autos, agregando además un número de licencia de taxi.
        private String licencia;

        public Taxi(String patente, String marca, int modelo, String licencia) {
            super(patente, marca, modelo);
            this.licencia = licencia;
        }

        @Override
        public String toString() {
            return   super.toString() +"\n\t"+
                    "Taxi{" +
                    "licencia='" + licencia + '\'' +
                    ", impuestos=" + calcularImpuestos() +

                    '}';
        }

        @Override
        public double calcularImpuestos() {
            return super.calcularImpuestos() + 150;
        }
    }


