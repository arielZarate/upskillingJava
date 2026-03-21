package PolimorfismoMio;

public class Pescado extends Animal{
    private String tipoAgua="";


    public Pescado(String name, String poder, String habitat, String tipoAnimal, String tipoAgua) {
        super(name, poder, habitat, tipoAnimal);
        this.tipoAgua = tipoAgua;
    }

    public String getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(String tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    @Override
    public String toString() {


        return  super.toString() +

                "tipoAgua= '" + tipoAgua + "'" +
                "}\n";
    }
}
