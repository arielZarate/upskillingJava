package NombresAleatorios;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //JOptionPane.showMessageDialog(null,"Hola Mundo");
        int  cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Nombres que decea generar"));
        imprimir(generarNombresAleatorios(cant));

    }


    //metodos estaticos de la clase
    public static String[] generarNombresAleatorios(int cantidad) {
        String[] nombresAleatorios = new String[cantidad];

        String[] nombres = { "Andrea ", "Leon" ,"Leonardo" ,"David", "Sofia", "Micaela", "Yohana", "Francisco", "Balduino",
                "Erdwin", "Baltasar", "Barry", "Patricio",
                "Bartolomé", "Florencia", "Belen", "Candelaria", "Natalia", "Canela",
                "Paloma", "Carina", "Clarisa","Melisa",
                "Dayana", "Carlota", "Ariel","Juan" ,"Lucas " , "Santiago" ,"Emanuel ","Ana" ,"Claudia" ,"alejandro"};
        String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Perez", "Cardona", "Cardoso", "Cariaga", "Carillo",
                "Carion", "Castiyo", "Castorena", "Zarate", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
                "Grigalva" ,"Poronga" , "Milei" , "Cafiero", "Cavallo" ,"Cordera ", "Spinneta" , "Garcia" , "Gieco"};

        for (int i = 0; i < cantidad; i++) {
            nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                    + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
        }
        return nombresAleatorios;
    }

    public static void imprimir(String[] nombresGenerados) {
        for (int i = 0; i < nombresGenerados.length; i++) {
            System.out.println(nombresGenerados[i]);
        }
    }


}
