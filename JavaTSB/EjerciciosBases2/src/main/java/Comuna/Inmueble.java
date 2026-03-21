package Comuna;

public class Inmueble implements Tributable {
    private int id;
    private float terreno;
    private float cubiertos;

    public Inmueble(int id, float terreno, float cubiertos) {
        this.id = id;
        this.terreno = terreno;
        this.cubiertos = cubiertos;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "id=" + id +
                ", terreno=" + terreno +
                ", cubiertos=" + cubiertos +
                ", impuestos=" + calcularImpuestos() +
                '}';
    }

    @Override
    public float calcularImpuestos() {
        return 20 * terreno + 50 * cubiertos;
    }
}

