package programacionOrientadaaObjetos.cuentabancaria;


/**
 * Representa una cuenta bancaria con funcionalidades básicas.
 *
 * Ejercicio basado en programación orientada a objetos.
 * Fuente: <a href="https://academiasanroque.com/ejercicios-sobre-programacion-orientada-a-objetos-poo-en-java/">
 * Academia San Roque - Ejercicios de POO</a>
 *
 * @author Ariel Zarate
 */

public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    private String titular;


    CuentaBancaria(){}

    public CuentaBancaria(String numeroCuenta, double saldo, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }



    /**nuevos metodos creados*/

    public boolean depositar(double cantidad){
        if(cantidad>0)
        {
            this.saldo+=cantidad;
            return  true;
        }
        return false;
    }

    public boolean extraer(double cantidad){
        if(cantidad >0 && saldo>=cantidad  ){
         saldo -=cantidad;
         return true;
        }
        return false;
    }

    public String mostrarSaldo(){
        return "Saldo actual : " + this.saldo;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", titular='" + titular + '\'' +
                '}';
    }
}
