package ListaNumerosPrograma;


import java.util.ArrayList;
import java.util.Scanner;

public class ListaNumeros {

    ArrayList<Double> listitaNumeros;

    public static void main(String[] args) {
        ListaNumeros miLista = new ListaNumeros();
        miLista.listitaNumeros = new ArrayList<>();
        miLista.LeerOpcion();
    }



    //codigo del programa
    public void LeerOpcion() {
        Scanner sc = new Scanner(System.in);
        int opcion =0;
      //  int sel = 0;
        do {
            System.out.println("\nLista de Numeros");
            System.out.println("[1] Agregar");
            System.out.println("[2] Buscar");
            System.out.println("[3] Modificar Elemento");
            System.out.println("[4] Eliminar Elemento");
            System.out.println("[5] Insertar Elemento");
            System.out.println("[6] Mostrar Elementos");
           // System.out.println("[7] clear()");
            System.out.println("[7] Salir ");
            System.out.print("Ingrese opcion de (1-7): \n");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                case 5:
                    this.IngresarValor();break;
                case 2: this.BuscarValor();break;
                case 3: this.ModificarValor();break;
                case 4: this.EliminarValor();break;

                case 6:this.mostrarLista();break;
                //case 7:this.Clear();break;
                case 7:
                    System.out.println("Ha finalizado el Programa Prueba ");
                    System.out.println("@copyrigth ArielZarate");
                    break;
                default:
                    System.out.println("Esa opción no existe");
            }
            //System.out.println("-------------------------------");


        } while (opcion != 7);
    }


    //ingresar valor

    public void IngresarValor() {
        Scanner sc = new Scanner(System.in);
        Double valor = 0.0;
        System.out.print("ingrese un valor: ");
        valor = sc.nextDouble();
        listitaNumeros.add(valor);
    }


    public void BuscarValor() {
        Scanner sc = new Scanner(System.in);
        Double valor = 0.0;
        int indice = -1;
        System.out.print("valor a buscar: ");
        valor = sc.nextDouble();
        listitaNumeros.add(valor);
        indice = listitaNumeros.indexOf(valor);
        if (indice != -1) {
            System.out.println("Dato se encuentra en la posicion " + indice);
        } else System.out.println("Dato no se encuentra");

    }

    public void ModificarValor() {
        Scanner sc = new Scanner(System.in);
        Double valor = 0.0;
        int indice;
        System.out.print("valor a modificar: ");
        valor = sc.nextDouble();

        //busco el elemento en el AraryList
        indice = listitaNumeros.indexOf(valor);
        if (indice != -1) {
            System.out.print("ingrese nuevo Valor: ");
            Double nuevoValor = sc.nextDouble();
            listitaNumeros.set(indice, nuevoValor);
            System.out.println("Valor modificado");
        } else System.out.println("Dato no se encuentra");

    }


    public void EliminarValor() {
        Scanner sc = new Scanner(System.in);
        Double valor = 0.0;
        int indice;
        System.out.print("valor a Eliminar: ");
        valor = sc.nextDouble();

        //busco el elemento en el AraryList
        indice = listitaNumeros.indexOf(valor);
        if (indice != -1) {
            listitaNumeros.remove(indice);
            System.out.println("Valor eliminado");
        } else System.out.println("Dato no se encuentra");

    }


    public void mostrarLista() {

        if (!listitaNumeros.isEmpty()) {
            System.out.println("Elementos dela lista");
            for (int i = 0; i < listitaNumeros.size(); i++) {
                //imprimirmos por pantalla
                System.out.println(listitaNumeros.get(i));
            }
        } else System.out.println("No hay Datos en la lista ");

    }

    public void Clear()
    {
        listitaNumeros.clear();
    }


}



