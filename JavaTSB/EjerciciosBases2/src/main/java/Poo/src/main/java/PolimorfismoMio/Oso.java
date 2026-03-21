package PolimorfismoMio;

public class Oso extends Animal{

    private String comida="";

    public Oso(String name, String poder, String habitat, String tipoAnimal ,String comida) {
        super(name, poder, habitat, tipoAnimal);
        this.comida=comida;
    }


    public String getComida() {
        return this.comida;
    }


    public void setComida(String comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return
                super.toString() +

                " comida=" + "'"+comida + "'"  +
                "}\n";
    }
}
