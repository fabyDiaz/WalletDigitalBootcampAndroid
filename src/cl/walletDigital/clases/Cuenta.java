package cl.walletDigital.clases;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Cuenta {

    private int numeroCuenta;
    private String titular;
    private double saldo;

    public Cuenta() {
    }

    public Cuenta(int numeroCuenta, String titular) {
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
        System.out.println("Cuenta: "+ numeroCuenta);
        System.out.println("Títular: "+ titular);
        System.out.println("Saldo: "+ FormaterSaldo(saldo));
    }

    public void ingresoDinero(double dinero){
        this.saldo += dinero;
    }

    public void retiroDinero(double dinero){
        this.saldo-=dinero;
    }

    public static Cuenta crearCuenta(String nombreCompleto){
        Scanner scanner = new Scanner(System.in);
        int numeroCuenta = (int)Math.random()*100000;
        double saldoCuenta;

        System.out.println("Ingrese el saldo de la cuenta: ");
        saldoCuenta= scanner.nextDouble();

        return new Cuenta(numeroCuenta,nombreCompleto);
    }

    public String FormaterSaldo(double monto) {
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
        //Menu

    }

}

