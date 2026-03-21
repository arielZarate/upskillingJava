package PolimorfismoMio;

public class Animal {

    private String name="";
    private  String  poder="";
    private String habitat ="";
    private String tipoAnimal="";

    public Animal(String name, String poder, String habitat, String tipoAnimal) {
        this.name = name;
        this.poder = poder;
        this.habitat = habitat;
        this.tipoAnimal = tipoAnimal;
    }

    public Animal() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", poder='" + poder + '\'' +
                ", habitat='" + habitat + '\'' +
                ", tipoAnimal='" + tipoAnimal + " \' ";
    }
}
