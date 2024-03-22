package cl.walletDigital.clases;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CuentaBancaria implements IConversorMoneda{

    private int numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria() {
    }
    public CuentaBancaria(int numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0;
    }

    public int getNumeroDeCuenta() {
        return numeroCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroCuenta = numeroDeCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



    public void MostrarDatosCuenta(){
        System.out.println("===============================");
        System.out.println("Los datos son: ");
        System.out.println("------------------------------");
        System.out.println("N° CUENTA: "+ numeroCuenta);
        System.out.println("TITULAR: "+ titular);
        System.out.println("SALDO: "+ formatearModena(saldo));
    }

    public void ingresoDinero(double dinero){
        this.saldo += dinero;
        System.out.println("Tu saldo actual es: "+formatearModena(saldo));
    }

    public void retiroDinero(double dinero){
        this.saldo-=dinero;
        System.out.println("Tu saldo actual es: "+ formatearModena(saldo));
    }

    public CuentaBancaria crearCuenta(String nombreCompleto){
        //Scanner scanner = new Scanner(System.in);
        int numeroCuenta = (int)Math.random()*100000;
       // double saldoCuenta;

       /* System.out.println("Ingrese el saldo de la cuenta: ");
        saldoCuenta= scanner.nextDouble();*/

        return new CuentaBancaria(numeroCuenta,nombreCompleto);
    }


    /*public String FormaterSaldo(double monto) {
        // Crear un formato para pesos chilenos
        NumberFormat formatoPesosChilenos = DecimalFormat.getCurrencyInstance(new Locale("es", "CL"));

        // Formatear el número en pesos chilenos
        String montoFormateado = formatoPesosChilenos.format(monto);

        // Mostrar el resultado
        return montoFormateado;

        //CrearCuenta
        //AgregarSaldo
        //RestarSaldo;
        //ver Saldo
        //conversor Moneda
        //Balance
        //Menu

    }*/

    @Override
    public String formatearModena(double monto) {
        NumberFormat formatoPesosChilenos = DecimalFormat.getCurrencyInstance(new Locale("es", "CL"));

        // Formatear el número en pesos chilenos
        String montoFormateado = formatoPesosChilenos.format(monto);

        // Mostrar el resultado
        return montoFormateado;
    }

    @Override
    public void convertirMoneda() {


    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta=" + numeroCuenta +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}

