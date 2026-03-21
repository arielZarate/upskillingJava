package PolimorfismoMio;

public class Aguila extends Animal{
    private String pesoAnimal="";

    public Aguila(String name, String poder, String habitat, String tipoAnimal, String pesoAnimal) {
        super(name, poder, habitat, tipoAnimal);
        this.pesoAnimal = pesoAnimal;
    }

    public String getPesoAnimal() {
        return pesoAnimal;
    }

    public void setPesoAnimal(String pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    @Override
    public String toString() {
        return super.toString() +
                "pesoAnimal=' " + pesoAnimal + "'" +
                "}\n";
    }
}
