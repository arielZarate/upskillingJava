package GestorDeGastos;

public class Gastos {
    /*
    De cada gasto se registra lo siguiente:
    • Código.
    • Descripción.
    • Mes (1-12).
    • Sucursal (0-2)
    • Importe.
     */


    private  int codigo;
    private  String descripcion;
    private  int mes ;
    private  int sucursal;
    private double importe;


    public Gastos(int codigo, String descripcion, int mes, int sucursal, double importe) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.mes = mes;
        this.sucursal = sucursal;
        this.importe = importe;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }


    @Override
    public String toString() {
        return "Gastos{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", mes=" + mes +
                ", sucursal=" + sucursal +
                ", importe=" + importe +
                '}';
    }

}
