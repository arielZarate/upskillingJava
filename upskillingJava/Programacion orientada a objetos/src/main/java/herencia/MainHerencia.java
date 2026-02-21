package POO.herencia;

public class MainHerencia{

public static void main(String[] args){
    ClaseHija_Suma op_s= new ClaseHija_Suma();
    ClaseHija_Resta op_r=new ClaseHija_Resta();
    op_s.PedirDatos();
    op_s.sumar();
    op_s.MostrarResultados();


    op_r.PedirDatos();
    op_r.restar();
    op_r.MostrarResultados();



}
}
