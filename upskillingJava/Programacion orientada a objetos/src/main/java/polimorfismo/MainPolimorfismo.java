package POO.polimorfismo;

public class MainPolimorfismo{

public static void main(String[] args){


    ClasePadre_Operaciones op_s = new ClaseHija_Suma();
    ClaseHija_Resta op_r = new ClaseHija_Resta();
    op_s.PedirDatos();
    op_s.operaciones();
    op_s.MostrarResultados();

    op_r.PedirDatos();
    op_r.operaciones();
    op_r.MostrarResultados();


}
}
