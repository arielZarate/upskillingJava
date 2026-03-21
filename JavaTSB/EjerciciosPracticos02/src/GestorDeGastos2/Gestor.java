package GestorDeGastos2;
import java.util.Scanner;
public class Gestor {

    private String codigo;
    private String descripcion;
    private int mes;
    private int sucursal;
    private int importe;
    Scanner scanner = new Scanner(System.in);

    public String getCodigo() {
        return codigo;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes < 3 && mes > -1) {
            this.mes = mes;
        } else {
            do {
                System.out.println(" Las sucursales posbibles van desde el 0 a 2 ");
                System.out.print("Ingrese el numero de sucursal:");
                mes = scanner.nextInt();
            } while (mes > 3 || mes < -1);
            this.mes = mes;
        }
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        if (sucursal < 3 && sucursal > -1) {
            this.sucursal = sucursal;
        } else {
            do {
                System.out.println(" Las sucursales posbibles van desde el 0 a 2 ");
                System.out.print("Ingrese el numero de sucursal:");
                sucursal = scanner.nextInt();
            } while (sucursal > 3 || sucursal < -1);
            this.sucursal = sucursal;
        }

    }

    public int getImporte() {
        return importe;
    }

    public Gestor(String codigo, String descripcion, int mes, int sucursal, int importe) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.mes = mes;
        this.sucursal = sucursal;
        this.importe = importe;
    }


    public void setImporte(int importe) {
        this.importe = importe;
    }

    public String toString() {
        String str = "Código:" + codigo + " - Mes:" + mes + " - Sucursal:" + sucursal + " - Descripción: " + descripcion + " - Importe: $" + importe;
        return str;
    }
}